package org.gks.problems.systemdesign.carddeck;

public class BlackJackCard extends Card {

	BlackJackCard(Suit s, int v) {
		super(s, v);
		// TODO Auto-generated constructor stub
	}
	
	public int value()
	{
		if(v<10) {
			return v;
		}
		return 10;
	}
}
