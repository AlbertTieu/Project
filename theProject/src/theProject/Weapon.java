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
	private double headshotMulti;	// a Weapon has-a headshot multiplier
	private String name;			// a Weapon has-an identifying name
	
	// constructors
	
	public Weapon()
	{
		damage = 0;
		attackRate = 0;
		headshotMulti = 1;
		name = "Weapon";
	}
	
	public Weapon(int initDamage, 
				  int initAttackRate, 
				  double initHeadshotMulti, 
				  String initName)
	{
		damage = initDamage;
		attackRate = initAttackRate;
		headshotMulti = initHeadshotMulti;
		name = initName;
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
	
	public double getHeadshotMulti()
	{
		return headshotMulti;
	}
	
	public String getName()
	{
		return name;
	}
	
	// setters
	
	// misc
	
	
}
