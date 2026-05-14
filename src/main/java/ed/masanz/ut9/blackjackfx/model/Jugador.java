package ed.masanz.ut9.blackjackfx.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Jugador {
    private String nombre;
    private BooleanProperty listo;
    private IntegerProperty saldo;

    public Jugador(String nombre) {
        this.nombre= nombre;
        this.listo = new SimpleBooleanProperty(false);
        this.saldo = new SimpleIntegerProperty(500);
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

    public int getSaldo() {
        return saldo.get();
    }

    public IntegerProperty saldoProperty() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo.set(saldo);
    }
}
