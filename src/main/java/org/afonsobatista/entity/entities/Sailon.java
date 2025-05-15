package org.afonsobatista.entity.entities;

import java.util.*;

import org.afonsobatista.entity.EntityClass;
import org.afonsobatista.gameSystem.Actions;
import org.afonsobatista.objects.Item;
import org.afonsobatista.objects.items.Book;

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
