package ProjectInformaticaPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import javax.imageio.*;

import javax.imageio.ImageIO;

public class Leo implements LifeForm {
private boolean male;
private float age;
private float passion;
private float starvation;
private float exhaustion;
private int xPosition;
private int yPosition;
private float starvationCoefficient;
private float passionCoefficient;
private float exhaustionCoefficient;
private float legacyStarvationCoefficient;
private float legacyPassionCoefficient;
private float legacyExhaustionCoefficient;
private float decision;
ArrayList <LeoWish> leoNeeds;
public float getExhaustion() {
	return exhaustion;
}
public void setExhaustion(float exhaustion) {
	this.exhaustion = exhaustion;
}
public float getExhaustionCoefficient() {
	return exhaustionCoefficient;
}
public void setExhaustionCoefficient(float exhaustionCoefficient) {
	this.exhaustionCoefficient = exhaustionCoefficient;
}
public float getLegacyExhaustionCoefficient() {
	return legacyExhaustionCoefficient;
}
public void setLegacyExhaustionCoefficient(float legacyExhaustionCoefficient) {
	this.legacyExhaustionCoefficient = legacyExhaustionCoefficient;
}
ArrayList<Leo> listOfLeos=Information.getListOfLeos();


public Leo (/*MainFrame window, */boolean IfMale, int startXPosition, int startYPosition, float startAge, 
						float startStarvation, float startPassion, float startExhaustion,
								float startStarvationCoefficient, float startPassionCoefficient, float startExhaustionCoefficient,
										float legacyStarvationCoefficient, float legacyPassionCoefficient, float legacyExhaustionCoefficient) {
	this.male=IfMale;
	this.xPosition=startXPosition;
	this.yPosition=startYPosition;
	this.age=startAge;
	this.starvation=startStarvation;
	this.passion=startPassion;
	this.exhaustion=startExhaustion;
	this.legacyPassionCoefficient=legacyPassionCoefficient;
	this.legacyStarvationCoefficient=legacyStarvationCoefficient;
	this.legacyExhaustionCoefficient=legacyExhaustionCoefficient;
	this.passionCoefficient=startPassionCoefficient;
	this.starvationCoefficient=startStarvationCoefficient;
	this.exhaustionCoefficient=startExhaustionCoefficient;
	
}
public float getAge() {
	return age;
}
public void setAge(float newAge) {
	this.age=newAge;
}
public float getPassion() {
	return passion;
}
public void setPassion(float passion) {
	this.passion = passion;
}
public float getStarvation() {
	return starvation;
}
public void setStarvation(float starvation) {
	this.starvation = starvation;
}
public int getXPosition() {
	return xPosition;
}
public void setXPosition(int xPosition) {
	this.xPosition = xPosition;
}
public int getYPosition() {
	return yPosition;
}
public void setYPosition(int yPosition) {
	this.yPosition = yPosition;
}
public boolean isMale() {
	return this.male;
}
public void moveToRelative(int xRelative, int yRelative) {
	this.xPosition+=xRelative;
	this.yPosition+=yRelative;
}
public void moveToAbs(int xAbs, int yAbs) {
	this.xPosition=xAbs;
	this.yPosition=yAbs;
}
public void setStarvationCoefficient(float newSCoef) {
	
}
public float getStarvationCoefficient() {
	return this.starvationCoefficient;
}
public void setPassionCoefficient(float newPCoef) {
	this.passionCoefficient=newPCoef;
}
public float getLegacyStarvationCoefficient() {
	return this.starvationCoefficient;
}
public void setLegacyStarvationCoefficient(float newLSCoef) {
	this.starvationCoefficient=newLSCoef;
}
public float getLegacyPassionCoefficient() {
	return this.legacyPassionCoefficient;
}
public void setLegacyPassionCoefficient(float newLPCoef) {
	legacyPassionCoefficient=newLPCoef;
}
public Image getAnimalImage() {
		if (decision==3) {return Information.getImageSleepingLeo();} else
			return Information.getImageLeo();
}
public boolean femaleAgree() {
	if (passion<=20) return true; return false;
}
public CoordinatesXY goToNearestPredator() {
	CoordinatesXY Coords=new CoordinatesXY();
	/*int index=0;
	for (int i=0;i<Information.getAmountPredator();i++) {
		if ((listOfLifeForms.get(i).getXPosition()+listOfLifeForms.get(i).getYPosition())*(listOfLifeForms.get(i).getXPosition()+listOfLifeForms.get(i).getYPosition())
				< (listOfLifeForms.get(index).getXPosition()+listOfLifeForms.get(index).getYPosition())*(listOfLifeForms.get(index).getXPosition()+listOfLifeForms.get(index).getYPosition())) {
			index=i;
		}
	}
	Coords.setXCoord(listOfLifeForms.get(index).getXPosition());
	Coords.setYCoord(listOfLifeForms.get(index).getYPosition());
	if (Coords.getXCoord()>=this.xPosition) {this.xPosition+=4;} else this.xPosition-=4;
	if (Coords.getYCoord()>=this.yPosition) {this.yPosition+=4;} else this.yPosition-=4;
	return Coords;*/
	Iterator<Leo> currentLifeForm = Information.getLinkedListOfLeos().iterator();
	if (currentLifeForm.hasNext()) {currentLifeForm.next();}
	Leo nearestLeo=Information.getLinkedListOfLeos().getFirst();
    while(currentLifeForm.hasNext()){
         Leo element =currentLifeForm.next();
         if ((element.getXPosition()+element.getYPosition())*(element.getXPosition()+element.getYPosition())
 				< (nearestLeo.getXPosition()+nearestLeo.getYPosition())*(nearestLeo.getXPosition()+nearestLeo.getYPosition())) {
        	 nearestLeo=element;
         }
        
    }
    
    
    Coords.setXCoord(nearestLeo.getXPosition());
	Coords.setYCoord(nearestLeo.getYPosition());
	if (Coords.getXCoord()>=this.xPosition) {this.xPosition+=4;} else this.xPosition-=4;
	if (Coords.getYCoord()>=this.yPosition) {this.yPosition+=4;} else this.yPosition-=4;
	float x=Coords.getXCoord();
	float y=Coords.getYCoord();
	if ((this.starvation<=100-2*this.starvationCoefficient)&&((xPosition-x)*(xPosition-x)+(yPosition-y)*(yPosition-y)<Information.getSizeOfCell()*Information.getSizeOfCell())) this.starvation+=2*this.starvationCoefficient;
	return Coords;
    
    
    
}
public void goToNearestGrass() {
	if (!Information.getLinkedListOfGrass().isEmpty()) {
	Grass nearestGrass=Information.getLinkedListOfGrass().getFirst();
	int nearestDistance=(nearestGrass.getXPosition()-this.xPosition)*(nearestGrass.getXPosition()-this.xPosition)+(nearestGrass.getYPosition()-this.yPosition)*(nearestGrass.getYPosition()-this.yPosition);
	int currentDistance;
	Grass currentGrass;
	for (Iterator<Grass> current = Information.getLinkedListOfGrass().iterator(); current.hasNext(); ) {
	    currentGrass = current.next();
	    currentDistance=(currentGrass.getXPosition()-this.xPosition)*(currentGrass.getXPosition()-this.xPosition)+(currentGrass.getYPosition()-this.yPosition)*(currentGrass.getYPosition()-this.yPosition);
	    
	    if (currentDistance<nearestDistance) {nearestGrass=currentGrass; nearestDistance=currentDistance;}
	}
	
	if (nearestGrass.getXPosition()>=this.xPosition) {this.xPosition+=4;} else this.xPosition-=4;
	if (nearestGrass.getYPosition()>=this.yPosition) {this.yPosition+=4;} else this.yPosition-=4;
	if (nearestDistance<=Information.getSizeOfCell()) {this.starvation+=nearestGrass.getEnergyValue();}
	
	}
}
private void feelHungry() {
	
}
private void tryMakeChildren(Leo female) {
	if (female.femaleAgree()) {this.passion=100; female.setPassion(100);}
}
private int feelPassion() {
	if (!Information.getLinkedListOfLeos().isEmpty()) {
		//LifeForm nearestLeo=Information.getLinkedListOfLifeForms().getFirst();
		Leo nearestLeo=null;
		Leo currentLeo;
		int currentDistance=-1;
		int nearestDistance=-1;
		for (Iterator<Leo> current = Information.getLinkedListOfLeos().iterator(); current.hasNext(); ) {
			currentLeo=current.next();
			if (    (nearestLeo==null)&&( ((this.isMale())^(currentLeo.isMale()))          )
					) 
			{
				nearestLeo=currentLeo; 
				nearestDistance=(nearestLeo.getXPosition()-this.xPosition)*(nearestLeo.getXPosition()-this.xPosition)+(nearestLeo.getYPosition()-this.yPosition)*(nearestLeo.getYPosition()-this.yPosition);
					}
			if ((nearestLeo!=null)&&(nearestLeo!=currentLeo)  &&
					    ((this.isMale())^(currentLeo.isMale()))         ) {
				currentDistance=(currentLeo.getXPosition()-this.xPosition)*(currentLeo.getXPosition()-this.xPosition)+(currentLeo.getYPosition()-this.yPosition)*(currentLeo.getYPosition()-this.yPosition);
				if (currentDistance<nearestDistance) {nearestDistance=currentDistance; nearestLeo=currentLeo;}
				
			}
			
		}
		if (nearestLeo==null) {return -1;}
		if (nearestLeo.getXPosition()>=this.xPosition) {this.xPosition+=4;} else this.xPosition-=4;
		if (nearestLeo.getYPosition()>=this.yPosition) {this.yPosition+=4;} else this.yPosition-=4;
		if (      (nearestDistance<=Information.getSizeOfCell())&&
									(this.isMale())		) {this.tryMakeChildren(nearestLeo);}
		return 0;
		//int nearestDistance=(nearestLeo.getXPosition()-this.xPosition)*(nearestLeo.getXPosition()-this.xPosition)+(nearestLeo.getYPosition()-this.yPosition)*(nearestLeo.getYPosition()-this.yPosition);
		
		/*Leo newCurrentLeo;
		for (Iterator<Leo> current = Information.getLinkedListOfLeos().iterator(); current.hasNext(); ) {
		    newCurrentLeo = current.next();
		    currentDistance=(newCurrentLeo.getXPosition()-this.xPosition)*(newCurrentLeo.getXPosition()-this.xPosition)+(newCurrentLeo.getYPosition()-this.yPosition)*(newCurrentLeo.getYPosition()-this.yPosition);
		    
		    if (currentDistance<nearestDistance) {nearestLeo=(Leo)newCurrentLeo; nearestDistance=currentDistance;}
		}
		
		if (nearestLeo!=null) {
		if (nearestLeo.getXPosition()>=this.xPosition) {this.xPosition+=4;} else this.xPosition-=4;
		if (nearestLeo.getYPosition()>=this.yPosition) {this.yPosition+=4;} else this.yPosition-=4;
		//if (nearestDistance<=Information.getSizeOfCell()) {this.starvation+=nearestGrass.getEnergyValue();}
		}*/
		} else return -1;
}
private void feelKillInstinct() {
	
}
private void feelSleepy() {
	this.exhaustion+=5*this.exhaustionCoefficient;
}
private int getDecision() {
	this.age-=0.5;                                              //��������� ����� �������� �����
	this.starvation-=this.starvationCoefficient;
	if (passion>20) {this.passion-=this.passionCoefficient;}  
	this.exhaustion-=this.exhaustionCoefficient;
	if (this.age<=0) {System.out.println("Age"); return 0;}
	if (this.starvation<=0) {System.out.println("Starvation"); return 0;}
	if (this.exhaustion<=0) return 3;
	
	if ((this.starvation<=this.exhaustion)&&(this.starvation<=this.passion)) return 1;
	if ((this.starvation>=this.passion)&&(this.passion<=this.exhaustion)) return 2;
	if ((this.starvation>=this.exhaustion)&&(this.exhaustion<=this.passion)) return 3;
	return 3;
	/*int length=this.leoNeeds.length;
	Arrays.sort(this.leoNeeds);*/
	
	/*ArrayList<LeoWish> leoNeeds= new  ArrayList<LeoWish>();
		leoNeeds.add(new LeoWish(1,this.starvation));
		leoNeeds.add(new LeoWish(2,this.passion));
		leoNeeds.add(new LeoWish(3,this.exhaustion));
	
		
	Collections.sort(leoNeeds);
	return leoNeeds.get(leoNeeds.size()-1).getNumberOfLeoNeed();*/
	
}

public boolean makeDecision() {
	decision=this.getDecision();
	if (decision==0) {return false;}
	if (decision==1) {System.out.println("Make decision: Feel hungry"+this.starvation+" "+this.exhaustion+" "+this.passion); this./*feelHungry();*/goToNearestGrass();}
	if (decision==2) {System.out.println("Make decision: Feel passion"+this.starvation+" "+this.exhaustion+" "+this.passion); if (this.feelPassion()==-1) {}}
	if (decision==4) {this.feelKillInstinct();}
	if (decision==3) {System.out.println("Make decision: Sleep"+this.starvation+" "+this.exhaustion+" "+this.passion); this.feelSleepy();}
	return true;
}
}
