package ProjectInformaticaPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Information {                //���� ����� ���������� ����������� ���� ������ � ������� ��� ���������� (��������, �������� ��� �������)
	private static int amountPredator=4;
	private static ArrayList<Leo> listOfLeos=new ArrayList<Leo>();    //����� � ������� ��������� �������� ��������� � ���������, �� � ������ ������ �� ���� ��������� ������������ ������ ��������� ���������
	private static ArrayList<Herbivore> listOfHerbivores=new ArrayList<Herbivore>();
	private static LinkedList<Leo> linkedListOfLeos=new LinkedList<Leo>();  //���� �������� �������� ���� ��������� ���� ������� � ��������� linked ����������
	private static LinkedList<Grass> linkedListOfGrass=new LinkedList<Grass>();  //���������� ��� linked ��������� �������� ��� ������� �����
	private static LinkedList<Leo> linkedListOfBornedLeos=new LinkedList<Leo>();
	private static LinkedList<Herbivore> linkedListOfBornedHerbivores=new LinkedList<Herbivore>();
	private static LinkedList<Herbivore> linkedListOfHerbivores=new LinkedList<Herbivore>();
	private static int sizeOfCell;   //������ ��������, ������������ �� ������
	private static int defaultWeight;     //��� ��� ������� �������� ���� ���������
	private static int defaultHeight;
	private static int quantTime=100;
	public static boolean letGo=false;          //����� ��� ������������� ���������
	private static Image imageGreenGrass;   //� ��� ��� ��������, ������������ � ��������� (���� �� 4 �����)
	private static Image imageYellowGrass;
	private static Image imageLeo;
	private static Image imageSleepingLeo;
	private static Image imageUsualGround;
	private static Image imageLeoChild;
	private static Image imageLeoFemaleChild;
	private static Image imageLeoFemale;
	private static Image imagePassionLeo;
	private static Image imageSleepingLeoFemale;
	
	private static Image imageSleepingHerbivore;
	private static Image imageSleepingHerbivoreFemale;
	private static Image imageHerbivore;
	private static Image imageHerbivoreChild;
	private static Image imageHerbivoreFemaleChild;
	private static Image imageHerbivoreFemale;
	private static Image imagePassionHerbivore;
	
	private static Image imageLotOfMeat;
	private static Image imageMiddleMeat;
	private static Image imageFewMeat;

	
	
	public static void readPredatorsFromConsole(/*MainFrame frame*/) {    //������� ��� ������. ���� ��� �� ���������� ���� ������  � ����������
		//Scanner in=new Scanner(System.in);
		
		/*for (int i=0;i<amountPredator;i++) {
			System.out.println((i+1)+"-�� ����������:");
			LifeForm k=new Leo(true, in.nextInt(), in.nextInt(),100,50,100,100,1,0,3,0,0,0);
			listOfLifeForms.add(k);
			linkedListOfLifeForms.add(k);
		}*/
		//in.close();
	                            //IfMale   X    Y    Age  starv pass exha        SC     PC      EC
		linkedListOfLeos.add(new Leo(true, 100, 200, 400, 100, 100, 100,     (float)1,(float)0.5,2,   1,(float)0.2,1));
		linkedListOfLeos.add(new Leo(false, 50, 400,  400, 100, 85,  20,      (float)1,(float)0.3,1,   3,(float)0.2,1));
		linkedListOfLeos.add(new Leo(true, 500, 200,  400, 100, 20,  70,      (float)1,(float)0.3,3,   3,(float)0.2,1));
		linkedListOfLeos.add(new Leo(false, 200, 100,  400, 100, 90,  50,     (float)1,(float)0.5,3,   1,(float)0.1,1));
	
	
		/*Iterator<LifeForm> currentLifeForm = listOfLifeForms.iterator();   // ��������, ��� ������ ��������
		while(currentLifeForm.hasNext()) {
			System.out.println(currentLifeForm.next().getXPosition()+" X");
			System.out.println(currentLifeForm.next().getYPosition()+" Y");
			
		}
		
		Iterator<LifeForm> currentNewLifeForm = linkedListOfLifeForms.iterator();   // ��������, ��� ������ ��������
		while(currentNewLifeForm.hasNext()) {
			System.out.println(currentNewLifeForm.next().getXPosition()+" LX");
			System.out.println(currentNewLifeForm.next().getYPosition()+" LY");
			
		}*/
	}
	
	
	public static void readHerbivoreFromConsole() {
		linkedListOfHerbivores.add(new Herbivore(true, 200, 100, 400, 100, 100, 100,     (float)1,(float)0.5,2,   1,(float)0.2,1));
		linkedListOfHerbivores.add(new Herbivore(false, 150, 300,  400, 100, 85,  20,      (float)1,(float)0.3,1,   3,(float)0.2,1));
		linkedListOfHerbivores.add(new Herbivore(true, 400, 300,  400, 100, 20,  70,      (float)1,(float)0.3,3,   3,(float)0.2,1));
		linkedListOfHerbivores.add(new Herbivore(false, 300, 200,  400, 100, 90,  50,     (float)1,(float)0.5,3,   1,(float)0.1,1));
	}
	
	
	public static void readGrassFromConsole() {    //���������� ����������� ������ ���� ��� �� ����������
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
	
	public static void loadImages() {                //��������� ���������� ������
	       try {
	    	   
	    	   //��� �����
	    	   imageLeo=ImageIO.read(new File("Textures/leo.png"));
	    	   imageSleepingLeo=ImageIO.read(new File("Textures/sleeping_leo.png"));
	    	   imageLeoChild=ImageIO.read(new File("Textures/NewLeoChild.png"));
	    	   imageLeoFemaleChild=ImageIO.read(new File("Textures/leoChildFemale.png"));
	    	   imageLeoFemale=ImageIO.read(new File("Textures/LeoFemale.png"));
	    	   imagePassionLeo=ImageIO.read(new File("Textures/PassionLeo.png"));
	    	   imageSleepingLeoFemale=ImageIO.read(new File("Textures/SleepingLeoFemale.png"));
	    	   
	    	   //��� ����� � �����
	    	   imageGreenGrass=ImageIO.read(new File("Textures/GreenGrass.jpg"));
	    	   imageYellowGrass=ImageIO.read(new File("Textures/YellowGrass.jpg"));
	    	   imageUsualGround=ImageIO.read(new File("Textures/UsualGround.jpg"));
	    	   
	    	   //��� ����������
	    	   imageHerbivore=ImageIO.read(new File("Textures/DonaldDuck.png"));
	    	   imageSleepingHerbivore=ImageIO.read(new File("Textures/Sleep.png"));
	    	   imageHerbivoreChild=ImageIO.read(new File("Textures/DuckChild.png"));
	    	   imageHerbivoreFemaleChild=ImageIO.read(new File("Textures/FemaleChildDuck.png"));
	    	   imageHerbivoreFemale=ImageIO.read(new File("Textures/Deisi.png"));
	    	   imagePassionHerbivore=ImageIO.read(new File("Textures/Love.png"));
	    	   imageSleepingHerbivoreFemale=ImageIO.read(new File("Textures/FemaleDuckSleep.png"));
	    	   
	    	   //��� �������� ��������
	    	   imageLotOfMeat=ImageIO.read(new File("Textures/LotOfMeat.png"));
	    	   imageMiddleMeat=ImageIO.read(new File("Textures/MiddleMeat.png"));
	    	   imageFewMeat=ImageIO.read(new File("Textures/FewMeat.png"));
	    	   
	       		} 
	       catch (IOException e) {System.out.println("Can't read file");}
	       }
	
	public static void readSizeOfCellFromConsole() {      //��������� ����� � ������� ������ ������
		sizeOfCell=50;	
	}
	
	public static int getAmountPredator() {
		return amountPredator;
	}
	
	public static ArrayList<Leo> getListOfLeos() {        //������ �� ������������
		return listOfLeos;
	}
	public static LinkedList<Leo> getLinkedListOfLeos() {   //����� ���� ����������� ����� �� �������, ������� �����, ������ �������� ������ � ��������� ��������
		return linkedListOfLeos;
	}
	public static LinkedList<Grass> getLinkedListOfGrass() { //���������� ��� �����
		return linkedListOfGrass;
	}
	public static int getSizeOfCell() {    //����� ���� ��� ������� ����� ������ ������ ������
		return sizeOfCell;
	}
	
	public static void readDefaultWeightFromConsole() {
		defaultWeight=900;
	}
	
	public static void checkIsLeoBorn() {
		for (Iterator<Leo> current = linkedListOfLeos.iterator(); current.hasNext(); ) {
		    Leo currentAnimal = current.next();
		    Random rand = new Random();
		    if (currentAnimal.wantToBorn()) {linkedListOfBornedLeos.add(
		    						new Leo( rand.nextBoolean(),
		    								currentAnimal.getXPosition(),
		    								currentAnimal.getYPosition(),
		    								60+rand.nextInt(41),
		    								100,
		    								100,
		    								100,
		    								(currentAnimal.getLegacyStarvationCoefficient()+currentAnimal.getFromWhom().getLegacyStarvationCoefficient())/2-2+rand.nextInt(5),
		    								(currentAnimal.getLegacyPassionCoefficient()+currentAnimal.getFromWhom().getLegacyPassionCoefficient())/2-(float)0.3+(float)rand.nextInt(7)/10,
		    								(currentAnimal.getLegacyExhaustionCoefficient()+currentAnimal.getFromWhom().getLegacyExhaustionCoefficient())/2-2+rand.nextInt(5),
		    								1+rand.nextInt(3),
		    								-(float)0.3+(float)rand.nextInt(7)/10,
		    								1+rand.nextInt(3)
		    						));
		    
		    currentAnimal.setTimeOfPregnant(-1);
		    currentAnimal.setFromWhom(null);
		    currentAnimal.setWantToBorn(false);
		    
		    						}
		    
		}
		
		for (Iterator<Leo> current = linkedListOfBornedLeos.iterator(); current.hasNext(); ) {
			linkedListOfLeos.add(current.next());
		}
		linkedListOfBornedLeos.clear();
		
		
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
public static Image getImageGround() {
	return imageUsualGround;
}
public static Image getImageLeoChild() {
	return imageLeoChild;
}
public static Image getImageLeoFemaleChild() {
	return imageLeoFemaleChild;
}
public static Image getImageLeoFemale() {
	return imageLeoFemale;
}
public static Image getImagePassionLeo() {
	return imagePassionLeo;
}
public static Image getImageSleepingLeoFemale() {
	return imageSleepingLeoFemale;
}
public static Image getImageLotOfMeat() {
	return imageLotOfMeat;
}
public static Image getImageMiddleMeat() {
	return imageMiddleMeat;
}
public static Image getImageFewMeat() {
	return imageFewMeat;
}
public static int getQuantTime() {
		return quantTime;
}
public static void setQuantTime(int newQuantTime) {
	quantTime=newQuantTime;
}

//����������

public static ArrayList<Herbivore> getListOfHerbivores() {
	return listOfHerbivores;
	
}

public static LinkedList<Herbivore> getLinkedListOfHerbivores() {
	return linkedListOfHerbivores;
}

public static Image getImageHerbivoreFemale() {
	return imageHerbivoreFemale;
}

public static Image getImageHerbivore() {
	return imageHerbivore;
}

public static Image getImageSleepingHerbivore() {
	return imageSleepingHerbivore;
}

public static Image getImageHerbivoreChild() {
	return imageHerbivoreChild;
}

public static Image getImageHerbivoreFemaleChild() {
	return imageHerbivoreFemaleChild;
}


public static Image getImagePassionHerbivore() {
	return imagePassionHerbivore;
}

public static Image getImageSleepingHerbivoreFemale() {
	return imageSleepingHerbivoreFemale;
}


public static void checkIsHerbivoreBorn() {
	for (Iterator<Herbivore> current = linkedListOfHerbivores.iterator(); current.hasNext(); ) {
	    Herbivore currentAnimal = current.next();
	    Random rand = new Random();
	    if (currentAnimal.wantToBorn()) {linkedListOfBornedHerbivores.add(
	    						new Herbivore( rand.nextBoolean(),
	    								currentAnimal.getXPosition(),
	    								currentAnimal.getYPosition(),
	    								60+rand.nextInt(41),
	    								100,
	    								100,
	    								100,
	    								(currentAnimal.getLegacyStarvationCoefficient()+currentAnimal.getFromWhom().getLegacyStarvationCoefficient())/2-2+rand.nextInt(5),
	    								(currentAnimal.getLegacyPassionCoefficient()+currentAnimal.getFromWhom().getLegacyPassionCoefficient())/2-(float)0.3+(float)rand.nextInt(7)/10,
	    								(currentAnimal.getLegacyExhaustionCoefficient()+currentAnimal.getFromWhom().getLegacyExhaustionCoefficient())/2-2+rand.nextInt(5),
	    								1+rand.nextInt(3),
	    								-(float)0.3+(float)rand.nextInt(7)/10,
	    								1+rand.nextInt(3)
	    						));
	    
	    currentAnimal.setTimeOfPregnant(-1);
	    currentAnimal.setFromWhom(null);
	    currentAnimal.setWantToBorn(false);
	    
	    						}
	    
	}
	
	for (Iterator<Herbivore> current = linkedListOfBornedHerbivores.iterator(); current.hasNext(); ) {
		linkedListOfHerbivores.add(current.next());
	}
	linkedListOfBornedHerbivores.clear();
	
}

}
