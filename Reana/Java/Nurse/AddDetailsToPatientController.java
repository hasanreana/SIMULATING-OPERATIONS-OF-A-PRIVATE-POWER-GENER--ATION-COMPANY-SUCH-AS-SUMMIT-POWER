/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dhara.Nurse;

import Model.PatientDetails;
import Users.Nurse;
import Users.Patient;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AddDetailsToPatientController implements Initializable {
    private Nurse nurse;
    @FXML
    private ComboBox<Integer> patientIDCB;
    @FXML
    private TextArea patientDetailsTextArea;
    @FXML
    private ComboBox<Integer> patientIDViewCB;
    private Label detailsLabel;
    @FXML
    private TableView<PatientDetails> notesTableView;
    @FXML
    private TableColumn<PatientDetails, String> noteTableColoumn;
    @FXML
    private TableColumn<PatientDetails, Integer> nurseAddedByTableColoumn;
    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
        System.out.println("nurse set in patientdeats"+ this.nurse.getName());
        
    }
    Alert unfill = new Alert(Alert.AlertType.WARNING, "FILL UP EVERYTHING");


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         patientIDCB.getItems().addAll(Patient.loadPatientIDs());
         patientIDViewCB.getItems().addAll(Patient.loadPatientIDs());
         
    }    

    @FXML
    private void addButtonOnClick(ActionEvent event) {
       Integer patientIdRead = patientIDCB.getValue();
        if (patientIdRead==null) {unfill.show(); return;}
        String details = patientDetailsTextArea.getText();
        if (details.isEmpty()){unfill.show(); return;}
       
        
        Boolean addStatus = this.nurse.addPatientDetails(patientIdRead, details, this.nurse.getID());
        if (addStatus) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("patient notes added");
            a.showAndWait();
        }
        patientDetailsTextArea.clear();
    }

    @FXML
    private void showDetailsOnClick(ActionEvent event) {
     Integer selectedPatientId = patientIDViewCB.getValue();
    
    if (selectedPatientId == null) {
        
        new Alert(Alert.AlertType.WARNING, "Select a patient ID first.").show();
        return;
    }
    
    List<PatientDetails> patientDetailsList = nurse.getPatientDetailsByPatientId(selectedPatientId);
    
    if (patientDetailsList.isEmpty()) {
       
        new Alert(Alert.AlertType.INFORMATION, "No patient notes found for the selected patient ID.").show();
        return;
    }
    
   
    ObservableList<PatientDetails> observableDetailsList = FXCollections.observableArrayList(patientDetailsList);
    
    
    
    noteTableColoumn.setCellValueFactory(new PropertyValueFactory<>("patientDetails"));
    nurseAddedByTableColoumn.setCellValueFactory(new PropertyValueFactory<>("nurseId"));
    
    
    
    notesTableView.setItems(observableDetailsList);
    }
           
        
    }
    
  
    
    

