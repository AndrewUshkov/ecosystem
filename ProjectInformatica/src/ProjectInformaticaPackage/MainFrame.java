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
		public MainFrame() {
			setTitle("ProjectInformatica");
			
			
			BioPanel lpanel=new BioPanel();
			add(lpanel);
		}
	}
	
	
	
	class BioPanel extends JPanel {
		public BioPanel() {
			
			
			
		}
					public void paintComponent(Graphics g) {    // ������ ���� �������� � ��� �����
						super.paintComponent(g);
						int sizeOfCell=Information.getSizeOfCell();
						
						
						g.drawImage(Information.getImageGround(),0,0,this.getSize().width,this.getSize().height,null);
						
						
						if (Information.worldCreated()) {
						for (Iterator<Grass> current = Information.getLinkedListOfGrass().iterator(); current.hasNext(); ) { //���������� ��� �����
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
						    
						    		g.drawImage(image,    //��� ����� � ������� getAnimalImage ����� � ����������� �� ��������� ������� (��������, �� ����) ������� ������ ��������
						    				val.getXPosition(), 
													val.getYPosition(),sizeOfCell*(30-val.timeOfInertion)/30,sizeOfCell*(30-val.timeOfInertion)/30, null);
						    } else
						    	g.drawImage(image,    //��� ����� � ������� getAnimalImage ����� � ����������� �� ��������� ������� (��������, �� ����) ������� ������ ��������
					    				val.getXPosition(), 
												val.getYPosition(),sizeOfCell,sizeOfCell, null);
						    
						    
						    
						    
						}
						
						for (Iterator<Herbivore> current = Information.getLinkedListOfHerbivores().iterator(); current.hasNext(); ) {
						    Herbivore val = current.next();
						    Image image;
						    if ((image=val.getAnimalImage())==null) return;
						    
						    
						    if (val.isChild()) {
						    
						    		g.drawImage(image,    //��� ����� � ������� getAnimalImage ����� � ����������� �� ��������� ������� (��������, �� ����) ������� ������ ��������
						    				val.getXPosition(), 
													val.getYPosition(),sizeOfCell*(30-val.timeOfInertion)/30,sizeOfCell*(30-val.timeOfInertion)/30, null);
						    } else
						    	g.drawImage(image,    //��� ����� � ������� getAnimalImage ����� � ����������� �� ��������� ������� (��������, �� ����) ������� ������ ��������
					    				val.getXPosition(), 
												val.getYPosition(),sizeOfCell,sizeOfCell, null);
						    
						    
						    
						    
						}
						
						
					}
						
						
						
						
					
					}
		}
