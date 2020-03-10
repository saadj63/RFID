/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;

/**
 * FXML Controller class
 *
 * @author Saad_BAD
 */
public class Case_PaperController implements Initializable {
@FXML
private JFXButton home_btn;
@FXML
private void home(ActionEvent event) throws Exception
{
    
       //    Parent root = FXMLLoader.load(getClass().getResource("Doctor_Home_Page.fxml"));
        ((Node)event.getSource()).getScene().getWindow().hide();
        //Stage stage=new Stage();
        //Scene scene = new Scene(root);
        
       // stage.setScene(scene);
        //stage.show();
         
}
@FXML
private Label lrfid;
@FXML
private JFXButton pre_btn;
@FXML
private void pres(ActionEvent event)throws Exception
{


           Parent root = FXMLLoader.load(getClass().getResource("Prescription_Home_Page.fxml"));
        ((Node)event.getSource()).getScene().getWindow().hide();
         Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
         
}
 @FXML
 private JFXTextArea ts,ta,tad,tc,pms,pme;
 @FXML
 private JFXComboBox dcb1;
 @FXML
 private JFXComboBox dcb;
@FXML
private void case_register(ActionEvent event) throws SQLException, ClassNotFoundException
{    
    System.out.println(dcb1.getSelectionModel().getSelectedItem().toString());
                  String Username="root";
        String password="root123";
        String q = "Insert into medical_problems(rfid,date,symptoms,allergies,addiction,comments,doctor_name) values(?,?,?,?,?,?,?)";
       String q1 = "Insert into pre_medical_problems values(?,?,?)";
       
        String url = "jdbc:mysql://localhost:3306/emr";
          
              Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,Username,password);
       
        PreparedStatement pst=con.prepareStatement(q);
       PreparedStatement pst1=con.prepareStatement(q1);
       
DateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss" );
Date date=new Date();
String d=dateformat.format(date);

     pst.setInt(1,parseInt(lrfid.getText()));
     pst.setString(2,d.substring(0,10));
     pst.setString(3,ts.getText());
     pst.setString(4,ta.getText());
     pst.setString(5,tad.getText());
     pst.setString(6,tc.getText());
      pst.setString(7,dcb1.getSelectionModel().getSelectedItem().toString());
  
    pst1.setInt(1,parseInt(lrfid.getText()));
    pst1.setString(2,pme.getText());
    pst1.setString(3,pms.getText());
   
   boolean rs1=pst1.execute();
   boolean rs=pst.execute();
   if((rs==false && rs1==false))
           {
       JOptionPane.showMessageDialog(null," Medical Problem  Data stored");
       
           ((Node)event.getSource()).getScene().getWindow().hide();
         
   }
   else
   {
       JOptionPane.showMessageDialog(null,"Data not Stored");

   }  
  
   
        
          

    }





/**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setRfid(String s)
    {
        lrfid.setText(s);
    
     try{
            String Username="root";
        String password="root123";
     String url = "jdbc:mysql://localhost:3306/emr";
              Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection(url,Username,password);

     String  q1="select doctor_name from doctor";
     PreparedStatement pst1=null;
   pst1 =conn.prepareStatement(q1); 
    ResultSet rs1=pst1.executeQuery();
          while(rs1.next())
          {
             dcb1.getItems().add(rs1.getString("doctor_name"));
          }
          }catch(ClassNotFoundException | SQLException e)
    {
    System.out.println(e);
    }
    }



}




