package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

public class MainViewController implements Initializable{

	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepartment;

	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerActive() {
		System.out.println("onMenuItemSellerActive");
	}

	@FXML
	public void onMenuItemDepartmentActive() {
		loadView2("/gui/DepartmentList.fxml");
	}

	@FXML
	public void onMenuItemAboutActive() {
		loadView("/gui/About.fxml");
	}

	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

	// synchronized garante que todo o processo vai ser executado durante um multi thred
	private synchronized void loadView(String absoluteName) { 
		//Abre uma tela  recebendo o caminho
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			// Pega uma ref no xml do Vbox (out scena pai) onde ira fica a tela
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			// Pega um ref dos filhos do Vbox
			Node mainMenu = mainVBox.getChildren().get(0);
			
			// apaga todos os filhos da tela pai
			mainVBox.getChildren().clear();
			
			// adiciona novamente o menu dentro de VBox
			mainVBox.getChildren().add(mainMenu);
			
			mainVBox.getChildren().addAll(newBox.getChildren());
			
		}
		catch (IOException e) {
			Alerts.showAlert("IOException", "Erro de carregamento de Tela", 
					e.getMessage(), AlertType.ERROR);
		}
	}

	// temporario
	private synchronized void loadView2(String absoluteName) { 
		//Abre uma tela  recebendo o caminho
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			// Pega uma ref no xml do Vbox (out scena pai) onde ira fica a tela
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			// Pega um ref dos filhos do Vbox
			Node mainMenu = mainVBox.getChildren().get(0);
			
			// apaga todos os filhos da tela pai
			mainVBox.getChildren().clear();
			
			// adiciona novamente o menu dentro de VBox
			mainVBox.getChildren().add(mainMenu);
			
			mainVBox.getChildren().addAll(newBox.getChildren());
			
			//Temporario
			DepartmentListController controller = loader.getController();
			controller.setDepartmentService(new DepartmentService()); //carrega a tabela com alistya
			controller.updateTableView(); // atualiza a tabela
		}
		catch (IOException e) {
			Alerts.showAlert("IOException", "Erro de carregamento de Tela", 
					e.getMessage(), AlertType.ERROR);
		}
	}
}

