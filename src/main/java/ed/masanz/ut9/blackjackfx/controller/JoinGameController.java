package ed.masanz.ut9.blackjackfx.controller;

import ed.masanz.ut9.blackjackfx.model.Jugador;
import ed.masanz.ut9.blackjackfx.model.Sala;
import ed.masanz.ut9.blackjackfx.model.UserSession;
import ed.masanz.ut9.blackjackfx.service.NavigationService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class JoinGameController {

    @FXML
    private TextField txtBusquedaSala;

    @FXML
    private TableColumn<Sala, String> tablaNombreSala;

    @FXML
    private TableColumn<Sala, Integer> tablaNumJugadores;

    @FXML
    private TableColumn<Sala, String> tablaContra;

    @FXML
    private TableColumn<Sala, String> tablaPrivacidad;

    @FXML
    private TableView<Sala> tablaSalas;

    private ObservableList<Sala> listaSalas;

    public void initialize() {
        tablaNombreSala.setCellValueFactory(new PropertyValueFactory<>("nombreSala"));
        tablaNumJugadores.setCellValueFactory(new PropertyValueFactory<>("numJugadores"));
        tablaPrivacidad.setCellValueFactory(new PropertyValueFactory<>("privacidad"));

        listaSalas = FXCollections.observableArrayList(
                new Sala(1,"Sala 1", 3, null, "Publica", new ArrayList<>(List.of(new Jugador[]{new Jugador("Ana"), new Jugador("Pedro"), new Jugador("Blanca")}))),
                new Sala(2,"Sala 2", 3, "0000", "Privada", new ArrayList<>(List.of(new Jugador[]{new Jugador("Valentina"), new Jugador("Bea")}))),
                new Sala(3,"Sala 3", 3, null, "Publica", new ArrayList<>(List.of(new Jugador[]{new Jugador("Popo")})))
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

        if (salaSeleccionada == null) {
            System.out.println("No se ha seleccionado ninguna sala.");
            return false;
        }

        if (salaSeleccionada.getNumJugadores() >= 4) {
            System.out.println("La sala está llena.");
            return false;
        }

        if(salaSeleccionada.getPrivacidad().equals("Privada")){
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Contraseña requerida");
            dialog.setHeaderText("Contraseña: ");

            ButtonType botonUnirse = new ButtonType("Unirme", ButtonBar.ButtonData.OK_DONE);
            ButtonType botonCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(botonUnirse, botonCancelar);

            PasswordField contraIntroducida = new PasswordField();
            contraIntroducida.setPromptText("Contraseña");
            dialog.getDialogPane().setContent(contraIntroducida);

            Platform.runLater(contraIntroducida::requestFocus);

            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == botonUnirse) {
                    return contraIntroducida.getText();
                }
                return null;
            });

            Optional<String> result = dialog.showAndWait();
            if (result.isEmpty()) {
                return false;
            }

            String introducida = result.get();
            String correcta = salaSeleccionada.getContra();

            if (correcta == null) correcta = "";
            if (!correcta.equals(introducida)) {
//                Alert alerta = new Alert(Alert.AlertType.ERROR);
//                alerta.setTitle("Contraseña incorrecta");
//                alerta.setHeaderText(null);
//                alerta.setContentText("La contraseña no es correcta. No puedes unirte a la sala.");
//                alerta.showAndWait();
                return false;
            }
        }

        String nombreJugador = UserSession.getInstance().getNickname();
        salaSeleccionada.aniadirJugador(new Jugador(nombreJugador));

        WaitingRoomController controlador = NavigationService.getInstance().navigateTo("waiting-room.fxml");
        if(controlador != null) {
            controlador.setSalaActual(salaSeleccionada);
        }

        System.out.println("Jugador añadido a la sala: " + salaSeleccionada.getNombreSala());
        return true;
    }

    @FXML
    void crearSala(ActionEvent event) {
        NavigationService.getInstance().navigateTo("host-config.fxml");
    }

}