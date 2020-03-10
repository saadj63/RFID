/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Saad_BAD
 */
public class Registration_PageController implements Initializable {
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
    private JFXTextField nm;
    @FXML
    private JFXTextField age;
    @FXML
    private JFXTextField phnno;
    @FXML
    private JFXRadioButton rb1;
    @FXML
    private JFXRadioButton rb2;
    @FXML
    private JFXTextField state;
    @FXML
    private JFXTextField city;
    @FXML
    private JFXTextField postalcode;
    @FXML
    private JFXTextArea address;
    @FXML
    private JFXTextField alternate_phnno;
   
    @FXML
    private JFXTextField g_nm; 
    
    @FXML
    private JFXTextField g_phnno;
    @FXML
    private JFXTextArea g_address;
    @FXML
    private JFXTextField rfid_no ;
    @FXML
    private JFXButton create_btn;
     @FXML
    private JFXTextField dob;
    
    @FXML
    public void register(ActionEvent eve)
    {
        
        if("".equals(rfid_no.getText()))
        {
            JOptionPane.showMessageDialog(null,"Enter rfid No");
        }
        else if ("".equals(nm.getText()))
        {
       JOptionPane.showMessageDialog(null,"Enter Name");
            
        }
        else if ("".equals(age.getText()))
        {
       JOptionPane.showMessageDialog(null,"Enter Age");
            
        }
        else if ("".equals(phnno.getText()))
        {
       JOptionPane.showMessageDialog(null,"Enter Phone No");
            
        }
        else if ("".equals(dob.getText()))
        {
       JOptionPane.showMessageDialog(null,"Enter Date Of Birth");
            
        }
        else if ("".equals(state.getText()))
        {
       JOptionPane.showMessageDialog(null,"Enter State");
            
        }
        
        else if ("".equals(city.getText()))
        {
       JOptionPane.showMessageDialog(null,"Enter City");
            
        }
        
        else if ("".equals(address.getText()))
        {
       JOptionPane.showMessageDialog(null,"Enter Address");
            
        }
        else if ("".equals(postalcode.getText()))
        {
       JOptionPane.showMessageDialog(null,"Enter Postal Code");
            
        }
        
        else if ("".equals(alternate_phnno.getText()))
        {
       JOptionPane.showMessageDialog(null,"Enter Alternate Phone No");
            
        }
        else if ("".equals(g_nm.getText()))
        {
       JOptionPane.showMessageDialog(null,"Enter Guardian Name");
            
        }
        
        else if ("".equals(g_phnno.getText()))
        {
       JOptionPane.showMessageDialog(null,"Enter Guardian Phone no");
            
        }
        else if ("".equals(g_address.getText()))
        {
       JOptionPane.showMessageDialog(null,"Enter Guardian Address");
            
        }
        else{
        String Username="root";
        String password="root123";
        String q = "Insert into reg_patient values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String url = "jdbc:mysql://localhost:3306/emr";
          try{
              Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,Username,password);
       
        PreparedStatement pst=con.prepareStatement(q);
       
       String rfid=rfid_no.getText();
      
        String f=nm.getText();
       String ag=age.getText();
       String ph=phnno.getText();
       String db=dob.getText();
       String g;
       if(rb1.isSelected()==true)
       {
        g="MALE";
       }
       else
       {
            g="FEMAlE";
       }String st=state.getText();
      String ct=city.getText();
      String ad=address.getText();
      String ps=postalcode.getText();
      String adp=alternate_phnno.getText();
      String gnm=g_nm.getText();
      String gph=g_phnno.getText();
      String ga=g_address.getText();
       
     pst.setString(1,rfid);
     pst.setString(2,f);
     pst.setString(3,ag);
     pst.setString(4,g);
     pst.setString(5,ph);
     pst.setString(6,db);
     pst.setString(7,st);
     pst.setString(8,ct);
     pst.setString(9,ad);
     pst.setString(10,ps);
     pst.setString(11,adp);
     pst.setString(12,gnm);
     pst.setString(13,gph);
     pst.setString(14,ga);

    
   boolean rs=pst.execute();
   if((rs==false))
           {
       JOptionPane.showMessageDialog(null,"Data stored");
       
            
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
    }
        /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
