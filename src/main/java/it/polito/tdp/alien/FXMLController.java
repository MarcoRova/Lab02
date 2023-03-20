package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Dictionary dictionary = new Dictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnTraslate;

    @FXML
    private TextField txtInput;

    @FXML
    private TextArea txtResult;

    @FXML
    void doClear(ActionEvent event) {
    	this.txtResult.clear();
    	this.txtInput.clear();
    }

    @FXML
    void doTraslate(ActionEvent event) {
    	
    	this.txtResult.clear();
    	
    	String input = this.txtInput.getText().toLowerCase();
    	
    	if(input.length()==0) {
    		this.txtResult.setText("Inserire almeno 1 parola!");
    	}
    	
    	StringTokenizer st = new StringTokenizer(input, " ");
    	
    	String alienWord = st.nextToken();
    	
    	if(st.hasMoreTokens()) {
    		
    		String traduzione = st.nextToken();
    		
    		if (!alienWord.matches("[a-zA-Z]*") || !traduzione.matches("[a-zA-Z]*")) {
				txtResult.setText("Inserire solo caratteri alfabetici.");
				return;
			}
    		
    		this.dictionary.addAlienWord(alienWord, traduzione);
    		txtResult.setText("La parola: \"" + alienWord + "\", con traduzione: \"" + traduzione + "\", è stata inserita nel dizionario.");
    	}
    	
    	else {
    		if (!alienWord.matches("[a-zA-Z?]*")) {
				txtResult.setText("Inserire solo caratteri alfabetici.");
				return;
			}

			String translation;
			
			if (alienWord.matches("[a-zA-Z?]*") && !alienWord.matches("[a-zA-Z]*")) {

				// Traduzione con WildCard
				translation = this.dictionary.translateWordWildCard(alienWord);

			} else {

				// Traduzione classica
				translation = this.dictionary.traduci(alienWord);
			}
			

			if (translation != null) {
				txtResult.setText(translation);
			} else {
				txtResult.setText("La parola cercata non esiste nel dizionario.");
			}
    	}
    }

    @FXML
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTraslate != null : "fx:id=\"btnTraslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
