package tp3.b;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class ChaosGame {
    ArrayList<PVector> startingPoints;
    PVector currentPoint;
    void initShape(PApplet p, int verticeNum) {
        startingPoints = new ArrayList<PVector>();

        float angleIncrement = PApplet.TWO_PI / verticeNum;

        // calculate starting points based on the number of vertices
        for (int i = 0; i < verticeNum; i++) {
            float x = p.width / 2 + p.cos(i * angleIncrement) * (p.width / 2);
            float y = p.height / 2 + p.sin(i * angleIncrement) * (p.height / 2);
            startingPoints.add(new PVector(x, y));
        }

        // draw the shape
        p.beginShape();
        for (PVector p1 : startingPoints) {
            p.vertex(p1.x, p1.y);
        }
        p.endShape(PApplet.CLOSE);
    }
    void drawInitialRandomPoint(PApplet p) {
        PVector randomInitialPoint = new PVector(p.random(p.width), p.random(p.height));
        p.point(randomInitialPoint.x, randomInitialPoint.y);
        currentPoint = randomInitialPoint;
    }
    void display(PApplet p){
        for(int i = 0; i != 1000; ++i) {
            int rand = (int) p.random(startingPoints.size());
            float x = PApplet.lerp(currentPoint.x, startingPoints.get(rand).x, 0.5f);
            float y = PApplet.lerp(currentPoint.y, startingPoints.get(rand).y, 0.5f);
            p.point(x, y);
            currentPoint = new PVector(x, y);
        }
    }
}
