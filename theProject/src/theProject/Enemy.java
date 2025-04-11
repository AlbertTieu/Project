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
	
	// constructors

	public Enemy()
	{
		health = 100;
	}
	
	public Enemy(String initName, int initHealth)
	{
		name = initName;
		health = initHealth;
	}
	
	// methods

	// getters

	public int getHealth()
	{
		return health;
	}
	
	// setters

	// misc
	
	public String toString()
	{
		return name + ": " + health;
	}
	
}
