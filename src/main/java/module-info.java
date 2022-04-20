module com.balls.bouncingballs {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.balls.bouncingballs to javafx.fxml;
    exports com.balls.bouncingballs;
}