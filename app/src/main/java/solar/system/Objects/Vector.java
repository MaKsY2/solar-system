package solar.system.Objects;

class Vector {
    private double x;
    private double y;

    Vector(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public void move(final double dx, final double dy) {
        x += dx;
        y += dy;
    }

    public double getX() {
        return x;
    }

    public void setX(final double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(final double y) {
        this.y = y;
    }
}
