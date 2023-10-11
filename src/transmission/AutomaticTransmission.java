package transmission;

public class AutomaticTransmission implements Transmission {
  private final int[] speedThresholds;
  private int speed;
  private int currentGear;

  public AutomaticTransmission(int[] speedThresholds) {

    // check the length of speedThresholds, should be 5
    if (speedThresholds.length != 5) {
      throw new IllegalArgumentException("Invalid number of speed thresholds");
    }
    //check value of Speed thresholds,should be greater than 0
    for (int i = 0; i < 5; i++) {
      if (speedThresholds[i] <= 0) {
        throw new IllegalArgumentException("Invalid Speed thresholds");
      }
    }
    this.speedThresholds = speedThresholds;
    this.speed = 0;
    this.currentGear = 0;
  }

  @Override
  public Transmission increaseSpeed() {
    // check whether speed

//    speed += 2;
//    if (1 <= speed && speed < speedThresholds[0]) {currentGear = 1;
//    } else if(speedThresholds[0] <= speed && speed< speedThresholds[1]){currentGear=2;
//    }else if(speedThresholds[1] <= speed && speed< speedThresholds[2]) {currentGear = 3;
//    } else if(speedThresholds[2] <= speed && speed< speedThresholds[3]){currentGear=4;
//    }else if(speedThresholds[3] <= speed && speed< speedThresholds[4]){currentGear=5;
//    }else if(speedThresholds[4] <= speed){currentGear=6;
//    }
//    return this;
    if (speed + 2 >= 0) {
      speed += 2;
    } else if (currentGear <6) {
      // If downgrade, decrease the gear and set speed to the new gear's threshold minus 2.
      currentGear++;
      speed = speedThresholds[currentGear] + 2;
    } else {
      throw new IllegalStateException("Speed cannot be increased.");
    }
    return this;
  }

  @Override
  public Transmission decreaseSpeed() {
    // check whether decreases the speed by 2 made gear downgrade
    if (speed - 2 >= 0) {
      speed -= 2;
    } else if (currentGear > 0) {
      // If downgrade, decrease the gear and set speed to the new gear's threshold minus 2.
      currentGear--;
      speed = speedThresholds[currentGear] - 2;
    } else {
      throw new IllegalStateException("Speed cannot be decreased.");
    }
    return this;
  }

  @Override
  public int getSpeed() {
    return speed;
  }

  @Override
  public int getCurrentGear() {

    return currentGear;
  }

  @Override
  public String toString() {
    return "Transmission (speed = " + speed + ", gear = " + getCurrentGear() + ")";
  }
}
