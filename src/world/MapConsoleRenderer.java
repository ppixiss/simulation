package world;

import actions.init.EntityIconMapperAction;
import entities.Entity;

public class MapConsoleRenderer {

    public void render(WorldMap worldMap) {
        Position position = new Position();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 15; y++) {

                position.setX(x);
                position.setY(y);
                if (worldMap.isCellEmpty(position)) {
                    renderEmptyCell();
                } else {
                    renderEntity(position, worldMap);
                }
            }
            System.out.println();
        }
    }

    public void renderEntity(Position position, WorldMap worldMap) {
        Entity entity = worldMap.getEntityAt(position);
        String entityIcon = EntityIconMapperAction.assignIcon(entity);
        System.out.print(entityIcon);
    }

    public void renderEmptyCell() {
        System.out.print("🟦");
    }
}
