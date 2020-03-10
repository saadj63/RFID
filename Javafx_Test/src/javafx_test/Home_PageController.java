/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton; 
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Saad_BAD
 */


public class Home_PageController implements Initializable {
@FXML
    private JFXButton pt_reg_btn;
@FXML 
private void regis(ActionEvent event) throws Exception
{
   Parent root = FXMLLoader.load(getClass().getResource("Registration_Page.fxml"));
        ((Node)event.getSource()).getScene().getWindow().hide();
         Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show(); 
}
@FXML
private JFXButton apt_btn;
@FXML
private void apt(ActionEvent event) throws Exception
{
  Parent root = FXMLLoader.load(getClass().getResource("Appointment_Page.fxml"));
        ((Node)event.getSource()).getScene().getWindow().hide();
         Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();    
}
@FXML
private JFXButton view1_btn;
@FXML
private void view1(ActionEvent event) throws Exception
{
  Parent root = FXMLLoader.load(getClass().getResource("View_Patient_Page.fxml"));
        ((Node)event.getSource()).getScene().getWindow().hide();
         Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();    
}
@FXML
private JFXButton exit_btn;
@FXML 
private void  exit(ActionEvent event) throws IOException
{
       Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        ((Node)event.getSource()).getScene().getWindow().hide();
         Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
}

/**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
