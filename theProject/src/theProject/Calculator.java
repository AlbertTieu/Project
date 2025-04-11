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

import java.util.ArrayList;

/**
 * Purpose: The reponsibility of Calculator is ...
 *
 * Calculator is-a ...
 * Calculator is ...
 */
public class Calculator
{
	// fields
	
	private Weapon weapon;
	private ArrayList<Enemy> enemies;
	
	// constructors

	public Calculator()
	{
		weapon = null;
		enemies = new ArrayList<Enemy>();
	}
	
	public Calculator(Weapon initWeapon, ArrayList<Enemy> initEnemies)
	{
		weapon = initWeapon;
		enemies = initEnemies;
	}
	
	// methods

	// getters

	public Weapon getWeapon()
	{
		return weapon;
	}
	
	public ArrayList<Enemy> getEnemies()
	{
		return enemies;
	}
	
	// setters

	public void setWeapon(Weapon newWeapon)
	{
		weapon = newWeapon;
	}
	
	public void setEnemies(ArrayList<Enemy> newEnemies)
	{
		enemies = newEnemies;
	}
	
	// misc
	
	public static void main(String[] args)
	{
		Calculator main = new Calculator();
		main.addEnemy(new Enemy("Slasher", 100));
		main.addEnemy(new Enemy("Charger", 70));
		main.addEnemy(new Enemy("Smasher", 1000));
		
		ArrayList<Enemy> enemyList = main.getEnemies();
		for(Enemy e : enemyList)
		{
			System.out.println(e.toString());
		}
	}
	
	public void addEnemy(Enemy enemy)
	{
		enemies.add(enemy);
	}
	
}
