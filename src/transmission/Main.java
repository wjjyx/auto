package transmission;

public class Main {
  public static void main(String[] args) {
    try {
      // Create an AutomaticTransmission object with speed thresholds
      int[] speedThresholds = {10, 20, 30, 40, 50};
      //creating an instance of the AutomaticTransmission
      Transmission transmission = new AutomaticTransmission(speedThresholds);

      //AutomaticTransmission automaticTransmission = new AutomaticTransmission(speedThresholds);

      System.out.println("Initial: " + transmission.getSpeed());

      // calling Increase speed
      for (int i = 0; i < 6; i++) {
        Transmission increaseSpeed= transmission.increaseSpeed();
        System.out.println("Increased Speed: " + increaseSpeed);
     }

      // calling decrease speed
      for (int i = 0; i < 6; i++) {
        Transmission decreaseSpeed = transmission.decreaseSpeed();
        System.out.println("Decreased Speed: " + decreaseSpeed);
     } //catch exceptions that thrown and display an error message
    } catch (IllegalArgumentException | IllegalStateException e) {
      System.out.println("Error: " + e.getMessage());

  }
    }
  }

