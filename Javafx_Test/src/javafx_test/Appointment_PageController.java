/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
/**
 * FXML Controller class
 *
 * @author Saad_BAD
 */



public class Appointment_PageController implements Initializable {

    @FXML
   private JFXTextField  trfid;
    @FXML
    private Label lpnm,ld;
    @FXML
    private JFXComboBox jcd;
    @FXML
    private JFXDatePicker datep;
    @FXML
    private JFXTimePicker timep;
    
    @FXML
private JFXButton home_btn,book_btn;
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
private void se()
{
        
                    String Username="root";
        String password="root123";
                                String  q1="Select * from reg_patient where rfid=?";
                  String ul = "jdbc:mysql://localhost:3306/emr";
          try{
              Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(ul,Username,password);
       PreparedStatement pst1=con.prepareStatement(q1);
       String  q2="select doctor_name from doctor";
     PreparedStatement pst2=null;
   pst2 =con.prepareStatement(q2); 
    ResultSet rs2=pst2.executeQuery();
          while(rs2.next())
          {
             jcd.getItems().add(rs2.getString("doctor_name"));
          }
     
        
        pst1.setInt(1,parseInt(trfid.getText()));

              ResultSet rs1= pst1.executeQuery();

            rs1.next();
         lpnm.setText(rs1.getString("name"));
         
          
          }
          catch(   ClassNotFoundException | SQLException e){
          
JOptionPane.showMessageDialog(null,e);
               }
 
}
@FXML
private String book(ActionEvent eve)
{
    
    
                  String Username="root";
        String password="root123";
        String q = "Insert into appointment values(?,?,?,?,?,?)";
        String q1 = "Select phoneno from reg_patient where rfid=?";

        String url = "jdbc:mysql://localhost:3306/emr";
          try{
              Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,Username,password);
       
        PreparedStatement pst=con.prepareStatement(q);
         PreparedStatement pst1=con.prepareStatement(q1);
       
DateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss" );
Date date=new Date();
String d=dateformat.format(date);


// Default Date Pattern
	 String pattern = "MM/dd/yyyy";
	// The Date Time Converter
	 DateTimeFormatter dtFormatter;
	
	dtFormatter = DateTimeFormatter.ofPattern(pattern);
	
	//	this.pattern = pattern;
		dtFormatter = DateTimeFormatter.ofPattern(pattern);
    String da;
                LocalDate dat = datep.getValue();
    da=dtFormatter.format(dat);
     pst.setInt(1,parseInt(trfid.getText()));
     pst.setString(2,d.substring(0,10));
     pst.setString(3,lpnm.getText());
     pst.setString(4,jcd.getSelectionModel().getSelectedItem().toString());
     pst.setString(5,da);
     pst.setString(6,timep.getValue().toString());
     
     pst1.setInt(1,parseInt(trfid.getText()));
     ResultSet rs1=pst1.executeQuery();
     boolean rs=pst.execute();
     rs1.next();
                     int phn=rs1.getInt("phoneno");
                System.out.println(phn)  ;   
  String ph=Integer.toString(phn);
     if((rs==false))
           {
               
               
       try{
       // Construct data
			String apiKey = "apikey=" + "2oUkIAakQDU-MHlB0iIdoHkyafIzUtAMjovIfhb67T";
			String message = "&message=" + " Dear Patient Your Appointment is Booked with "+jcd.getSelectionModel().getSelectedItem().toString()+" on "+da+" Time "+timep.getValue().toString();
			String sender = "&sender=" + "Hospital";
			String numbers = "&numbers=" +"+919011483749" ;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				//stringBuffer.append(line);
	JOptionPane.showMessageDialog(null,"Appointment Booked");
       
                                JOptionPane.showMessageDialog(null,line);
                    Parent root = FXMLLoader.load(getClass().getResource("Home_Page.fxml"));
        ((Node)eve.getSource()).getScene().getWindow().hide();
         Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
            
       
                        }
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error SMS "+e);
			return "Error "+e;
		}
       //    ((Node)event.getSource()).getScene().getWindow().hide();
         
   }
   
         }catch(Exception e) 
          {
       System.out.println(e);
    }
        return null;
   
        
       
  
    
    
    
    
}

    @FXML
private void cre(ActionEvent event) throws Exception
{
    
   Parent root = FXMLLoader.load(getClass().getResource("Registration_Page.fxml"));
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
       

    DateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss" );
Date date=new Date();
String d=dateformat.format(date);
    ld.setText(d.substring(0,10));
        
    
          
       

    
    }
}
