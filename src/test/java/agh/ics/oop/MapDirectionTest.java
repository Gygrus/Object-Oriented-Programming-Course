package agh.ics.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {
    MapDirection north = MapDirection.NORTH;
    MapDirection east = MapDirection.EAST;
    MapDirection south = MapDirection.SOUTH;
    MapDirection west = MapDirection.WEST;



    @Test
    public void testNext(){
        assertEquals(east, north.next());
        assertEquals(south, east.next());
        assertEquals(MapDirection.WEST, south.next());
        assertEquals(MapDirection.NORTH, west.next());
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