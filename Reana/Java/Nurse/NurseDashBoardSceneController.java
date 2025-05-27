/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dhara.Nurse;


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
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class NurseDashBoardSceneController implements Initializable {
   
    @FXML
    private BorderPane nurseDashboardBorderpane;
 private Nurse nurse;
    @FXML
    private Label nurseDashboardLabel;
    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
        System.out.println("nurse set in dashboard"+ this.nurse.getName());
         nurseDashboardLabel.setText("Name: "+ this.nurse.getName() + "  " + "ID: " + this.nurse.getID());
        
    }
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        // TODO
    }    

  
    @FXML
    private void viewAssignmentOnClick(ActionEvent event) {
         try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAssignedtasksScene.fxml"));
        Parent root = loader.load();

       
        ViewAssignedtasksSceneController b = loader.getController();

        
        b.setNurse(nurse);

        nurseDashboardBorderpane.setCenter(root);
    } catch (IOException ex) {
        Logger.getLogger(NurseDashBoardSceneController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    

    @FXML
    private void requestForDocOnClick(ActionEvent event) {
  try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ContactDoctorScene.fxml"));
        Parent root = loader.load();

       
        ContactDoctorSceneController b = loader.getController();

        
        b.setNurse(nurse);

        nurseDashboardBorderpane.setCenter(root);
    } catch (IOException ex) {
        Logger.getLogger(NurseDashBoardSceneController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    

    @FXML
    private void addPatientDetailsOnClick(ActionEvent event) {
         System.out.println("Nusre in button" + this.nurse.getName());
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddDetailsToPatient.fxml"));
        Parent root = loader.load();

       
        AddDetailsToPatientController b = loader.getController();

              System.out.println("nurse thats being passed" + this.nurse.getName());
        b.setNurse(this.nurse);

        nurseDashboardBorderpane.setCenter(root);
    } catch (IOException ex) {
        Logger.getLogger(NurseDashBoardSceneController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }

 
    


 


    

    @FXML
    private void dischargePatientOnClick(ActionEvent event) {
            try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DischargePatient.fxml"));
        Parent root = loader.load();

       
        DischargePatientController b = loader.getController();

        
        b.setNurse(nurse);

        nurseDashboardBorderpane.setCenter(root);
    } catch (IOException ex) {
        Logger.getLogger(NurseDashBoardSceneController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }



    @FXML
    private void admitPatientOnClickYas(ActionEvent event) {
         try {
             System.out.println("nurse is abt to be ");
        //AdmitPatientSceneController.passNurse(nurse);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdmitPatientScene.fxml"));
        Parent root = loader.load();

       
        //AdmitPatientSceneController b = loader.getController();

         
            // System.out.println("nurse pased"+ nurse.getName());

        nurseDashboardBorderpane.setCenter(root);
    } catch (IOException ex) {
        Logger.getLogger(NurseDashBoardSceneController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void patientChartOnClick(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientPieChart.fxml"));
        Parent root = loader.load();

       
        PatientPieChartController b = loader.getController();

        
        b.setNurse(nurse);

        nurseDashboardBorderpane.setCenter(root);
    } catch (IOException ex) {
        Logger.getLogger(NurseDashBoardSceneController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void patientInfoPdf(ActionEvent event) {
         try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientInfoPdf.fxml"));
        Parent root = loader.load();

       
        PatientInfoPdfController b = loader.getController();

        
        b.setNurse(nurse);

        nurseDashboardBorderpane.setCenter(root);
    } catch (IOException ex) {
        Logger.getLogger(NurseDashBoardSceneController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    

    @FXML
    private void signOutOnClick(ActionEvent event) {
         try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignOut.fxml"));
        Parent root = loader.load();

       
        SignOutController b = loader.getController();

        
        b.setNurse(nurse);

        nurseDashboardBorderpane.setCenter(root);
    } catch (IOException ex) {
        Logger.getLogger(NurseDashBoardSceneController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }

    @FXML
    private void FeedbackOnClick(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddFeedbackNurse.fxml"));
        Parent root = loader.load();

       
        AddFeedbackNurseController b = loader.getController();

        
        b.setNurse(nurse);

        nurseDashboardBorderpane.setCenter(root);
    } catch (IOException ex) {
        Logger.getLogger(NurseDashBoardSceneController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }

    @FXML
    private void ResignationOnClick(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddResignationNurse.fxml"));
        Parent root = loader.load();

       
        AddResignationNurseController b = loader.getController();

        
        b.setNurse(nurse);

        nurseDashboardBorderpane.setCenter(root);
    } catch (IOException ex) {
        Logger.getLogger(NurseDashBoardSceneController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
}
