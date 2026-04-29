package ed.masanz.ut9.blackjackfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ed/masanz/ut9/blackjackfx/launcher.fxml"));

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

    @FXML
    void crearSala(ActionEvent event) {
        String nombreSala = txtnombresala.getText();
        int numeroJugadores = Integer.parseInt(txtnumerojugadores.getText());
        String tipoSala = rbtPrivado.isSelected() ? "Privada" : "Pública";

        //TODO HACER QUE GUARDE LOS DATOS?
    }

}

