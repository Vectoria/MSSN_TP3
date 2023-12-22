package tp3.b;

import processing.core.PApplet;
import processing.core.PVector;
import tp3.processing.IProcessingApp;

import java.util.Scanner;

public class ChaosGameApp implements IProcessingApp {
    private ChaosGame cg;
    @Override
    public void setup(PApplet p) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please, insert the number of vertices you want you shape to have.");
        int chosenVerticeNum = keyboard.nextInt();
        while (chosenVerticeNum < 3) {
            System.out.println("You can't have a shape with less than 3 vertices, re-insert your value");
            chosenVerticeNum = keyboard.nextInt();
        }
        cg = new ChaosGame();
        cg.drawInitialRandomPoint(p);
        cg.initShape(p, chosenVerticeNum);
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
