package ed.masanz.ut9.blackjackfx.util;

import javafx.scene.control.TextField;

public class Validator {
    public static boolean hashText(TextField textField) {
        String texto = textField.getText();
        if(texto != null && !texto.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public static boolean hashNumber(TextField txtNumeroJugadores) {
        if(txtNumeroJugadores == null || txtNumeroJugadores.getText().isEmpty()){
            return false;
        }
        int numero = Integer.parseInt(txtNumeroJugadores.getText());
        if(numero < 5 && numero > 1){
            return true;
        } else {
            return false;
        }
    }
}
