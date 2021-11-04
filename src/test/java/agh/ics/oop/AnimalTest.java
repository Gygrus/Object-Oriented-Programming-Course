//package agh.ics.oop;
//import org.junit.jupiter.api.Test;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class AnimalTest {
//    String f = "f";
//    String b = "b";
//    String l = "l";
//    String r = "r";
//    String forward = "forward";
//    String backward = "backward";
//    String left = "left";
//    String right = "right";
//    MapDirection north = MapDirection.NORTH;
//    MapDirection east = MapDirection.EAST;
//    MapDirection south = MapDirection.SOUTH;
//    MapDirection west = MapDirection.WEST;
//    MoveDirection l_parsed = MoveDirection.LEFT;
//    MoveDirection r_parsed = MoveDirection.RIGHT;
//    MoveDirection f_parsed = MoveDirection.FORWARD;
//    MoveDirection b_parsed = MoveDirection.BACKWARD;
//
//    Animal testRabbit = new Animal();
//    OptionsParser parser = new OptionsParser();
//
//    @Test
//    public void testMove () {
//        assertEquals("(2,2)-Północ", testRabbit.toString());
//        testRabbit.move(l_parsed);
//        assertEquals("(2,2)-Zachód", testRabbit.toString());
//        testRabbit.move(f_parsed);
//        testRabbit.move(f_parsed);
//        assertTrue(testRabbit.isAt(new Vector2d(0, 2)));
//        testRabbit.move(f_parsed);
//        testRabbit.move(r_parsed);
//        testRabbit.move(r_parsed);
//        assertEquals("(0,2)-Wschód", testRabbit.toString());
//        testRabbit.move(r_parsed);
//        testRabbit.move(f_parsed);
//        testRabbit.move(f_parsed);
//        testRabbit.move(f_parsed);
//        testRabbit.move(f_parsed);
//        assertEquals("(0,0)-Południe", testRabbit.toString());
//        testRabbit.move(l_parsed);
//        testRabbit.move(l_parsed);
//        testRabbit.move(f_parsed);
//        assertTrue(testRabbit.isAt(new Vector2d(0, 1)));
//        testRabbit.move(f_parsed);
//        testRabbit.move(f_parsed);
//        testRabbit.move(f_parsed);
//        testRabbit.move(r_parsed);
//        assertEquals("(0,4)-Wschód", testRabbit.toString());
//        testRabbit.move(r_parsed);
//        testRabbit.move(r_parsed);
//        testRabbit.move(b_parsed);
//        testRabbit.move(b_parsed);
//        testRabbit.move(b_parsed);
//        assertEquals("(3,4)-Zachód", testRabbit.toString());
//        testRabbit.move(b_parsed);
//        testRabbit.move(b_parsed);
//        assertEquals("(4,4)-Zachód", testRabbit.toString());
//    }
//    @Test
//    public void testMoveParsed () {
//        String[] stringTab = {"b", "f", "forward", "l", "r", "fghb", "hgf", "right", "b", "backward", "l", "b", "b", "left"};
//        ArrayList<MoveDirection> compare = new ArrayList<MoveDirection>(
//                Arrays.asList(b_parsed, f_parsed, f_parsed, l_parsed, r_parsed, r_parsed, b_parsed, b_parsed, l_parsed, b_parsed, b_parsed, l_parsed)
//                );
////        ArrayList<MoveDirection> outputTab = parser.parse(stringTab);
////        assertEquals(compare, outputTab);
////        for (MoveDirection m : outputTab) {
////            testRabbit.move(m);
////        }
//        assertEquals("(0,1)-Zachód", testRabbit.toString());
//    }
//}
