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
			//Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
			
			
					
			//setSize(d.width,d.height);
			//setExtendedState(JFrame.MAXIMIZED_BOTH);
			//setExtendedState(JFrame.MAXIMIZED_BOTH);
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
						
						
						g.drawImage(Information.getImageGround(),0,0,Information.getDefaultWeight(),Information.getDefaultHeight(),null);
						for (Iterator<Grass> current = Information.getLinkedListOfGrass().iterator(); current.hasNext(); ) { //аналогично для травы
						    Grass val = current.next();
						    if (val.getGrassImage()==null) return;
						    g.drawImage(val.getGrassImage(), 
									val.getXPosition(), 
											val.getYPosition(),sizeOfCell,sizeOfCell, null);
						}
						
						
						for (Iterator<Leo> current = Information.getLinkedListOfLeos().iterator(); current.hasNext(); ) {
						    Leo val = current.next();
						    Image image;
						    if ((image=val.getAnimalImage())==null) return;
						    
						    
						    if (val.isChild()) {
						    
						    		g.drawImage(image,    //вот здесь с помощью getAnimalImage можно в зависимости от состояния объекта (гапример, он спит) ставить разные картинки
						    				val.getXPosition(), 
													val.getYPosition(),sizeOfCell*(30-val.timeOfInertion)/30,sizeOfCell*(30-val.timeOfInertion)/30, null);
						    } else
						    	g.drawImage(image,    //вот здесь с помощью getAnimalImage можно в зависимости от состояния объекта (гапример, он спит) ставить разные картинки
					    				val.getXPosition(), 
												val.getYPosition(),sizeOfCell,sizeOfCell, null);
						    
						    
						    
						    
						}
						
						for (Iterator<Herbivore> current = Information.getLinkedListOfHerbivores().iterator(); current.hasNext(); ) {
						    Herbivore val = current.next();
						    Image image;
						    if ((image=val.getAnimalImage())==null) return;
						    
						    
						    if (val.isChild()) {
						    
						    		g.drawImage(image,    //вот здесь с помощью getAnimalImage можно в зависимости от состояния объекта (гапример, он спит) ставить разные картинки
						    				val.getXPosition(), 
													val.getYPosition(),sizeOfCell*(30-val.timeOfInertion)/30,sizeOfCell*(30-val.timeOfInertion)/30, null);
						    } else
						    	g.drawImage(image,    //вот здесь с помощью getAnimalImage можно в зависимости от состояния объекта (гапример, он спит) ставить разные картинки
					    				val.getXPosition(), 
												val.getYPosition(),sizeOfCell,sizeOfCell, null);
						    
						    
						    
						    
						}
						
						
						
						
					
					}
		}
