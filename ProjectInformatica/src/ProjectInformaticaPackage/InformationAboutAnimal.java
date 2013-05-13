package ProjectInformaticaPackage;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class InformationAboutAnimal extends JFrame { 
	Image imageInformationAnimal;
	
	JLabel labelIsMale=new JLabel("���:");
	JLabel labelIsMaleInfo=new JLabel();
	
	JLabel labelStarvation=new JLabel("�����:");
	JLabel labelStarvationInfo=new JLabel();
	
	JLabel labelExhaustion=new JLabel("���������:");
	JLabel labelExhaustionInfo=new JLabel();
	
	JLabel labelPassion=new JLabel("�������:");
	JLabel labelPassionInfo=new JLabel();
	
	JLabel labelCurrentAction=new JLabel("��������:");
	JLabel labelCurrentActionInfo=new JLabel();
	
	JButton enter=new JButton("OK");
		
	
		public InformationAboutAnimal(LifeForm animal) {
			
			try {
				imageInformationAnimal=ImageIO.read(new File("Textures/InformationAnimal.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.setIconImage(imageInformationAnimal);
			this.setTitle("����������");
			this.setSize(300,210);
			setLayout(null); 
			add(labelIsMale);
			add(labelStarvation);
			add(labelExhaustion);
			add(labelPassion);
			add(labelCurrentAction);
			add(labelIsMaleInfo);
			add(labelStarvationInfo);
			add(labelExhaustionInfo);
			add(labelPassionInfo);
			add(labelCurrentActionInfo);
			//add(cansel);
			add(enter);
			
			//������������ ��������� � ����
			labelIsMale.setBounds(5,5,150,20);
			labelIsMaleInfo.setBounds(160,5,150,20);
			
			labelStarvation.setBounds(5, 30, 150, 20);
			labelStarvationInfo.setBounds(160, 30, 150, 20);
			
			labelExhaustion.setBounds(5,55,150, 20);
			labelExhaustionInfo.setBounds(160,55,150, 20);
			
			labelPassion.setBounds(5, 80, 150, 20);
			labelPassionInfo.setBounds(160, 80, 150, 20);
			
			labelCurrentAction.setBounds(5, 105, 150, 20);
			labelCurrentActionInfo.setBounds(160, 105, 150, 20);
			
			enter.setBounds(180, 140, 80, 20);
			
			Exit exit=new Exit(this);
			//CreationAction creationNewWorld=new CreationAction(this);
			enter.addActionListener(exit);
			//WriteTextAction writeText=new WriteTextAction();
			//option.addMouseListener(writeText);
			
			labelIsMaleInfo.setText(String.valueOf(animal.isMale()));
			labelStarvationInfo.setText(String.valueOf(animal.getStarvation()));
			labelExhaustionInfo.setText(String.valueOf(animal.getExhaustion()));
			labelPassionInfo.setText(String.valueOf(animal.getPassion()));
			//labelCurrentActionInfo
			
			
		}
	
}

class Exit implements ActionListener {
	InformationAboutAnimal b;
	public Exit(InformationAboutAnimal a) {
		b=a;
	}
	public void actionPerformed(ActionEvent event) {
		b.setVisible(false);
	}
}
/*class CreationAction implements ActionListener {
	int numberOfPredators;
	int numberOfHerbivores;
	int numberOfGrass;
	CreateNewWorld  a;
	public CreationAction(CreateNewWorld d) {
		a=d;
	}
	public void actionPerformed(ActionEvent event) {
		
		//������������� ���������
		Information.setWorldCreated(false);
		
		//�������� ������ � Information
		Information.setAmountOfPredators((Integer.parseInt(a.numberPredators.getText())));
		Information.setAmountOfHerbivores((Integer.parseInt(a.numberHerbivores.getText())));
		Information.setAmountOfGrass((Integer.parseInt(a.numberGrass.getText())));
		
		//Information ���������� ���������
		Information.readPredatorsFromConsole();
		Information.readHerbivoreFromConsole();
		Information.readGrassFromConsole();
		
		//��������� ����
		a.setVisible(false);
		
		//�������, ��� ��� �����������
		Information.setWorldCreated(true);
	}
}

class WriteTextAction implements MouseListener {
	
	public void mouseClicked(MouseEvent e) {
		
	}
	public void mouseEntered(MouseEvent e) {
		System.out.println("tbtdb\n\n\n\n\n\n\n\\n\n\n\n");
	}
	public void mouseExited(MouseEvent e) {
		
	}
	public void mousePressed(MouseEvent e) {
		
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	
}*/

