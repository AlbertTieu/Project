/**
* Lead Author(s):
* @author albert; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2025-03-25
*/
package theProject;

/**
 * Purpose: The reponsibility of Gun is ...
 *
 * Gun is-a ...
 * Gun is ...
 */
public class Gun extends Weapon
{
	// fields
	
	private double reloadTime;
	private int currentMagazine;
	private int magazineSize;
	private double penMulti;
	
	// constructors

	public Gun(String initName,
			   int initDamage, 
			   int initAttackRate, 
			   int initHitCount,
			   double initHeadshotMulti, 
			   double initReloadTime, 
			   int initMagazineSize,
			   double initPenMulti)
	{
		super(initName, initDamage, initAttackRate, initHitCount, initHeadshotMulti);
		reloadTime = initReloadTime;
		magazineSize = initMagazineSize;
		currentMagazine = magazineSize;
		penMulti = initPenMulti;
	}
	
	// methods

	// getters
	
	public double getReloadTime()
	{
		return reloadTime;
	}
	
	public int getCurrentMagazine()
	{
		return currentMagazine;
	}
	
	public int getMagazineSize()
	{
		return magazineSize;
	}
	
	public double getPenMulti()
	{
		return penMulti;
	}
	
	// setters
	
	public void setCurrentMagazine(int newMag)
	{
		currentMagazine = newMag;
	}

	// misc
	
	public void reload()
	{
		currentMagazine = magazineSize;
	}
	
}
