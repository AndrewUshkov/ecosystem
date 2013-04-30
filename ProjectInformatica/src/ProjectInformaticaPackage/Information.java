package ProjectInformaticaPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Information {                //���� ����� ���������� ����������� ���� ������ � ������� ��� ���������� (��������, �������� ��� �������)
	private static int amountPredator=4;
	private static ArrayList<Leo> listOfLeos=new ArrayList<Leo>();    //����� � ������� ��������� �������� ��������� � ���������, �� � ������ ������ �� ���� ��������� ������������ ������ ��������� ���������
	private static LinkedList<Leo> linkedListOfLeos=new LinkedList<Leo>();  //���� �������� �������� ���� ��������� ���� ������� � ��������� linked ����������
	private static LinkedList<Grass> linkedListOfGrass=new LinkedList<Grass>();  //���������� ��� linked ��������� �������� ��� ������� �����
	private static LinkedList<Leo> linkedListOfBornedLeos=new LinkedList<Leo>();
	private static int sizeOfCell;   //������ ��������, ������������ �� ������
	private static int defaultWeight;     //��� ��� ������� �������� ���� ���������
	private static int defaultHeight;
	private static Image imageGreenGrass;   //� ��� ��� ��������, ������������ � ��������� (���� �� 4 �����)
	private static Image imageYellowGrass;
	private static Image imageLeo;
	private static Image imageSleepingLeo;
	private static Image imageUsualGround;
	private static Image imageLeoChild;
	
	public static void readPredatorsFromConsole(/*MainFrame frame*/) {    //������� ��� ������. ���� ��� �� ���������� ���� ������  � ����������
		Scanner in=new Scanner(System.in);
		
		/*for (int i=0;i<amountPredator;i++) {
			System.out.println((i+1)+"-�� ����������:");
			LifeForm k=new Leo(true, in.nextInt(), in.nextInt(),100,50,100,100,1,0,3,0,0,0);
			listOfLifeForms.add(k);
			linkedListOfLifeForms.add(k);
		}*/
		in.close();
	
		linkedListOfLeos.add(new Leo(true, 100, 200, 400, 150, 100, 100,     (float)1,1,3,   1,2,1,   false));
		linkedListOfLeos.add(new Leo(false, 50, 400,  400, 160, 85,  20,    (float) 1,2,1,   3,2,1,    false));
		linkedListOfLeos.add(new Leo(true, 500, 200,  400, 170, 20,  70,     (float)1,3,3,   3,2,1,    false));
		linkedListOfLeos.add(new Leo(false, 200, 100,  400, 180, 90,  50,     (float)1,1,3,   1,1,1,   false));
	
	
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
	    	   imageLeo=ImageIO.read(new File("Textures/leo.png"));
	    	   imageSleepingLeo=ImageIO.read(new File("Textures/sleeping_leo.png"));
	    	   imageGreenGrass=ImageIO.read(new File("Textures/GreenGrass.jpg"));
	    	   imageYellowGrass=ImageIO.read(new File("Textures/YellowGrass.jpg"));
	    	   imageUsualGround=ImageIO.read(new File("Textures/UsualGround.jpg"));
	    	   imageLeoChild=ImageIO.read(new File("Textures/NewLeoChild.png"));
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
		    								(currentAnimal.getLegacyPassionCoefficient()+currentAnimal.getFromWhom().getLegacyPassionCoefficient())/2-2+rand.nextInt(5),
		    								(currentAnimal.getLegacyExhaustionCoefficient()+currentAnimal.getFromWhom().getLegacyExhaustionCoefficient())/2-2+rand.nextInt(5),
		    								1+rand.nextInt(3),
		    								1+rand.nextInt(3),
		    								1+rand.nextInt(3),
		    								true
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
}