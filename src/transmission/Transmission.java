package transmission;

public interface Transmission {
  Transmission increaseSpeed();
  Transmission decreaseSpeed();
  int getSpeed();
  int getCurrentGear();
  String toString();

}
