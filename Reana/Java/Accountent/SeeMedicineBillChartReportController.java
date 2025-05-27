/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Dhara.Accountant;

import CommonScenes.StartSceneController;
import Model.Bill;

import Users.Accountant;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class SeeMedicineBillChartReportController implements Initializable {



private Accountant accountant; 

    public void setAccountant(Accountant accountant) {
        this.accountant = accountant;
    }

    public Accountant getAccountant() {
        return accountant;
    }
    @FXML
    private BarChart<String, Integer> BillBarChart;
    @FXML
    private NumberAxis xaxis;
    @FXML
    private CategoryAxis yaxis;
    
@Override
public void initialize(URL url, ResourceBundle rb) {
    ObservableList<Bill> billList = Accountant.readAllBillsList();

    XYChart.Series<String, Integer> series = new XYChart.Series<>();
    for (Bill bill : billList) {
        series.getData().add(new XYChart.Data<String, Integer>(Integer.toString(bill.getPatientId()), bill.getTotalDue()));

    }

    BillBarChart.getData().add(series);
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
    }


    

