package ed.masanz.ut9.blackjackfx.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Jugador {
    private String nombre;
    private BooleanProperty listo;

    public Jugador(String nombre) {
        this.nombre= nombre;
        this.listo = new SimpleBooleanProperty(false);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isListo() {
        return listo.get();
    }

    public void setListo(boolean valor) {
        this.listo.set(valor);
    }

    public BooleanProperty listoProperty() {
        return listo;
    }

}
