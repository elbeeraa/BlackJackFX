package ed.masanz.ut9.blackjackfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LauncherController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    void crearSala(ActionEvent event) {

//        String nickname = txtNickname.getText();
//        System.out.println("LauncherController");
//        System.out.println("Nickname: " + nickname);
//        UserSession.getInstance().setNickname(nickname);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ed/masanz/ut9/blackjackfx/host-config.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}