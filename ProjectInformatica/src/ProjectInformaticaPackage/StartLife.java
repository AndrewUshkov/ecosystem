package ProjectInformaticaPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class StartLife extends JFrame {
	public static void main(String[] args) {    //����� �������� �������� ���������
		//int amountPredator=4;
		//int amountHerbivore;
		//ArrayList<LifeForm> listOfLifeForms=new ArrayList<LifeForm>();
		int quantTime;
		int numberAnimalsInThread=2;
		int numberOfThreads;
		Leo a;
		Leo b;
		Thread currentPredatorThread;
		
		Information.readPredatorsFromConsole(/*this*/);  //����� ����������� ������� ���������� ����������
		Information.readHerbivoreFromConsole();
		Information.readGrassFromConsole();
		Information.readSizeOfCellFromConsole();
		Information.readDefaultHeightFromConsole();
		Information.readDefaultWeightFromConsole();
		Information.loadImages();
		MainFrame frame=new MainFrame(Information.getDefaultWeight(), Information.getDefaultHeight()); //������� ������� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JMenuBar menuBar=new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu menuNewWorld=new JMenu("����� ���");
		JMenu menuActions=new JMenu("��������");
		JMenu menuGraphs=new JMenu("�������");
		menuBar.add(menuNewWorld);
		menuBar.add(menuActions);
		menuBar.add(menuGraphs);
		JMenuItem stopItem=new JMenuItem("����������");
		JMenuItem pauseItem=new JMenuItem("�����");
		JMenuItem renewalItem=new JMenuItem("�����������");
		menuActions.add(stopItem);
		menuActions.add(pauseItem);
		menuActions.add(renewalItem);
		PauseAction pause= new PauseAction(0);
		PauseAction renewal=new PauseAction(100);
		pauseItem.addActionListener(pause);
		renewalItem.addActionListener(renewal);
		
		
		
		frame.setVisible(true);
		
		
		
		
		
		PredatorThread predatorThread=new PredatorThread();
		HerbivoreThread herbivoreThread=new HerbivoreThread();
		GrassThread grassThread=new GrassThread();
		
		do {
			
		quantTime=Information.getQuantTime();
		if (quantTime>0) {
			
			predatorThread.run();      //��� ��� ������- ��� �������� � �����
			herbivoreThread.run();
			grassThread.run();
			
			try {
				Thread.sleep(quantTime);/*����� ������ �����������*/ 
				} catch (Exception e) {}
			frame.repaint();
		}	
		} while (true);
		
		
		
		
		/*numberOfThreads=(Information.getLinkedListOfLeos().size()+1)/numberAnimalsInThread;  //� ������ ����� �������� 2 �������, �������: 1
		ArrayList<Thread> threads=new ArrayList<Thread>();
		
		for (int i=1;i<=numberOfThreads;i++) {
			a=Information.getLinkedListOfLeos().get(2*(i-1));
			if (Information.getLinkedListOfLeos().size()>=2*(i-1)+2) b=Information.getLinkedListOfLeos().get(2*(i-1)+1); else b=null;
			threads.add(new Thread(new PredatorThread(a,b), String.valueOf(i)));
		}
		
		
		do {
		for (Iterator<Thread> currentThread = threads.iterator(); currentThread.hasNext(); ) {
		    currentThread.next().run();
		}
		
		try {
			quantTime=Information.getQuantTime();
			if (quantTime>0) {Thread.sleep(quantTime);/*����� ������ �����������*/ //frame.repaint();}
			/*else {}
		
	} catch (Exception e) {}
			
		} while (true);*/
		
	}
}
class PauseAction implements ActionListener {
	int time;
	public PauseAction(int quantTime) {
		time=quantTime;
	}
	public void actionPerformed(ActionEvent event) {
		if (time==0) {}
		Information.setQuantTime(time);
	}
}
