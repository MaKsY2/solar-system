package solar.system.Objects;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class AstroGraphics {
    private final AstroObject point;

    public AstroGraphics(AstroObject point) {
        this.point = point;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillOval(point.getX() - point.getRadius(), point.getY() - point.getRadius(),
                2 * point.getRadius(), 2 * point.getRadius());
    }

    public AstroObject getObject() {
        return this.point;
    }
}
