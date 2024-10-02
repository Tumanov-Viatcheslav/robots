import java.util.LinkedList;
import java.util.Queue;

public class Robot {
    private Coordinates position;
    private Direction direction = Direction.NORTH;
    private final Queue<Action> commandsToDo = new LinkedList<>();

    public Robot() {
    }

    public Robot(int x, int y, Direction direction, String commands) {
        this.position = new Coordinates(x, y);
        this.direction = direction;
        this.inputProgram(commands);
    }

    public Direction getDirection() {
        return direction;
    }

    private void turnLeft() {
        switch (direction) {
            case NORTH:
                direction = Direction.WEST;
                return;
            case WEST:
                direction = Direction.SOUTH;
                return;
            case SOUTH:
                direction = Direction.EAST;
                return;
            case EAST:
                direction = Direction.NORTH;
        }
    }

    private void turnRight() {
        switch (direction) {
            case NORTH:
                direction = Direction.EAST;
                return;
            case EAST:
                direction = Direction.SOUTH;
                return;
            case SOUTH:
                direction = Direction.WEST;
                return;
            case WEST:
                direction = Direction.NORTH;
        }
    }

    private void stepForward() {
        switch (direction) {
            case NORTH:
                position.y++;
                return;
            case WEST:
                position.x--;
                return;
            case SOUTH:
                position.y--;
                return;
            case EAST:
                position.x++;
        }
    }

    private void executeAction(Action action) {
        switch (action) {
            case FORWARD:
                stepForward();
                break;
            case LEFT:
                turnLeft();
                break;
            case RIGHT:
                turnRight();
                break;
        }
    }

    public boolean doAction() {
        if (!commandsToDo.isEmpty()) {
            executeAction(commandsToDo.poll());
            return true;
        }
        return false;
    }

    public void inputProgram(String commands) {
        for (char c : commands.toCharArray()) {
            switch (c) {
                case 'S':
                    commandsToDo.add(Action.FORWARD);
                    break;
                case 'L':
                    commandsToDo.add(Action.LEFT);
                    break;
                case 'R':
                    commandsToDo.add(Action.RIGHT);
                    break;
            }
        }
    }
}
