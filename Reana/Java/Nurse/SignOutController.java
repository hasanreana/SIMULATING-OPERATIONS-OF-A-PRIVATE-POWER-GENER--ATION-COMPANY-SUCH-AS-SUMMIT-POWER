/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dhara.Nurse;

import Dhara.Accountant.AccountantDashboardController;
import Users.Nurse;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class SignOutController implements Initializable {
  
 private Nurse nurse;
    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void noButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = null;
        FXMLLoader nurseLoader = new FXMLLoader(getClass().getResource("NurseDashBoardScene.fxml"));
        parent = (Parent) nurseLoader.load();
        Scene nurseScene = new Scene(parent);

        NurseDashBoardSceneController d = nurseLoader.getController();
        d.setNurse(this.nurse);

        Stage nurseStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        nurseStage.setScene(nurseScene);
        nurseStage.show();
    }

    @FXML
    private void yesButtonOnClick(ActionEvent event) {
        Parent login = null;
        try {
            login = FXMLLoader.load(getClass().getResource("/CommonScenes/StartScene.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Dhara.Nurse.SignOutController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene1 = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
    
}
