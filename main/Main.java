package main;

import engine.Engine;
import maths.*;
import renderer.*;
import util.Console;

import java.util.Locale;



public class Main {
    public static int WIDTH =1280, HEIGHT=720;
    public String TITLE = "Tempest";
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US")); // ustawiamy lokalizację na US, żeby si się floaty ładowały
        Camera camera = new Camera();
        Renderer renderer = new MainRenderer(new Vector2(WIDTH, HEIGHT), camera);
        Window window = new Window(new Vector2(WIDTH, HEIGHT), "Tempest", renderer);
        renderer.addKeyListener(camera); // poruszanie się klawiaturą
        renderer.addMouseMotionListener(camera); // obracanie się myszką
        renderer.requestFocus(); // okno jest przenoszone w systemie na pierwsze tło (ważne)
        camera.enableRotationPitch = false; // obracanie się wokół osi x (góra - dół)
        camera.enableRotationYaw = false; // obracanie się wokół osi y (prawo - lewo)
        //camera.enableMovement = false; // poruszanie się kamerą
        MainLogic mainLogic = new MainLogic(camera); // tutaj 60 razy na sekundę jest wykonywana logika
        Engine engine = new Engine(renderer, mainLogic); // tutaj jest pętla gry
        engine.start(); // uruchamiamy silnik
    }
}
