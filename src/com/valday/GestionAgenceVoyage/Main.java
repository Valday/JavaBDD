package com.valday.GestionAgenceVoyage;

import com.valday.GestionAgenceVoyage.DAO.AccompagnateurDAO;
import com.valday.GestionAgenceVoyage.DAO.CircuitDAO;
import com.valday.GestionAgenceVoyage.DAO.DAO;
import com.valday.GestionAgenceVoyage.GUI.LogInWindow;
import com.valday.GestionAgenceVoyage.Managers.JdbcConnectionManager;
import com.valday.GestionAgenceVoyage.Table.Accompagnateur;
import com.valday.GestionAgenceVoyage.Table.Circuit;
import com.valday.utils.xmlParser;
import org.w3c.dom.Document;

import javax.swing.*;

public class Main
{
    public static void main(String[] args) {
	    // Parsing fichier config xml
        Document doc = xmlParser.deserializeXML("D:\\Git\\JavaBDD","conf\\\\jdbcConfig.xml");
        String dataBaseUrl = xmlParser.nodeToOracleAddress(doc);

        JdbcConnectionManager.Instance().Open(dataBaseUrl);

        //region test

        DAO<Circuit> circuitDAO = new CircuitDAO(JdbcConnectionManager.Instance().get_connector());
        DAO<Accompagnateur> accompagnateurDAO = new AccompagnateurDAO(JdbcConnectionManager.Instance().get_connector());
        for(int i = 1; i < 5; i++){
            Circuit circuit = circuitDAO.find(i);
            Accompagnateur accompagnateur = accompagnateurDAO.find(i);
            System.out.println("\nCircuit N°" + circuit.get_id() + "  - " + circuit.get_name() + " \nPlaces disponnibles : " + circuit.get_placesDispo()+ " \nDate depart : "+circuit.get_dateDepart()+" \nDate de fin : "+circuit.get_dateFin()+" \nAnnulation : "+circuit.is_cancel());
            System.out.println("\nAccompagnateur N°" + accompagnateur.get_id() + " \nNom : " + accompagnateur.get_name());
            System.out.println("\n=====================================");

        }

        //endregion test


        // Appel interface connexion
        JFrame frame = new JFrame("JavaBDD");
        frame.setContentPane(new LogInWindow().PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
