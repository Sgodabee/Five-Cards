package com.sgodabee.hands;
import java.util.SortedSet;

import com.sgodabee.card.Card;


public interface HandAnalyzer {
	
	
	SortedSet<Card> getCards();
	Classification getClassification();
	CategoryGroup getCategoryGroup();
	TypeGroup getTypeGroup();
	
	
	
	
	

}
