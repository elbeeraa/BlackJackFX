package ed.masanz.ut9.blackjackfx.controller;

import ed.masanz.ut9.blackjackfx.model.Jugador;
import ed.masanz.ut9.blackjackfx.model.Sala;
import ed.masanz.ut9.blackjackfx.model.UserSession;
import ed.masanz.ut9.blackjackfx.service.NavigationService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Iterator;

public class WaitingRoomController {

    @FXML
    private TextArea areaMensajes;

    @FXML
    private Button btnEnviar;

    @FXML
    private TableColumn<Jugador, String> columnaJugadores;

    //TODO AÑADIR UNA COLUMNA PARA MOSTRAR SI EL JUGADOR ESTÁ LISTO O NO
    //COMO LO HAGO?
    @FXML
    private TableColumn<Jugador, Boolean> columnaListo;

    @FXML
    private TableView<Jugador> tablaSalaEspera;

    private ObservableList<Jugador> listaJugadores;
    private Sala salaActual;

    @FXML
    private void initialize() {
        // Aquí puedes inicializar la tabla, por ejemplo, estableciendo las celdas de las columnas
        inicializarTablaJugadores();
        inicializarChat();
        areaMensajes.setEditable(false);
    }

    private void inicializarChat() {
    }

    private void inicializarTablaJugadores() {
        columnaJugadores.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaListo.setCellValueFactory(cellData -> cellData.getValue().listoProperty());
        columnaListo.setCellFactory(CheckBoxTableCell.forTableColumn(columnaListo));

        listaJugadores = FXCollections.observableArrayList();
        tablaSalaEspera.setItems(listaJugadores);

    }

    @FXML
    void abandonarSala(ActionEvent event) {
        String nombreUsuario = UserSession.getInstance().getNickname();
        Iterator iterator = salaActual.getJugadoresEnSala().iterator();
        while(iterator.hasNext()){
            Jugador j = (Jugador) iterator.next();
            if (nombreUsuario.equals(j.getNombre())) {
                iterator.remove();
                setSalaActual(null);
                NavigationService.getInstance().navigateTo("join-game.fxml");
                break;
            }
        }
    }

    @FXML
    void estoyListo(ActionEvent event) {
//        String nombreUsuario = UserSession.getInstance().getNickname();
//        for (Jugador j : salaActual.getJugadoresEnSala()) {
//            if (nombreUsuario.equals(j.getNombre())) {
//                j.setListo(true);
//                break;
//            }
//        }
//        tablaSalaEspera.refresh();
        if (salaActual == null) return;
        String nombreUsuario = UserSession.getInstance().getNickname();

        for (Jugador j : salaActual.getJugadoresEnSala()) {
            if (nombreUsuario.equals(j.getNombre())) {
                j.setListo(true);
                System.out.println("Jugador marcado como listo");
                break;
            }
        }
        tablaSalaEspera.refresh();
    }

    @FXML
    void enviarMensaje(ActionEvent event) {

    }

    public void setSalaActual(Sala sala) {
        this.salaActual = sala;
        if (salaActual != null) {
            listaJugadores.setAll(salaActual.getJugadoresEnSala());
        }
    }

}
