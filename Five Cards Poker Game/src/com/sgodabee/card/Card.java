package com.sgodabee.card;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class Card implements Comparable<Card> {
	
	private  Categories categories;
	private  Types types;
	
	
	private final static Map<String,Card> card_temp = initCache();
	

	
	private static  Map<String, Card> initCache(){
		
		final Map<String, Card> cache= new HashMap<>();
		for (final Types type : Types.values()) {
			
			for (final Categories categories:Categories.values())
			{
				cache.put(cardKey(categories,type), new Card(categories,type));
				
				
			}
		}
		
		return Collections.unmodifiableMap(cache);
		

	}
	
	public static Card getCard( Categories categories,  Types types) {
		
		 final  Card  card  = card_temp.get(cardKey(categories,types));
		 if (card !=null) {
			 
			 return card;
			 
		 }
		return card;


	}
	
	public  Categories getCategories()
	{
		
		return this.categories;
		
	}
	
	public Types getTypes()
	{
		
		return this.types;
		
	}
	
	private static String cardKey(final Categories categories, final Types types)
	{
		return  categories+" of " + types;
		
	}
	
	public Card (final Categories categories , final Types types) {
		
		this.categories = categories;
		this.types = types;

	}

	public  String toString()
	{
		
		return  String.format("%s of %s", this.categories,this.types);
		
	}
	
	 public boolean equals(final Object obj)
	 {
		 if (this==obj)
		 {
			 return false;
		 }
		 if (obj==null|| getClass() !=obj.getClass())
		 {
			 final Card card = (Card) obj;
			 return this.categories== card.categories && this.types==card.types;
		 }
		 return false;
	 }
	 
	 
	 public int  hashCode()
	 {
		 int result = this.categories != null ?this.categories.hashCode() :0;
		 
		 result = 31 *result + (this.types !=null ? this.types.hashCode():0);
		 
		 return result;
	 }
	
	@Override
	public int compareTo(Card obj) 
	{
		final int rankComparison =Integer.compare(this.categories.getCategories(),obj.categories.getCategories());
		
		return rankComparison != 0 ? rankComparison :Integer.compare(this.types.getVal(), obj.types.getVal());
		
	}

	
}
