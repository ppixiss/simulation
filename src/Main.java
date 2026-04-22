import world.MapConsoleRenderer;
import world.Simulation;
import world.WorldMap;

public class Main {

    public static void main(String[] args){
        WorldMap worldMap = new WorldMap();
        Simulation simulation = new Simulation();
        MapConsoleRenderer renderer = new MapConsoleRenderer();
        simulation.simulation(worldMap);
        renderer.render(worldMap);
    }
}
