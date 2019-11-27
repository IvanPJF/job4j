module javafx {
    requires javafx.fxml;
    requires javafx.controls;
    requires jcip.annotations;
    opens ru.job4j.pingpong to javafx.fxml;
    exports ru.job4j.pingpong;
}