package ProjectInformaticaPackage;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

class StartLife extends JFrame {
	public static void main(String[] args) {    //здесь начинает работать программа
		//int amountPredator=4;
		//int amountHerbivore;
		//ArrayList<LifeForm> listOfLifeForms=new ArrayList<LifeForm>();
		Information.readPredatorsFromConsole(/*this*/);  //много статических методов считывания информации
		Information.readGrassFromConsole();
		Information.readSizeOfCellFromConsole();
		Information.readDefaultHeightFromConsole();
		Information.readDefaultWeightFromConsole();
		Information.loadImages();
		MainFrame frame=new MainFrame(Information.getDefaultWeight(), Information.getDefaultHeight()); //создаем главное окно
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		/*LifeForm CurrentLifeForm=listOfLifeForms.get(0);
		CurrentLifeForm.setXPosition(0);
		 		try {
		 				Thread.sleep(1000);//чтобы успеть просмотреть
		 			} catch (Exception e) {
		 				}
		CurrentLifeForm.setXPosition(300);
		frame.repaint();*/                 //здесь разобрался, как перерисовывать картинку
		
		
		
		
		/*do {
		for (int i=0;i<Information.getAmountPredator();i++) {
			listOfLifeForms.get(i).goToNearestPredator();
		}
		*/
		
		
		do {
			
			
			
		/*Iterator<LifeForm> current = Information.getLinkedListOfLifeForms().iterator();
		while (current.hasNext()) {/*current.next().goToNearestPredator();*/
			//currentLeo=current.next();
			//isAlive=current.next().makeDecision(); 
			/*if (current.next().makeDecision()==false) {
			Information.getLinkedListOfLifeForms().remove();}}*/
			
			
			
			//здесь перебираем все объекты из коллекций животных и травы и у каждого вызываем метод makeDecision. Как бы предоставляем ход этому объекту.
			for (Iterator<Leo> current = Information.getLinkedListOfLeos().iterator(); current.hasNext(); ) {
			    LifeForm currentAnimal = current.next();
			    if (currentAnimal.makeDecision()==false) { //false появляется, если объект погибает
			        current.remove();
			    }
			}
			
			//аналогично для травы
			for (Iterator<Grass> current = Information.getLinkedListOfGrass().iterator(); current.hasNext(); ) {
			    Grass currentGrass = current.next();
			    if (currentGrass.makeDecision()==false) {
			        current.remove();
			    }
			}
			
			
			Information.checkIsLeoBorn();
			
			
			
			
			
			
			try {
				Thread.sleep(100);//чтобы успеть просмотреть
			} catch (Exception e) {}
		frame.repaint();
		
		
	} while (true);
		
	}
}
