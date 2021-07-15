package com.sgodabee.hands;

import java.util.Iterator;
import java.util.*;
import java.util.Map;

import java.util.SortedSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.ArrayList;
import com.sgodabee.card.Card;
import com.sgodabee.card.Categories;


public class CategoryGroup implements Iterable<Map.Entry<Categories, List<Card>>> {

	private final Map<Categories, List<Card>> categoriesMap;

	private final int quadcount;
	private final int setCount;
	private final int doubleCount;

	public CategoryGroup(final SortedSet<Card> cards) {
		this.categoriesMap = initialCategoriesMap(cards);

		this.quadcount = groupCount(4);
		this.setCount = groupCount(3);
		this.doubleCount = groupCount(2);
	}

	public Map<Categories, List<Card>> getCategoriesMap() {
		return categoriesMap;
	}

	public int getQuadcount() {
		return quadcount;
	}

	public int getSetCount() {
		return setCount;
	}

	public int getDoubleCount() {
		return doubleCount;
	}

	

	private static Map<Categories, List<Card>> initialCategoriesMap(final SortedSet<Card> cards) {
		final Comparator<Map.Entry<Categories, List<Card>>> valueComparator = (o1,
				o2) -> o2.getValue().size() == o1.getValue().size()
						? o2.getKey().getCategories() - o1.getKey().getCategories()
						: o2.getValue().size() - o1.getValue().size();

		final List<Map.Entry<Categories, List<Card>>> listOfEntries = new ArrayList<>(
				cards.stream().collect(Collectors.groupingBy(Card::getCategories)).entrySet());

		listOfEntries.sort(valueComparator);
		final LinkedHashMap<Categories, List<Card>> sortedResults = new LinkedHashMap<>();

		for (final Map.Entry<Categories, List<Card>> entry : listOfEntries) {
			sortedResults.put(entry.getKey(), entry.getValue());

		}

		return Collections.unmodifiableMap(sortedResults);
	}
	
	private int groupCount(int i) {
		// TODO Auto-generated method stub
		return Math.toIntExact(this.categoriesMap.values().stream().filter(n -> n.size() == i).count());
	}
	

	@Override
    public Iterator<Map.Entry<Categories, List<Card>>> iterator() {
        return this.categoriesMap.entrySet().iterator();
    }
	
	

}
