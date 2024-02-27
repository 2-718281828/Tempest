package src.main;
import src.entity.Bullet1;
import src.entity.Rectangle;
import src.entity.Player;
import engine.*;
import entity.*;
import maths.Vector3;
import renderer.*;

import java.awt.*;
import java.io.File;
import java.util.Random;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import static java.awt.Color.pink;
import static src.entity.ID.Rectangle;
import static src.entity.Player.i;
import static src.main.MainRenderer.tunelwx;
import static src.main.MainRenderer.tunelwy;

public class MainLogic implements Logic {
    public EntityHandler entityHandler;
    public Camera camera;

    String classPath=getClass().getResource("").getPath();

    Random random = new Random();
    // ten obiekt jest publiczny dla całej klasy i innych klas mających dostęp do tej klasy
    //public EntityHandler entityHandler;

    public MainLogic(Camera camera,EntityHandler entityHandler){
        this.camera = camera;
        this.entityHandler = entityHandler;



    }
    public double t=0;
    public void update() {
        t++;
        if(t%2==0){
        if (Player.keys[0]){
            Bullet1 bullet1 = new Bullet1(LoadModel.loadModel(new File(classPath + "/square.model"), Color.red, camera.renderer, camera),new Vector3(tunelwx.get(i), tunelwy.get(i), 10), entityHandler, ((MainRenderer)camera.renderer));//model, położenie, entityHandler
            entityHandler.entities.add(bullet1);
            bullet1.model.init(((MainRenderer)camera.renderer).triangles);
        }}
        camera.update();
      ((MainRenderer)camera.renderer).entityHandler.logic();
    }
}