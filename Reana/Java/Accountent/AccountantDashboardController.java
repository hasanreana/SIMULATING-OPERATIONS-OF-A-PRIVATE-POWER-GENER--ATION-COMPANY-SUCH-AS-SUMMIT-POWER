/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dhara.Accountant;

import CommonScenes.StartSceneController;
import Users.Accountant;
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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



/**
 * 
 * FXML Controller class
 *
 * @author Asus
 */
public class AccountantDashboardController implements Initializable {
    private Accountant accountant;
    @FXML
    private Label LabelFxid;

    public Accountant getAccountant() {
        return accountant;
    }

    public void setAccountant(Accountant accountant) {
        this.accountant = accountant;
         LabelFxid.setText("Name: "+ this.accountant.getName() + "  " + "ID: " + this.accountant.getID());
       
    }

    @FXML
    private BorderPane accountantDashBoardBorderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void InsuranceOnClick(ActionEvent event) {
                try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InsuranceMenuItemScene.fxml"));
        Parent root = loader.load();

       
        InsuranceMenuItemSceneController b = loader.getController();

        
        b.setAccountant(accountant);

        accountantDashBoardBorderPane.setCenter(root);
    } catch (IOException ex) {
        Logger.getLogger(AccountantDashboardController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void BIllOnClick(ActionEvent event) {
          try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BillMenuItemScene.fxml"));
        Parent root = loader.load();

       
        BillMenuItemSceneController b = loader.getController();

        
        b.setAccountant(accountant);

        accountantDashBoardBorderPane.setCenter(root);
    } catch (IOException ex) {
        Logger.getLogger(AccountantDashboardController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void expinditureOnClick(ActionEvent event) {
           try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ExpenditureMenuItem.fxml"));
        Parent root = loader.load();

       
        ExpenditureMenuItemController b = loader.getController();

        
        b.setAccountant(accountant);

        accountantDashBoardBorderPane.setCenter(root);
    } catch (IOException ex) {
        Logger.getLogger(AccountantDashboardController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    
@FXML
private void signOutOnClick(ActionEvent event) {
     try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignOut.fxml"));
        Parent root = loader.load();

       
        SignOutController b = loader.getController();

        
        b.setAccountant(accountant);

        accountantDashBoardBorderPane.setCenter(root);
    } catch (IOException ex) {
        Logger.getLogger(AccountantDashboardController.class.getName()).log(Level.SEVERE, null, ex);
    }

}

    @FXML
    private void resignationOnClick(ActionEvent event) {
         try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ResignationOnClick.fxml"));
        Parent root = loader.load();

       
        ResignationOnClickController b = loader.getController();

        
        b.setAccountant(accountant);

        accountantDashBoardBorderPane.setCenter(root);
    } catch (IOException ex) {
        Logger.getLogger(AccountantDashboardController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void feedbackOnClick(ActionEvent event) {
         try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddFeedBackAccountant.fxml"));
        Parent root = loader.load();

       
        AddFeedBackAccountantController b = loader.getController();

        
        b.setAccountant(accountant);

        accountantDashBoardBorderPane.setCenter(root);
    } catch (IOException ex) {
        Logger.getLogger(AccountantDashboardController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }


}
   
    
    

