package ProjectInformaticaPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Grass {
	   private int xPosition;
	   private int yPosition;
       private int timeNewAppears;
       private int age;
       private float energyValue;
       private Image imageGreenGrass;
       private Image imageYellowGrass;
       
       
       Grass(int xPosition, int yPosition, int age) {
    	   this.xPosition=xPosition;
    	   this.yPosition=yPosition;
    	   this.age=age;
       }
       
       public boolean makeDecision(){
    	   //this.age--;
    	   if (age<=0) return false; return true;
       }
       public Image getGrassImage() {
    		
    			if (age>=50) return Information.getImageGreenGrass();
    			if (age<50) return Information.getImageYellowGrass();
    			return null;
    	}

	public int getXPosition() {
		return xPosition;
	}

	public int getYPosition() {
		return yPosition;
	}
	public float getEnergyValue() {
		if (age>=50) return (float) 2.5; else return 1;
	}
}
