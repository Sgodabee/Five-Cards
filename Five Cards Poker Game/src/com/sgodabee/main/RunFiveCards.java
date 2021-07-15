package com.sgodabee.main;

import com.sgodabee.card.Card;
import com.sgodabee.hands.Hand;

import java.util.*;

public class RunFiveCards implements Hand{
	
	
	
	private final FiveCardHandAnalyzer handAnalyzer;
	
	private static final int POKER_HAND_SIZE = 5;

	public RunFiveCards(final Builder builder)
	{
		
		this.handAnalyzer= new FiveCardHandAnalyzer(builder.cards);
		
	}
	
	public FiveCardHandAnalyzer  getHandAnalyzer()
	{
		
		return this.handAnalyzer;
	}
	
	
	@Override
	public String toString() {
		return this.getHandAnalyzer().getCards().toString();
	}


	public static class Builder{
		
		public SortedSet<Card> cards;
		
		public Builder() {
			
			this.cards = new TreeSet<>();
			
		}
		public Builder addCard(final Optional <Card> card)
		{
			this.cards.add(card.orElseThrow(IllegalStateException::new ));
			
			return this;
					
		}
		
		public RunFiveCards build()
		
		{
			
			if (this.cards.size()!= POKER_HAND_SIZE)
			{
				throw new RuntimeException("Invalid hand size for hand "+this.cards.toString());
				
			}
			
			return new RunFiveCards(this);
		}
		
	}

}
