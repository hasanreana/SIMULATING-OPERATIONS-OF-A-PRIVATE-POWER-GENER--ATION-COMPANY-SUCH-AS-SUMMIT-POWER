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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class PatientPieChartController implements Initializable {
private Nurse nurse;
    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }
    @FXML
    private PieChart patientPieChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         ObservableList<Patient> patients = Nurse.readPatientList();

        int admittedCount = 0;
        int notAdmittedCount = 0;
        for (Patient patient : patients) {
            if (patient.getAdmittedStatus()) {
                admittedCount++;
            } else {
                notAdmittedCount++;
            }
        }

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Admitted", admittedCount),
                new PieChart.Data("Not Admitted", notAdmittedCount));

        patientPieChart.setData(pieChartData);
        // TODO
    }    
    
}
