package Stepic.Tasks.NewRobot;

public class MovingRobot {
    public static void main(String[] args) {
        moveRobot(new Robot(), new Robot().randomCoords(), new Robot().randomCoords());
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        while (robot.getDirection() != Direction.UP) {
            robot.turnRight();
        }

        if (toX != robot.getX() || toY != robot.getY()) {
            if (toY >= robot.getY()) {
                while (toY != robot.getY()) {
                    robot.stepForward();
                }

                if (toX > robot.getX()) {
                    robot.turnRight();
                    while (toX != robot.getX()) {
                        robot.stepForward();
                    }
                } else if (toX < robot.getX()) {
                    robot.turnLeft();
                    while (toX != robot.getX()) {
                        robot.stepForward();
                    }
                } else {
                    System.out.printf("Robot has reached destination point (%d, %d)\n", robot.getX(), robot.getY());
                }
            } else {
                robot.turnRight();
                robot.turnRight();

                while (toY != robot.getY()) {
                    robot.stepForward();
                }

                if (toX > robot.getX()) {
                    robot.turnLeft();
                    while (toX != robot.getX()) {
                        robot.stepForward();
                    }
                } else if (toX < robot.getX()) {
                    robot.turnRight();
                    while (toX != robot.getX()) {
                        robot.stepForward();
                    }
                } else {
                    System.out.printf("Robot has reached destination point (%d, %d)\n", robot.getX(), robot.getY());
                }
            }
        } else {
            System.out.printf("Robot has reached destination point (%d, %d)\n", robot.getX(), robot.getY());
        }
    }
}