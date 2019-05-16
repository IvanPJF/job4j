package ru.job4j.transform;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Working with database.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 16.05.2019
 *@version 0.1
 */
public class StoreSQL implements AutoCloseable {

    private Config config;
    private Connection connect;

    public StoreSQL(Config config) {
        this.config = config;
        this.init();
        this.createTable();
    }

    /**
     * The connection to the database.
     */
    private void init() {
        if (this.connect == null) {
            try {
                Class.forName(config.get("driver-class-name"));
                this.connect = DriverManager.getConnection(
                        this.config.get("url"),
                        this.config.get("username"),
                        this.config.get("password")
                );
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

    /**
     * Create a storage table.
     * If the table already exists then it is cleared of the created records.
     */
    private void createTable() {
        try (Statement st = this.connect.createStatement()) {
            st.executeUpdate("CREATE TABLE IF NOT EXISTS entry(field INTEGER)");
            st.executeUpdate("DELETE FROM entry");
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Inserts the specified number of records into the table.
     * @param size Number of records.
     */
    public void generate(int size) {
        try (PreparedStatement pst = this.connect.prepareStatement("INSERT INTO entry VALUES(?)")) {
            this.connect.setAutoCommit(false);
            for (int index = 1; index <= size; index++) {
                pst.setInt(1, index);
                pst.addBatch();
            }
            pst.executeBatch();
            this.connect.commit();
            this.connect.setAutoCommit(true);
        } catch (Exception e) {
            try {
                this.connect.rollback();
            } catch (SQLException exroll) {
                throw new IllegalStateException(exroll);
            }
            throw new IllegalStateException(e);
        }
    }

    /**
     * Get all values from the table as a list of new Entry objects.
     * @return
     */
    public List<Entry> load() {
        List<Entry> result = new LinkedList<>();
        try (Statement st = this.connect.createStatement()) {
            ResultSet resultSet = st.executeQuery("SELECT * FROM entry");
            while (resultSet.next()) {
                int value = resultSet.getInt("field");
                result.add(new Entry(value));
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }
}
