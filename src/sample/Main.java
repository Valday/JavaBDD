/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package sample;

import com.julienCreach.agenceVoyage.managers.JdbcConnectionManager;
import com.julienCreach.utils.xmlParser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.w3c.dom.Document;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("../com/julienCreach/agenceVoyage/GUI/loginWindow.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Log In");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        Document doc = xmlParser.deserializeXML("conf\\\\jdbcConfig.xml"); //deserialiszation du fichier de config

        String dataBaseUrl = xmlParser.nodeToOracleAddress(doc); //Concaténation de l'url

        JdbcConnectionManager.Instance().Open(dataBaseUrl, "tutor", "oracletutor");

        launch(args);
    }
}
