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
        int predatorCount = entityConfig.predatorCount();
        List<Predator> predators = new ArrayList<>();

        for (int i = 0; i < predatorCount; i++) {
            predators.add(new Predator());
        }
        return predators;
    }

    public static List<Prey> createPrey(EntityConfig entityConfig) {
        int preyCount = entityConfig.preyCount();
        List<Prey> preys = new ArrayList<>();

        for (int i = 0; i < preyCount; i++) {
            preys.add(new Prey());
        }
        return preys;
    }

    public static List<Coral> createCorals(EntityConfig entityConfig) {
        int coralCount = entityConfig.coralCount();
        List<Coral> corals = new ArrayList<>();

        for (int i = 0; i < coralCount; i++) {
            corals.add(new Coral());
        }
        return corals;
    }

    public static List<Island> createIslands(EntityConfig entityConfig) {
        int islandCount = entityConfig.islandCount();
        List<Island> islands = new ArrayList<>();

        for (int i = 0; i < islandCount; i++) {
            islands.add(new Island());
        }
        return islands;
    }

    public static List<Wave> createWaves(EntityConfig entityConfig) {
        int waveCount = entityConfig.waveCount();
        List<Wave> waves = new ArrayList<>();

        for (int i = 0; i < waveCount; i++) {
            waves.add(new Wave());
        }
        return waves;
    }
}