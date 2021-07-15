package com.sgodabee.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import com.sgodabee.card.Card;
import com.sgodabee.main.FiveCardHandAnalyzer;

class RunFiveCardsTest {

	@Test
	void testRunFiveCards() {
		SortedSet<Card> cards = new TreeSet<>();
		
		if (cards.size()!=5)
		{
			System.out.println(" Valid Argument");
		}
		
		else
		{
			System.out.println(" InValid Argument");
			
		}
		
	}

	@Test
	void testGetHandAnalyzer() {
		
		
		FiveCardHandAnalyzer analyzer = null;
		
		
		assertNull(analyzer,"must be  a valid argument");
		
		
	}

	@Test
	void testToString() {
		
	}

}
