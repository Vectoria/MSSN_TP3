package tp3.c;

import tp3.processing.IProcessingApp;
import tp3.processing.SubPlot;
import processing.core.PApplet;
import processing.core.PVector;

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
        // Rule[] rules = new Rule[1];
        Rule[] rules = new Rule[2];

        // rules[0] = new Rule('F', "FF+[+F-F-F]-[-F+F+F]");

        rules[0] = new Rule('F', "G[+F]-F");
        rules[1] = new Rule('G', "GG");

        // triangle de Sierpinski
        //rules[0] = new Rule('F', "F-G+F+G-F");
        //rules[1] = new Rule('G', "GG");


        // curva de Koch
        // rules[0] = new Rule('F', "F+F-F-F+F");
        // descomentar se não for para fazer a curva de koch

        ls = new LSystem("F", rules);
        turtle = new Turtle(7, PApplet.radians(22.5f));

        // descomentar se for para fazer a curva de koch
        // turtle = new Turtle(7,PApplet.radians(90f));

        // descomentar se for para fazer o triangulo de Sierpinski
        //turtle = new Turtle(7,PApplet.radians(120f));
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
        if (p.key == '+') {
            escala = escala + 0.5f;
            this.window = new double[] { -15 * escala, 15 * escala, 0, 15 * escala };
            this.plt = new SubPlot(window, viewport, p.width, p.height);
        }
    }

    @Override
    public void mouseReleased(PApplet p) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(PApplet p) {
        // TODO Auto-generated method stub

    }
}
