package controllers;

import ciphers.Cipher;
import ciphers.impl.CesarCipher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable { //przez to że rozszerzamy Initializable, to pola stają się dynamiczne, dzięki temu nasze zmienne sa parsowane na fxml

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    @FXML
   public TextArea textArea; // tekst wpisywany przez użytkownika

    @FXML
    public void triggerEncoding() {         ///metoda wywołana przez buttona
        String userText = textArea.getText();
        if (!userText.isEmpty()) {
            Cipher cesarCipher = new CesarCipher();
            String encode = cesarCipher.encode(userText);
            textArea.setText(encode);
        }
    }

    @FXML
    public void triggerDecoding() {         ///metoda wywołana przez buttona
        String userText = textArea.getText();
        if (!userText.isEmpty()) {
            Cipher cesarCipher = new CesarCipher();
            String decode = cesarCipher.decode(userText);
            textArea.setText(decode);
        }
    }
}
