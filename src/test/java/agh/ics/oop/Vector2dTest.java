package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    public void testEquals(){
        String[] tab1 = new String[5];
        String smth = "test1";
        int num = 1;
        double d_num = 2.53;
        Vector2d vec1 = new Vector2d(5, 3);
        Vector2d vec2 = new Vector2d(7, 4);
        Vector2d vec3 = new Vector2d(5, 3);
        assertTrue(vec1.equals(vec1));
        assertTrue(vec1.equals(vec3));
        assertTrue(vec3.equals(vec1));
        assertFalse(vec1.equals(tab1));
        assertFalse(vec1.equals(smth));
        assertFalse(vec1.equals(num));
        assertFalse(vec1.equals(d_num));
    }

    @Test
    public void testToString(){
        Vector2d vec1 = new Vector2d(5, 3);
        Vector2d vec2 = new Vector2d(7, 4);
        Vector2d vec3 = new Vector2d(45, 2);
        assertEquals("(5,3)", vec1.toString());
        assertEquals("(7,4)", vec2.toString());
        assertEquals("(45,2)", vec3.toString());
    }
    @Test
    public void testPrecedes(){
        Vector2d vec1 = new Vector2d(5, 3);
        Vector2d vec2 = new Vector2d(7, 4);
        Vector2d vec3 = new Vector2d(45, 2);
        Vector2d vec4 = new Vector2d(8, 5);
        assertTrue(vec1.precedes(vec4));
        assertTrue(vec1.precedes(vec2));
        assertTrue(vec2.precedes(vec4));
        assertTrue(vec1.precedes(vec1));
        assertTrue(vec2.precedes(vec2));
        assertTrue(vec3.precedes(vec3));
        assertTrue(vec4.precedes(vec4));
        assertFalse(vec1.precedes(vec3));
        assertFalse(vec2.precedes(vec1));
        assertFalse(vec2.precedes(vec3));
        assertFalse(vec3.precedes(vec1));
        assertFalse(vec3.precedes(vec2));
        assertFalse(vec3.precedes(vec4));
        assertFalse(vec4.precedes(vec1));
        assertFalse(vec4.precedes(vec2));
        assertFalse(vec4.precedes(vec3));
    }

    @Test
    public void testFollows(){
        Vector2d vec1 = new Vector2d(5, 3);
        Vector2d vec2 = new Vector2d(7, 4);
        Vector2d vec3 = new Vector2d(45, 2);
        Vector2d vec4 = new Vector2d(8, 5);
        assertTrue(vec2.follows(vec1));
        assertTrue(vec4.follows(vec2));
        assertTrue(vec4.follows(vec1));
        assertTrue(vec1.follows(vec1));
        assertTrue(vec2.follows(vec2));
        assertTrue(vec3.follows(vec3));
        assertTrue(vec4.follows(vec4));
        assertFalse(vec1.follows(vec2));
        assertFalse(vec1.follows(vec3));
        assertFalse(vec1.follows(vec4));
        assertFalse(vec2.follows(vec3));
        assertFalse(vec2.follows(vec4));
        assertFalse(vec3.follows(vec1));
        assertFalse(vec3.follows(vec2));
        assertFalse(vec3.follows(vec4));
        assertFalse(vec4.follows(vec3));
    }

    @Test
    public void testUpperRight(){
        Vector2d vec1 = new Vector2d(5, 3);
        Vector2d vec2 = new Vector2d(7, 4);
        Vector2d vec3 = new Vector2d(45, 2);
        Vector2d vec4 = new Vector2d(8, 5);
        assertEquals(new Vector2d(5, 3), vec1.upperRight(vec1));
        assertEquals(new Vector2d(7, 4), vec1.upperRight(vec2));
        assertEquals(new Vector2d(45, 3), vec1.upperRight(vec3));
        assertEquals(new Vector2d(8, 5), vec1.upperRight(vec4));
        assertEquals(new Vector2d(7, 4), vec2.upperRight(vec1));
        assertEquals(new Vector2d(7, 4), vec2.upperRight(vec2));
        assertEquals(new Vector2d(45, 4), vec2.upperRight(vec3));
        assertEquals(new Vector2d(8, 5), vec2.upperRight(vec4));
        assertEquals(new Vector2d(45, 3), vec3.upperRight(vec1));
        assertEquals(new Vector2d(45, 4), vec3.upperRight(vec2));
        assertEquals(new Vector2d(45, 2), vec3.upperRight(vec3));
        assertEquals(new Vector2d(45, 5), vec3.upperRight(vec4));
        assertEquals(new Vector2d(8, 5), vec4.upperRight(vec1));
        assertEquals(new Vector2d(8, 5), vec4.upperRight(vec2));
        assertEquals(new Vector2d(45, 5), vec4.upperRight(vec3));
        assertEquals(new Vector2d(8, 5), vec4.upperRight(vec4));
    }

    @Test
    public void testLowerLeft(){
        Vector2d vec1 = new Vector2d(5, 3);
        Vector2d vec2 = new Vector2d(7, 4);
        Vector2d vec3 = new Vector2d(45, 2);
        Vector2d vec4 = new Vector2d(8, 5);
        assertEquals(new Vector2d(5, 3), vec1.lowerLeft(vec1));
        assertEquals(new Vector2d(5, 3), vec1.lowerLeft(vec2));
        assertEquals(new Vector2d(5, 2), vec1.lowerLeft(vec3));
        assertEquals(new Vector2d(5, 3), vec1.lowerLeft(vec4));
        assertEquals(new Vector2d(5, 3), vec2.lowerLeft(vec1));
        assertEquals(new Vector2d(7, 4), vec2.lowerLeft(vec2));
        assertEquals(new Vector2d(7, 2), vec2.lowerLeft(vec3));
        assertEquals(new Vector2d(7, 4), vec2.lowerLeft(vec4));
        assertEquals(new Vector2d(5, 2), vec3.lowerLeft(vec1));
        assertEquals(new Vector2d(7, 2), vec3.lowerLeft(vec2));
        assertEquals(new Vector2d(45, 2), vec3.lowerLeft(vec3));
        assertEquals(new Vector2d(8, 2), vec3.lowerLeft(vec4));
        assertEquals(new Vector2d(5, 3), vec4.lowerLeft(vec1));
        assertEquals(new Vector2d(7, 4), vec4.lowerLeft(vec2));
        assertEquals(new Vector2d(8, 2), vec4.lowerLeft(vec3));
        assertEquals(new Vector2d(8, 5), vec4.lowerLeft(vec4));
    }

    @Test
    public void testAdd(){
        Vector2d vec1 = new Vector2d(5, 3);
        Vector2d vec2 = new Vector2d(7, 4);
        Vector2d vec3 = new Vector2d(45, 2);
        assertEquals(new Vector2d(10, 6), vec1.add(vec1));
        assertEquals(new Vector2d(12, 7), vec1.add(vec2));
        assertEquals(new Vector2d(50, 5), vec1.add(vec3));
        assertEquals(new Vector2d(12, 7), vec2.add(vec1));
        assertEquals(new Vector2d(14, 8), vec2.add(vec2));
        assertEquals(new Vector2d(52, 6), vec2.add(vec3));
        assertEquals(new Vector2d(50, 5), vec3.add(vec1));
        assertEquals(new Vector2d(52, 6), vec3.add(vec2));
        assertEquals(new Vector2d(90, 4), vec3.add(vec3));
    }

    @Test
    public void testSubtract(){
        Vector2d vec1 = new Vector2d(5, 3);
        Vector2d vec2 = new Vector2d(7, 4);
        Vector2d vec3 = new Vector2d(45, 2);
        assertEquals(new Vector2d(0, 0), vec1.subtract(vec1));
        assertEquals(new Vector2d(-2, -1), vec1.subtract(vec2));
        assertEquals(new Vector2d(-40, 1), vec1.subtract(vec3));
        assertEquals(new Vector2d(2, 1), vec2.subtract(vec1));
        assertEquals(new Vector2d(0, 0), vec2.subtract(vec2));
        assertEquals(new Vector2d(-38, 2), vec2.subtract(vec3));
        assertEquals(new Vector2d(40, -1), vec3.subtract(vec1));
        assertEquals(new Vector2d(38, -2), vec3.subtract(vec2));
        assertEquals(new Vector2d(0, 0), vec3.subtract(vec3));
    }

    @Test
    public void testOpposite(){
        Vector2d vec1 = new Vector2d(5, 3);
        Vector2d vec2 = new Vector2d(7, 4);
        Vector2d vec3 = new Vector2d(45, 2);
        Vector2d vec4 = new Vector2d(-6, 23);
        Vector2d vec5 = new Vector2d(-4, -5);
        Vector2d vec6 = new Vector2d(27, -34);
        assertEquals(new Vector2d(-5, -3), vec1.opposite());
        assertEquals(new Vector2d(-7, -4), vec2.opposite());
        assertEquals(new Vector2d(-45, -2), vec3.opposite());
        assertEquals(new Vector2d(6, -23), vec4.opposite());
        assertEquals(new Vector2d(4, 5), vec5.opposite());
        assertEquals(new Vector2d(-27, 34), vec6.opposite());

    }
}