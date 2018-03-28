package com.valday.agenceVoyage.GUI.Popup;

import com.valday.agenceVoyage.DAO.CircuitDAO;
import com.valday.agenceVoyage.DAO.DAO;
import com.valday.agenceVoyage.Table.Circuit;
import com.valday.agenceVoyage.managers.JdbcConnectionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;

public class ajoutCircuitController
{
    @FXML
    private Button but_cancel;

    @FXML
    private Button but_Valider;

    @FXML
    private TextField textField_name;

    @FXML
    private TextField textField_placeDispo;

    @FXML
    private DatePicker datePick_depart;

    @FXML
    private DatePicker datePick_arrivee;

    @FXML
    private void but_AnnulerClick()
    {
        // get a handle to the stage
        Stage stage = (Stage) but_cancel.getScene().getWindow();

        // do what you have to do
        stage.close();
    }

    @FXML
    private void but_ValiderClick()
    {
        DAO<Circuit> circuitDAO = new CircuitDAO(JdbcConnectionManager.Instance().get_connector());
        SimpleDateFormat simpleDateFormater = new SimpleDateFormat("dd/MM/yy");
        Circuit newCircuit = null;
            newCircuit = new Circuit(circuitDAO.Count()+1, this.textField_name.getText(), Integer.parseInt(this.textField_placeDispo.getText()), simpleDateFormater.format(java.sql.Date.valueOf(this.datePick_depart.getValue())), simpleDateFormater.format(java.sql.Date.valueOf(this.datePick_arrivee.getValue())),false);

        if(circuitDAO.Add(newCircuit))
        {
            System.out.println(" => Circuit successfully add ...");
            // get a handle to the stage
            Stage stage = (Stage) but_Valider.getScene().getWindow();

            // do what you have to do
            stage.close();
        }

    }
}
