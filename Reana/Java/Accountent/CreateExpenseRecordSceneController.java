/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dhara.Accountant;

import CommonScenes.StartSceneController;
import Users.Accountant;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class CreateExpenseRecordSceneController implements Initializable {
    Alert noDate = new Alert(Alert.AlertType.WARNING, "CHOOSE DATE");
    Alert unfill = new Alert(Alert.AlertType.WARNING, "FILL UP EVERYTHING");
    private Accountant accountant;

    public Accountant getAccountant() {
        return accountant;
    }

    public void setAccountant(Accountant accountant) {
        this.accountant = accountant;
    }
    
    
    

    @FXML
    private DatePicker expenseRecordDatePicker;
    @FXML
    private TextField addAmountTextField;
    @FXML
    private ComboBox<String> chooseSpendReasonComboBox;
    @FXML
    private TextField detailsTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
        ObservableList<String> items = FXCollections.observableArrayList(
                "Machinery", "Tiles", "Bed", "Plumbing", "Electricity","Other"
        );

        chooseSpendReasonComboBox.setItems(items);
    }    

    @FXML
    private void addButtonOnClick(ActionEvent event) {
        String amountText = addAmountTextField.getText();
        if (amountText.isEmpty()) {
            unfill.show();
            return;
        }

        try {
            double amount = Double.parseDouble(amountText);

            if (Double.isNaN(amount)) {
                Alert invalidAmountAlert = new Alert(Alert.AlertType.ERROR);
                invalidAmountAlert.setContentText("Invalid amount entered. Please enter a valid number.");
                invalidAmountAlert.showAndWait();
                return;
            }

            String ItemSpentOn = chooseSpendReasonComboBox.getValue();
            if (ItemSpentOn == null || ItemSpentOn.isEmpty()) {
                unfill.show();
                return;
            }

            LocalDate dateSpent = expenseRecordDatePicker.getValue();
            if (dateSpent == null) {
                noDate.show();
                return;
            }

            String details = detailsTextField.getText();
            if (details == null || details.isEmpty()) {
                unfill.show();
                return;
            }

            Boolean addStatus = accountant.CreateExpenseRecord(amount, ItemSpentOn, dateSpent, details);
            if (addStatus) {
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setContentText("New Expense added");
                successAlert.showAndWait();
            }
        } catch (NumberFormatException ex) {
            Alert invalidAmountAlert = new Alert(Alert.AlertType.ERROR);
            invalidAmountAlert.setContentText("Invalid amount format. Please enter a valid number.");
            invalidAmountAlert.showAndWait();
        }

        
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
      Parent parent = null;
        FXMLLoader accountantLoader = new FXMLLoader(getClass().getResource("ExpenditureMenuItem.fxml"));
        parent = (Parent) accountantLoader.load();
        Scene accountantScene = new Scene(parent);

        ExpenditureMenuItemController d = accountantLoader.getController();
        d.setAccountant(this.accountant);

        Stage accountantStage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        accountantStage.setScene(accountantScene);
        accountantStage.show();

    } 
    

    
}
