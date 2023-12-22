package tp3.b;

import processing.core.PApplet;
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
        cg.display(p);
    }
    @Override
    public void draw(PApplet p, float dt) {
        cg.display(p);
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
