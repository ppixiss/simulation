package actions.init;

import entities.Coral;
import entities.Island;
import entities.Predator;
import entities.Prey;
import entities.Wave;

import java.util.ArrayList;
import java.util.List;

public class EntityCreatorAction {

    public static List<Predator> createPredators(EntityConfig entityConfig) {
        List<Predator> predators = new ArrayList<>();
        int predatorCount = entityConfig.getPredatorCount();

        for (int i = 0; i < predatorCount; i++) {
            predators.add(new Predator());
        }
        return predators;
    }

    public static List<Prey> createPrey(EntityConfig entityConfig) {
        List<Prey> preys = new ArrayList<>();
        int preyCount = entityConfig.getPreyCount();
        for (int i = 0; i < preyCount; i++) {
            preys.add(new Prey());
        }
        return preys;
    }

    public static List<Coral> createCorals(EntityConfig entityConfig) {
        List<Coral> corals = new ArrayList<>();
        int coralCount = entityConfig.getCoralCount();
        for (int i = 0; i < coralCount; i++) {
            corals.add(new Coral());
        }
        return corals;
    }

    public static List<Island> createIslands(EntityConfig entityConfig) {
        List<Island> islands = new ArrayList<>();
        int islandCount = entityConfig.getIslandCount();
        for (int i = 0; i < islandCount; i++) {
            islands.add(new Island());
        }
        return islands;
    }

    public static List<Wave> createWaves(EntityConfig entityConfig) {
        List<Wave> waves = new ArrayList<>();
        int waveCount = entityConfig.getWaveCount();
        for (int i = 0; i < waveCount; i++) {
            waves.add(new Wave());
        }
        return waves;
    }
}