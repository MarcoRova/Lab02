package it.polito.tdp.model;

import java.util.*;

public class Dictionary {
	
	private Map<String, Word> dictionary;

	public Dictionary() {
		this.dictionary = new HashMap<>();
	}
	
	public void addAlienWord(String alienWord, String traduzione) {
		if(!dictionary.containsKey(alienWord)) {
			dictionary.put(alienWord, new Word(alienWord));
		}
		
		dictionary.get(alienWord).aggiungiTraduzione(traduzione);
	}
	
	public String traduci(String alienWord) {
		
		if(dictionary.containsKey(alienWord)) {
			return dictionary.get(alienWord).getTraduzioni();
		}
		else
			return null;
	}

	public String translateWordWildCard(String alienWildCard) {

		// Utilizzo le regular expression di Java (posso usare stringa.matches())
		// Sostituisco "?" con "."
		// "." nelle regex indica un qualsiasi carattere
		
		alienWildCard = alienWildCard.replaceAll("\\?", ".");

		int matchCounter = 0;
		StringBuilder sb = new StringBuilder();

		for (Word w : dictionary.values()) {
			if (w.getAlienWord().matches(alienWildCard)) {
				matchCounter++;
				sb.append(w.getTraduzioni());
			}
		}
		
		if (matchCounter != 0)
			return sb.toString();
		else
			return null;
	}	
}


