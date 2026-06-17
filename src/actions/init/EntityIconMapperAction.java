package actions.init;

import entities.environment.Coral;
import entities.Entity;
import entities.environment.Island;
import entities.creatures.Predator;
import entities.creatures.Prey;

public class EntityIconMapperAction {
    private static final String PREDATOR = "\uD83E\uDD88 ";
    private static final String PREY = "\uD83C\uDFC4 ";
    private static final String CORAL = "\uD83E\uDEB8 ";
    private static final String ISLAND = "\uD83C\uDFDD️ ";
    private static final String WAVE = "\uD83C\uDF0A ";

    public static String assignIcon(Entity entity) {
        if (entity instanceof Predator) {
            return PREDATOR;
        } else if (entity instanceof Prey) {
            return PREY;
        } else if (entity instanceof Coral) {
            return CORAL;
        } else if (entity instanceof Island) {
            return ISLAND;
        } else {
            return WAVE;
        }
    }
}
