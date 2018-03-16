package com.valday;

import com.valday.utils.xmlParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.swing.*;

public class Main
{
    public static void main(String[] args) {
	    // Parsing fichier config xml
        Document doc = xmlParser.deserializeXML("D:\\Git\\JavaBDD","conf\\\\jdbcConfig.xml");

        Element element = doc.getDocumentElement();
        NodeList nodeList = element.getChildNodes();
        String dataBaseUrl = xmlParser.nodeToOracleAddress(nodeList);
        JdbcConnectionManager JdbcConnector = new JdbcConnectionManager();
        JdbcConnector.Open(dataBaseUrl);

        // Appel interface connexion
        JFrame frame = new JFrame("JavaBDD");
        frame.setContentPane(new LogInWindow().PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
