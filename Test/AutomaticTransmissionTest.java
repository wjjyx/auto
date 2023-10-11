package transmission;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class AutomaticTransmissionTest {

  private Transmission transmission;

  @Before
  public void setUp() {
    int[] SpeedThresholds = {10, 20, 30, 40, 50};
    transmission = new AutomaticTransmission(SpeedThresholds);
  }

  @Test
  public void testIncreaseSpeed() {

//    // Initially
    assertEquals(0, transmission.getSpeed());
    assertEquals(1, transmission.getCurrentGear());
    // Increase speed and check
//    transmission.increaseSpeed();
//    assertEquals(2, transmission.getSpeed());
//    assertEquals(1, transmission.getCurrentGear());
//
//
//    transmission.increaseSpeed();
//    assertEquals(4, transmission.getSpeed());
//    assertEquals(1, transmission.getCurrentGear());
//    transmission.increaseSpeed();
//    assertEquals(6, transmission.getSpeed());
//    assertEquals(1, transmission.getCurrentGear());
//    transmission.increaseSpeed();
//    assertEquals(8, transmission.getSpeed());
//    assertEquals(1, transmission.getCurrentGear());
//    transmission.increaseSpeed();
//    assertEquals(10, transmission.getSpeed());
//    assertEquals(2, transmission.getCurrentGear());
//    transmission.increaseSpeed();
//    assertEquals(12, transmission.getSpeed());
//    assertEquals(2, transmission.getCurrentGear());
//    transmission.increaseSpeed();
//    assertEquals(14, transmission.getSpeed());
//    assertEquals(2, transmission.getCurrentGear());
//    transmission.increaseSpeed();
//    assertEquals(16, transmission.getSpeed());
//    assertEquals(2, transmission.getCurrentGear());
//    transmission.increaseSpeed();
//    assertEquals(18, transmission.getSpeed());
//    assertEquals(2, transmission.getCurrentGear());
//    transmission.increaseSpeed();
//    assertEquals(20, transmission.getSpeed());
//    assertEquals(3, transmission.getCurrentGear());
//    transmission.increaseSpeed();
//    assertEquals(22, transmission.getSpeed());
//    assertEquals(3, transmission.getCurrentGear());
//    assertEquals(24, transmission.getSpeed());
//    assertEquals(3, transmission.getCurrentGear());
//    assertEquals(26, transmission.getSpeed());
//    assertEquals(3, transmission.getCurrentGear());
//    assertEquals(28, transmission.getSpeed());
//    assertEquals(3, transmission.getCurrentGear());
//    assertEquals(30, transmission.getSpeed());
//    assertEquals(4, transmission.getCurrentGear());
//    assertEquals(32, transmission.getSpeed());
//    assertEquals(4, transmission.getCurrentGear());
//    assertEquals(34, transmission.getSpeed());
//    assertEquals(4, transmission.getCurrentGear());
//    assertEquals(36, transmission.getSpeed());
//    assertEquals(4, transmission.getCurrentGear());
//    assertEquals(38, transmission.getSpeed());
//    assertEquals(4, transmission.getCurrentGear());
//    assertEquals(40, transmission.getSpeed());
//    assertEquals(5, transmission.getCurrentGear());
//    assertEquals(42, transmission.getSpeed());
//    assertEquals(5, transmission.getCurrentGear());
//    assertEquals(44, transmission.getSpeed());
//    assertEquals(5, transmission.getCurrentGear());
//    assertEquals(46, transmission.getSpeed());
//    assertEquals(5, transmission.getCurrentGear());
//    assertEquals(48, transmission.getSpeed());
//    assertEquals(5, transmission.getCurrentGear());
//    assertEquals(50, transmission.getSpeed());
//    assertEquals(6, transmission.getCurrentGear());
//    assertEquals(52, transmission.getSpeed());
//    assertEquals(6, transmission.getCurrentGear());
//
//  }

    public void testDecreaseSpeed() {

    // Initially
    assertEquals(1, transmission.getSpeed());
    assertEquals(1, transmission.getCurrentGear());

    // Decrease speed below 0, throw an exception
    try {
      transmission = transmission.decreaseSpeed();
      fail("Expected IllegalStateException, but got none.");
    } catch (IllegalStateException e) {
//      throw boolean b = true;
//      throw = b;
//    }

    // Increase speed to reach the maximum gear
    for (int i = 0; i < 6; i++) {
      transmission = transmission.increaseSpeed();
    }

    // Decrease speed
    transmission.decreaseSpeed();
    assertEquals(48, transmission.getSpeed());
    assertEquals(5, transmission.getCurrentGear());
  }

  @Test(expected = IllegalStateException.class)
  public void testDecreaseSpeedBelowZero() {
    // decrease speed below zero, should throw IllegalStateException
    for (int i = 0; i < 5; i++) {
      transmission.decreaseSpeed();
    }
  }

  @Test
  public void testDecreaseSpeedWithinGearRange() {
    // Increase speed first, then decrease within the current gear's speed threshold range
    for (int i = 0; i < 2; i++) {
      transmission.increaseSpeed();
    }
    transmission.decreaseSpeed();
    assertEquals(2, transmission.getSpeed());
    assertEquals(1, transmission.getCurrentGear());
  }

  @Test
  public void testDecreaseSpeedGearChange() {
    // Increase speed,let gear change, then decrease
    for (int i = 0; i < 6; i++) {
      transmission.increaseSpeed();
    }
    transmission.decreaseSpeed();
    assertEquals(48, transmission.getSpeed()); // Back to speed 18

  }

  @Test
  public void testToString() {


    assertEquals("Transmission (speed = 1, gear = 1)", transmission.toString());


    transmission = transmission.increaseSpeed();
    assertEquals("Transmission (speed = 3, gear = 1)", transmission.toString());

    // Increase speed to reach the maximum gear
    for (int i = 0; i < 4; i++) {
      transmission = transmission.increaseSpeed();
    }
    assertEquals("Transmission (speed = 10, gear = 6)", transmission.toString());
  }
}