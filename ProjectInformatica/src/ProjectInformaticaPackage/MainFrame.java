package ProjectInformaticaPackage;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import javax.swing.*;
	/*class StartLife extends JFrame {
		public static void main(String[] args) {
			MainFrame frame=new MainFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
}*/
	class MainFrame extends JFrame {                                   
		public MainFrame(int DEFAULT_WIDTH, int DEFAULT_HEIGHT) {
			setTitle("ProjectInformatica");
			setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
			BioPanel lpanel=new BioPanel();
			add(lpanel);
		}
		//private LinkedList<LifeForm> getListOfLifeForms() {
		//}
	}
	class BioPanel extends JPanel {
		//private Image image;
		public BioPanel() {
			
			
			
		}
					public void paintComponent(Graphics g) {    // рисуем всех животных и всю траву
						super.paintComponent(g);
						int sizeOfCell=Information.getSizeOfCell();
						
						for (Iterator<Leo> current = Information.getLinkedListOfLeos().iterator(); current.hasNext(); ) {
						    Leo val = current.next();
						    Image image;
						    if ((image=val.getAnimalImage())==null) return;
						    g.drawImage(image,    //вот здесь с помощью getAnimalImage можно в зависимости от состояния объекта (гапример, он спит) ставить разные картинки
									val.getXPosition(), 
											val.getYPosition(),sizeOfCell,sizeOfCell, null);
						}
						
						
						for (Iterator<Grass> current = Information.getLinkedListOfGrass().iterator(); current.hasNext(); ) { //аналогично для травы
						    Grass val = current.next();
						    if (val.getGrassImage()==null) return;
						    g.drawImage(val.getGrassImage(), 
									val.getXPosition(), 
											val.getYPosition(),sizeOfCell,sizeOfCell, null);
						}
						
						
					
					}
		}
