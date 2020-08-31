package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

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
		System.out.println("onMenuItemDepartmentActive");
	}

	@FXML
	public void onMenuItemAboutActive() {
		System.out.println("onMenuItemAboutActive");
	}

	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

}
