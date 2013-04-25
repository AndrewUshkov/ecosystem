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
			LeoPanel lpanel=new LeoPanel();
			add(lpanel);
		}
		//private LinkedList<LifeForm> getListOfLifeForms() {
		//}
	}
	class LeoPanel extends JPanel {
		//private Image image;
		public LeoPanel() {
			
			
			
		}
					public void paintComponent(Graphics g) {
						super.paintComponent(g);
						//LinkedList<LifeForm> listOfLifeForms=Information.getLinkedListOfLifeForms();
						//Iterator<LifeForm> currentLifeForm = listOfLifeForms.iterator();
						int sizeOfCell=Information.getSizeOfCell();
						/*for (int i=0;i<Information.getAmountPredator();i++) {
							LifeForm CurrentLifeForm=listOfLifeForms.get(i);
							
							if (CurrentLifeForm.getAnimalImage()==null) return;
							
								g.drawImage(CurrentLifeForm.getAnimalImage(), 
												CurrentLifeForm.getXPosition(), 
														CurrentLifeForm.getYPosition(),sizeOfCell,sizeOfCell, null);
							
							
							
							
						}*/
						
						for (Iterator<LifeForm> current = Information.getLinkedListOfLifeForms().iterator(); current.hasNext(); ) {
						    LifeForm val = current.next();
						    if (val.getAnimalImage()==null) return;
						    g.drawImage(val.getAnimalImage(), 
									val.getXPosition(), 
											val.getYPosition(),sizeOfCell,sizeOfCell, null);
						}
						
						
						for (Iterator<Grass> current = Information.getLinkedListOfGrass().iterator(); current.hasNext(); ) {
						    Grass val = current.next();
						    if (val.getGrassImage()==null) return;
						    g.drawImage(val.getGrassImage(), 
									val.getXPosition(), 
											val.getYPosition(),sizeOfCell,sizeOfCell, null);
						}
						
						
						
			//for (int i=1;i<=this.;i++) {
				
			//}
					}
		}
	
	
	
	
	
	
	/*class GrassPanel extends JPanel {
		//private Image image;
		public GrassPanel() {
			
			
			
		}
					public void paintComponent(Graphics g) {
						super.paintComponent(g);
						System.out.println("Grass repaint");
						int sizeOfCell=Information.getSizeOfCell();
						for (Iterator<Grass> current = Information.getLinkedListOfGrass().iterator(); current.hasNext(); ) {
						    Grass val = current.next();
						    if (val.getGrassImage()==null) return;
						    g.drawImage(val.getGrassImage(), 
									val.getXPosition(), 
											val.getYPosition(),sizeOfCell,sizeOfCell, null);
						}
						
						
						
			//for (int i=1;i<=this.;i++) {
				
			//}
					}
		}*/
