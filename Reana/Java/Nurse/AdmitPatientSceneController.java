/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dhara.Nurse;

import Users.Nurse;
import Users.Patient;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AdmitPatientSceneController implements Initializable {

    private static Nurse staticNurse;

    public static void passNurse(Nurse nurse) {
        staticNurse = nurse;
    }

    @FXML
    private TableView<Patient> patientTableView;
    @FXML
    private TableColumn<Patient, Integer> patientIdTableColoumn;
    @FXML
    private TableColumn<Patient, Boolean> admittedStatusTableColoumn;

    ObservableList<Patient> admittedPatientList = FXCollections.observableArrayList();
    ObservableList<Patient> nonAdmittedPatientList = FXCollections.observableArrayList();
    @FXML
    private TextField idSearchText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //System.out.println("passed nurse check" + staticNurse.getName());
        //System.out.println("this is nusre name" + nurse.getName());
        // TODO
        patientIdTableColoumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        admittedStatusTableColoumn.setCellValueFactory(new PropertyValueFactory<>("admittedStatus"));

        Nurse.readPatientLists(admittedPatientList, nonAdmittedPatientList);
        System.out.println("printing" + admittedPatientList + "list 2" + nonAdmittedPatientList);

        patientTableView.setItems(nonAdmittedPatientList);

    }

    @FXML
    private void admitButtonOnClick(ActionEvent event) {
        Patient selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
        if (selectedPatient != null) {

            selectedPatient.markAsadmitted();

            nonAdmittedPatientList.remove(selectedPatient);
            admittedPatientList.add(selectedPatient);

            Nurse.updatePatientAdmittedStatus(admittedPatientList, nonAdmittedPatientList);

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Patient admitted status changed successfully!");
            successAlert.showAndWait();
        } else {

        }
    }

    @FXML
    private void searchButtonOnClick(ActionEvent event) {
           String searchText = idSearchText.getText();
        FilteredList<Patient> filteredPatients = new FilteredList<>(nonAdmittedPatientList);
        filteredPatients.setPredicate(patient -> {
            String lowerCaseSearchText = searchText.toLowerCase();
            return String.valueOf(patient.getID()).contains(lowerCaseSearchText);
        });
        patientTableView.setItems(filteredPatients);
    }

    @FXML
    private void loadAllOnClick(ActionEvent event) {
         ObservableList<Patient> admittedPatientList = FXCollections.observableArrayList();
    ObservableList<Patient> nonAdmittedPatientList = FXCollections.observableArrayList();

        Nurse.readPatientLists(admittedPatientList, nonAdmittedPatientList);
        patientTableView.setItems(nonAdmittedPatientList);

        idSearchText.clear();
    }

}
