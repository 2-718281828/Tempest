package src.main;
import src.entity.Bullet1;
import src.entity.Rectangle;
import src.entity.Player;
import engine.*;
import entity.*;
import maths.Vector3;
import renderer.*;
import util.Console;
import java.awt.*;
import java.io.File;
import java.util.Random;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import static java.awt.Color.pink;
import static src.entity.ID.Rectangle;
import static src.entity.Player.i;
import static src.main.MainRenderer.*;
//import static sun.jvm.hotspot.runtime.BasicObjectLock.size;

public class MainLogic implements Logic {
    public EntityHandler entityHandler;
    public Camera camera;
    public static int enemyCount=0;
    String classPath=getClass().getResource("").getPath();
    //public Triangles triangles;
    Random random = new Random();
    // ten obiekt jest publiczny dla całej klasy i innych klas mających dostęp do tej klasy
    //public EntityHandler entityHandler;

    public MainLogic(Camera camera,EntityHandler entityHandler){
        this.camera = camera;
        this.entityHandler = entityHandler;

        for (int i = 0; i < entityHandler.entities.size(); i++) {
            entityHandler.entities.get(i).model.init(((MainRenderer)camera.renderer).triangles);
        }
        double N = 14;
        //boolean isClosed1=true;
        for(double i=0;i<N;i++){
            tunelwx.add(Math.cos(2*Math.PI*(i/N))/(2*Math.tan(Math.PI/(N))));
            tunelwy.add(Math.sin(2*Math.PI*(i/N))/(2*Math.tan(Math.PI/(N))));
            angle_.add(2*Math.PI*(i/N));}
        Player player = new  Player(LoadModel.loadModel(new File(classPath + "/enemy2.model"), new Color(255, 213, 0), camera.renderer, camera),new Vector3(0,0,4), entityHandler);


        entityHandler.entities.add(player);
        //czuje sie jak tau neutrino, albo benzen. benzen.
        KeyHandler keyHandler1 = new KeyHandler(player);
        camera.renderer.addKeyListener(keyHandler1);

        //triangles = new Triangles();
        player.model.init(src.main.MainRenderer.triangles);

    }
    public double t=0;
    public void update() {
        if (whichTunel == 16) {
            whichTunel = 0; //16 tuneli
        }
        t++;
        if (t % 2 == 0) {
            if (Player.keys[0]) {
                Bullet1 bullet1 = new Bullet1(LoadModel.loadModel(new File(classPath + "/square.model"), Color.red, camera.renderer, camera), new Vector3(tunelwx.get(i), tunelwy.get(i), 10), entityHandler, ((MainRenderer) camera.renderer));//model, położenie, entityHandler
                entityHandler.entities.add(bullet1);
                bullet1.model.init(((MainRenderer) camera.renderer).triangles);
            }
        }
        camera.update();
        ((MainRenderer) camera.renderer).entityHandler.logic();
        if (isNewTunel) {
            if (whichTunel == 0) {
                double N = 14;
                //boolean isClosed1=true;
                for (double i = 0; i < N; i++) {
                    if (i == 0) {
                        tunelwx.clear();
                        tunelwy.clear();
                        angle_.clear();

                    }

                    tunelwx.add(Math.cos(2 * Math.PI * (i / N)) / (2 * Math.tan(Math.PI / (N))));
                    tunelwy.add(Math.sin(2 * Math.PI * (i / N)) / (2 * Math.tan(Math.PI / (N))));
                    angle_.add(2 * Math.PI * (i / N));

                    Rectangle rectangle = (new Rectangle(LoadModel.loadModel(
                            new File(classPath + "/tunel2.model"), new Color(26, 53, 183), camera.renderer, camera),
                            new Vector3(Math.cos(2 * Math.PI * (i / N)) / (2 * Math.tan(Math.PI / (N))), Math.sin(2 * Math.PI * (i / N)) / (2 * Math.tan(Math.PI / (N))), 30), entityHandler, 2 * Math.PI * (i / N), N, (MainRenderer) camera.renderer));//model, położenie, entityHandler
                    entityHandler.entities.add(rectangle);
                    rectangle.model.init(((MainRenderer) camera.renderer).triangles);
                    //Console.log("SEX");
                    //Console.log(angle_); sam juz nie rozumiem jak to działa ale działą czyli jest git,szkoda ze jako jedyny pisze (subiektywnie) najtrudniejsza gre 2 dni przed dedlinem >_< (23:38 27.02.2024)
                }

                isClosed1 = true;
                enemyCount++;
                whichTunel++;
            }


             else if (whichTunel == 1) {
                double N = 10;
                //boolean isClosed1=true;
                for (double i = 0; i < N; i++) {
                    if (i == 0) {
                        tunelwx.clear();
                        tunelwy.clear();
                        angle_.clear();

                    }

                    tunelwx.add(-2.25+0.5*i);
                    tunelwy.add(0.0);
                    angle_.add(0.0);

                    Rectangle rectangle = (new Rectangle(LoadModel.loadModel(
                            new File(classPath + "/tunel2.model"), new Color(26, 53, 183), camera.renderer, camera),
                            new Vector3(-2.25+0.5*i, 0, 30), entityHandler, Math.PI/2, N, (MainRenderer) camera.renderer));//model, położenie, entityHandler
                    entityHandler.entities.add(rectangle);
                    rectangle.model.init(((MainRenderer) camera.renderer).triangles);
                    //Console.log("SEX");
                    //Console.log(angle_); sam juz nie rozumiem jak to działa ale działą czyli jest git,szkoda ze jako jedyny pisze (subiektywnie) najtrudniejsza gre 2 dni przed dedlinem >_< (23:38 27.02.2024)
                }

                isClosed1 = false;
                enemyCount++;
                whichTunel++;

            }
            isNewTunel=false;
        }

    }

}