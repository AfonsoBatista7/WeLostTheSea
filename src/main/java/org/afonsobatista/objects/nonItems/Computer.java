package org.afonsobatista.objects.nonItems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.afonsobatista.gameSystem.Propertys;
import org.afonsobatista.gameSystem.Programs;
import org.afonsobatista.objects.*;
         
/**      
 * @author Afonso Batista
 *
 */
public class Computer extends NonItemClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1909725508318784822L;
	
	private static final String TYPE = "Computer";
	private static final Propertys PROPERTY[] = {Propertys.USE};
	private List<Programs> programs;
	private String txt = "Archive: When You're all covererd between the nothingness of darkness... "             //TODO POR ENQUANTO
			+ "Try Close your Eyes, thats the best option sometimes...\n\n";

	public Computer(String direction, String description, LinkedList<Programs> programs) {
		super(TYPE, direction, description, PROPERTY);
		this.programs = programs; 
	}
	
	public Iterator<Programs> getPrograms() {
		return programs.iterator();
	}
	
	public String getTxt() {
		return txt;
	}
	
}
