package ProjectInformaticaPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Information {
	private static int amountPredator=4;
	private static ArrayList<LifeForm> listOfLifeForms=new ArrayList<LifeForm>();
	private static LinkedList<LifeForm> linkedListOfLifeForms=new LinkedList<LifeForm>();
	private static LinkedList<Grass> linkedListOfGrass=new LinkedList<Grass>();
	private static int sizeOfCell;
	private static int defaultWeight;
	private static int defaultHeight;
	private static Image imageGreenGrass;
	private static Image imageYellowGrass;
	private static Image imageLeo;
	private static Image imageSleepingLeo;
	
	public static void readPredatorsFromConsole(/*MainFrame frame*/) {
		Scanner in=new Scanner(System.in);
		
		/*for (int i=0;i<amountPredator;i++) {
			System.out.println((i+1)+"-ые координаты:");
			LifeForm k=new Leo(true, in.nextInt(), in.nextInt(),100,50,100,100,1,0,3,0,0,0);
			listOfLifeForms.add(k);
			linkedListOfLifeForms.add(k);
		}*/
		in.close();
	
		linkedListOfLifeForms.add(new Leo(true, 100, 200, 100, 50, 100, 100,     1,1,3,   0,0,0));
		linkedListOfLifeForms.add(new Leo(false, 50, 400,  80, 60, 90,  50,     2,2,1,   0,0,0));
		linkedListOfLifeForms.add(new Leo(true, 500, 200,  90, 70, 80,  70,     3,3,3,   0,0,0));
		linkedListOfLifeForms.add(new Leo(true, 200, 100,  95, 80, 95,  50,     2,1,3,   0,0,0));
	
	
		Iterator<LifeForm> currentLifeForm = listOfLifeForms.iterator();   // проверка, что делает итератор
		while(currentLifeForm.hasNext()) {
			System.out.println(currentLifeForm.next().getXPosition()+" X");
			System.out.println(currentLifeForm.next().getYPosition()+" Y");
			
		}
		
		Iterator<LifeForm> currentNewLifeForm = linkedListOfLifeForms.iterator();   // проверка, что делает итератор
		while(currentNewLifeForm.hasNext()) {
			System.out.println(currentNewLifeForm.next().getXPosition()+" LX");
			System.out.println(currentNewLifeForm.next().getYPosition()+" LY");
			
		}
	}
	
	public static void readGrassFromConsole() {
		linkedListOfGrass.add(new Grass(50,30,120));
		linkedListOfGrass.add(new Grass(90,10,150));
		linkedListOfGrass.add(new Grass(200,100,100));
		linkedListOfGrass.add(new Grass(300,400,125));
		linkedListOfGrass.add(new Grass(500,320,90));
		linkedListOfGrass.add(new Grass(600,640,123));
		linkedListOfGrass.add(new Grass(600,50,124));
		linkedListOfGrass.add(new Grass(50,200,129));
		linkedListOfGrass.add(new Grass(400,340,130));
		linkedListOfGrass.add(new Grass(300,100,100));
	}
	
	public static void loadImages() {
	       try {
	    	   imageLeo=ImageIO.read(new File("c:\\leo.png"));
	    	   imageSleepingLeo=ImageIO.read(new File("c:\\sleeping_leo.jpg"));
	    	   imageGreenGrass=ImageIO.read(new File("c:\\GreenGrass.jpg"));
	    	   imageYellowGrass=ImageIO.read(new File("c:\\YellowGrass.jpg"));
	       		} 
	       catch (IOException e) {System.out.println("Can't read file");}
	       }
	
	public static void readSizeOfCellFromConsole() {
		sizeOfCell=20;	
	}
	
	public static int getAmountPredator() {
		return amountPredator;
	}
	
	public static ArrayList<LifeForm> getListOfLifeForms() {
		return listOfLifeForms;
	}
	public static LinkedList<LifeForm> getLinkedListOfLifeForms() {
		return linkedListOfLifeForms;
	}
	public static LinkedList<Grass> getLinkedListOfGrass() {
		return linkedListOfGrass;
	}
	public static int getSizeOfCell() {
		return sizeOfCell;
	}
	
	public static void readDefaultWeightFromConsole() {
		defaultWeight=900;
	}
	
public static void readDefaultHeightFromConsole() {
		defaultHeight=500;
	}

public static int getDefaultWeight() {
	return defaultWeight;
}

public static int getDefaultHeight() {
	return defaultHeight;
}
public static Image getImageSleepingLeo() {
	return imageSleepingLeo;
}
public static Image getImageLeo() {
	return imageLeo;
}
public static Image getImageGreenGrass() {
	return imageGreenGrass;
}
public static Image getImageYellowGrass() {
	return imageYellowGrass;
}
}
