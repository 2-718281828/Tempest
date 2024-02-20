package src.main;
import src.entity.Enemy1;
import src.entity.Enemy2;
import engine.*;
import entity.*;
import maths.Vector3;
import renderer.*;

import java.awt.*;
import java.io.File;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import static java.awt.Color.pink;
import static src.entity.ID.Enemy1;

public class MainLogic implements Logic {

    public Camera camera; // ten obiekt jest publiczny dla całej klasy i innych klas mających dostęp do tej klasy
    //public EntityHandler entityHandler;
    String classPath=getClass().getResource("").getPath();
    public MainLogic(Camera camera){
        this.camera = camera;



    }
    public void update() {
        camera.update();
      ((MainRenderer)camera.renderer).entityHandler.logic();
    }
}