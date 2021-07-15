package com.sgodabee.card;

import java.util.Collections;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.IntStream;

public class Deck {

	private final Stack<Card> deckCards;

	public Deck(final boolean shouldShuffle) {
		this.deckCards = initDeck(shouldShuffle);

	}

	public  Stack<Card> initDeck(boolean shoulfShuffle) {

		final Stack<Card> deckCards = new Stack<>();

		for (final Types type : Types.values()) {
			for (final Categories categories : Categories.values()) {

				deckCards.push(Card.getCard(categories, type));
			}

		}

		if (shoulfShuffle) {
			Collections.shuffle(deckCards);

		}

		else {
			Collections.sort(deckCards);
		}

		return deckCards;

	}
	
	public static Deck newShuffledSingleDeck()
	{
		return new Deck(true);
	}

	public static Deck newUnShuffledSingleDeck()
	{
		return new Deck(false);
	}
	
	public int size()
	{
		return this.deckCards.size();
		
	}
	
	public Optional<Card> deal()
	{
		return this.deckCards.empty()? Optional.empty():Optional.of(this.deckCards.pop());
	}
	
	public static void main (String args[])
	{
		
		final Deck deck = Deck.newShuffledSingleDeck();
		final int numCardsToDeal = 52;
		
		IntStream.range(0, numCardsToDeal).forEach(n ->System.out.println(deck.deal()));;
		
	}
	
}
