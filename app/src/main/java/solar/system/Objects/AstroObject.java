package solar.system.Objects;

class AstroObject {

    static final double G = 6.6743E-11;

    Vector position;
    Vector rotate;

    double mass;

    double radius;

    AstroObject(final Vector position, final Vector rotate, final double mass, final double radius) {
        this.position = position;
        this.rotate = rotate;
        this.mass = mass;
        this.radius = radius;
    }

    public static double getG() {
        return G;
    }

    private static double gravity(double G, double m1, double m2, double r) {
        return G * m1 * m2 / (r * r);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void push(final AstroObject rhs) {
        // F = G m1 m2 / r^2
        Vector lpos = this.getPosition();
        Vector rpos = rhs.getPosition();
        double rx = lpos.getX() - rpos.getX();
        double ry = lpos.getY() - rpos.getY();
        double lm = this.getMass();
        double rm = rhs.getMass();
        double G = AstroObject.G;
        double fx = AstroObject.gravity(G, lm, rm, rx);
        double fy = AstroObject.gravity(G, lm, rm, ry);

        this.getPosition().move(fx, fy);
        this.getRotate().move(fx, fy);
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Vector getRotate() {
        return rotate;
    }

    public void setRotate(Vector rotate) {
        this.rotate = rotate;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

}
