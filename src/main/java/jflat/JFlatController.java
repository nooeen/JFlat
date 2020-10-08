package jflat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class JFlatController implements Initializable{

    public Database dictDB = new Database();
    public ObservableList<String> words = FXCollections.observableArrayList();

    @FXML public ListView<String> wordsList;
    @FXML public WebView defView;
    @FXML public TextField autoCompleteField;
    @FXML public Button switchBTN;

    @FXML public void initWordsList() {
        dictDB.listAV(words);
        //dictDB.listVA(words);
        wordsList.setItems(words);
    }

    @FXML public void getWordDef() {
        String selectedWord = wordsList.getSelectionModel().getSelectedItems().toString();
        StringBuilder sb = new StringBuilder(selectedWord);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        selectedWord = sb.toString();
        defView.getEngine().loadContent(dictDB.getEngDef(selectedWord), "text/html");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initWordsList();
    }



}
