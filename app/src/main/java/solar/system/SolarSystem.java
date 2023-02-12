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
import javafx.util.Duration;
import solar.system.Objects.AstroGraphics;
import solar.system.Objects.AstroObject;

class SolarSystem {
    private final Canvas canvas;
    private final GraphicsContext gc;
    private List<AstroGraphics> points;

    SolarSystem(Canvas canvas) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        var object = new AstroObject(0, 0, 100, 10, 1, 1);
        var object2 = new AstroObject(10, 100, 100, 10, 1, 1);
        this.points = new ArrayList<AstroGraphics>();
        this.points.add(new AstroGraphics(object));
        this.points.add(new AstroGraphics(object2));
    }

    public void run() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(16), event -> {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            for (AstroGraphics point : points) {
                point.draw(gc);
            }
            Function<AstroGraphics, AstroObject> func = new Function<AstroGraphics, AstroObject>() {
                public AstroObject apply(AstroGraphics value) {
                    return value.getObject();
                }
            };
            var opoints = points.stream().map(func).collect(Collectors.toList());
            for (AstroObject point : opoints) {
                for (AstroObject otherPoint : opoints) {
                    if (point != otherPoint) {
                        point.updateVelocity(otherPoint, 9.9, 1);
                    }
                }
                point.updatePosition(1);
            }
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
