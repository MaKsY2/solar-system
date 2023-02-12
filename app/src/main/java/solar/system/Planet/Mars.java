package solar.system.Planet;

import javafx.scene.paint.Color;
import solar.system.Objects.AstroGraphics;
import solar.system.Objects.AstroObject;

public class Mars extends AstroGraphics {
    public Mars(
            double x,
            double y,
            double dx,
            double dy,
            double G) {
        super(new AstroObject(x, y, dx, dy, 6.39e9, 3.389, G), Color.RED);
    }
}
