/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author Saad_BAD
 */
public class Doctor_Home_PageController implements Initializable {
@FXML
public JFXTextField trfid;
    @FXML
private JFXButton case_btn;
@FXML
private void case_paper(ActionEvent event)throws Exception
        { 
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("Case_Paper.fxml"));
           Parent root=loader.load();
           // ((Node)event.getSource()).getScene().getWindow().hide();
         Stage stage=new Stage();
        Scene scene = new Scene(root);
Case_PaperController cp=loader.getController();
    cp.setRfid(trfid.getText());
                    
        stage.setScene(scene);
        stage.show();
         
        }
@FXML
private JFXButton pre_btn;
@FXML
private void pres(ActionEvent event)throws Exception
{

FXMLLoader loader=new FXMLLoader(getClass().getResource("Prescription_Home_Page.fxml"));
           Parent root = loader.load();
           Prescription_Home_PageController ph=loader.getController();
           ph.setRfid(trfid.getText());
        //((Node)event.getSource()).getScene().getWindow().hide();
         Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
         
}
@FXML
private JFXButton vitals_btn;
@FXML
private void vitals(ActionEvent event)throws Exception
        {
FXMLLoader loader=new FXMLLoader(getClass().getResource("Vitals_Page.fxml"));
           Parent root = loader.load();
        //((Node)event.getSource()).getScene().getWindow().hide();
         Stage stage=new Stage();
        Scene scene = new Scene(root);
           Vitals_PageController ph=loader.getController();
           ph.setRfid(trfid.getText());
        
        stage.setScene(scene);
        stage.show();
         
        }
    @FXML
private JFXButton trt_btn;
@FXML
private void trt(ActionEvent event)throws Exception
        {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Treatment_Page.fxml"));
           Parent root = loader.load();
       // ((Node)event.getSource()).getScene().getWindow().hide();
         Stage stage=new Stage();
        Scene scene = new Scene(root);
        Treatment_PageController trt=loader.getController();
        trt.setRfid(trfid.getText());
        stage.setScene(scene);
        stage.show();
         
        }
    @FXML
private JFXButton db_btn;
  
    
@FXML
private void db(ActionEvent event)throws Exception
      {
      FXMLLoader loader=new FXMLLoader(getClass().getResource("Main_Home_Page.fxml"));
           Parent root = loader.load();
         //   ((Node)event.getSource()).getScene().getWindow().hide();
              Main_Home_PageController mh=loader.getController();
    mh.setRfid(trfid.getText());
            Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
         
        }

@FXML
private void report(ActionEvent event)throws Exception
        {
        
      FXMLLoader loader=new FXMLLoader(getClass().getResource("Lab_Page.fxml"));
           Parent root = loader.load();
         //((Node)event.getSource()).getScene().getWindow().hide();
         Stage stage=new Stage();
        Scene scene = new Scene(root);
          Lab_PageController lp=loader.getController();
    lp.setRfid(trfid.getText());
            
        stage.setScene(scene);
        stage.show();
         
        }
@FXML
private JFXButton new_btn;
@FXML
private void new_a(ActionEvent event) throws IOException
{
     Parent root = FXMLLoader.load(getClass().getResource("Doctor_Home_Page.fxml"));
        ((Node)event.getSource()).getScene().getWindow().hide();
         Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
          
}

@FXML
private JFXButton clickme;
@FXML
private Pane pane;
@FXML
private void panel() throws SQLException
{
    String q;
        
                    String Username="root";
        String password="root123";
                   q = "Select rfid from reg_patient where rfid = ?";
                  String ul = "jdbc:mysql://localhost:3306/emr";
          try{
              Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(ul,Username,password);
        PreparedStatement pst=con.prepareStatement(q);
        pst.setInt(1,parseInt(trfid.getText()));
   ResultSet rs=pst.executeQuery();
        if(rs.next())
   {pane.setVisible(true);
   }
   else
   {
       JOptionPane.showMessageDialog(null, "Patient with this RFID Not Present");
   }
}   catch (ClassNotFoundException ex) {
        Logger.getLogger(Doctor_Home_PageController.class.getName()).log(Level.SEVERE, null, ex);
    }
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
 pane.setVisible(false);
    }    
    
   public String getRfId()
   {
       return trfid.getText();
   }
}
