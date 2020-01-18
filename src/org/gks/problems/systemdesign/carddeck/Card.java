package org.gks.problems.systemdesign.carddeck;

public class Card {
	
	Suit s;
	int v;
	
	
	public Suit suit() {
		return s;
		
	}
	
	public int value() {
		return v;
	}
	
	Card(Suit s, int v){
		this.s = s;
		this.v = v;
	}

}
