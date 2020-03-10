/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class Main_Home_PageController implements Initializable {

     Doctor_Home_PageController dp=new Doctor_Home_PageController();
@FXML
private JFXButton home_btn;
@FXML
private void home(ActionEvent event) throws Exception
{
    
        //   Parent root = FXMLLoader.load(getClass().getResource("Doctor_Home_Page.fxml"));
        ((Node)event.getSource()).getScene().getWindow().hide();
         //Stage stage=new Stage();
        //Scene scene = new Scene(root);
    
   //     stage.setScene(scene);
     //   stage.show();
         
}   
@FXML
public Label lrfid;
@FXML
public JFXButton load;
 @FXML
   private Label lname;
@FXML
   private Label lage,lw,lh,lbp,lbs,lt,lp,ld,la,lad,ls,lsdate,lfd,ltg,lc,ldnm;
@FXML
 private JFXComboBox jcm;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
}
 public void setRfid(String s)
    {
        lrfid.setText(s);
    
        
        
        String q;
        
                    String Username="root";
        String password="root123";
                   q = "Select rfid,name,age from reg_patient where rfid = ?";
                  String  q1="Select date,height,weight,bp,pulse,blood_sugar_level,temprature from vitals where rfid = ?";
                  String  q2="Select date,symptoms,allergies,addiction,comments,doctor_name from medical_problems where rfid = ?";
                  String  q3="Select * from treatment where rfid = ? ";
                   
                  String ul = "jdbc:mysql://localhost:3306/emr";
          try{
              Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(ul,Username,password);
        PreparedStatement pst=con.prepareStatement(q);
        PreparedStatement pst1=con.prepareStatement(q1);
        PreparedStatement pst2=con.prepareStatement(q2);
        PreparedStatement pst3=con.prepareStatement(q3);
        
        System.out.println(lrfid.getText());
        
        
        pst.setInt(1,parseInt(lrfid.getText()));
        pst1.setInt(1,parseInt(lrfid.getText()));
        pst2.setInt(1,parseInt(lrfid.getText()));
        pst3.setInt(1,parseInt(lrfid.getText()));
        
              ResultSet rs= pst.executeQuery();
              ResultSet rs1= pst1.executeQuery();
              ResultSet rs2= pst2.executeQuery();
              ResultSet rs3= pst3.executeQuery();
            
              rs.next();
              rs1.next();
              rs2.next();
              rs3.next();
        System.out.println(rs2.getString("doctor_name"));
              
          lrfid.setText(rs.getString("rfid"));
          lname.setText(rs.getString("name"));
          lage.setText(rs.getString("age"));
          lw.setText(rs1.getString("weight"));
          lh.setText(rs1.getString("height"));
          lbp.setText(rs1.getString("bp"));
          lbs.setText(rs1.getString("blood_sugar_level"));
          lt.setText(rs1.getString("temprature"));
          lp.setText(rs1.getString("pulse"));
          ld.setText(rs1.getString("Date"));
          jcm.getItems().add(rs2.getString("comments"));
          la.setText(rs2.getString("allergies"));
          lad.setText(rs2.getString("addiction"));
          ls.setText(rs2.getString("symptoms"));
          lsdate.setText(rs2.getString("date"));
        ldnm.setText(rs2.getString("doctor_name"));
          lfd.setText(rs3.getString("Final_Diagnosis"));
          ltg.setText(rs3.getString("Treatment_Given"));
          lc.setText(rs3.getString("Condition_at_the_time_of_Discharge"));
          
          }
          catch(   ClassNotFoundException | SQLException e){
          
System.out.println(e);               }
    }

}     // TODO
        
  
 

