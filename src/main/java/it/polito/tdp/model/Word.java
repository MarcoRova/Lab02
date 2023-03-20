package it.polito.tdp.model;

import java.util.*;

public class Word {
	
	private String alienWord;
	private Set<String> traduzioni;
	
	public Word(String alienWord) {
		this.alienWord = alienWord;
		this.traduzioni = new HashSet<String>();
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public void aggiungiTraduzione(String trad) {
		traduzioni.add(trad);
	}
	
	public String getTraduzioni() {
		
		String trad = "";
		
		for(String t:traduzioni) {
			trad += t+"\n";
		}
		return trad;
	}

}
