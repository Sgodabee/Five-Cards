package com.sgodabee.card;

public enum Types {

	SPADE(1),DIAMONDS(2),HEARTS(3),CLUBS(4);
	
	private int val ;

Types(int val) {
	
	this.val= val;
	
}

public int getVal() {
	return val;
}




	
	
	
}
