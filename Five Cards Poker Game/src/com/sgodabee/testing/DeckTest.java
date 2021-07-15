package com.sgodabee.testing;

import java.util.Collections;
import java.util.Stack;

import org.junit.jupiter.api.Test;

import com.sgodabee.card.Card;
import com.sgodabee.card.Categories;
import com.sgodabee.card.Types;

class DeckTest {

	@Test
	void testInitDeck() {
		
		boolean shoulfShuffle = false;
		final Stack<Card> deckCards = new Stack<>();

		for (final Types type : Types.values()) {
			for (final Categories categories : Categories.values()) {

				deckCards.push(Card.getCard(categories, type));
			}

		}

		if (shoulfShuffle) {
			Collections.shuffle(deckCards);
			System.out.print("Looking good");

		}

		else {
			Collections.sort(deckCards);
			System.out.print("Looking great It runs Perfect");
		}

		
		
	}

	@Test
	void testSize() {
		
	}

	@Test
	void testDeal() {
		
	}

}
