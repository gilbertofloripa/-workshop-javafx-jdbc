package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {

	private static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));

			// Modificado para ScrollPane, para o menu ocupar toda a tela
			//Parent parent = loader.load();
			ScrollPane scrollPane = loader.load();
			scrollPane.setFitToHeight(true);// ocupapa a altura e largura da tela
			scrollPane.setFitToWidth(true);
			mainScene = new Scene(scrollPane);

			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Exemplo de aplicação JavaFX");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Metodo para pegar a instancia da tela principal pois ela e privada
	public static Scene getMainScene() {
		return mainScene;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
