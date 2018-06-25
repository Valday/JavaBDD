/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI.Popup;

import com.julienCreach.agenceVoyage.Modele.Accompagnateur;
import com.julienCreach.agenceVoyage.Modele.Circuit;
import com.julienCreach.agenceVoyage.managers.TableManager;
import com.julienCreach.utils.MessageBox;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AjoutCircuitController
{
    private static boolean isNewOrEdit;

    public static boolean isIsNewOrEdit()
    {
        return isNewOrEdit;
    }

    public static void setIsNewOrEdit(boolean isNewOrEdit)
    {
        AjoutCircuitController.isNewOrEdit = isNewOrEdit;
    }

    private static  Circuit _selectedCircuit;

    public static void set_selectedCircuit(Circuit _selectedCircuit)
    {
        AjoutCircuitController._selectedCircuit = _selectedCircuit;
    }

    @FXML
    private Button butCancel;

    @FXML
    private Button butValider;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldPlaceDispo;

    @FXML
    private TextField textFieldPrix;

    @FXML
    private DatePicker datePickDepart;

    @FXML
    private DatePicker datePickArrivee;

    @FXML
    private CheckBox checkBoxCircuitOpen;

    @FXML
    private ComboBox comboBoxAccompagnateurs;

    private ObservableList<String> _listNomAccompagnateurs;

    private List<Accompagnateur> _listAccompagnateurs;

    /**
     * Constructeur par defaut.
     */
    public AjoutCircuitController()
    {

    }

    @FXML
    private void butAnnulerClick()
    {
        // get a handle to the stage
        Stage stage = (Stage)butCancel.getScene().getWindow();

        // do what you have to do
        stage.close();
    }

    @FXML
    private void butValiderClick()
    {
        SimpleDateFormat simpleDateFormater = new SimpleDateFormat("dd/MM/yy");
        try
        {
            if((!this.textFieldName.getText().isEmpty())
                    && (!this.textFieldPlaceDispo.getText().isEmpty())
                    && (!this.textFieldPrix.getText().isEmpty())
                    && (this.datePickDepart.getValue() != null)
                    && (this.datePickArrivee.getValue() != null))
            {
                int idAcc = -1;
                for(int i = 0; i < this._listAccompagnateurs.size();i++)
                {
                    if(this.comboBoxAccompagnateurs.getSelectionModel().getSelectedItem().toString().contains(this._listAccompagnateurs.get(i).get_nameAccompagnateur())
                            && this.comboBoxAccompagnateurs.getSelectionModel().getSelectedItem().toString().contains(this._listAccompagnateurs.get(i).get_prenomAccompagnateur()))
                    {
                        idAcc = this._listAccompagnateurs.get(i).get_idAccompagnateur();
                    }
                }


                Circuit newCircuit = new Circuit(-1,
                        this.textFieldName.getText(),
                        Integer.parseInt(this.textFieldPlaceDispo.getText()),
                        Integer.parseInt(this.textFieldPrix.getText()),
                        simpleDateFormater.format(java.sql.Date.valueOf(this.datePickDepart.getValue())),
                        simpleDateFormater.format(java.sql.Date.valueOf(this.datePickArrivee.getValue())),
                        this.checkBoxCircuitOpen.isSelected(),
                        idAcc);
                if(isNewOrEdit)
                {
                    if(TableManager.Instance().get_circuitDAO().Add(newCircuit))
                    {
                        System.out.println(" => Circuit "+newCircuit.get_idCircuit()+" successfully add ...");

                        // get a handle to the stage
                        Stage stage = (Stage)butValider.getScene().getWindow();

                        // do what you have to do
                        stage.close();
                    }
                }
                else
                {

                    newCircuit.set_idCircuit(_selectedCircuit.get_idCircuit());

                    if(TableManager.Instance().get_circuitDAO().Edit(newCircuit))
                    {
                        System.out.println(" => Circuit "+newCircuit.get_idCircuit()+" successfully updated ...");

                        // get a handle to the stage
                        Stage stage = (Stage)butValider.getScene().getWindow();

                        // do what you have to do
                        stage.close();
                    }
                }
            }
            else
            {
                MessageBox.Show(Alert.AlertType.WARNING, "Champ(s) de saisie vide", "Merci de remplir tous les champs","");
            }
        }
            catch (NumberFormatException e)
        {
            MessageBox.Show(Alert.AlertType.ERROR,"Erreur de saisie","Le contenu du champ -Nombre de places- et -prix- doivent etre un nombre","");
        }
    }

    @FXML
    private void butAddAccClick()
    {
        try
        {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjoutAccompagnateur.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ajout Accompagnateur");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            this.loadComboxValue();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize()
    {
        this.loadComboxValue();
        if(!isNewOrEdit && _selectedCircuit != null)
        {
            this.loadEditValues();
        }

    }

    private void loadComboxValue()
    {
        try
        {
            this._listNomAccompagnateurs = this.comboBoxAccompagnateurs.getItems();
            this._listAccompagnateurs = new ArrayList<>();

            ResultSet allAccompagnateurs = TableManager.Instance().get_accompagnateurDAO().selectAll("Accompagnateurs");

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
            this.comboBoxAccompagnateurs.setItems(this._listNomAccompagnateurs);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void loadEditValues()
    {
            this.textFieldName.setText(_selectedCircuit.get_nameCircuit());
            this.textFieldPlaceDispo.setText(Integer.toString(_selectedCircuit.get_places()));
            this.textFieldPrix.setText(Integer.toString(_selectedCircuit.get_prix()));
            this.datePickDepart.setValue(LocalDate.parse(_selectedCircuit.get_dateDepart()));
            this.datePickArrivee.setValue(LocalDate.parse(_selectedCircuit.get_dateFin()));
            this.checkBoxCircuitOpen.setSelected(_selectedCircuit.is_open());
            this.comboBoxAccompagnateurs.getSelectionModel().select(_selectedCircuit.get_idAccompagnateur()-1);
    }
}
