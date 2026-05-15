package ed.masanz.ut9.blackjackfx.controller;

import ed.masanz.ut9.blackjackfx.model.Jugador;
import ed.masanz.ut9.blackjackfx.model.UserSession;
import ed.masanz.ut9.blackjackfx.service.NavigationService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

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
    private int dineroApostar;

    private final List<String> mazoJugador = new ArrayList<>();
    private final List<String> mazoBanca = new ArrayList<>();
    private int indiceMazoJugador = 0;
    private int indiceMazoBanca = 0;
    private int puntosJugador = 0;
    private int puntosBanca = 0;
//    private boolean rondaActiva = false;

    @FXML
    private void initialize() {
        inicializarValoresJugador();
    }

    private void prepararNuevaRonda() {
        lblPuntosBanca.setVisible(true);
        lblPuntosBanca.setText("0");
        lblPuntosJugador.setVisible(true);
        lblPuntosJugador.setText("0");

        aniadirCartaMazo(mazoJugador, jugadorCarta1);
        jugadorCarta1.setVisible(true);
        aniadirCartaMazo(mazoJugador, jugadorCarta2);
        jugadorCarta2.setVisible(true);

        aniadirCartaMazo(mazoBanca, bancaCarta1);
        bancaCarta1.setVisible(true);

        puntosJugador = calcularPuntos(mazoJugador);
        puntosBanca = calcularPuntos(mazoBanca);
        lblPuntosBanca.setText(String.valueOf(puntosBanca));
        lblPuntosJugador.setText(String.valueOf(puntosJugador));

        cjtoHacer.setVisible(true);

    }


    private int calcularPuntos(List<String> mazoJugador) {
        int puntos = 0;
        for (String carta : mazoJugador) {
            String valorCarta = carta.split("-")[0];
            if (valorCarta.equals("11") || valorCarta.equals("12") || valorCarta.equals("13")) {
                puntos += 10;
            } else if(valorCarta.equals("1") && puntos <= 10){
                puntos += 11;
            } else{
                puntos += Integer.parseInt(valorCarta);
            }
        }
        return puntos;
    }

    private void aniadirCartaMazo(List<String> mazo, ImageView cartaView) {
        int numRandom = (int) (Math.random() * 13) + 1;
        int numRandomPalo = (int) (Math.random() * 4) + 1;
        switch (numRandomPalo) {
            case 1 -> mazo.add(numRandom + "-c");
            case 2 -> mazo.add(numRandom + "-p");
            case 3 -> mazo.add(numRandom + "-r");
            case 4 -> mazo.add(numRandom + "-t");
        }
        Image image = new Image(getClass().getResourceAsStream("/images/" + mazo.get(mazo.size() - 1) + ".png"));
        cartaView.setImage(image);
    }

    private void juego() {
//        while(true){
//            //1. El jugador apuesta
        prepararNuevaRonda();
//            //2. Se reparten las cartas
//        while(cartasJugador < 4)
//        repartirCartas();
//            //3. El jugador juega su turno
//        turnoJugador();
//            //4. La banca juega su turno
//        turnoBanca();
//            //5. Se muestra el resultado
//        verificarResultado();
//        elegirDecision();
//        }
    }


    private void verificarApuesta(int dineroApostar) {
        if(jugadorActual.getSaldo() < 50){
            //TODO ENSEÑAR LABEL NO TIENES DINERO SUFICIENTE PARA APOSTAR
        } else {
            jugadorActual.setSaldo(jugadorActual.getSaldo() - dineroApostar);
            cjtoDinero.setVisible(false);
            //TODO HACER LA IMAGEN Y PONERLA DEPENDIENDO DE CUAL SEA
            Image imagenApuesta = new Image(getClass().getResourceAsStream("/images/" + dineroApostar + ".png"));
            imgApostado.setImage(imagenApuesta);
            juego();
        }
    }

    private void inicializarValoresJugador() {
        String nick = UserSession.getInstance().getNickname();
        if (nick != null) {
            jugadorActual = (new Jugador(nick));
            lblDineroTotal.textProperty().bind(jugadorActual.saldoProperty().asString());
        }
    }

    @FXML
    void apostar100(ActionEvent event) {
        dineroApostar = 100;
        verificarApuesta(dineroApostar);
    }

    @FXML
    void apostar150(ActionEvent event) {
        dineroApostar = 150;
        verificarApuesta(dineroApostar);
    }

    @FXML
    void apostar50(ActionEvent event) {
        dineroApostar = 50;
        verificarApuesta(dineroApostar);
    }

    @FXML
    void otraCarta(ActionEvent event) {
        if(mazoJugador.size() < 4){
            aniadirCartaMazo(mazoJugador, jugadorCarta3);
            jugadorCarta3.setVisible(true);
            puntosJugador = calcularPuntos(mazoJugador);
            lblPuntosJugador.setText(String.valueOf(puntosJugador));
        } else if(mazoJugador.size() == 4){
            aniadirCartaMazo(mazoJugador, jugadorCarta4);
            jugadorCarta4.setVisible(true);
            puntosJugador = calcularPuntos(mazoJugador);
            lblPuntosJugador.setText(String.valueOf(puntosJugador));
        } else {
            //TODO ENSEÑAR LABEL NO PUEDES PEDIR MAS CARTAS
        }
        comprobarPuntosJugador();
    }

    private void comprobarPuntosJugador() {
        if(puntosJugador > 21){
            cjtoHacer.setVisible(false);
            cjtoGanarPerder.setVisible(true);
            lblGanado.setVisible(false);
            lblPerdido.setVisible(true);
        } else if (puntosJugador < 21) {
            cjtoHacer.setVisible(true);
        }
    }

    @FXML
    void plantarse(ActionEvent event) {
        turnoBanca();
    }

    private void turnoBanca() {
        while(puntosBanca < 21){
                if(mazoBanca.size() < 4){
                    aniadirCartaMazo(mazoBanca, bancaCarta2);
                    bancaCarta2.setVisible(true);
                } else if(mazoBanca.size() == 4){
                    aniadirCartaMazo(mazoBanca, bancaCarta3);
                    bancaCarta3.setVisible(true);
                } else {
                    aniadirCartaMazo(mazoBanca, bancaCarta4);
                    bancaCarta4.setVisible(true);
                }
                puntosBanca = calcularPuntos(mazoBanca);
                lblPuntosBanca.setText(String.valueOf(puntosBanca));
        }
        compararPuntosBancaJugador();
    }

    private void compararPuntosBancaJugador() {
        if(puntosJugador > puntosBanca || puntosBanca > 21){
            cjtoHacer.setVisible(false);
            cjtoGanarPerder.setVisible(true);
            lblGanado.setVisible(true);
            jugadorActual.setSaldo(jugadorActual.getSaldo() + dineroApostar * 2);
        } else if (puntosJugador == puntosBanca) {
            cjtoHacer.setVisible(false);
            cjtoGanarPerder.setVisible(true);
            lblGanado.setText("Empate");
            lblGanado.setVisible(true);
            jugadorActual.setSaldo(jugadorActual.getSaldo() + dineroApostar);
        } else {
            cjtoHacer.setVisible(false);
            cjtoGanarPerder.setVisible(true);
            lblPerdido.setVisible(true);
        }
    }

    @FXML
    void salir(ActionEvent event) {
        NavigationService.getInstance().navigateTo("launcher.fxml");
    }

    @FXML
    void volverJugar(ActionEvent event) {
        mazoJugador.clear();
        mazoBanca.clear();
        puntosJugador = 0;
        puntosBanca = 0;
        cjtoDinero.setVisible(true);
        cjtoGanarPerder.setVisible(false);
    }

}
