package ed.masanz.ut9.blackjackfx.controller;

import ed.masanz.ut9.blackjackfx.model.UserSession;
import ed.masanz.ut9.blackjackfx.service.NavigationService;
import ed.masanz.ut9.blackjackfx.util.Validator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LauncherController {
    @FXML
    private Label lblError;

    @FXML
    private TextField txtNickname;

    public void initialize() {
        //SI TENGO EL NICKNAME GUARDADO EN LA SESION, LO PONGO EN EL TEXTFIELD
        if(UserSession.getInstance().getNickname() != null){
            txtNickname.setText(UserSession.getInstance().getNickname());
        }

    }

    @FXML
    void crearSala(ActionEvent event) {
        if(Validator.hashText(txtNickname)){
            getNickname();
            NavigationService.getInstance().navigateTo("host-config.fxml");
        } else {
            lblError.setVisible(true);
        }

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ed/masanz/ut9/blackjackfx/host-config.fxml"));
//
//        Parent root = null;
//        try {
//            root = loader.load();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Scene scene = new Scene(root);
//
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
    }

    @FXML
    void jugarSolitario(ActionEvent event) {
//        NavigationService.getInstance().navigateTo("solo-game.fxml");
    }

    @FXML
    void unirmeSala(ActionEvent event) {
        if (Validator.hashText(txtNickname)) {
            getNickname();
            NavigationService.getInstance().navigateTo("join-game.fxml");
        } else {
            lblError.setVisible(true);
        }
    }

    private void getNickname(){
        String nickname = txtNickname.getText();
        UserSession.getInstance().setNickname(nickname);
    }
}