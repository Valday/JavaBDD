package sample;

import com.valday.agenceVoyage.managers.JdbcConnectionManager;
import com.valday.utils.xmlParser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.w3c.dom.Document;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../com/valday/agenceVoyage/GUI/loginWindow.fxml"));
        primaryStage.setTitle("Log In");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        Document doc = xmlParser.deserializeXML("D:\\Git\\JavaBDD","conf\\\\jdbcConfig.xml");
        String dataBaseUrl = xmlParser.nodeToOracleAddress(doc);

        JdbcConnectionManager.Instance().Open(dataBaseUrl);

//        DAO<Circuit> circuitDAO = new CircuitDAO(JdbcConnectionManager.Instance().get_connector());
//        DAO<Accompagnateur> accompagnateurDAO = new AccompagnateurDAO(JdbcConnectionManager.Instance().get_connector());
//        DAO<Hotel> hotelDAO = new HotelDAO(JdbcConnectionManager.Instance().get_connector());
//        for(int i = 1; i < 5; i++){
//            Circuit circuit = circuitDAO.find(i);
//            Accompagnateur accompagnateur = accompagnateurDAO.find(i);
//            Hotel hotel = hotelDAO.find(i);
//            System.out.println("\nCircuit N°" + circuit.get_id() + "  - " + circuit.get_name() + " \nPlaces disponnibles : " + circuit.get_placesDispo()+ " \nDate depart : "+circuit.get_dateDepart()+" \nDate de fin : "+circuit.get_dateFin()+" \nAnnulation : "+circuit.is_cancel());
//            System.out.println("\nAccompagnateur N°" + accompagnateur.get_id() + " \nNom : " + accompagnateur.get_name());
//            System.out.println("\nHotel N°" + accompagnateur.get_id() + " \nNom : " + accompagnateur.get_name());
//            System.out.println("\n=====================================");
//
//        }

        launch(args);
    }
}
