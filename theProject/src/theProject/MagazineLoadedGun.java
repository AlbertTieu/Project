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
 * Purpose: The reponsibility of MagazineLoadedGun is ...
 *
 * MagazineLoadedGun is-a ...
 * MagazineLoadedGun is ...
 */
public class MagazineLoadedGun extends Gun
{
	// fields
	
	private double tacReloadTime;

	// constructors

	public MagazineLoadedGun(String initName,
							 int initDamage, 
			   				 int initAttackRate, 
			   				 int initHitCount, 
			   				 double initHeadshotMulti, 
			   				 double initReloadTime, 
			   				 int initMagazineSize, 
			   				 double initPenMulti,
			   				 double initTacReloadTime)
	{
		super(initName, initDamage, initAttackRate, initHitCount, initHeadshotMulti, initReloadTime, initMagazineSize, initPenMulti);
		tacReloadTime = initTacReloadTime;
	}
	
	// methods

	// getters

	public double getTacReloadTime()
	{
		return tacReloadTime;
	}
	
	@Override
	public double getReloadTime()
	{
		if(getCurrentMagazine() > 0)
		{
			return tacReloadTime;
		}
		return super.getReloadTime();
	}
	
	// setters

	// misc
	
}
