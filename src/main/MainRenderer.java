package src.main;

import entity.EntityHandler;
import maths.*;
import renderer.*;
import src.entity.Rectangle;
import src.entity.Player;

import java.util.*;

import java.awt.*;
import java.io.File;

public class MainRenderer extends Renderer {
    public static boolean isClosed1;
    public static boolean isNewTunel = false;
    public Triangles triangles;
    public Model model;


    public EntityHandler entityHandler = new EntityHandler();
    String classPath = getClass().getResource("").getPath(); // żebyśmy nie musieli tego pisać za każdym razem
    public static  ArrayList<Double> tunelwx = new ArrayList<Double>();
    public static  ArrayList<Double> tunelwy = new ArrayList<Double>();
    public static ArrayList<Double> angle_ = new ArrayList<Double>();
    public MainRenderer(Vector2 vector2, Camera camera) {
        super(vector2, camera);
        triangles = new Triangles();

        double N = 14;
        //boolean isClosed1=true;
        for(double i=0;i<N;i++){
            entityHandler.entities.add(new Rectangle(LoadModel.loadModel(
                new File(classPath + "/tunel2.model"), new Color(26, 53, 183), camera.renderer, camera),
                new Vector3(0,0,10), entityHandler,2*Math.PI*(i/N), N,this));//model, położenie, entityHandler
            tunelwx.add(Math.cos(2*Math.PI*(i/N))/(2*Math.tan(Math.PI/(N))));
            tunelwy.add(Math.sin(2*Math.PI*(i/N))/(2*Math.tan(Math.PI/(N))));
            angle_.add(2*Math.PI*(i/N));

        }
        isClosed1=true;
        Player player = new  Player(LoadModel.loadModel(new File(classPath + "/enemy2.model"), new Color(255, 213, 0), camera.renderer, camera),new Vector3(0,0,4), entityHandler);
        

        entityHandler.entities.add(player);

        for (int i = 0; i < entityHandler.entities.size(); i++) {
            entityHandler.entities.get(i).model.init(((src. main.MainRenderer)camera.renderer).triangles);
        }
        KeyHandler keyHandler1 = new KeyHandler(player);
        addKeyListener(keyHandler1);
        player.model.init(triangles);
//        enemy1.model.init(triangles);
    }

    public void render(Graphics2D graphics2D) {
        triangles.render(graphics2D);
    }}