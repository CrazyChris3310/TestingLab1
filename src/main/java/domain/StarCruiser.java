package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class StarCruiser implements Killable {
    private final String name;
    private final List<Weapon> weapons = new ArrayList<>();
    private int currentWeaponId = 0;
    private int health;

    public StarCruiser(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }


    public void shoot(Killable victim) {
        if (weapons.isEmpty()) {
            return;
        }
        if (currentWeaponId >= weapons.size()) {
            currentWeaponId = 0;
        }
        Weapon weapon = weapons.get(currentWeaponId);
        try {
            weapon.shoot();
            victim.damage(weapon.getDamage());
        } catch (NoAmmoException e) {
            weapons.remove(weapon);
        }
        currentWeaponId += 1;
    }

    public boolean isDestroyed() {
        return health <= 0;
    }

    @Override
    public void damage(int damage) {
        health -= damage;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }
}
