package Frontend;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AddBillController implements Initializable {

    @FXML
    private Label lbl_captcha;

    @FXML
    private TextField meterId;

    @FXML
    private TextField oneunit;

    @FXML
    private TextField units;

    @FXML
    private TextField amount;

    @FXML
    private TextField captcha;

    @FXML
    private Label statuslbl;
    
    @FXML
    private Label adminLabel;
    
    public void GetAdmin(String admin) {

		adminLabel.setText(admin);

   }

    @FXML
    void addmore(ActionEvent event) {
    	
    	meterId.setText("");
		oneunit.setText("");
		units.setText("");
		amount.setText("");
		captcha.setText("");
		statuslbl.setText("");

    }

    @FXML
    void dashboard(ActionEvent event) throws IOException {

    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/Frontend/Admin.fxml").openStream());
		Scene scene = new Scene(root);
		AdminController adminController = (AdminController)loader.getController();
	    adminController.GetAdmin(adminLabel.getText());
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
    }

    @FXML
    void exxit(ActionEvent event) {

    	System.exit(0);
    }

    @FXML
    void logout(ActionEvent event) throws IOException {

    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/Frontend/Login.fxml").openStream());
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
    }

    @FXML
    void reload(ActionEvent event) {
    	String myrandcatcha = random();
		lbl_captcha.setText(myrandcatcha);
    }
    public String random() {
    	Random rand = new Random();
    	return String.valueOf(rand.nextInt(10000 + 1));
    }
   
		
	

    @FXML
    void submit(ActionEvent event) {
    	
    	if(meterId.getText().trim().isEmpty() || amount.getText().trim().isEmpty() || 
    		units.getText().trim().isEmpty() || oneunit.getText().trim().isEmpty()
    		|| captcha.getText().trim().isEmpty()) 
    		
            statuslbl.setText("enter all details");
         else
         {
        	 statuslbl.setText("Submitted");
         }

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String myrandcatcha = random();
		lbl_captcha.setText(myrandcatcha);
		
	}

}
