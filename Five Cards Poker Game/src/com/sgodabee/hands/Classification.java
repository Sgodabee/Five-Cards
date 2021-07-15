package com.sgodabee.hands;

import java.util.Collections;
import java.util.SortedSet;

import com.sgodabee.card.Card;

public class Classification {
	
	private final ClassificationRank classificationRank;
	private final SortedSet<Card> classifiedCards;
	
	
	Classification (final ClassificationRank classificationRank, final SortedSet<Card> cards)
	
	{
		
		this.classificationRank= classificationRank;
		this.classifiedCards = Collections.unmodifiableSortedSet(cards);
		
	}
	
	public SortedSet<Card> getClassifiedCards()
	{
		
		return this.classifiedCards;
		
		}

	public ClassificationRank getClassificationRank()
	{
		
		
		return this.classificationRank;
		
	}
	public String toString()
	{
		return this.classificationRank.toString();
		
		
	}
	
	
}
