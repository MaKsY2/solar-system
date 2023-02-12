package solar.system.Objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class AstroGraphics {
    private final AstroObject point;
    private final Color color;

    public AstroGraphics(AstroObject point, Color color) {
        this.point = point;
        this.color = color;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(point.getX() - point.getRadius(), point.getY() - point.getRadius(),
                2 * point.getRadius(), 2 * point.getRadius());
    }

    public AstroObject getObject() {
        return this.point;
    }
}
