package com.sgodabee.hands;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;

import com.sgodabee.card.Card;
import com.sgodabee.card.Categories;
import com.sgodabee.card.Types;


public enum PokerHandUtils {
;   //no instance
    public static final int TIE = 0;

	public static final List<Card> ROYAL_FLUSH_SPADES = Arrays.asList(new Card(
			Categories.ACE, Types.SPADE),
                                                                      new Card(Categories.KING, Types.SPADE),
                                                                      new Card(Categories.QUEEN, Types.SPADE),
                                                                      new Card(Categories.JACK, Types.SPADE),
                                                                      new Card(Categories.TEN, Types.SPADE));


    public static final List<Card> ROYAL_FLUSH_HEARTS = Arrays.asList(new Card(Categories.ACE, Types.HEARTS),
                                                                      new Card(Categories.KING, Types.HEARTS),
                                                                      new Card(Categories.QUEEN, Types.HEARTS),
                                                                      new Card(Categories.JACK, Types.HEARTS),
                                                                      new Card(Categories.TEN, Types.HEARTS));

    public static final List<Card> ROYAL_FLUSH_CLUBS = Arrays.asList(new Card(Categories.ACE, Types.CLUBS),
                                                                     new Card(Categories.KING, Types.CLUBS),
                                                                     new Card(Categories.QUEEN, Types.CLUBS),
                                                                     new Card(Categories.JACK, Types.CLUBS),
                                                                     new Card(Categories.TEN, Types.CLUBS));

    public static final List<Card> ROYAL_FLUSH_DIAMONDS = Arrays.asList(new Card(Categories.ACE, Types.DIAMONDS),
                                                                        new Card(Categories.KING, Types.DIAMONDS),
                                                                        new Card(Categories.QUEEN, Types.DIAMONDS),
                                                                        new Card(Categories.JACK, Types.DIAMONDS),
                                                                        new Card(Categories.TEN, Types.DIAMONDS));

    public static final List<Card> STRAIGHT_WHEEL_SPADES = Arrays.asList(new Card(Categories.ACE, Types.SPADE),
                                                                         new Card(Categories.TWO, Types.SPADE),
                                                                         new Card(Categories.THREE, Types.SPADE),
                                                                         new Card(Categories.FOUR, Types.SPADE),
                                                                         new Card(Categories.FIVE, Types.SPADE));

    public static final List<Card> STRAIGHT_WHEEL_HEARTS = Arrays.asList(new Card(Categories.ACE, Types.HEARTS),
                                                                         new Card(Categories.TWO, Types.HEARTS),
                                                                         new Card(Categories.THREE, Types.HEARTS),
                                                                         new Card(Categories.FOUR, Types.HEARTS),
                                                                         new Card(Categories.FIVE, Types.HEARTS));

    public static final List<Card> STRAIGHT_WHEEL_CLUBS = Arrays.asList(new Card(Categories.ACE, Types.CLUBS),
                                                                        new Card(Categories.TWO, Types.CLUBS),
                                                                        new Card(Categories.THREE, Types.CLUBS),
                                                                        new Card(Categories.FOUR, Types.CLUBS),
                                                                        new Card(Categories.FIVE, Types.CLUBS));

    public static final List<Card> STRAIGHT_WHEEL_DIAMONDS = Arrays.asList(new Card(Categories.ACE, Types.DIAMONDS),
                                                                           new Card(Categories.TWO, Types.DIAMONDS),
                                                                           new Card(Categories.THREE, Types.DIAMONDS),
                                                                           new Card(Categories.FOUR, Types.DIAMONDS),
                                                                           new Card(Categories.FIVE, Types.DIAMONDS));


    public static final List<Categories> STRAIGHT_TWO_TO_SIX = Arrays.asList(Categories.TWO, Categories.THREE, Categories.FOUR, Categories.FIVE, Categories.SIX);

    public static final List<Categories> STRAIGHT_THREE_TO_SEVEN = Arrays.asList(Categories.THREE,Categories. FOUR, Categories.FIVE, Categories.SIX,Categories. SEVEN);

    public static final List<Categories> STRAIGHT_FOUR_TO_EIGHT = Arrays.asList(Categories.FOUR, Categories.FIVE, Categories.SIX, Categories.SEVEN, Categories.EIGHT);

    public static final List<Categories> STRAIGHT_FIVE_TO_NINE = Arrays.asList(Categories.FIVE, Categories.SIX, Categories.SEVEN, Categories.EIGHT, Categories.NINE);

    public static final List<Categories> STRAIGHT_SIX_TO_TEN = Arrays.asList(Categories.SIX, Categories.SEVEN, Categories.EIGHT, Categories.NINE, Categories.TEN);

    public static final List<Categories> STRAIGHT_SEVEN_TO_JACK = Arrays.asList(Categories.SEVEN, Categories.EIGHT, Categories.NINE, Categories.TEN, Categories.JACK);

    public static final List<Categories> STRAIGHT_EIGHT_TO_QUEEN = Arrays.asList(Categories.EIGHT, Categories.NINE, Categories.TEN, Categories.JACK, Categories.QUEEN);

    public static final List<Categories> STRAIGHT_NINE_TO_KING = Arrays.asList(Categories.NINE, Categories.TEN, Categories.JACK, Categories.QUEEN,Categories. KING);

    public static final List<Categories> STRAIGHT_TEN_TO_ACE = Arrays.asList(Categories.TEN, Categories.JACK, Categories.QUEEN,Categories. KING, Categories.ACE);

    public static void checkHandClassification(final Hand hand,
                                               final ClassificationRank classificationRank) {
        if(hand.getHandAnalyzer().getClassification().getClassificationRank() != classificationRank) {
            throw new RuntimeException("Hand : " +hand+ " does not match expected classificationRank " + classificationRank);
        }
    }

    public static Classification classifyPokerHand(final CategoryGroup rankGroup,
                                                   final TypeGroup suitGroup,
                                                   final SortedSet<Card> cards) {
        final PokerHandClassifier handDetector = new PokerHandClassifier(rankGroup, suitGroup, cards);
        return handDetector.classify();
    }
}
