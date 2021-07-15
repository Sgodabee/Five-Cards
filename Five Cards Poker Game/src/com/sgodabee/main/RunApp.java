package com.sgodabee.main;

import java.util.Arrays;
import java.util.stream.IntStream;

import com.sgodabee.card.Deck;
import com.sgodabee.hands.ClassificationRank;

public class RunApp {

	private static final int EXPERIMENT = 1000000 * 5;

	public static void main(String[] args) {
		//System.out.println("5 Card Poker app Running");
		runApp1();
		runApp2();
		

	}

	private static void runApp1() {
		final long startTime = System.currentTimeMillis();

		final int[] frequencyTable = new int[ClassificationRank.values().length];

		IntStream.range(0, EXPERIMENT).mapToObj(i -> new RunFiveCards.Builder()).forEach(builder -> {
			final Deck deck = Deck.newShuffledSingleDeck();
			builder.addCard(deck.deal());
			builder.addCard(deck.deal());
			builder.addCard(deck.deal());
			builder.addCard(deck.deal());
			builder.addCard(deck.deal());

			final RunFiveCards fiveHand = builder.build();
			final ClassificationRank classificationRank = fiveHand.getHandAnalyzer().getClassification()
					.getClassificationRank();
			frequencyTable[classificationRank.ordinal()]++;

		});

		System.out.println("Finished experiment with " + EXPERIMENT + " Iteration in "
				+ (System.currentTimeMillis() - startTime) + "milliseconds");
		System.out.println(Arrays.toString(frequencyTable) + "\n");

	}
	
	private static void runApp2()
	{
		
		final long  startTime = System.currentTimeMillis();
		final int[] frequencyTable = new int [3];
		
		final PokerHandComparator comparator = new PokerHandComparator();
		
		
		IntStream.range(0, EXPERIMENT).forEach(builder -> {
			final Deck deck = Deck.newShuffledSingleDeck();
			final RunFiveCards.Builder builder1 = new RunFiveCards.Builder();
			
			builder1.addCard(deck.deal());
			builder1.addCard(deck.deal());
			builder1.addCard(deck.deal());
			builder1.addCard(deck.deal());
			builder1.addCard(deck.deal());
			
			final RunFiveCards hand = builder1.build();
			
final RunFiveCards.Builder builder2 = new RunFiveCards.Builder();
			
			builder2.addCard(deck.deal());
			builder2.addCard(deck.deal());
			builder2.addCard(deck.deal());
			builder2.addCard(deck.deal());
			builder2.addCard(deck.deal());
			
			final RunFiveCards hand2 = builder2.build();
			
			final int comparison = comparator.compare(hand,hand2);
			if (comparison<0)
			{
				frequencyTable[0]++;
				
			}
			else if (comparison==0)
			{
				frequencyTable[1]++;
			}
			else if (comparison>0)
			{
				
				frequencyTable[2]++;
			}
			else 
			{
				throw new RuntimeException ("Error has Been Detected");
			}
			
			
			
			
			
			
			
		
		});
		System.out.println("Number of experiment "+EXPERIMENT+ " iterations in "+ (System.currentTimeMillis()-startTime) +"milliSeconds");
		System.out.println(Arrays.toString(frequencyTable));
		
		
	}
	
	
	
	

}
