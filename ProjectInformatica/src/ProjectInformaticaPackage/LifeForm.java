package ProjectInformaticaPackage;

import java.awt.Image;

public interface LifeForm {
	void setAge(float newAge);
	float getAge();
	void setStarvation(float newStarvation);
	float getStarvation();
	void setPassion(float newPassion);
	float getPassion();
	void setXPosition(int newXPosition);
	int getXPosition();
	void setYPosition(int newXPosition);
	int getYPosition();
	void setStarvationCoefficient(float newSCoef);
	float getStarvationCoefficient();
	void setPassionCoefficient(float newPCoef);
	float getLegacyStarvationCoefficient();
	void setLegacyStarvationCoefficient(float newLSCoef);
	float getLegacyPassionCoefficient();
	void setLegacyPassionCoefficient(float newLPCoef);
	Image getAnimalImage();
	//CoordinatesXY goToNearestPredator();
	boolean makeDecision();
}
