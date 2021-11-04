package agh.ics.oop;
import java.util.ArrayList;
import java.util.Arrays;

public class OptionsParser {
    public MoveDirection[] parse(String[] tab) {
        String[] temp = {"f", "forward", "b", "backward", "r", "right", "l", "left"};
        int n = 0;
        for (String value : tab) {
            if (Arrays.asList(temp).contains(value)) {
                n += 1;
            }
        }
        MoveDirection[] output = new MoveDirection[n];
        int counter = 0;
        for (String s : tab) {
            switch (s) {
                case "f", "forward" -> output[counter] = MoveDirection.FORWARD;
                case "b", "backward" -> output[counter] = MoveDirection.BACKWARD;
                case "r", "right" -> output[counter] = MoveDirection.RIGHT;
                case "l", "left" -> output[counter] = MoveDirection.LEFT;
                default -> counter -= 1;
            }
            counter += 1;
        }
        return output;
    }
}
