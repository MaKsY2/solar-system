package solar.system.Objects;

public class AstroObject {
    private double x;
    private double y;
    private double mass;
    private double radius;
    private double dx;
    private double dy;

    public AstroObject(double x, double y, double mass, double radius, double dx, double dy) {
        this.x = x;
        this.y = y;
        this.mass = mass;
        this.radius = radius;
        this.dx = dx;
        this.dy = dy;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public double distance(AstroObject other) {
        double dx = x - other.x;
        double dy = y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void updateVelocity(AstroObject other, double G, double dt) {
        double r = distance(other);
        double f = G * mass * other.mass / (r * r);
        double theta = Math.atan2(other.y - y, other.x - x);
        double fx = f * Math.cos(theta);
        double fy = f * Math.sin(theta);
        dx += fx / mass * dt;
        dy += fy / mass * dt;
    }

    public void updatePosition(double dt) {
        x += dx * dt;
        y += dy * dt;
    }
}
