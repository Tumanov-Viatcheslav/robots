import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Robots {
    public static void main(String[] args) {
        String direcrionsStr;
        Robot[] robots = readRobots();
        boolean didAction = true;
        while (didAction) {
            didAction = false;
            direcrionsStr = "";
            for (Robot robot : robots) {
                if (robot.doAction())
                    didAction = true;
                direcrionsStr += robot.getDirection().toString() + " ";
            }
            System.out.println(direcrionsStr);
        }
    }

    private static Robot[] readRobots() {
        List<Robot> robots = new ArrayList<>();
        try(BufferedReader input = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = input.readLine()) != null) {
                String[] robotStr = line.split(";");
                robots.add(new Robot(Integer.parseInt(robotStr[0]), Integer.parseInt(robotStr[1]), Direction.valueOf(robotStr[2]), robotStr[3]));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return robots.toArray(new Robot[0]);
    }
}