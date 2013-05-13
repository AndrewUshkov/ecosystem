package ProjectInformaticaPackage;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import javax.swing.*;

	class MainFrame extends JFrame {                                   
		public MainFrame() {
			setTitle("ProjectInformatica");
			BioPanel lpanel=new BioPanel();
			add(lpanel);
			
			
		}
	}
	
	class BioPanel extends JPanel {
		int x;
		int y;
		int cell=Information.getSizeOfCell();
		boolean isEvent;
		public BioPanel() {
			this.addMouseListener(new MouseListener() {
				@Override
	            public void mouseReleased(MouseEvent e) {
	                //System.out.println(":MOUSE_RELEASED_EVENT:");
	            }
	            @Override
	            public void mousePressed(MouseEvent e) {
	                //System.out.println(":MOUSE_PRESSED_EVENT:");
	            }
	            @Override
	            public void mouseExited(MouseEvent e) {
	               // System.out.println(":MOUSE_EXITED_EVENT:");
	            }
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                //System.out.println(":MOUSE_ENTER_EVENT:");
	            }
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	//this.showInformationAnimal(e.getX(),e.getY());
	            	//System.out.println("Changed");
	            	//if (!Information.isEvent()) {Information.setIsEvent(true); /*System.out.println("Changed");*/}
	            	//Information.setIsEvent(true);
	            	if (Information.worldCreated()) {
	            	x=e.getX();
	            	y=e.getY();
	            	isEvent=true;
	            	}
	            }
			});
		}
		
	private LifeForm findAnimal() {
		for (Iterator<Leo> current = Information.getLinkedListOfLeos().iterator(); current.hasNext(); ) {
		    Leo val = current.next();
		    if ((x>=val.getXPosition())&&(x<=val.getXPosition()+cell)&&(y>=val.getYPosition())&&(y<=val.getYPosition()+cell)) {
		    	return val;
		    }
		}
		    for (Iterator<Herbivore> current = Information.getLinkedListOfHerbivores().iterator(); current.hasNext(); ) {
			    Herbivore valh = current.next();
			    if ((x>=valh.getXPosition())&&(x<=valh.getXPosition()+cell)&&(y>=valh.getYPosition())&&(y<=valh.getYPosition()+cell)) {
			    	return valh;
			    }
		    }
		return null;
	}
	private void showInformationAboutAnimal() {
		LifeForm animal;
		if ((animal=this.findAnimal())!=null) {
		InformationAboutAnimal inform=new InformationAboutAnimal(animal);
		inform.setVisible(true);
		}
	}
	public void paintComponent(Graphics g) {    // рисуем всех животных и всю траву
						super.paintComponent(g);
						int sizeOfCell=Information.getSizeOfCell();
						
						g.drawImage(Information.getImageGround(),0,0,this.getSize().width,this.getSize().height,null);
						
						
						if (Information.worldCreated()) {
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
						
						if (isEvent) {this.showInformationAboutAnimal(); isEvent=false;}
						
						
					}
						
						
						
						
					
					}
		
		}
