package ed.masanz.ut9.blackjackfx.controller;

import ed.masanz.ut9.blackjackfx.model.Jugador;
import ed.masanz.ut9.blackjackfx.model.UserSession;
import ed.masanz.ut9.blackjackfx.service.NavigationService;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class SoloGameController {

    @FXML
    private ImageView bancaCarta1;

    @FXML
    private ImageView bancaCarta2;

    @FXML
    private ImageView bancaCarta3;

    @FXML
    private ImageView bancaCarta4;

    @FXML
    private Button btn100;

    @FXML
    private Button btn150;

    @FXML
    private Button btn50;

    @FXML
    private VBox cjtoDinero;

    @FXML
    private VBox cjtoGanarPerder;

    @FXML
    private VBox cjtoHacer;

    @FXML
    private ImageView imgApostado;

    @FXML
    private ImageView jugadorCarta1;

    @FXML
    private ImageView jugadorCarta2;

    @FXML
    private ImageView jugadorCarta3;

    @FXML
    private ImageView jugadorCarta4;

    @FXML
    private Label lblDineroTotal;

    @FXML
    private Label lblGanado;

    @FXML
    private Label lblPerdido;

    @FXML
    private Label lblPuntosBanca;

    @FXML
    private Label lblPuntosJugador;

    private Jugador jugadorActual;

    @FXML
    private void initialize() {
        inicializarTodo();
    }

    private void inicializarTodo() {
        bancaCarta1.setVisible(false);
        bancaCarta2.setVisible(false);
        bancaCarta3.setVisible(false);
        bancaCarta4.setVisible(false);

        jugadorCarta1.setVisible(false);
        jugadorCarta2.setVisible(false);
        jugadorCarta3.setVisible(false);
        jugadorCarta4.setVisible(false);

        cjtoGanarPerder.setVisible(false);
        cjtoDinero.setVisible(true);
        cjtoHacer.setVisible(false);

        lblPuntosBanca.setText("0");
        lblPuntosJugador.setText("0");

        String nick = UserSession.getInstance().getNickname();
        if (nick != null) {
            jugadorActual = (new Jugador(nick));
            lblDineroTotal.textProperty().bind(jugadorActual.saldoProperty().asString());
        }

    }

    @FXML
    void otraCarta(ActionEvent event) {

    }

    @FXML
    void plantarse(ActionEvent event) {

    }

    @FXML
    void salir(ActionEvent event) {
        NavigationService.getInstance().navigateTo("launcher.fxml");
    }

    @FXML
    void volverJugar(ActionEvent event) {

    }

}
