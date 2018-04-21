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
        Document doc = xmlParser.deserializeXML("D:\\Git\\JavaBDD","conf\\\\jdbcConfig.xml");
        String dataBaseUrl = xmlParser.nodeToOracleAddress(doc);

        JdbcConnectionManager.Instance().Open(dataBaseUrl);

        launch(args);
    }
}
