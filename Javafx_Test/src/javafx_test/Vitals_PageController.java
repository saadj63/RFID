/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class Vitals_PageController implements Initializable {
@FXML
private JFXButton home_btn;
@FXML
private void home(ActionEvent event) throws Exception
{
    
          // Parent root = FXMLLoader.load(getClass().getResource("Doctor_Home_Page.fxml"));
        ((Node)event.getSource()).getScene().getWindow().hide();
         //Stage stage=new Stage();
        //Scene scene = new Scene(root);
        
       // stage.setScene(scene);
       // stage.show();
         
}   
DateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss" );
Date date=new Date();
@FXML
private Label date_lbl,lrfid;

        String d=dateformat.format(date);

//date_lbl.setText();
/**
     * Initializes the controller class.
     */
@FXML
private JFXTextField th,tw,tp,tbp,tbs,tt;
@FXML
public void vital_register(ActionEvent eve)
    {//(rfid,Patient_Name,Patient_Age,Phone_No,Gender,Date_of_Birth,State,City,Postal_Code,Alternate_Phone_No,Guardian_Name,Guardian_Phone_No,Guardian_Address)
              String Username="root";
        String password="root123";
        String q = "Insert into vitals(rfid,date,height,weight,bp,pulse,blood_sugar_level,temprature) values(?,?,?,?,?,?,?,?)";
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
     pst.setString(3,th.getText());
     pst.setInt(4,parseInt(tw.getText()));
     pst.setInt(5,parseInt(tbp.getText()));
     pst.setInt(6,parseInt(tp.getText()));
     pst.setInt(7,parseInt(tbs.getText()));
     pst.setInt(8,parseInt(tt.getText()));
    
   boolean rs=pst.execute();
   if((rs==false))
           {
       JOptionPane.showMessageDialog(null," Vitals Data stored");
        ((Node)eve.getSource()).getScene().getWindow().hide();
       
            
   }
   else
   {
       JOptionPane.showMessageDialog(null,"Data not Stored");
   }  
  
   
        
          }catch(Exception e) 
          {
        JOptionPane.showMessageDialog(null,e);
    }  

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setRfid(String s)
    {
        lrfid.setText(s);
    }
}
