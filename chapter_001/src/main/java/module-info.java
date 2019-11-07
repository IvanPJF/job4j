module javafx {
    requires javafx.fxml;
    requires javafx.controls;
    opens ru.job4j.tictactoe to javafx.fxml;
    opens ru.job4j.puzzle to javafx.fxml;
    exports ru.job4j.tictactoe;
    exports ru.job4j.puzzle;
}