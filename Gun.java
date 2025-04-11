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
	private int magazineSize;
	private double penMulti;
	
	// constructors

	public Gun(int initDamage, 
			   int initAttackRate, 
			   double initHeadshotMulti, 
			   String initName, 
			   double initReloadTime, 
			   int initMagazineSize,
			   double initPenMulti)
	{
		super(initDamage, initAttackRate, initHeadshotMulti, initName);
		reloadTime = initReloadTime;
		magazineSize = initMagazineSize;
		penMulti = initPenMulti;
	}
	
	// methods

	// getters
	
	public double getReloadTime()
	{
		return reloadTime;
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

	// misc
	
}
