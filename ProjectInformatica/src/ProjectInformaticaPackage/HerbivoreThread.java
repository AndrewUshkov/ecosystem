package ProjectInformaticaPackage;

import java.util.Iterator;

public class HerbivoreThread implements Runnable {

	@Override
	public void run() {
		for (Iterator<Herbivore> current = Information.getLinkedListOfHerbivores().iterator(); current.hasNext(); ) {
	    	LifeForm currentAnimal = current.next();
	    	if (currentAnimal.makeDecision()==false) { //false появляется, если объект погибает
	        	current.remove();
	    	}
		}
		
		Information.checkIsHerbivoreBorn();
	}
	
	
	
	
}
