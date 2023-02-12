package solar.system.Objects;

public class AstroObject {
	private double x;
	private double y;
	private double dx;
	private double dy;
	private double mass;
	private double radius;
	private double G;

	public AstroObject(
			final double x,
			final double y,
			final double dx,
			final double dy,
			final double mass,
			final double r,
			final double G) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.mass = mass;
		this.radius = r;
		this.G = G;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	private void pushGravity(final AstroObject other, final double k) {
		var r = distance(other);
		var f = G * mass * other.mass / (r * r);
		var theta = Math.atan2(other.y - y, other.x - x);
		var fx = f * Math.cos(theta);
		var fy = f * Math.sin(theta);
		this.dx += fx / mass * k;
		this.dy += fy / mass * k;
	}

	public void updateVelocity(final AstroObject other, final double k) {
		if (distance(other) > radius + other.radius) {
			pushGravity(other, k);
		} else {
			pushGravity(other, -k);
		}
	}

	public void updatePosition(final double k) {
		x += dx * k;
		y += dy * k;
	}

	private double distance(final AstroObject rhs) {
		return Math.sqrt(Math.pow(x - rhs.x, 2) + Math.pow(y - rhs.y, 2));
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getG() {
		return G;
	}

	public void setG(double g) {
		G = g;
	}

}
