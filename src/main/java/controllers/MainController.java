package controllers;

import application.Main;
import ciphers.Cipher;
import ciphers.impl.VigenereCipher;
import factories.CipherFactory;
import factories.impl.CipherFactoryImpl;
import file.utils.FileTool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;

import static factories.impl.CipherFactoryImpl.*;

public class MainController implements Initializable { //przez to że rozszerzamy Initializable, to pola stają się dynamiczne, dzięki temu nasze zmienne sa parsowane na fxml
    private Stage mainStage;
    private ObservableList<String> possibleCipherMethods =
            FXCollections.observableArrayList(Arrays.asList(CESAR, ROOT13, VIGENERE));
    private CipherFactory cipherFactory = new CipherFactoryImpl();

    @FXML
    public TextArea inputTextArea; // tekst wpisywany przez użytkownika
    @FXML
    ChoiceBox<String> cipherChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cipherChoiceBox.setItems(possibleCipherMethods);
        cipherChoiceBox.setValue(VIGENERE); //domyślna wartość
        mainStage = Main.getMainStage();
    }

    @FXML
    public void triggerEncoding() {         ///metoda wywołana przez buttona
        String userText = inputTextArea.getText();
        if (!userText.isEmpty()) {
            String cipherType = cipherChoiceBox.getValue(); //od użytkownika z listy typów wybieramy dany typ
            Cipher cipher = cipherFactory.create(cipherType); //tworzymy instancje szyfrujacą
            if (cipher instanceof VigenereCipher) { //
                TextInputDialog inputDialog = new TextInputDialog("Key"); //tworzymy nowy dialog z inputem
                inputDialog.setHeaderText("Please choose key and remember it. "); // ustawiamy na górze okienka do wpisania klucza co użytkownik ma zrobić
                inputDialog.setContentText("Key: "); // jak będzie oznaczona labelka z fieldem
                Optional<String> userInputOptional = inputDialog.showAndWait(); //czeka na wpisanie wartości
                if (userInputOptional.isPresent() && !userInputOptional.get().equals("")) { // jeśli wartość bedzie
                    ((VigenereCipher) cipher).setKey(userInputOptional.get()); // rzutujemy ciphera i ustawiamy seterem klucz
                } else {                      //(userInputOptional.get().equals("")) {  sprawdza czy jest pusty String
//                    Alert alert = new Alert(Alert.AlertType.WARNING); // szybkie narzędzie do powiadomienie użytkownika o błędzie
//                    alert.setTitle("warning");
//                    alert.setHeaderText("Key value can not be empty!");
//                    alert.showAndWait();
                    return;
                }
            }
            String encode = cipher.encode(userText); // wykonujemy encode i wstawiamy zaszyfrowany text
            inputTextArea.setText(encode);
        }
    }

    @FXML
    public void triggerDecoding() {         ///metoda wywołana przez buttona
        String userText = inputTextArea.getText();
        if (!userText.isEmpty()) {
            String cipherType = cipherChoiceBox.getValue();
            Cipher cipher = cipherFactory.create(cipherType);
            if (cipher instanceof VigenereCipher) {
                TextInputDialog inputDialog = new TextInputDialog("Key");
                inputDialog.setContentText("Key");
                inputDialog.setHeaderText("If you know the key, write it here. ");
                Optional<String> userInputOptional = inputDialog.showAndWait();
                if (userInputOptional.isPresent() && !userInputOptional.get().equals("")) {
                    ((VigenereCipher) (cipher)).setKey(userInputOptional.get());
                } else {
                    return;
                }
            }
            String decode = cipher.decode(userText);
            inputTextArea.setText(decode);
        }
    }

    @FXML
    public void saveToFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save to file");
        fileChooser.setInitialFileName("message.crpt");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("crypt file", "*.crpt"),
                new FileChooser.ExtensionFilter("text file", "*.txt")
        );
        File fileToSave = fileChooser.showSaveDialog(null);
        if (fileToSave != null) {
            String absolutePath = fileToSave.getAbsolutePath();
            FileTool.writeTextAreaContentToFile(absolutePath, inputTextArea.getText());
        }
    }

    public void loadFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("crypt file", "*.crpt"),
                new FileChooser.ExtensionFilter("text file", "*.txt")
        );
        File fileToLoad = fileChooser.showOpenDialog(mainStage);
        if (null != fileToLoad) {
            String fileContent = FileTool.getFileContent(fileToLoad.getAbsolutePath());
            inputTextArea.setText(fileContent);
        }
    }
}



