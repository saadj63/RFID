/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Saad_BAD
 */
public class Lab_PageController implements Initializable {
@FXML
private JFXButton  upload;
@FXML
private JFXListView list;
@FXML
private Label lrfid;
@FXML
private void filechoser()
{
    FileChooser fc=new FileChooser();
    File selectedfile=fc.showOpenDialog(null);
    if(selectedfile != null)
    {
        list.getItems().add(selectedfile.getName());
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
    }
}
