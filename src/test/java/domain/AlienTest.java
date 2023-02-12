package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlienTest {

    @Test
    void testShootNoWeapon() {
        Alien alien = new Guvnut("Guvnut", 8, "green");
        Alien vrug = new Vhurg("Vhurg", 8);

        alien.shoot(vrug);
        assertEquals(8, vrug.getHealth());
    }

    @Test
    void testShootWithWeapon() {
        Alien alien = new Vhurg("Vhurg", 8);
        Alien guvnut = new Guvnut("Guvnut", 8, "green");
        Weapon weapon = new Weapon(10, 1);
        alien.setWeapon(weapon);
        alien.shoot(guvnut);

        assertEquals(-2, guvnut.getHealth());
        assertTrue(guvnut.isDead());
        assertEquals(0, weapon.getAmmo());
    }

    void testShootWithNoAmmo() {
        Alien alien = new Vhurg("Vhurg", 8);
        Alien guvnut = new Guvnut("Guvnut", 8, "green");
        Weapon weapon = new Weapon(10, 0);
        alien.setWeapon(weapon);

        assertThrows(NoAmmoException.class, () -> alien.shoot(guvnut));

        assertEquals(8, guvnut.getHealth());
        assertFalse(guvnut.isDead());
        assertEquals(0, weapon.getAmmo());
    }

}