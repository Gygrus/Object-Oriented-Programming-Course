package agh.ics.oop;
import java.util.ArrayList;

public class OptionsParser {
    public ArrayList<MoveDirection> parse(String[] tab) {
        ArrayList<MoveDirection> output = new ArrayList<MoveDirection>();
        for (String s : tab) {
            switch (s) {
                case "f", "forward" -> output.add(MoveDirection.FORWARD);
                case "b", "backward" -> output.add(MoveDirection.BACKWARD);
                case "r", "right" -> output.add(MoveDirection.RIGHT);
                case "l", "left" -> output.add(MoveDirection.LEFT);
            }
        }
        return output;
    }
}
