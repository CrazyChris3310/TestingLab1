package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StarCruiserTest {

    @ParameterizedTest
    @MethodSource("provideCrusaderDamageData")
    void testDamageEqualToHealth(int health, int damage, boolean expected) {
        StarCruiser starCruiser = new StarCruiser("Ship", health);
        starCruiser.damage(damage);
        assertEquals(expected, starCruiser.isDestroyed());
    }

    static Stream<Arguments> provideCrusaderDamageData() {
        return Stream.of(
                Arguments.of(8, 8, true),
                Arguments.of(8, 218, true),
                Arguments.of(8, 4, false)
        );
    }

    @Test
    void testShootNoWeapons() {
        StarCruiser starCruiser = new StarCruiser("Ship", 8);
        Alien alien = new Alien("Alien", 8);
        starCruiser.shoot(alien);
        assertEquals(8, alien.getHealth());
    }

    @Test
    void testShootNoAmmo() {
        StarCruiser starCruiser = new StarCruiser("Ship", 8);
        Alien alien = new Alien("Alien", 8);
        starCruiser.addWeapon(new Weapon(10, 0));
        assertFalse(starCruiser.getWeapons().isEmpty());

        starCruiser.shoot(alien);
        assertEquals(8, alien.getHealth());
        assertTrue(starCruiser.getWeapons().isEmpty());
    }

    @Test
    void testShootOk() {
        StarCruiser starCruiser = new StarCruiser("Ship", 8);
        Alien alien = new Alien("Alien", 8);
        Weapon weapon = new Weapon(10, 1);
        starCruiser.addWeapon(weapon);
        starCruiser.shoot(alien);

        assertEquals(-2, alien.getHealth());
        assertTrue(alien.isDead());
        assertEquals(0, weapon.getAmmo());
    }

    @Test
    void testShootWith2Guns() {
        StarCruiser starCruiser = new StarCruiser("Ship", 8);
        Alien alien = new Alien("Alien", 15);
        Weapon weapon1 = new Weapon(4, 3);
        Weapon weapon2 = new Weapon(7, 2);
        starCruiser.addWeapon(weapon1);
        starCruiser.addWeapon(weapon2);

        starCruiser.shoot(alien);
        assertEquals(11, alien.getHealth());
        assertEquals(2, weapon1.getAmmo());

        starCruiser.shoot(alien);
        assertEquals(4, alien.getHealth());
        assertEquals(1, weapon2.getAmmo());

        starCruiser.shoot(alien);
        assertTrue(alien.isDead());
        assertEquals( 1, weapon1.getAmmo());
    }

}