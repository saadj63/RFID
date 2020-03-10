/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Array;
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
public class Prescription_Home_PageController implements Initializable {
    @FXML
    private Label lrfid;
@FXML
private JFXButton home_btn;
@FXML
private void home(ActionEvent event) throws Exception
{
    
 //          Parent root = FXMLLoader.load(getClass().getResource("Doctor_Home_Page.fxml"));
        ((Node)event.getSource()).getScene().getWindow().hide();
   //      Stage stage=new Stage();
     //   Scene scene = new Scene(root);
        
       // stage.setScene(scene);
        //stage.show();
         
}   
@FXML
private JFXTextField  td,tdd,tq;
@FXML
private JFXListView list,lq,ldo,lnm,lqu,ldos;
String a,q1,d1;
@FXML
public void add_pres()
{
    list.getItems().add(td.getText());
 a=list.getItems().toString();
  lq.getItems().add(tq.getText());
    q1=lq.getItems().toString();
  ldo.getItems().add(tdd.getText());
    d1=ldo.getItems().toString();
   tdd.setText("");
 td.setText("");
  tq.setText("");
}

@FXML
public void save(ActionEvent event)
{
                      String Username="root";
        String password="root123";
        String q = "Insert into prescription values(?,?,?,?,?)";
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
    pst.setString(3, a);
    pst.setString(4, q1);
    pst.setString(5, d1);
    
    
   boolean rs=pst.execute();
   if((rs==false))
           {
       JOptionPane.showMessageDialog(null," Prescription Data stored");
       
   ((Node)event.getSource()).getScene().getWindow().hide();
           
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
@FXML
private Label ld,ldnn,lpnm,lp;
        /**
     * 
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void setRfid(String s)
    {
        lrfid.setText(s);
    DateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss" );
Date date=new Date();
String d=dateformat.format(date);
    ld.setText(d.substring(0,10));
        
     String q;
        
                    String Username="root";
        String password="root123";
                   q = "Select * from prescription where rfid = ?";
               String  q1="Select * from reg_patient where rfid=?";
                  String ul = "jdbc:mysql://localhost:3306/emr";
          try{
              Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(ul,Username,password);
        PreparedStatement pst=con.prepareStatement(q);
       PreparedStatement pst1=con.prepareStatement(q1);
       
        
        System.out.println(lrfid.getText());
        pst.setInt(1,parseInt(lrfid.getText()));
        pst1.setInt(1,parseInt(lrfid.getText()));

              ResultSet rs= pst.executeQuery();
              ResultSet rs1= pst1.executeQuery();

            rs1.next();
              rs.next();
           lp.setText(rs.getString("pres_name"));
         lpnm.setText(rs1.getString("name"));
        // lnm.getItems().add(rs.getString("pres_name"));
          
            String a1=rs.getString("pres_name");
            String[] a2=a1.split(",");
            for(int i=0;i<a2.length;i++)
            {
            lnm.getItems().add(i, a2[i]);
            }
          
            
            String b1=rs.getString("quantity");
            String[] b2=b1.split(",");
            for(int i=0;i<b2.length;i++)
            {
            lqu.getItems().add(i, b2[i]);
            }
            
            
            String c1=rs.getString("dosage");
            String[] c2=c1.split(",");
            for(int i=0;i<c2.length;i++)
            {
            ldos.getItems().add(i, c2[i]);
            }
          }catch(   ClassNotFoundException | SQLException e){
          
JOptionPane.showMessageDialog(null,e);
               }
    }
}
