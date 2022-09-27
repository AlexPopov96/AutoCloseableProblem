package Stepic.Tasks.NewRobot;

public class UpgradedRobot implements RobotConnectionManager {
    public static void main(String[] args) {
        moveRobot(new UpgradedRobot(), 2, 5);
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int x, int y) {
        try {
            robotConnectionManager.getConnection().moveRobotTo(x, y);
        } catch (Exception ex) {
            throw new RobotConnectionException(ex.getMessage());
        }
    }
    @Override
    public RobotConnection getConnection() {
        try (RobotConnection connection = new RobotConnection() {
            @Override
            public void moveRobotTo(int x, int y) {
                MovingRobot.moveRobot(new Robot(), x, y);
                System.out.printf("robot moved to: (%d; %d)\n", x, y);
            }

            @Override
            public void close() {
                System.out.println("close");
            }
        }) {
            return connection;
        } catch (RobotConnectionException exception) {
            try (RobotConnection connection = new RobotConnection() {
                @Override
                public void moveRobotTo(int x, int y) {
                    MovingRobot.moveRobot(new Robot(), x, y);
                    System.out.printf("robot moved to: (%d; %d)\n", x, y);
                }

                @Override
                public void close() {
                    System.out.println("close");
                }
            }) {
                return connection;
            } catch (RobotConnectionException exception1) {
                try (RobotConnection connection = new RobotConnection() {
                    @Override
                    public void moveRobotTo(int x, int y) {
                        MovingRobot.moveRobot(new Robot(), x, y);
                        System.out.printf("robot moved to: (%d; %d)\n", x, y);
                    }

                    @Override
                    public void close() {
                        System.out.println("close");
                    }
                }) {
                    return connection;
                } catch (RobotConnectionException exception2) {
                    throw new RobotConnectionException(exception2.getMessage());
                }
            }
        }
    }
}

interface RobotConnectionManager {
    RobotConnection getConnection();
}

interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);

    @Override
    void close();
}

class RobotConnectionException extends RuntimeException {
    public RobotConnectionException(String message) {
        super(message);
    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}