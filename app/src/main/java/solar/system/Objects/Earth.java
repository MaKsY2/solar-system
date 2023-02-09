package solar.system.Objects;

class Earth extends AstroObject {
    final static double mass = 5972;
    final static double radius = 6371;

    Earth(Vector position, Vector rotate) {
        super(position, rotate, mass, radius);
    }

    Earth(final Vector position, final Vector rotate, final double mass, final double radius) {
        super(position, rotate, mass, radius);
    }
}
