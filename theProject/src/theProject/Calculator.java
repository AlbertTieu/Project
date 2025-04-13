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

import java.util.LinkedList;
import java.util.Hashtable;

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
	private LinkedList<Enemy> enemies;
	
	// constructors

	public Calculator()
	{
		weapon = null;
		enemies = new LinkedList<Enemy>();
	}
	
	public Calculator(Weapon initWeapon, LinkedList<Enemy> initEnemies)
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
	
	public LinkedList<Enemy> getEnemies()
	{
		return enemies;
	}
	
	// setters

	public void setWeapon(Weapon newWeapon)
	{
		weapon = newWeapon;
	}
	
	public void setEnemies(LinkedList<Enemy> newEnemies)
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
		
		Hashtable<String, Weapon> weaponTable = new Hashtable<String, Weapon>();
		
		weaponTable.put("M4A1", new MagazineLoadedGun(25, 800, 1, 1.5, 3.0, 300, 1.0, 2.6));
		
		main.setWeapon(weaponTable.get("M4A1"));
		
		System.out.println(main.getWeapon().toString());
		
		LinkedList<Enemy> enemyList = main.getEnemies();
		for(Enemy e : enemyList)
		{
			System.out.println(e.toString());
		}
		
		main.attackUntilClear(main.getWeapon());
	}
	
	public void addEnemy(Enemy enemy)
	{
		enemies.add(enemy);
	}
	
	public int attack(Weapon theWeapon)
	{
		double damageMulti = 1.0;
		int hits = theWeapon.getHitCount();
		int totalDamage = 0;
		
		for(int i = 0; i < enemies.size(); i++)
		{
			if(hits > 0)
			{
				Enemy theEnemy = enemies.get(i);
				int damage = theEnemy.takeDamage( (int) (theWeapon.getDamage() * damageMulti));
				totalDamage = totalDamage + damage;
				System.out.println(theEnemy.getName() + " took " + damage + " damage!" + " (" + (theEnemy.getHealth() + damage) + " -> " + theEnemy.getHealth() + ")");
//				damageMulti = theWeapon.getPenMulti() * damageMulti;
				if(theEnemy.getHealth() == 0)
				{
					System.out.println(theEnemy.getName() + " has died!");
					enemies.remove(i);
				}
				hits--;
			}
		}
		return totalDamage;
		
	}
	
	public void attackUntilClear(Weapon theWeapon)
	{
		while(enemies.size() > 0)
		{
			attack(theWeapon);
		}
	}
	
}
