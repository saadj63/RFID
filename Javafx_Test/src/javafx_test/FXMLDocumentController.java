/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_test;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Saad_BAD
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
       private JFXTextField username;
    @FXML
    private JFXPasswordField t2;
     
    
    @FXML
    private void loginbutton(ActionEvent event) throws Exception {
String u=username.getText();
 String p=t2.getText();
           System.out.println(p+u);
        if("abc".equals(u) && "123".equals(p))
        {
        Parent root = FXMLLoader.load(getClass().getResource("Home_Page.fxml"));
        ((Node)event.getSource()).getScene().getWindow().hide();
         Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
            
        }
        else if ("Doc".equals(u) && "doc".equals(p))  
        {
            Parent root = FXMLLoader.load(getClass().getResource("Doctor_Home_Page.fxml"));
        ((Node)event.getSource()).getScene().getWindow().hide();
         Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }
        else if ("Lab".equals(u) && "lab".equals(p))  
        {
            Parent root = FXMLLoader.load(getClass().getResource("Lab_Page.fxml"));
        ((Node)event.getSource()).getScene().getWindow().hide();
         Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Invalid Details");
        }
        
        
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

   
    }   

}

