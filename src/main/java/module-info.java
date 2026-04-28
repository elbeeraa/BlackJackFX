module ed.masanz.ut9.blackjackfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens ed.masanz.ut9.blackjackfx to javafx.fxml;
    exports ed.masanz.ut9.blackjackfx;
}