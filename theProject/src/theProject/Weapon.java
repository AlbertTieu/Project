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
 * Purpose: The reponsibility of Weapon is ...
 *
 * Weapon is-a ...
 * Weapon is ...
 */
public class Weapon
{
	// fields
	
	private int damage;				// a Weapon has-a damage value
	private int attackRate;			// a Weapon has-an attack rate
	private int hitCount;
	private double headshotMulti;	// a Weapon has-a headshot multiplier
	
	// constructors
	
	public Weapon()
	{
		damage = 0;
		attackRate = 0;
		hitCount = 1;
		headshotMulti = 1;;
	}
	
	public Weapon(int initDamage, 
				  int initAttackRate, 
				  int initHitCount,
				  double initHeadshotMulti)
	{
		damage = initDamage;
		attackRate = initAttackRate;
		hitCount = initHitCount;
		headshotMulti = initHeadshotMulti;
	}
	
	// methods
	
	// getters
	
	public int getDamage()
	{
		return damage;
	}
	
	public int getAttackRate()
	{
		return attackRate;
	}
	
	public int getHitCount()
	{
		return hitCount;
	}
	
	public double getHeadshotMulti()
	{
		return headshotMulti;
	}
	
	// setters
	
	// misc
	
	public String toString()
	{
		return  "Damage: " + damage + '\n' +
				"RPM: " + attackRate + '\n' + 
				"Headshot: " + headshotMulti + '\n';
	}
	
}
