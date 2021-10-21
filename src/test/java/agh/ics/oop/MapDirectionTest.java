package agh.ics.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {
    @Test
    public void testNext(){
        MapDirection a = MapDirection.NORTH;
        MapDirection b = MapDirection.EAST;
        MapDirection c = MapDirection.SOUTH;
        MapDirection d = MapDirection.WEST;
        assertEquals(MapDirection.EAST, a.next());
        assertEquals(MapDirection.SOUTH, b.next());
        assertEquals(MapDirection.WEST, c.next());
        assertEquals(MapDirection.NORTH, d.next());
    }
    @Test
    public void testPrevious(){
        MapDirection a = MapDirection.NORTH;
        MapDirection b = MapDirection.EAST;
        MapDirection c = MapDirection.SOUTH;
        MapDirection d = MapDirection.WEST;
        assertEquals(MapDirection.WEST, a.previous());
        assertEquals(MapDirection.NORTH, b.previous());
        assertEquals(MapDirection.EAST, c.previous());
        assertEquals(MapDirection.SOUTH, d.previous());
    }
    @Test
    public void testToUnitVector(){
        MapDirection a = MapDirection.NORTH;
        MapDirection b = MapDirection.EAST;
        MapDirection c = MapDirection.SOUTH;
        MapDirection d = MapDirection.WEST;
        assertEquals(new Vector2d(0, 1), a.toUnitVector());
        assertEquals(new Vector2d(1, 0), b.toUnitVector());
        assertEquals(new Vector2d(0, -1), c.toUnitVector());
        assertEquals(new Vector2d(-1, 0), d.toUnitVector());
    }
}