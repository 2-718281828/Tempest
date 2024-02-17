package main;

import maths.*;
import renderer.*;


import java.awt.*;
import java.io.File;

public class MainRenderer extends Renderer {

    public Triangles triangles;
    public Model torus;
    String classPath = getClass().getResource("").getPath(); // żebyśmy nie musieli tego pisać za każdym razem

    public MainRenderer(Vector2 dimensions, Camera camera) {
        super(dimensions, camera);
        triangles = new Triangles();
        torus = LoadModel.loadModel(new File(classPath + "/monkey.model"), Color.pink, camera.renderer, camera); // ładujemy model z pliku
        torus.init(triangles); // inicjalizujemy model (wymagane)
    }


    public void render(Graphics2D graphics) {
        triangles.render(graphics);
    }
}