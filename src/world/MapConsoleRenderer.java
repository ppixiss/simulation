package world;

public class MapConsoleRenderer {

    public void render(WorldMap worldMap) {
        Position position = new Position();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 15; y++) {

                position.setX(x);
                position.setY(y);
                if (worldMap.isCellEmpty(position)) {
                    System.out.print("\uD83D\uDFE6");
                } else {
                    System.out.print("\uD83E\uDD88");
                }
            }
            System.out.println();
        }
    }
}
