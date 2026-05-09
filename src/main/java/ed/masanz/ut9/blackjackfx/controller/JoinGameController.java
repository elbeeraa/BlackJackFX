package ed.masanz.ut9.blackjackfx.controller;

import ed.masanz.ut9.blackjackfx.model.Jugador;
import ed.masanz.ut9.blackjackfx.model.Sala;
import ed.masanz.ut9.blackjackfx.model.UserSession;
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
                new Sala(1,"Sala 1", 3, 50, "Publica"),
                new Sala(2,"Sala 2", 3, 30, "Privada"),
                new Sala(3,"Sala 3", 3, 70, "Publica")
        );
        tablaSalas.setItems(listaSalas);
    }

    @FXML
    void buscarSala(ActionEvent event) {
        if(txtBusquedaSala != null && !txtBusquedaSala.getText().isEmpty()){
            String textoBusqueda = txtBusquedaSala.getText().toLowerCase();
            ObservableList<Sala> salasFiltradas = FXCollections.observableArrayList();

            for (Sala sala : listaSalas) {
                if (sala.getNombreSala().toLowerCase().contains(textoBusqueda)) {
                    salasFiltradas.add(sala);
                }
            }

            tablaSalas.setItems(salasFiltradas);
        } else {
            tablaSalas.setItems(listaSalas);
        }
    }

    @FXML
    void cancelar(ActionEvent event) {
        NavigationService.getInstance().navigateTo("launcher.fxml");
    }

    @FXML
    void unirSala(ActionEvent event) {
        if(!aniadirJugadorASalaSeleccionada()){
            System.out.println("No se ha podido unir a la sala.");
        }
    }

    private boolean aniadirJugadorASalaSeleccionada() {
        Sala salaSeleccionada = tablaSalas.getSelectionModel().getSelectedItem();
        if (salaSeleccionada != null && salaSeleccionada.getNumJugadores() < 4) {

            String nombreJugador = UserSession.getInstance().getNickname();
            salaSeleccionada.aniadirJugador(new Jugador(nombreJugador));

            WaitingRoomController controlador = NavigationService.getInstance().navigateTo("waiting-room.fxml");
            if(controlador != null) {
                controlador.setSalaActual(salaSeleccionada);
            }

            System.out.println("Jugador añadido a la sala: " + salaSeleccionada.getNombreSala());
            return true;
        } else {
            System.out.println("No se ha seleccionado ninguna sala.");
            return false;
        }
    }

    @FXML
    void crearSala(ActionEvent event) {
        NavigationService.getInstance().navigateTo("host-config.fxml");
    }

}