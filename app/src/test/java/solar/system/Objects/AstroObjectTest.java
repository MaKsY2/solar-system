package solar.system.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AstroObjectTest {
    @Test
    public void testUpdateVelocity() {
        var mass = 10;
        var g = 10;
        AstroObject lhs = new AstroObject(0, 0, 0, 0, mass, 1, g);
        AstroObject rhs = new AstroObject(5, 0, 0, 0, mass, 1, g);
        lhs.updateVelocity(rhs, 1);
        assertEquals(lhs.getDx(), 4d);
        assertEquals(lhs.getDy(), 0d);

        lhs = new AstroObject(0, 0, 0, 0, mass, 1, 10);
        rhs = new AstroObject(0, 5, 0, 0, mass, 1, 10);
        lhs.updateVelocity(rhs, 1);
        assertEquals(Math.round(lhs.getDx()), 0d);
        assertEquals(lhs.getDy(), 4d);
    }

    @Test
    public void testUpdatePosition() {
        var mass = 10;
        var g = 10;
        AstroObject lhs = new AstroObject(0, 0, 0, 0, mass, 1, g);
        AstroObject rhs = new AstroObject(5, 0, 0, 0, mass, 1, g);

        lhs.updateVelocity(rhs, 1);

        lhs.updatePosition(1);
        assertEquals(lhs.getX(), 4d);
        assertEquals(lhs.getY(), 0d);

        lhs.updatePosition(2);
        assertEquals(lhs.getX(), 4d * 3);
        assertEquals(lhs.getY(), 0d);

        lhs = new AstroObject(0, 0, 0, 0, mass, 1, g);
        rhs = new AstroObject(0, 5, 0, 0, mass, 1, g);

        lhs.updateVelocity(rhs, 1);

        lhs.updatePosition(1);
        assertEquals(Math.round(lhs.getX()), 0d);
        assertEquals(lhs.getY(), 4d);

        lhs.updatePosition(2);
        assertEquals(Math.round(lhs.getX()), 0d);
        assertEquals(lhs.getY(), 4d * 3);

    }

    @Test
    public void getRadius() {
        var mass = 10;
        var g = 10;
        var r = 1;
        AstroObject lhs = new AstroObject(0, 0, 1, 0, mass, r, g);
        assertEquals(lhs.getRadius(), r);
    }

    @Test
    public void testTetRadius() {
        var mass = 10;
        var g = 10;
        var r = 1;
        var newr = 10;
        AstroObject lhs = new AstroObject(0, 0, 1, 0, mass, r, g);
        lhs.setRadius(newr);
        assertEquals(lhs.getRadius(), newr);
    }

    @Test
    public void testGetG() {
        var mass = 10;
        var g = 10;
        var r = 1;
        AstroObject lhs = new AstroObject(0, 0, 1, 0, mass, r, g);
        assertEquals(lhs.getG(), g);
    }

    @Test
    public void testSetG() {
        var mass = 10;
        var g = 10;
        var r = 1;
        var newg = 100;
        AstroObject lhs = new AstroObject(0, 0, 1, 0, mass, r, g);
        lhs.setG(newg);
        assertEquals(lhs.getG(), newg);
    }

}
