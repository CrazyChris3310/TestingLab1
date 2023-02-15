package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MasterTest {

    @Test
    void testAll() {
        Vhurg vhurg = new Vhurg("Steeve", 32);
        Vhurg master = new Vhurg("Misha", 28);
        vhurg.setCommander(master);
        assertEquals(master, vhurg.getCommander());

        Guvnut guvnut = new Guvnut("Joshua", 30, "green");
        Guvnut chief = new Guvnut("Zhenya", 10, "yellow");
        guvnut.setChief(chief);
        assertEquals(chief, guvnut.getChief());
        assertEquals("green", guvnut.getVapour());

        vhurg.look(guvnut);
        guvnut.offence(vhurg);

        StarCruiser cruiser = new StarCruiser("Fleet", 128);
        cruiser.shoot(guvnut);

        assertEquals(30, guvnut.getHealth());
        assertTrue(cruiser.getWeapons().isEmpty());

        Weapon starWeapon = new Weapon(12, 3);
        cruiser.addWeapon(starWeapon);
        cruiser.shoot(guvnut);

        assertFalse(cruiser.getWeapons().isEmpty());
        assertEquals(2, starWeapon.getAmmo());
        assertEquals(18, guvnut.getHealth());
        assertFalse(guvnut.isDead());

        StarCruiser enemy = new StarCruiser("Enemy", 100);
        Weapon weapon = new Weapon(23, 4);
        Weapon weapon1 = new Weapon(10, 5);
        enemy.addWeapon(weapon);
        enemy.addWeapon(weapon1);
        assertEquals(2, enemy.getWeapons().size());

        enemy.shoot(cruiser);

        assertEquals(3, weapon.getAmmo());
        assertEquals(105, cruiser.getHealth());

        enemy.shoot(vhurg);
        assertEquals(3, weapon.getAmmo());
        assertEquals(4, weapon1.getAmmo());
        assertEquals(22, vhurg.getHealth());

    }

}
