package ed.masanz.ut9.blackjackfx.controller;

import ed.masanz.ut9.blackjackfx.service.NavigationService;
import ed.masanz.ut9.blackjackfx.util.Validator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class HostConfigController {

    @FXML
    private ImageView imagen;

    @FXML
    private RadioButton rbtPrivado;

    @FXML
    private RadioButton rbtPublico;

    @FXML
    private ToggleGroup tipoGrupo;

    @FXML
    private TextField txtnombresala;

    @FXML
    private TextField txtnumerojugadores;

    @FXML
    private Label lblError;

    @FXML
    void cambiarImagen(MouseEvent event) {
       //  el gemini me sugiere usar libreria FileChooser para que se abra archivos y Image para poder ver la imagen
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar imagen");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg")
        );
        Stage stage = (Stage) imagen.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imagen.setImage(image);
        }
    }

    @FXML
    void cancelar(ActionEvent event) {
        NavigationService.getInstance().navigateTo("launcher.fxml");
    }

    @FXML
    void crearSala(ActionEvent event) {

        if(Validator.hashText(txtnombresala) && Validator.hashNumber(txtnumerojugadores)) {
            NavigationService.getInstance().navigateTo("waiting_room.fxml");
        } else {
            lblError.setVisible(true);
        }

        String nombreSala = txtnombresala.getText();
        int numeroJugadores = Integer.parseInt(txtnumerojugadores.getText());
        String tipoSala = rbtPrivado.isSelected() ? "Privada" : "Pública";

        //TODO HACER QUE GUARDE LOS DATOS?
    }

}

