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
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void damage(int damage) {
        health -= damage;
    }

    public int getHealth() {
        return health;
    }
}
