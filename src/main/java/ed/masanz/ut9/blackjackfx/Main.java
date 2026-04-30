package ed.masanz.ut9.blackjackfx;

import ed.masanz.ut9.blackjackfx.service.NavigationService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        NavigationService nav = ed.masanz.ut9.blackjackfx.service.NavigationService.getInstance();
        nav.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("launcher.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("BlackJack");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}