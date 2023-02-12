package solar.system.Planet;

import javafx.scene.paint.Color;
import solar.system.Objects.AstroGraphics;
import solar.system.Objects.AstroObject;

public class Earth extends AstroGraphics {
    public Earth(
            double x,
            double y,
            double dx,
            double dy,
            double G) {
        super(new AstroObject(x, y, dx, dy, 5.972e10, 6.371, G), Color.BLUE);
    }
}
