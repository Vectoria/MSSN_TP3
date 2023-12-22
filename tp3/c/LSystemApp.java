package tp3.c;

import tp3.processing.IProcessingApp;
import tp3.processing.SubPlot;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.Scanner;

public class LSystemApp implements IProcessingApp {

    private LSystem ls;
    float escala = 0.5f;
    private double[] window = { -15, 15, 0, 15 };
    private float[] viewport = { 0f, 0f, 1f, 1f };
    private PVector startingPos = new PVector();
    private SubPlot plt;
    private Turtle turtle;

    @Override
    public void setup(PApplet p) {
        plt = new SubPlot(window, viewport, p.width, p.height);
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Choose a ruleset. Type 0 for the Binary Tree ruleset with an angle of 22.5, " +
                "1 for the Binary Tree ruleset with an angle of 120, \n2 for the Koch Curve ruleset, or " +
                "3 for the Sierpinski Triangle ruleset.");
        int chosenRuleset = keyboard.nextInt();
        while (chosenRuleset != 0 && chosenRuleset != 1 && chosenRuleset != 2 && chosenRuleset != 3) {
            System.out.println("Please, insert a valid ruleset (0, 1, 2, or 3):");
            chosenRuleset = keyboard.nextInt();
        }
        System.out.println("If you need to zoom in, use the '+' key, and if you need to zoom out, use the '-' " +
                "key on your keyboard.");
        Rule[] rules;
        switch (chosenRuleset){
            case 0:
                rules = new Rule[2];
                rules[0] = new Rule('F', "G[+F]-F");
                rules[1] = new Rule('G', "GG");
                ls = new LSystem("F", rules);
                turtle = new Turtle(7, PApplet.radians(22.5f));
                break;
            case 1:
                rules = new Rule[2];
                rules[0] = new Rule('F', "G[+F]-F");
                rules[1] = new Rule('G', "GG");
                ls = new LSystem("F", rules);
                turtle = new Turtle(7,PApplet.radians(120f));
                break;
            case 2:
                rules = new Rule[1];
                rules[0] = new Rule('F', "F+F-F-F+F");
                ls = new LSystem("F", rules);
                turtle = new Turtle(7,PApplet.radians(90f));
                break;
            case 3:
                rules = new Rule[2];
                rules[0] = new Rule('F', "F-G+F+G-F");
                rules[1] = new Rule('G', "GG");
                ls = new LSystem("F", rules);
                turtle = new Turtle(7,PApplet.radians(120f));
                break;
        }
    }
    @Override
    public void draw(PApplet p, float dt) {
        p.background(0);
        float[] bb = plt.getBoundingBox();
        p.rect(bb[0], bb[1], bb[2], bb[3]);
        turtle.setPose(startingPos, PApplet.radians(90), p, plt);
        turtle.render(ls, p, plt);
    }
    @Override
    public void mousePressed(PApplet p) {
        System.out.println(ls.getSequence());
        ls.nextGeneration();
        turtle.scaling(0.6f);
    }
    @Override
    public void keyPressed(PApplet p) {
        if (p.key == '-') {
            escala = escala + 0.5f;
            if (escala == 0) escala = 0.5f;
            this.window = new double[] { -15 * escala, 15 * escala, 0, 15 * escala };
            this.plt = new SubPlot(window, viewport, p.width, p.height);
        }
        if (p.key == '+') {
            escala = escala - 0.5f;
            if (escala == 0) escala = 0.5f;
            this.window = new double[] { -15 * escala, 15 * escala, 0, 15 * escala };
            this.plt = new SubPlot(window, viewport, p.width, p.height);
        }
    }
    @Override
    public void mouseReleased(PApplet p) {
    }
    @Override
    public void mouseDragged(PApplet p) {
    }
}
