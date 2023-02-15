package domain;

import java.util.List;

public class Alien implements Killable {
    private final String name;
    private Weapon weapon;
    private int health;

    public Alien(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void shoot(Alien alien) {
        if (weapon == null) {
            return;
        }
        weapon.shoot();
        alien.health -= weapon.getDamage();
        System.out.println(name + " shoots " + alien.getName());
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void damage(int damage) {
        health -= damage;
        System.out.println(name + "'s health is " + health);
    }

    public int getHealth() {
        return health;
    }

    public String getName() { return name; }

    public void offence(Alien alien) {
        System.out.println(name + " says something about " + alien.getName() + "'s mom...");
    }
}
