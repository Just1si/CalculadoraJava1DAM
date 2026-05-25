package calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalcController {

	private double valor1 = 0;
	private String operador = "";
	private boolean nuevoNumero = true;

	@FXML
	private TextField pantalla;

	@FXML
	private void onButton(ActionEvent e) {
	    Button boton = (Button) e.getSource();
	    String texto = boton.getText();

	    // Números y punto
	    if (texto.matches("[0-9\\.]")) {
	        if (this.nuevoNumero) {
	            pantalla.setText(texto);
	            nuevoNumero = false;
	        } else {
	            pantalla.appendText(texto);
	        }
	        return; // Muy importante: salimos del método
	    }

	    // Operadores
	    if (texto.matches("[+\\-*/]")) {
	        valor1 = Double.parseDouble(pantalla.getText());
	        operador = texto;
	        nuevoNumero = true;
	        return;
	    }

	    // Igual
	    if (texto.equals("=")) {
	        double valor2 = Double.parseDouble(pantalla.getText());
	        double resultado = 0;

	        switch (operador) {
	            case "+": resultado = valor1 + valor2; break;
	            case "-": resultado = valor1 - valor2; break;
	            case "*": resultado = valor1 * valor2; break;
	            case "/":
	                if (valor2 == 0) {
	                    pantalla.setText("Error");
	                    nuevoNumero = true;
	                    return;
	                }
	                resultado = valor1 / valor2;
	                break;
	        }

	        pantalla.setText(String.valueOf(resultado));
	        valor1 = resultado;
	        nuevoNumero = true;
	    }
	}


	@FXML
	private void onClear() {

		this.pantalla.clear();
		this.valor1 = 0;
		this.operador = "";
		this.nuevoNumero = true;

	}

}
