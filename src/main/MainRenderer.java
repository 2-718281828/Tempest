package src.main;

import entity.EntityHandler;
import maths.*;
import renderer.*;
import src.entity.Enemy1;
import src.entity.Enemy2;


import java.awt.*;
import java.io.File;



public class MainRenderer extends Renderer {

    public Triangles triangles;
    public Model model;
    public EntityHandler entityHandler = new EntityHandler();
    String classPath = getClass().getResource("").getPath(); // żebyśmy nie musieli tego pisać za każdym razem

    public MainRenderer(Vector2 vector2, Camera camera) {
        super(vector2, camera);
        triangles = new Triangles();

        Enemy2 enemy2 = new  Enemy2(LoadModel.loadModel(new File(classPath + "/monkey.model"), new Color(0, 0, 0), camera.renderer, camera),new Vector3(0,0,4), entityHandler);
        double N = 14;
        for(double i=0;i<N;i++){
            entityHandler.entities.add(new Enemy1(LoadModel.loadModel(
                new File(classPath + "/tunel2.model"), new Color(26, 53, 183), camera.renderer, camera),
                new Vector3(0,0,10), entityHandler,2*Math.PI*(i/N), N));//model, położenie, entityHandler
        }
        //entityHandler.entities.add(enemy2);

        for (int i = 0; i < entityHandler.entities.size(); i++) {
            entityHandler.entities.get(i).model.init(((src.main.MainRenderer)camera.renderer).triangles);
        }
        KeyHandler keyHandler1 = new KeyHandler(enemy2);
        addKeyListener(keyHandler1);
        enemy2.model.init(triangles);
//        enemy1.model.init(triangles);
    }

    public void render(Graphics2D graphics2D) {
        triangles.render(graphics2D);
    }}