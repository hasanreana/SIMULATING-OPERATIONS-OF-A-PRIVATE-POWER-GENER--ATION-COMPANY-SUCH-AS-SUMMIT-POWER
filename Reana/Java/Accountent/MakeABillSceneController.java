/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dhara.Accountant;

import CommonScenes.StartSceneController;
import Model.Bill;
import Model.Cart;
import Model.Medicine;

import Model.Treatment;
import Users.Accountant;
import Users.Doctor;
import Users.Patient;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MakeABillSceneController implements Initializable {

    private Accountant accountant;

    @FXML
    private Label updateStatus;
    @FXML
    private Label treatmentPriceLabel;
    @FXML
    private ComboBox<Integer> patientIdComboBox;

    public Accountant getAccountant() {
        return accountant;
    }

    public void setAccountant(Accountant accountant) {
        this.accountant = accountant;
        System.out.println("Loaded to create: "+this.accountant.toString());
        System.out.println("this accountants id" +this.accountant.getID());
    }

    @FXML
    private ComboBox<String> treatmentComboBox;
    @FXML
    private ComboBox<String> medicineComboBox;
    @FXML
    private ComboBox<String> treatmentQuantityComboBox;
    @FXML
    private ComboBox<String> medicineQuantityComboBox;

    @FXML
    private Label medicinePriceLabel;

    private ComboBox<Integer> patientComboBox;
    @FXML
    private Label totalOutputTextField;

    private ArrayList<Medicine> medList = new ArrayList<>();
   
    private ArrayList<Cart> cartList = new ArrayList<>();
    @FXML
    private DatePicker DueByDatePicker;
    Alert noDate = new Alert(Alert.AlertType.WARNING, "CHOOSE DATE");
    Alert unfill = new Alert(Alert.AlertType.WARNING, "FILL UP EVERYTHING");
    /**
     * Initializes the controller class.
     */
    
    ArrayList<Treatment> treatmentList = Accountant.readTreatmentList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        medList.add(new Medicine("Square painkiller", 100));
        medList.add(new Medicine("Beximco Eye Drop", 200));
        medList.add(new Medicine("BD eye hospital special medicine", 300));
        medList.add(new Medicine("Poison", 400));
        medList.add(new Medicine("Eye Cancer drops", 500));

        for (Medicine m : medList) {
            medicineComboBox.getItems().add(m.getMedicineName());
        }

        /*treatmentList.add(new Treatment("eye cancer chemo", 40000));
        treatmentList.add(new Treatment("Lasik surgery", 50000));
        treatmentList.add(new Treatment("Just Checkup", 900));
        treatmentList.add(new Treatment("Normal Surgery", 10000));*/
   
        for (Treatment t : treatmentList) {
            treatmentComboBox.getItems().add(t.getTreatmentName());
        }

        for (int i = 1; i <= 10; i++) {
            medicineQuantityComboBox.getItems().add(Integer.toString(i));
            treatmentQuantityComboBox.getItems().add(Integer.toString(i));
        }
        
       
        
        patientIdComboBox.getItems().addAll(Patient.loadPatientIDs());
    }

    @FXML
    private void onClickTreatmentComboBox(ActionEvent event) {
        updateStatus.setText("..");
        for (Treatment t : treatmentList) {
            if (treatmentComboBox.getValue().equals(t.getTreatmentName())) {
                treatmentPriceLabel.setText(Float.toString(t.getTreatmentCost()));

            }
        }

    }

    @FXML
    private void onClickMedsComboBox(ActionEvent event) {
        updateStatus.setText("..");
        for (Medicine m : medList) {
            if (medicineComboBox.getValue().equals(m.getMedicineName())) {
                medicinePriceLabel.setText(Float.toString(m.getMedicinePrice()));

            }
        }
    }

    @FXML
    private void addBillOnClick(ActionEvent event) {
        
        
        int totalpayable = 0;
        for (Cart c : cartList) {
            totalpayable += c.getTotalAmount();
        }
        totalOutputTextField.setText(Integer.toString(totalpayable));
        

        Integer patientIdRead = patientIdComboBox.getValue();
        if (patientIdRead==null) {unfill.show(); return;}
        String tempBill = totalOutputTextField.getText();
        if (tempBill.isEmpty()){unfill.show(); return;}
        Integer totalBill = Integer.valueOf(tempBill);
        LocalDate due = DueByDatePicker.getValue();
        if (due == null) {noDate.show(); return;}
        
        Boolean addStatus = 
                accountant.addNewBill(patientIdRead, this.accountant.getID(), totalBill, due);
        if (addStatus) {
            Alert a = new Alert(AlertType.INFORMATION);
            a.setContentText("New Bill added");
            a.showAndWait();
        }

    }

    @FXML
    private void onClickAddTreatmentButton(ActionEvent event) {

        for (Cart c : cartList) {
            if (c.getProductName().equals(treatmentComboBox.getValue())) {
                int curval = Integer.parseInt(treatmentQuantityComboBox.getValue());

                if (curval + c.getQuantity() > 10) {
                    Alert a = new Alert(AlertType.ERROR);

                    a.setContentText("Quantity exceeds the maximum allowed(10)");

                    a.showAndWait();
                    return;
                }

                c.setQuantity(c.getQuantity() + curval);

                return;
            }
            cartList.add(new Cart(treatmentComboBox.getValue(),
                    Float.parseFloat(treatmentPriceLabel.getText()),
                    Integer.parseInt(treatmentQuantityComboBox.getValue())
            ));
            updateStatus.setText("treatment added successfully");

        }

    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {

        Parent parent = null;
        FXMLLoader accountantLoader = new FXMLLoader(getClass().getResource("BillMenuItemScene.fxml"));
        parent = (Parent) accountantLoader.load();
        Scene accountantScene = new Scene(parent);

        BillMenuItemSceneController d = accountantLoader.getController();
        d.setAccountant(this.accountant);

        Stage accountantStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        accountantStage.setScene(accountantScene);
        accountantStage.show();

    }

    @FXML
    private void addMedicineOnClick(ActionEvent event) {
        for (Cart c : cartList) {
            if (c.getProductName().equals(medicineComboBox.getValue())) {
                int curval = Integer.parseInt(medicineQuantityComboBox.getValue());

                if (curval + c.getQuantity() > 10) {
                    Alert a = new Alert(AlertType.ERROR);

                    a.setContentText("Quantity exceeds the maximum allowed(10)");

                    a.showAndWait();
                    return;
                }

                c.setQuantity(c.getQuantity() + curval);

                return;
            }
        }
        cartList.add(new Cart(medicineComboBox.getValue(),
                Float.parseFloat(medicinePriceLabel.getText()),
                Integer.parseInt(medicineQuantityComboBox.getValue())));

        updateStatus.setText("added successfully");

    }
    
    @FXML
    private void showTotalOnClick(ActionEvent event) {
        updateStatus.setText("");
        int totalpayable = 0;
        for (Cart c : cartList) {
            totalpayable += c.getTotalAmount();
        }
        totalOutputTextField.setText(Integer.toString(totalpayable));
    }

}
