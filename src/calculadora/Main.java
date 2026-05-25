package calculadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("calculadora.fxml"));
		BorderPane root = loader.load();

		Scene scene = new Scene(root, 300, 400);
		stage.setTitle("Calculadora");
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}

}
