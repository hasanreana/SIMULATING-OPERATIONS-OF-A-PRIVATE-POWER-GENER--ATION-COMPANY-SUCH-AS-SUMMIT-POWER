/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dhara.Nurse;

import Users.Nurse;
import Users.Patient;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class PatientInfoPdfController implements Initializable {

    private Nurse nurse;

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    @FXML
    private TableView<Patient> patientTableView;
    @FXML
    private TableColumn<Patient, Integer> IdTableColoumn;
    @FXML
    private TableColumn<Patient, String> NameTableColoumn;
    @FXML
    private TableColumn<Patient, String> genderTableColoumn;
    @FXML
    private TableColumn<Patient, LocalDate> DOBTableColoumn;
    @FXML
    private TableColumn<Patient, String> emailTableColoumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IdTableColoumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        NameTableColoumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        genderTableColoumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        DOBTableColoumn.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        emailTableColoumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        patientTableView.setItems(Nurse.readPatientList());
        // TODO
    }

    @FXML
    private void onClickMakePdf(ActionEvent event) throws FileNotFoundException, IOException, ClassNotFoundException {

     FileChooser fc = new FileChooser();
    fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
    fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", ".jpg", ".bmp", "*.png"));
    File f = fc.showSaveDialog(null);
    
    if (f != null) {
        PdfWriter pw = new PdfWriter(new FileOutputStream(f));
        PdfDocument pdf = new PdfDocument(pw);
        pdf.addNewPage();
        Document doc = new Document(pdf);
        doc.setLeftMargin(70);

        Text titleText = new Text("Patients currently in BD Eye Hospital");
                titleText.setFontSize(18f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();   


        ObservableList<Patient> patients = Nurse.readPatientList();
        
       
        Table patientTable = new Table(5); 
      
        patientTable.addCell("Patient ID");
        patientTable.addCell("Name");
        patientTable.addCell("Admitted Status");
        patientTable.addCell("Admitted Date");
        patientTable.addCell("Gender");

       
        for (Patient patient : patients) {
            patientTable.addCell(String.valueOf(patient.getID()));
            patientTable.addCell(patient.getName());
            patientTable.addCell(patient.getAdmittedStatus() ? "True" : "False");
            patientTable.addCell(patient.getAdmittedDate() != null ? patient.getAdmittedDate().toString() : "N/A");
            patientTable.addCell(patient.getGender());
        }

        doc.add(pageTitle);
        doc.add(patientTable);

        doc.close();

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("PDF Generated successfully!");
        a.showAndWait();
    } else {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("PDF Generation failed!");
        a.showAndWait();
    }
    }
}


 