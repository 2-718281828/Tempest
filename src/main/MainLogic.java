package src.main;
import src.entity.Bullet1;
import src.entity.Flipper;
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
    public static int enemyCount = 0;
    String classPath = getClass().getResource("").getPath();
    //public Triangles triangles;
    Random random = new Random();
    // ten obiekt jest publiczny dla całej klasy i innych klas mających dostęp do tej klasy
    //public EntityHandler entityHandler;

    public MainLogic(Camera camera, EntityHandler entityHandler) {
        this.camera = camera;
        this.entityHandler = entityHandler;

        for (int i = 0; i < entityHandler.entities.size(); i++) {
            entityHandler.entities.get(i).model.init(((MainRenderer) camera.renderer).triangles);
        }
        double N = 14;
        //boolean isClosed1=true;
        for (double i = 0; i < N; i++) {
            tunelwx.add(Math.cos(2 * Math.PI * (i / N)) / (2 * Math.tan(Math.PI / (N))));
            tunelwy.add(Math.sin(2 * Math.PI * (i / N)) / (2 * Math.tan(Math.PI / (N))));
            angle_.add(2 * Math.PI * (i / N));
        }


    }

    public double t = 0;
    public int ifl = 0; //ilosc flippers
    public int it = 0;
    public int is = 0; //ilsoc spikers
    public int ifu = 0; //ilsoc fuseballs
    public int level = 0;
    public int oifl = 0;
    public int oit = 0;
    public int ois = 0;
    public int oifu = 0;
    public int M;
    public void update() {
        if (whichTunel == 16) {
            whichTunel = 0; //16 tuneli
        }
        t++;
        if (t % 2 == 0) {
            if (Player.keys[0]) {
                Bullet1 bullet1 = new Bullet1(LoadModel.loadModel(new File(classPath + "/monkey.model"), Color.red, camera.renderer, camera), new Vector3(tunelwx.get(i), tunelwy.get(i), 10), entityHandler, ((MainRenderer) camera.renderer));//model, położenie, entityHandler
                entityHandler.entities.add(bullet1);
                bullet1.model.init(((MainRenderer) camera.renderer).triangles);
            }
        }
        camera.update();
        ((MainRenderer) camera.renderer).entityHandler.logic();
        if (isNewTunel) {

            tunelwx.clear();
            tunelwy.clear();
            angle_.clear();
            level++;
            //enemyCount=1;
            enemyCount = (int) Math.round(16 * Math.exp(level / 69));
            if (whichTunel == 0) {
                double N = 14;
                M= (int) N;
                //boolean isClosed1=true;
                for (double d = 0; d < N; d++) {
                    tunelwx.add(Math.cos(2 * Math.PI * (d / N)) / (2 * Math.tan(Math.PI / (N))));
                    tunelwy.add(Math.sin(2 * Math.PI * (d / N)) / (2 * Math.tan(Math.PI / (N))));
                    angle_.add(2 * Math.PI * (d / N));

                    Rectangle rectangle = (new Rectangle(LoadModel.loadModel(
                            new File(classPath + "/tunel2.model"), new Color(26, 53, 183), camera.renderer, camera),
                            new Vector3(Math.cos(2 * Math.PI * (d / N)) / (2 * Math.tan(Math.PI / (N))), Math.sin(2 * Math.PI * (d / N)) / (2 * Math.tan(Math.PI / (N))), 30), entityHandler, 2 * Math.PI * (d / N), N, ((MainRenderer) camera.renderer)));//model, położenie, entityHandler
                    entityHandler.entities.add(rectangle);
                    rectangle.model.init(((MainRenderer) camera.renderer).triangles);
                    //Console.log("SEX");
                    //Console.log(angle_); sam juz nie rozumiem jak to działa ale działą czyli jest git,szkoda ze jako jedyny pisze (subiektywnie) najtrudniejsza gre 2 dni przed dedlinem >_< (23:38 27.02.2024)
                }


                isClosed1 = true;
                //enemyCount++;
                //whichTunel++;
            } else if (whichTunel == 1) {
                double N = 10;
                M= (int)N;
                //boolean isClosed1=true;
                for (double d = 0; d < N; d++) {
                    tunelwx.add(-5 + 1 * d);
                    tunelwy.add(-2.0);
                    angle_.add(Math.PI / 2);

                    Rectangle rectangle = (new Rectangle(LoadModel.loadModel(
                            new File(classPath + "/tunel2.model"), new Color(26, 53, 183), camera.renderer, camera),
                            new Vector3(-5 + 1 * d, -2, 30), entityHandler, Math.PI / 2, N, ((MainRenderer) camera.renderer)));//model, położenie, entityHandler
                    entityHandler.entities.add(rectangle);
                    rectangle.model.init(((MainRenderer) camera.renderer).triangles);

                }

                isClosed1 = false;


            } else if (whichTunel == 2) {
                double N = 8;
                M= (int)N;
                //boolean isClosed1=true;
                for (double d = 0; d < N; d++) {
                    tunelwx.add((-3 + d / Math.sqrt(2))/*1/Math.sin(Math.PI/4)*/);
                    tunelwy.add(-2.0 + 1 / Math.cos(Math.PI / 4));
                    angle_.add(Math.PI * Math.pow((-1), d) / 4);

                    Rectangle rectangle = (new Rectangle(LoadModel.loadModel(
                            new File(classPath + "/tunel2.model"), new Color(26, 53, 183), camera.renderer, camera),
                            new Vector3((((-3 + d / Math.sqrt(2)))), -2.0 + 1 / Math.cos(Math.PI / 4), 30), entityHandler, Math.PI * Math.pow((-1), d) / 4, N, ((MainRenderer) camera.renderer)));//model, położenie, entityHandler
                    entityHandler.entities.add(rectangle);
                    rectangle.model.init(((MainRenderer) camera.renderer).triangles);
                }
                isClosed1 = false;
            } else if (whichTunel == 3) {
                double N = 16;
                M= (int)N;
                //boolean isClosed1=true;
                for (double d = 0; d < N; d++) {

                    for (int q = 0; q < N; q++) {
                        Rectangle rectangle = (new Rectangle(LoadModel.loadModel(
                                new File(classPath + "/tunel2.model"), new Color(26, 53, 183), camera.renderer, camera),
                                new Vector3(tunelwx.get(q), tunelwy.get(q), 30), entityHandler, angle_.get(q), N, ((MainRenderer) camera.renderer)));//model, położenie, entityHandler

                        entityHandler.entities.add(rectangle);
                        rectangle.model.init(((MainRenderer) camera.renderer).triangles);
                    }
                    isClosed1 = true;
                }
            }

            //isClosed1 = false;
            //enemyCount++;
            whichTunel++;
            Player player = new Player(LoadModel.loadModel(new File(classPath + "/enemy2.model"), new Color(255, 213, 0), camera.renderer, camera), new Vector3(0, 0, 4), entityHandler, ((MainRenderer) camera.renderer));


            entityHandler.entities.add(player);

            //czuje sie jak tau neutrino, albo benzen. benzen.
            KeyHandler keyHandler1 = new KeyHandler(player);
            camera.renderer.addKeyListener(keyHandler1);

            //triangles = new Triangles();
            player.model.init(src.main.MainRenderer.triangles);
            isNewTunel = false;
            if (level < 3) {
                ifl = enemyCount;
            } else if (level < 5) {
                ifl = Math.round(4 / 5 * enemyCount);
                it = enemyCount - ifl;
            } else if (level < 7) {
                ifl = Math.round(2 / 3 * enemyCount);
                it = Math.round(1 / 4 * enemyCount);
                is = enemyCount - ifl - it;

            } else if (level < 9) {
                ifl = Math.round(1 / 2 * enemyCount);
                it = Math.round(1 / 6 * enemyCount);
                is = Math.round(1 / 6 * enemyCount);
                ifu = enemyCount - ifl - it - is;
            }
            oifl = 0;
            oit = 0;
            ois = 0;
            oifu = 0;
        }


        if (oifl < ifl && random.nextInt(120) == 99) {
            oifl++;
            int s =random.nextInt(M);
            Flipper flipper = new Flipper(LoadModel.loadModel(new File(classPath + "/enemy1.model"), Color.white, camera.renderer, camera), new Vector3(tunelwx.get(s), tunelwy.get(s), 40), entityHandler, camera, angle_.get(s),s,((MainRenderer) camera.renderer));//model, położenie, entityHandler
            entityHandler.entities.add(flipper);
            flipper.model.init(((MainRenderer) camera.renderer).triangles);
        }

    }
}