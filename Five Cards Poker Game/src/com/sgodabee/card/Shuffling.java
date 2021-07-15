package com.sgodabee.card;

import java.util.Stack;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.IntStream;



public class Shuffling {
	
	private Stack<Card> stackCard;
	
	private Shuffling (final boolean shuffle) {
		this.stackCard= initialD(shuffle);
	}
	
	
	private Stack<Card> initialD(boolean shuffle){
		
	final Stack<Card> deckCards =  new Stack<Card>();
	for(final Types type : Types.values()) {
		for(final  Categories categories : Categories.values())
		{
			deckCards.push(Card.getCard(categories, type));
			
			
		}
		if (shuffle)
		{
			
			Collections.shuffle(deckCards);
		}
		else
		{
			Collections.sort(deckCards);
		}
		
		
		
	}
	return deckCards;
	
	}
	
	public static Shuffling newShuffledSingleDeck() {
		
		return new Shuffling(true);
				
	}
public static Shuffling newUnShuffledSingleDeck() {
		
		return new Shuffling(false);
				
	}
	
	public int size()
	{
		return this.stackCard.size();
		
	}
	
	
	public boolean contains (final Card card)
	{
		
		return stackCard.contains(card);
		
	}

	public static void main(String[] args) {
		
		
		
		final Shuffling deck = Shuffling.newShuffledSingleDeck();
		
		final int numCard = 52;
		IntStream.range(0,numCard).forEach(n -> System.out.println(deck.deal()));
		
		

	}
	
	public Optional<Card> deal()
	{
		
		return this.stackCard.empty()? Optional.empty():
		Optional.of(this.stackCard.pop());
		
	}

}
