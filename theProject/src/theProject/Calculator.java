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
import java.text.DecimalFormat;
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
	
	private int totalDamage;
	private double elapsedTime;
	private Gun gun;
	private LinkedList<Enemy> enemies;
	
	DecimalFormat CALCULATED_FORMAT = new DecimalFormat("#.##");
	
	// constructors

	public Calculator()
	{
		gun = null;
		enemies = new LinkedList<Enemy>();
	}
	
	public Calculator(Gun initGun, LinkedList<Enemy> initEnemies)
	{
		gun = initGun;
		enemies = initEnemies;
	}
	
	// methods

	// getters
	
	public double getTime()
	{
		return elapsedTime;
	}

	public Gun getGun()
	{
		return gun;
	}
	
	public LinkedList<Enemy> getEnemies()
	{
		return enemies;
	}
	
	// setters
	
	public void setTime(double newTime)
	{
		elapsedTime = newTime;
	}

	public void setGun(Gun newGun)
	{
		gun = newGun;
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
		
		Hashtable<String, Gun> gunTable = new Hashtable<String, Gun>();
		
		gunTable.put("M4A1", new MagazineLoadedGun("M4A1", 25, 800, 1, 1.5, 3.0, 30, 1.0, 2.6));
		gunTable.put("Winchester 1873", new SingleLoadedGun("Winchester 1873", 25, 300, 3, 5.4, 4.4, 8, 1.0, 1, 0.425, 1.0));
		
		main.setGun(gunTable.get("M4A1"));
		
		System.out.println(main.getGun().toString());
		
		main.setTime(0);
		
		LinkedList<Enemy> enemyList = main.getEnemies();
		for(Enemy e : enemyList)
		{
			System.out.println(e.toString());
		}
		
		System.out.println("DPS: " + main.CALCULATED_FORMAT.format(main.shootTacticalUntilClear(main.getGun())));
	}
	
	public void addEnemy(Enemy enemy)
	{
		enemies.add(enemy);
	}
	
	public void shoot(Gun theGun)
	{
		double damageMulti = 1.0;
		int hits = theGun.getHitCount();
		
		for(int i = 0; i < enemies.size(); i++)
		{
			if(hits > 0)
			{
				Enemy theEnemy = enemies.get(i);
				int damage = theEnemy.takeDamage( (int) (theGun.getDamage() * damageMulti) );
				totalDamage += damage;
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
		
		elapsedTime +=  (double) (1/ (double) (theGun.getAttackRate()/60));
		
	}
	
	public double shootEmptyUntilClear(Gun theGun)
	{
		while(enemies.size() > 0)
		{
			if(theGun.getCurrentMagazine() > 0)
			{
				shoot(theGun);
				
				theGun.setCurrentMagazine(theGun.getCurrentMagazine() - 1);
				
				System.out.println("Magazine: (" + theGun.getCurrentMagazine() + '/' + theGun.getMagazineSize() + ')');
			}
			else 
			{
				double reloadingTime = theGun.getReloadTime();
				elapsedTime += reloadingTime;
				theGun.reload();
				System.out.println("Reloading!" + '\n' + "Time: " + reloadingTime + '\n');
			}
		}
		
		System.out.println("Damage dealt: " + totalDamage);
		System.out.println("Elapsed time: " + CALCULATED_FORMAT.format(elapsedTime) + 's');
		
		double DPS = totalDamage/elapsedTime;
		return DPS;
	}
	
	public double shootTacticalUntilClear(Gun theGun)
	{
		while(enemies.size() > 0)
		{
			if(theGun.getCurrentMagazine() > 1)
			{
				shoot(theGun);
				
				theGun.setCurrentMagazine(theGun.getCurrentMagazine() - 1);
				
				System.out.println("Magazine: (" + theGun.getCurrentMagazine() + '/' + theGun.getMagazineSize() + ')');
			}
			else 
			{
				double reloadingTime = theGun.getReloadTime();
				elapsedTime += reloadingTime;
				theGun.reload();
				System.out.println("Reloading!" + '\n' + "Time: " + reloadingTime + '\n');
			}
		}
		
		System.out.println("Damage dealt: " + totalDamage);
		System.out.println("Elapsed time: " + CALCULATED_FORMAT.format(elapsedTime) + 's');
		
		double DPS = totalDamage/elapsedTime;
		return DPS;
	}
	
	public double shootTacticalUntilClear(Gun theGun, int reloadAt)
	{
		while(enemies.size() > 0)
		{
			if(theGun.getCurrentMagazine() > reloadAt)
			{
				shoot(theGun);
				
				theGun.setCurrentMagazine(theGun.getCurrentMagazine() - 1);
				
				System.out.println("Magazine: (" + theGun.getCurrentMagazine() + '/' + theGun.getMagazineSize() + ')');
			}
			else 
			{
				double reloadingTime = theGun.getReloadTime();
				elapsedTime += reloadingTime;
				theGun.reload();
				System.out.println("Reloading!" + '\n' + "Time: " + reloadingTime + '\n');
			}
		}
		
		System.out.println("Damage dealt: " + totalDamage);
		System.out.println("Elapsed time: " + CALCULATED_FORMAT.format(elapsedTime) + 's');
		
		double DPS = totalDamage/elapsedTime;
		return DPS;
	}
	
}
