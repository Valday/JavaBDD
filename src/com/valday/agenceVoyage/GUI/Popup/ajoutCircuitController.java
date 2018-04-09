package com.valday.agenceVoyage.GUI.Popup;

import com.valday.agenceVoyage.DAO.AccompagnateurDAO;
import com.valday.agenceVoyage.DAO.CircuitDAO;
import com.valday.agenceVoyage.DAO.DAO;
import com.valday.agenceVoyage.Table.Accompagnateur;
import com.valday.agenceVoyage.Table.Circuit;
import com.valday.agenceVoyage.managers.JdbcConnectionManager;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
    private TextField textField_prix;

    @FXML
    private DatePicker datePick_depart;

    @FXML
    private DatePicker datePick_arrivee;

    @FXML
    private CheckBox checkBox_circuitOpen;

    @FXML
    private ComboBox comboBox_accompagnateurs;

    private ObservableList<String> _listNomAccompagnateurs;

    private List<Accompagnateur> _listAccompagnateurs;
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
        int idAcc = -1;
        for(int i = 0; i < this._listAccompagnateurs.size();i++)
        {
            if(this.comboBox_accompagnateurs.getSelectionModel().getSelectedItem().toString().contains(this._listAccompagnateurs.get(i).get_nameAccompagnateur())
                    && this.comboBox_accompagnateurs.getSelectionModel().getSelectedItem().toString().contains(this._listAccompagnateurs.get(i).get_prenomAccompagnateur()))
            {
                idAcc = this._listAccompagnateurs.get(i).get_idAccompagnateur();
            }
        }

        newCircuit = new Circuit(circuitDAO.Count()+1,
                this.textField_name.getText(),
                Integer.parseInt(this.textField_placeDispo.getText()),
                Integer.parseInt(this.textField_prix.getText()),
                simpleDateFormater.format(java.sql.Date.valueOf(this.datePick_depart.getValue())),
                simpleDateFormater.format(java.sql.Date.valueOf(this.datePick_arrivee.getValue())),
                this.checkBox_circuitOpen.isSelected(),
                idAcc);

        if(circuitDAO.Add(newCircuit))
        {
            System.out.println(" => Circuit successfully add ...");
            // get a handle to the stage
            Stage stage = (Stage) but_Valider.getScene().getWindow();

            // do what you have to do
            stage.close();
        }
    }

    @FXML
    private void initialize()
    {
        try
        {
            this._listNomAccompagnateurs = this.comboBox_accompagnateurs.getItems();
            this._listAccompagnateurs = new ArrayList<>();

            DAO<Accompagnateur> accompagnateurDAO = new AccompagnateurDAO(JdbcConnectionManager.Instance().get_connector());
            ResultSet allAccompagnateurs = accompagnateurDAO.selectAll();

            while (allAccompagnateurs.next())
            {
                Accompagnateur newAccompagnateur = new Accompagnateur(allAccompagnateurs.getInt(1),
                        allAccompagnateurs.getString(2),
                        allAccompagnateurs.getString(3),
                        allAccompagnateurs.getString(4),
                        allAccompagnateurs.getInt(5),
                        allAccompagnateurs.getString(6),
                        allAccompagnateurs.getString(7),
                        allAccompagnateurs.getString(8));

                this._listAccompagnateurs.add(newAccompagnateur);
                this._listNomAccompagnateurs.add(newAccompagnateur.get_nameAccompagnateur()+" "+newAccompagnateur.get_prenomAccompagnateur());
            }
            this.comboBox_accompagnateurs.setItems(this._listNomAccompagnateurs);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
