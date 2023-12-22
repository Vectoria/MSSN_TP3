package tp3.b;

import processing.core.PApplet;
import processing.core.PVector;

import static jdk.nashorn.internal.objects.NativeMath.random;

public class Restriction1 extends ChaosGame{
    int previousVertex = 0;
    @Override
    void display(PApplet p) {
            int rand = getRandomVertexSquare(previousVertex, p);

            float x = PApplet.lerp(currentPoint.x, startingPoints.get(rand).x, 0.5f);
            float y = PApplet.lerp(currentPoint.y, startingPoints.get(rand).y, 0.5f);

            p.point(x, y);

            previousVertex = rand;
            currentPoint = new PVector(x, y);

    }

    int getRandomVertexSquare(int excludeVertex, PApplet p) {
        int rand = (int) p.random(3);
        if (rand >= excludeVertex) {
            rand += 2;
        } else if (rand + 2 >= excludeVertex) {
            rand += 1;
        }
        return rand % 4;
    }
}
