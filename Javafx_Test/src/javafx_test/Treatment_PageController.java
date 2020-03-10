/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Saad_BAD
 */
public class Treatment_PageController implements Initializable {

   @FXML
   private Label lrfid;
    
@FXML
private JFXButton home_btn;
@FXML
private void home(ActionEvent event) throws Exception
{
    
//           Parent root = FXMLLoader.load(getClass().getResource("Doctor_Home_Page.fxml"));
        ((Node)event.getSource()).getScene().getWindow().hide();
  //       Stage stage=new Stage();
    //    Scene scene = new Scene(root);
     
        
      //  stage.setScene(scene);
        //stage.show();
         
}   


@FXML
private JFXButton trtsave_btn;
@FXML
private JFXTextArea tfd,ttg,tcd;
@FXML 
private Label ldnm;
@FXML
private void trt_save(ActionEvent eve)
{
    
     String Username="root";
        String password="root123";
        String q = "Insert into treatment (rfid,date,Final_Diagnosis,Treatment_Given,Condition_at_the_time_of_Discharge,Doctor_Name)values(?,?,?,?,?,?)";
        String url = "jdbc:mysql://localhost:3306/emr";
          try{
              Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,Username,password);
       
        PreparedStatement pst=con.prepareStatement(q);
       
DateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss" );
Date date=new Date();
String d=dateformat.format(date);

     pst.setInt(1,parseInt(lrfid.getText()));
     pst.setString(2,d.substring(0,10));
     pst.setString(3,tfd.getText());
     pst.setString(4,ttg.getText());
     pst.setString(5,tcd.getText());
     pst.setString(6,jcdnm.getSelectionModel().getSelectedItem().toString());
   boolean rs=pst.execute();  
   if((rs==false))
           {
       JOptionPane.showMessageDialog(null," Data stored");
        ((Node)eve.getSource()).getScene().getWindow().hide();
       
            
   }
   else
   {
       JOptionPane.showMessageDialog(null,"Data not Stored");
   }  
  
   
        
          }catch(Exception e) 
          {
System.out.println(e);    }  

    
}
@FXML
private Label ld;
@FXML
private JFXComboBox jcdnm;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    public void setRfid(String s) throws ClassNotFoundException, SQLException
    {
        lrfid.setText(s);
   
                String Username="root";
        String password="root123";
                                String  q1="Select * from reg_patient where rfid=?";
                  String ul = "jdbc:mysql://localhost:3306/emr";
         
              Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(ul,Username,password);
       PreparedStatement pst1=con.prepareStatement(q1);
       String  q2="select doctor_name from doctor";
     PreparedStatement pst2=null;
   pst2 =con.prepareStatement(q2); 
    ResultSet rs2=pst2.executeQuery();
          while(rs2.next())
          {
             jcdnm.getItems().add(rs2.getString("doctor_name"));
          }
     
        
        
DateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss" );
Date date=new Date();
String d=dateformat.format(date);
ld.setText(d);
    
    }
    
    
}
