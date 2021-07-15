package com.sgodabee.main;

import java.util.Collections;
import java.util.SortedSet;

import com.sgodabee.card.Card;
import com.sgodabee.hands.CategoryGroup;
import com.sgodabee.hands.Classification;
import com.sgodabee.hands.HandAnalyzer;
import com.sgodabee.hands.PokerHandUtils;
import com.sgodabee.hands.TypeGroup;

public class FiveCardHandAnalyzer implements HandAnalyzer {
	
	private final SortedSet<Card> cards;
	private final Classification handClassification;
	private final CategoryGroup categories;
	private final TypeGroup type;
	
	
	
	 public FiveCardHandAnalyzer(final SortedSet<Card> cards) {
		
		this.cards = Collections.unmodifiableSortedSet(cards);
		
		this.categories = new CategoryGroup(this.cards);
		this.type = new TypeGroup(this.cards);
		this.handClassification = PokerHandUtils.classifyPokerHand(getCategoryGroup(),getTypeGroup(),getCards());
		
	}
	
	
	@Override
	public SortedSet<Card> getCards() {
		// TODO Auto-generated method stub
		return this.cards;
	}
	@Override
	public Classification getClassification() {
		// TODO Auto-generated method stub
		return this.handClassification;
	}
	@Override
	public CategoryGroup getCategoryGroup() {
		// TODO Auto-generated method stub
		return this.categories;
	}
	@Override
	public TypeGroup getTypeGroup() {
		// TODO Auto-generated method stub
		return this.type;
	}
	
	
	
	
	

}
