module ed.masanz.ut9.blackjackfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.media;
   


    opens ed.masanz.ut9.blackjackfx to javafx.fxml;
    opens ed.masanz.ut9.blackjackfx.model to javafx.base;
    exports ed.masanz.ut9.blackjackfx;
    exports ed.masanz.ut9.blackjackfx.controller;
    opens ed.masanz.ut9.blackjackfx.controller to javafx.fxml;
}