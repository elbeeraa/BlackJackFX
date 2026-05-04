package ed.masanz.ut9.blackjackfx.controller;

import ed.masanz.ut9.blackjackfx.model.Sala;
import ed.masanz.ut9.blackjackfx.service.NavigationService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class JoinGameController {

    @FXML
    private TextField txtBusquedaSala;

    @FXML
    private TableColumn<Sala, String> tablaNombreSala;

    @FXML
    private TableColumn<Sala, Integer> tablaNumJugadores;

    @FXML
    private TableColumn<Sala, Integer> tablaPing;

    @FXML
    private TableColumn<Sala, String> tablaPrivacidad;

    @FXML
    private TableView<Sala> tablaSalas;

    private ObservableList<Sala> listaSalas;

    public void initialize() {
        tablaNombreSala.setCellValueFactory(new PropertyValueFactory<>("nombreSala"));
        tablaNumJugadores.setCellValueFactory(new PropertyValueFactory<>("numJugadores"));
        tablaPing.setCellValueFactory(new PropertyValueFactory<>("ping"));
        tablaPrivacidad.setCellValueFactory(new PropertyValueFactory<>("privacidad"));

        listaSalas = FXCollections.observableArrayList(
                new Sala("Sala 1", 3, 50, "Publica"),
                new Sala("Sala 2", 2, 30, "Privada"),
                new Sala("Sala 3", 4, 70, "Publica")
        );
        tablaSalas.setItems(listaSalas);
    }

    @FXML
    void buscarSala(ActionEvent event) {
       // if(txtBusquedaSala != null)
        //TODO QUE SALGAN LAS SALAS QUE TIENE EL SERVIDOR CON EL NOMBRE PUESTO EN TXT BUSQUEDA
    }

    @FXML
    void cancelar(ActionEvent event) {
        NavigationService.getInstance().navigateTo("launcher.fxml");
    }

    @FXML
    void unirSala(ActionEvent event) {
        NavigationService.getInstance().navigateTo("game.fxml");
    }

    @FXML
    void crearSala(ActionEvent event) {
        NavigationService.getInstance().navigateTo("host-config.fxml");
    }

}