import exception.IgnoreException;
import simulator.Command;
import simulator.Explorer;
import simulator.Mars;
import simulator.Position;

public class MarsExplorer {
    Mars mars;
    Explorer explorer;

    public MarsExplorer(Mars mars, Explorer explorer) {
        this.mars = mars;
        this.explorer = explorer;
    }

    /**
     * @param inputString
     * @return result of the command
     * @throws IgnoreException
     */
    public String getCommand(String inputString) throws IgnoreException {
        String[] args = inputString.split(" ");

        // validate command
        Command command;
        try {
            command = Command.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            throw new IgnoreException("Invalid command: invalid command");
        }
        if ((command == Command.PLACE || command == Command.MOVE) && args.length != 2) {
            throw new IgnoreException("Invalid command: wrong command parameters format");
        }

        // validate PLACE params
        String[] params;
        int x = 0;
        int y = 0;
        if (command == Command.PLACE || command == Command.MOVE) {
            params = args[1].split(",");
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);

            } catch (Exception e) {
                throw new IgnoreException("Invalid command: wrong place parameters");
            }
        }
        String output;

        switch (command) {
            case PLACE:
                output = placeExplorer(new Position(x, y));
                break;
            case MOVE:
                output = MoveExplorer(new Position(x, y));
                break;
            case REPORT:
                output = report();
                break;
            default:
                throw new IgnoreException("Invalid command");
        }
        return output;
    }

    /**
     *
     * @return return the current position of explorer
     */
    private String report() {
        if (this.explorer.getPosition() == null)
            return "The explorer has not been placed yet.";
        return "P: " + this.explorer.getPosition().toString();
    }

    /**
     *
     * @param targetPosition
     * @return the movement trace from current position to target position/the reason of not moving
     *
     */
    private String MoveExplorer(Position targetPosition) {
        //valid target position
        if (!this.mars.isValidPosition(targetPosition))
            return "Ignored: Move to invalid position.";
        if (!this.explorer.isOnMars())
            return "Ignored: Explorer is not placed yet.";

        String trace = "M: "+ explorer.getPosition().toString();
        while (explorer.getPosition().getX() != targetPosition.getX() || explorer.getPosition().getY() != targetPosition.getY()) {

            trace = trace +" "+explorer.move(targetPosition).toString();
        }
        return trace;
    }

    /**
     * placeExplorer to any position
     * @param position
     * @return the reason of false placing/nothing
     */
    private String placeExplorer(Position position) {
        //valid place position
        if (!this.mars.isValidPosition(position))
            return "Ignored: Place explorer to invalid position.";
        //place explorer on Mars
        explorer.setPosition(position);
        explorer.setOnMars(true);
        return "";
    }
}

