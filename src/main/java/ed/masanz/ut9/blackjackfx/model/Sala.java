package ed.masanz.ut9.blackjackfx.model;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private String nombreSala;
    private int numJugadores;
    private String contra;
    private String privacidad;

    //TODO AÑADIR ID DE LA SALA PARA PODER IDENTIFICARLA CUANDO SE QUIERA UNIR A ELLA
    //TODO AÑADIR UNA LISTA DE LOS JUGADORES QUE HAY EN LA SALA PARA PODER MOSTRARLA EN LA SALA DE ESPERA
    private int idSala;

    //TODO poner solo String con el nombre o el objeto jugador directamente?
    private List<Jugador> jugadoresEnSala;

    public Sala(String nombreSala, int numJugadores, String contra, String privacidad) {
        this.nombreSala = nombreSala;
        this.numJugadores = numJugadores;
        this.contra = contra;
        this.privacidad = privacidad;
        this.jugadoresEnSala = new ArrayList<>();
        //AQUI HE AÑADIDO JUGADORES PARA PRUEBA
        this.jugadoresEnSala.add(new Jugador("Ana"));
        this.jugadoresEnSala.add(new Jugador("Luis"));
        this.jugadoresEnSala.add(new Jugador("Marta"));
        this.numJugadores = this.jugadoresEnSala.size();
    }
        //TODO CONSTRUCTOR CON ID PARA PODER CREAR LAS SALAS CON ID
    public Sala(int id,String nombreSala, int numJugadores, String contra, String privacidad, List<Jugador> jugadoresEnSala) {
        this.idSala = id;
        this.nombreSala = nombreSala;
        this.numJugadores = numJugadores;
        this.contra = contra;
        this.privacidad = privacidad;
        this.jugadoresEnSala = new ArrayList<>();
        //AQUI HE AÑADIDO JUGADORES PARA PRUEBA
        this.jugadoresEnSala = jugadoresEnSala;
        this.numJugadores = this.jugadoresEnSala.size();
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public List<Jugador> getJugadoresEnSala() {
        return jugadoresEnSala;
    }

    public void setJugadoresEnSala(List<Jugador> jugadoresEnSala) {
        this.jugadoresEnSala = jugadoresEnSala;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(String privacidad) {
        this.privacidad = privacidad;
    }

    public void aniadirJugador(Jugador nuevoJugador) {
        jugadoresEnSala.add(nuevoJugador);
        numJugadores = jugadoresEnSala.size();
    }
}
