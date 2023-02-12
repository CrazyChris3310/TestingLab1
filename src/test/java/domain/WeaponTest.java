package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    @Test
    void testShoot() {
        Weapon weapon = new Weapon(10, 10);
        int initialAmmo = weapon.getAmmo();
        weapon.shoot();
        assertEquals(initialAmmo - 1, weapon.getAmmo());
    }

    @Test
    void testNoAmmo() {
        Weapon weapon = new Weapon(10, 0);
        assertThrows(NoAmmoException.class, weapon::shoot);
    }

}