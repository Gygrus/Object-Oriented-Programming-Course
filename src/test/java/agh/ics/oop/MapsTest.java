package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MapsTest {
    Vector2d testVec1 = new Vector2d(6, 3);
    Vector2d testVec2 = new Vector2d(1, 0);
    Vector2d testVec3 = new Vector2d(1, 0);
    Vector2d testVec4 = new Vector2d(11, 0);
    Vector2d testVec5 = new Vector2d(10, 9);
    Vector2d testVec6 = new Vector2d(6, -2);

    IWorldMap map = new RectangularMap(10, 10);

    @Test
    public void testRectangularMap() {
        //place
        assertTrue(map.place(new Animal (map, testVec1)));
        assertTrue(map.place(new Animal (map, testVec2)));
        assertFalse(map.place(new Animal (map, testVec3)));
        assertFalse(map.place(new Animal (map, testVec4)));
        //canMoveTo
        assertTrue(map.canMoveTo(testVec5));
        assertFalse(map.canMoveTo(testVec6));
        assertFalse(map.canMoveTo(testVec2));
        map.place(new Animal (map, testVec5));
        assertFalse(map.canMoveTo(testVec5));
        //isOccupied
        assertTrue(map.isOccupied(testVec3));
        assertTrue(map.isOccupied(testVec5));
        assertTrue(map.isOccupied(testVec1));
        //objectAt
        assertNull(map.objectAt(testVec4));
        assertNotNull(map.objectAt(testVec2));
        assertNotNull(map.objectAt(testVec1));
        assertNotNull(map.objectAt(testVec5));

    }

    IWorldMap map2 = new GrassField(1);

    Animal specificAnimal = new Animal(map2, new Vector2d(0, -2));

    @Test
    public void testGrassField() {
        //place
        assertTrue(map2.place(specificAnimal));
        assertTrue(map2.place(new Animal (map2, testVec1)));
        assertTrue(map2.place(new Animal (map2, testVec2)));
        assertThrows(IllegalArgumentException.class,
                ()->{
                    map2.place(new Animal (map2, testVec3));
                });
        assertTrue(map2.place(new Animal (map2, testVec4)));
        //canMoveTo
        assertTrue(map2.canMoveTo(testVec5));
        assertTrue(map2.canMoveTo(testVec6));
        assertFalse(map2.canMoveTo(testVec2));
        map2.place(new Animal (map2, testVec5));
        assertFalse(map2.canMoveTo(testVec5));
        //isOccupied
        assertTrue(map2.isOccupied(testVec3));
        assertTrue(map2.isOccupied(testVec5));
        assertTrue(map2.isOccupied(testVec1));
        //objectAt
        assertNotNull(map2.objectAt(testVec4));
        assertNotNull(map2.objectAt(testVec2));
        assertNotNull(map2.objectAt(testVec1));
        assertNotNull(map2.objectAt(testVec5));
        assertEquals(specificAnimal, map2.objectAt(new Vector2d(0, -2)));
    }
}
