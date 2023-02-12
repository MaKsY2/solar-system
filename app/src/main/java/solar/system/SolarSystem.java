package solar.system;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import solar.system.Objects.AstroGraphics;
import solar.system.Objects.AstroObject;
import solar.system.Planet.Earth;
import solar.system.Planet.Mars;
import solar.system.Planet.Sun;

class SolarSystem {
    private final Canvas canvas;
    private final GraphicsContext gc;
    private List<AstroGraphics> points;
    private final double G = 6.67430e-11;

    SolarSystem(Canvas canvas) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        var xcenter = canvas.getWidth() / 2;
        var ycenter = canvas.getHeight() / 2;
        this.points = new ArrayList<>();
        this.points.add(new Sun(xcenter, ycenter, 0d, 0d, G));
        this.points.add(new Earth(xcenter + 100, ycenter, 0d, 14d, G));
        this.points.add(new Mars(xcenter + 200, ycenter, 0d, 8d, G));
    }

    public void run() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(16), event -> {
            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            for (AstroGraphics point : points) {
                point.draw(gc);
            }
            for (AstroGraphics point : points) {
                for (AstroGraphics otherPoint : points) {
                    if (point != otherPoint) {
                        point.getObject().updateVelocity(otherPoint.getObject(), 1);
                    }
                }
                point.getObject().updatePosition(1);
            }
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
