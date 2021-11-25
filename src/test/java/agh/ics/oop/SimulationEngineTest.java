package agh.ics.oop;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {
    Vector2d testVec1 = new Vector2d(6, 3);
    Vector2d testVec2 = new Vector2d(1, 0);
    Vector2d testVec3 = new Vector2d(-2, 3);
    Vector2d testVec4 = new Vector2d(6, 34);

    Vector2d testVec5 = new Vector2d(1, 1);
    Vector2d testVec6 = new Vector2d(2, 1);

    String[] tab1 = {"f", "forward", "backward", "right", "f", "fdgr", "f", "l", "r", "b", "b"};
    String[] tab2 = {"b", "left", "backward", "right", "f", "f", "l", "l", "b", "f"};
    String[] tab3 = {"l", "r", "backward", "forward", "rhtf", "f", "right", "l", "f", "b", "b"};
    String[] tab4 = {"r", "l", "f", "f", "f", "f", "b", "b", "b", "b", "b"};

    IWorldMap map1 = new RectangularMap(6, 4);
    IWorldMap map2 = new RectangularMap(10, 12);
    IWorldMap map3 = new RectangularMap(8, 8);
    IWorldMap map4 = new RectangularMap(5, 1);

    Vector2d[] positions1 = { testVec1, testVec2 };
//    Vector2d[] positions2 = { testVec2, testVec4 };
    Vector2d[] positions3 = { testVec1, testVec6 };
    Vector2d[] positions4 = { testVec1, testVec2, testVec3, testVec4, testVec1, testVec3 };
    Vector2d[] positions5 = { testVec5, testVec6 };


    @Test
    public void testRun() {
        MoveDirection[] directions = new OptionsParser().parse(tab1);
        IEngine engine = new SimulationEngine(directions, map1, positions1);
        engine.run();
        SimulationEngine engine2 = (SimulationEngine) engine;
        assertEquals(new Vector2d(6, 4), engine2.getAnimals().get(0).getPosition());
        assertEquals(new Vector2d(2, 2), engine2.getAnimals().get(1).getPosition());

        directions = new OptionsParser().parse(tab4);
        engine = new SimulationEngine(directions, map4, positions5);
        engine.run();
        engine2 = (SimulationEngine) engine;
        assertEquals(new Vector2d(0, 1), engine2.getAnimals().get(0).getPosition());
        assertEquals(new Vector2d(4, 1), engine2.getAnimals().get(1).getPosition());

        directions = new OptionsParser().parse(tab2);
        engine = new SimulationEngine(directions, map2, positions4);
        engine.run();
        engine2 = (SimulationEngine) engine;
        assertEquals(new Vector2d(7, 2), engine2.getAnimals().get(0).getPosition());
        assertEquals(new Vector2d(0, 1), engine2.getAnimals().get(1).getPosition());

        directions = new OptionsParser().parse(tab3);
        engine = new SimulationEngine(directions, map3, positions3);
        engine.run();
        engine2 = (SimulationEngine) engine;
        assertEquals(new Vector2d(6, 4), engine2.getAnimals().get(0).getPosition());
        assertEquals(new Vector2d(3, 1), engine2.getAnimals().get(1).getPosition());

    }

}
