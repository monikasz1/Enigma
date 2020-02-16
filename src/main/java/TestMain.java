import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestMain extends Application { //klasa application rezerwuje ram, tworzy proces, wisza w powietrzu, czekając na działanie

    String resourcePath = "/fxml/Test.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception { //ta metoda to jest start aplikacji,stage wycinek ekranu, na stegau ustawiamy sceny

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(resourcePath)); //tworzymy loadera, który jest połączony z resourcem
        Parent root = loader.load(); //przez połączenie możemy załadować do Parenta zaaranżowana scenę
        Scene scene = new Scene(root, 600, 400); //tworzymy scenę, określamy szerokość wstawiamy na stage'u
        primaryStage.setTitle("Enigma"); //w lewym górnym rogu nazwa aplikacji
        primaryStage.setScene(scene); //tu mozemy ustawic scenę
        primaryStage.show();  //
    }
}
