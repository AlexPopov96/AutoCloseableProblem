package Stepic.Tasks.NewRobot;

public class Robot{
    private int X;
    private int Y;
    private Direction direction;

    public Robot() {
        X = randomCoords();
        Y = randomCoords();
        this.direction = randomDirection();
    }

    public Direction getDirection() {
        switch (direction) {
            case UP -> {
                System.out.println("Robot looks UP");
                return Direction.UP;
            }
            case DOWN -> {
                System.out.println("Robot looks DOWN");
                return Direction.DOWN;
            }
            case LEFT -> {
                System.out.println("Robot looks LEFT");
                return Direction.LEFT;
            }
            case RIGHT -> {
                System.out.println("Robot looks RIGHT");
                return Direction.RIGHT;
            }
            default -> {
                return null;
            }
        }
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void turnLeft() {
        switch (direction) {
            case UP -> {
                System.out.println("Now robot Looks LEFT");
                direction = Direction.LEFT;
            }
            case DOWN -> {
                System.out.println("Now robot Looks RIGHT");
                direction = Direction.RIGHT;
            }
            case LEFT -> {
                System.out.println("Now robot Looks DOWN");
                direction = Direction.DOWN;
            }
            case RIGHT -> {
                System.out.println("Now robot Looks UP");
                direction = Direction.UP;
            }
        }
    }

    public void turnRight() {
        switch (direction) {
            case UP -> {
                System.out.println("Now robot Looks RIGHT");
                direction = Direction.RIGHT;
            }
            case DOWN -> {
                System.out.println("Now robot Looks LEFT");
                direction = Direction.LEFT;
            }
            case LEFT -> {
                System.out.println("Now robot Looks UP");
                direction = Direction.UP;
            }
            case RIGHT -> {
                System.out.println("Now robot Looks DOWN");
                direction = Direction.DOWN;
            }
        }
    }

    public void stepForward() {
        switch (direction) {
            case UP -> {
                Y++;
                System.out.printf("Coords - (%d, %d)\n", X, Y);
            }
            case DOWN -> {
                Y--;
                System.out.printf("Coords - (%d, %d)\n", X, Y);
            }
            case LEFT -> {
                X--;
                System.out.printf("Coords - (%d, %d)\n", X, Y);
            }
            case RIGHT -> {
                X++;
                System.out.printf("Coords - (%d, %d)\n", X, Y);
            }
        }
    }

    public int randomCoords() {
        return  (int)(Math.random() * 20 - 10);
    }

    public Direction randomDirection() {
        switch ((int)(Math.random() * 3)) {
            case 0 -> {
                return Direction.UP;
            }
            case 1 -> {
                return Direction.RIGHT;
            }
            case 2 -> {
                return Direction.DOWN;
            }
            case 3 -> {
                return Direction.LEFT;
            }
            default -> {
                return null;
            }
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "X=" + X +
                ", Y=" + Y +
                ", direction=" + direction +
                '}';
    }
}