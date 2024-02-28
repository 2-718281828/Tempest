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
    public static boolean isNewTunel = true;
    public static Triangles triangles;
    public Model model;


    public EntityHandler entityHandler = new EntityHandler();
    String classPath = getClass().getResource("").getPath(); // żebyśmy nie musieli tego pisać za każdym razem
    public static  ArrayList<Double> tunelwx = new ArrayList<Double>();
    public static  ArrayList<Double> tunelwy = new ArrayList<Double>();
    public static ArrayList<Double> angle_ = new ArrayList<Double>();
    public static int whichTunel=0;
    public MainRenderer(Vector2 vector2, Camera camera) {
        super(vector2, camera);
        triangles = new Triangles();


        for (int f = 0; f < entityHandler.entities.size(); f++) {
            entityHandler.entities.get(f).model.init(((src. main.MainRenderer)camera.renderer).triangles);
        }
//        enemy1.model.init(triangles);
    }

    public void render(Graphics2D graphics2D) {
        triangles.render(graphics2D);
    }}