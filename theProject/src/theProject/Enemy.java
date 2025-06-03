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
 * Purpose: The reponsibility of Enemy is ...
 *
 * Enemy is-a ...
 * Enemy is ...
 */
public class Enemy
{
	// fields

	private String name;
	private int health;
	private int maxHealth;
	
	// constructors

	public Enemy()
	{
		name = "Testing Dummy";
		maxHealth = 999999;
		health = maxHealth;
	}
	
	public Enemy(String initName, int initHealth)
	{
		name = initName;
		maxHealth = initHealth;
		health = maxHealth;
	}
	
	public Enemy(Enemy theEnemy)
	{
		name = theEnemy.getName();
		maxHealth = theEnemy.getMaxHealth();
		health = maxHealth;
	}
	
	// methods

	// getters

	public String getName()
	{
		return name;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getMaxHealth()
	{
		return maxHealth;
	}
	
	// setters

	public void setHealth(int newHealth)
	{
		health = newHealth;
	}
	
	// misc
	
	public int takeDamage(int damageTaken)
	{
		setHealth(health - damageTaken);
		if(health < 0)
		{
			int actualDamageTaken = damageTaken + health;
			health = 0;
			return actualDamageTaken;
		}
		
		return damageTaken;
	}
	
	public String toString()
	{
		return name + ": " + health + '/' + maxHealth;
	}
	
}
