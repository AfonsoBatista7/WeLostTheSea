package entity.entities;

import java.util.*;

import entity.EntityClass;
import gameSystem.Actions;
import objects.Item;
import objects.items.Book;

public class Sailon extends EntityClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2339811828964391867L;


	private static Map<String, ArrayList<Item>> bag = new HashMap<String, ArrayList<Item>>() {
		private static final long serialVersionUID = 1L;

		{
			put("book", new ArrayList<Item>(Arrays.asList(new Book("The Universe!",""))));
		}
		
	};
	
	
	// TODO IMPORTANTE!!! -> dialogues
		
	
	private static final String NAME = "SAILON";
	
	public Sailon(Actions action) {
		super(NAME, action, bag);
	}

}
