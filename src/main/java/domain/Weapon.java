package domain;


public class Weapon {
    private final int damage;
    private int ammo;

    public Weapon(int damage, int ammo) {
        this.damage = damage;
        this.ammo = ammo;
    }

    public int getDamage() {
        return damage;
    }

    public int getAmmo() {
        return ammo;
    }

    public void shoot() {
        if (ammo <= 0) {
            System.out.println("No ammo left");
            throw new NoAmmoException();
        }
        ammo--;
    }
}
