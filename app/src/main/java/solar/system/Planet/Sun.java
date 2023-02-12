package solar.system.Planet;

import javafx.scene.paint.Color;
import solar.system.Objects.AstroGraphics;
import solar.system.Objects.AstroObject;

public class Sun extends AstroGraphics {
    public Sun(
            double x,
            double y,
            double dx,
            double dy,
            double G) {
        super(new AstroObject(x, y, dx, dy, 1.989e14, 69.6340, G), Color.YELLOW);
    }
}
