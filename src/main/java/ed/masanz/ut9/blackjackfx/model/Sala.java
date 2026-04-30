package ed.masanz.ut9.blackjackfx.model;

public class Sala {
    private String nombreSala;
    private int numJugadores;
    private int ping;
    private String privacidad;

    public Sala(String nombreSala, int numJugadores, int ping, String privacidad) {
        this.nombreSala = nombreSala;
        this.numJugadores = numJugadores;
        this.ping = ping;
        this.privacidad = privacidad;
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

    public int getPing() {
        return ping;
    }

    public void setPing(int ping) {
        this.ping = ping;
    }

    public String getPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(String privacidad) {
        this.privacidad = privacidad;
    }
}
