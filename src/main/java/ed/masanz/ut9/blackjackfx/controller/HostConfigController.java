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
    private RadioButton rbtPrivado;

    @FXML
    private RadioButton rbtPublico;

    @FXML
    private ToggleGroup tipoGrupo;

    @FXML
    private TextField txtContra;

    @FXML
    private Label lblContra;

    @FXML
    private TextField txtnombresala;

    @FXML
    private TextField txtnumerojugadores;

    @FXML
    private Label lblError;


    @FXML
    private void initialize() {
        txtContra.setVisible(false);
        lblContra.setVisible(false);
        txtContra.setManaged(false);
        lblContra.setManaged(false);

        tipoGrupo.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
           boolean isPrivada = rbtPrivado.isSelected();
           txtContra.setVisible(isPrivada);
           lblContra.setVisible(isPrivada);
           txtContra.setManaged(isPrivada);
           lblContra.setManaged(isPrivada);

           if(!isPrivada) {
               txtContra.clear();
           }
        });
    }

    @FXML
    void cancelar(ActionEvent event) {
        NavigationService.getInstance().navigateTo("launcher.fxml");
    }

    @FXML
    void crearSala(ActionEvent event) {

        boolean esPrivada = rbtPrivado.isSelected();

        if (!Validator.hashText(txtnombresala) || !Validator.hashNumber(txtnumerojugadores)) {
            lblError.setVisible(true);
            return;
        }

        if (esPrivada) {
            if (!Validator.hashText(txtContra)) {
                lblError.setVisible(true);
                return;
            }
        }
        //TODO HACER QUE HAGA LA SALA CON LOS DATOS INTRODUCIDOS
        String nombreSala = txtnombresala.getText();
        int numeroJugadores = Integer.parseInt(txtnumerojugadores.getText());
        String tipoSala = rbtPrivado.isSelected() ? "Privada" : "Pública";
        //TODO
        String contra = txtContra.getText();
        //TODO LUEGO REDIRIGIR DIRECTAMENTE A LA SALA DE ESPERA DE ESA SALA

    }

}

