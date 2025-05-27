 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dhara.Accountant; 

import CommonScenes.StartSceneController;
import Model.Bill;
import Model.ExpenseRecord;
import Users.Accountant;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ViewExpenseRecordSceneController implements Initializable {

    @FXML
    private Label detailsTextField;

    
    public Accountant getAccountant() {
        return accountant;
    }

    public void setAccountant(Accountant accountant) {
        this.accountant = accountant;
    }
    
    private Accountant accountant;
    @FXML
    private TableView<ExpenseRecord> expenseRecordsTableView;
    @FXML
    private TextField searchTextField;
    @FXML
    private TableColumn<ExpenseRecord, Double> amountTableColoumn;
    @FXML
    private TableColumn<ExpenseRecord, String> spentOnTableColoumn;
    @FXML
    private TableColumn<ExpenseRecord, LocalDate> dateSpenttableColoumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    amountTableColoumn.setCellValueFactory(new PropertyValueFactory<>("Amount"));
    spentOnTableColoumn.setCellValueFactory(new PropertyValueFactory<>("SpentOn"));
    dateSpenttableColoumn.setCellValueFactory(new PropertyValueFactory<>("DateSpent"));
      
    expenseRecordsTableView.setItems(Accountant.readExpenseRecordList());
    
    
    
        // TODO
        
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

    @FXML
    private void searchButtonOnClick(ActionEvent event) {
        
        String searchText = searchTextField.getText().trim().toLowerCase();

    ObservableList<ExpenseRecord> expenseRecordList = Accountant.readExpenseRecordList();

    FilteredList<ExpenseRecord> filteredExpenseRecordList = new FilteredList<>(expenseRecordList);
    filteredExpenseRecordList.setPredicate(record -> {
        if (searchText.isEmpty()) {
            return true;
        }
        return String.valueOf(record.getAmount()).contains(searchText) ||
               record.getSpentOn().toLowerCase().contains(searchText) ||
               String.valueOf(record.getDateSpent()).contains(searchText);
    });

    expenseRecordsTableView.setItems(filteredExpenseRecordList);
        
        
    }

    @FXML
    private void viewDetailsOnClick(ActionEvent event) {
         
    ExpenseRecord selectedRecord = expenseRecordsTableView.getSelectionModel().getSelectedItem();
    
    if (selectedRecord != null) {
       
        detailsTextField.setText(selectedRecord.getDetails());
    }
    }


        
    }
    

