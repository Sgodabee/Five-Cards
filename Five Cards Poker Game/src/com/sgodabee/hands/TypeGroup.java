package com.sgodabee.hands;

import java.util.Map;

import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.Collections;

import java.util.stream.Collectors;

import com.sgodabee.card.Card;
import com.sgodabee.card.Types;

public class TypeGroup implements Iterable<Map.Entry<Types, List<Card>>>{
	
	private final Map<Types, List<Card>> typeMap ;
	
	
	
	
	
	public TypeGroup(final SortedSet<Card> cards) {
		
		this.typeMap = initTypeGroup(cards);
	}

	Map<Types,List<Card>> getTypesMap()
	{
		
		return this.typeMap;
		
	}

	@Override
	public Iterator<Map.Entry<Types, List<Card>>> iterator() {
		// TODO Auto-generated method stub
		
		return typeMap.entrySet().iterator();
	}
	
	@SuppressWarnings("unused")
	private static Map<Types,List<Card>> initTypeGroup(final SortedSet<Card> card)
	{
		
		return Collections.unmodifiableMap(new TreeMap<>(card.stream().collect(Collectors.groupingBy(Card::getTypes))));
		
		 
		
	}

}
