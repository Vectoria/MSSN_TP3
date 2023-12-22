package tp3.b;

import processing.core.PApplet;
import processing.core.PVector;
import tp3.processing.IProcessingApp;

public class ChaosGameApp implements IProcessingApp {
    private ChaosGame cg;
    @Override
    public void setup(PApplet p) {
        cg = new ChaosGame();
        cg.initShape(p);
        cg.drawInitialRandomPoint(p);
    }
    @Override
    public void draw(PApplet p, float dt) {
        for(int i = 0; i != 1000; ++i) {
            int r = (int) p.random(cg.initialPoints.size());
            float x = PApplet.lerp(cg.currentPoint.x, cg.initialPoints.get(r).x, 0.5f);
            float y = PApplet.lerp(cg.currentPoint.y, cg.initialPoints.get(r).y, 0.5f);
            p.point(x, y);
            cg.currentPoint = new PVector(x, y);
        }
    }
    @Override
    public void mousePressed(PApplet p) {
    }
    @Override
    public void keyPressed(PApplet p) {
    }
    @Override
    public void mouseReleased(PApplet p) {
    }
    @Override
    public void mouseDragged(PApplet p) {
    }
}
