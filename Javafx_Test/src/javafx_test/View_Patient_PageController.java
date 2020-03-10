/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_test;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import net.proteanit.sql.DbUtils;

/**
 * FXML Controller class
 *
 * @author Saad_BAD
 */
public class View_Patient_PageController implements Initializable {
    
@FXML
private TableView t1;
@FXML
private TableColumn rfid_col,nm_col,phnno_col,city_col;
@FXML
private JFXButton home_btn;
@FXML
private void home(ActionEvent event) throws Exception
{
    
           Parent root = FXMLLoader.load(getClass().getResource("Home_Page.fxml"));
        ((Node)event.getSource()).getScene().getWindow().hide();
         Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
         
}
 @FXML
 private void di(ActionEvent event) throws Exception
 {
   
     
     
 }
 
 /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
          String Username="root";
        String password="root123";
        String q = "Select * from reg_patient ";
        String ul = "jdbc:mysql://localhost:3306/test";
          try{
              Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(ul,Username,password);
        PreparedStatement pst=con.prepareStatement(q);
     
       ResultSet rs= pst.executeQuery();
      while(rs.next())
      {
         // t1.
      }
       
          }catch(Exception e){}
    
    }    
    
}
