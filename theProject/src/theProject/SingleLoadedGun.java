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
 * Purpose: The reponsibility of SingleLoadedGun is ...
 *
 * SingleLoadedGun is-a ...
 * SingleLoadedGun is ...
 */
public class SingleLoadedGun extends Gun
{
	// fields

	
	private int roundsPerLoad;
	private double timePerLoad;
	private double reloadEngageDisengage;
	
	// constructors

	public SingleLoadedGun(String initName,
						   int initDamage, 
				 		   int initAttackRate, 
				 		   int initHitCount,
				 		   double initHeadshotMulti,
				 		   double initReloadTime, 
				 		   int initMagazineSize, 
				 		   double initPenMulti,
				 		   int initRoundsPerCycle,
				 		   double initTimePerCycle,
				 		   double initReloadEngageDisengage)
	{
		super(initName, initDamage, initAttackRate, initHitCount, initHeadshotMulti, initReloadTime, initMagazineSize, initPenMulti);
		roundsPerLoad = initRoundsPerCycle;
		timePerLoad = initTimePerCycle;
		reloadEngageDisengage = initReloadEngageDisengage;
	}
	
	// methods

	public int getRoundsLoaded()
	{
		return roundsPerLoad;
	}
	
	public double getTimePerCycle()
	{
		return timePerLoad;
	}
	
	public double getReloadEngageDisengage()
	{
		return reloadEngageDisengage;
	}
	
	@Override
	public double getReloadTime()
	{
		if (getCurrentMagazine() > 0)
		{
			return reloadEngageDisengage + ( ((getMagazineSize() - getCurrentMagazine() ) / roundsPerLoad) * timePerLoad);
		}
		return super.getReloadTime();
	}
	
	// getters

	// setters

	// misc
	
}
