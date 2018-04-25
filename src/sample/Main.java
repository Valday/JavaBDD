/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package sample;

import com.julienCreach.agenceVoyage.managers.JdbcConnectionManager;
import com.julienCreach.utils.XmlParser;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.w3c.dom.Document;

/**
 * Classe principale.
 * @author Julien Creach
 * @version 1.0
 */
public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("../com/julienCreach/agenceVoyage/GUI/LoginWindow.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Log In");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event)
            {
                JdbcConnectionManager.Instance().Close();
            }
        });
    }

    /**
     * Routine principale.
     * @param args arguments
     */
    public static void main(String[] args)
    {
        Document doc = XmlParser.deserializeXML("conf\\\\jdbcConfig.xml"); //deserialiszation du fichier de config

        String dataBaseUrl = XmlParser.nodeToOracleAddress(doc); //Concaténation de l'url

        JdbcConnectionManager.Instance().Open(dataBaseUrl, "tutor", "oracletutor");

        launch(args);
    }
}
