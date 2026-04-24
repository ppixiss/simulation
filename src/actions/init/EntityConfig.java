package actions.init;

public class EntityConfig {
    private final int predatorCount;
    private final int preyCount;
    private final int coralCount;
    private final int islandCount;
    private final int waveCount;

    public EntityConfig(int predatorCount, int preyCount, int coralCount, int islandCount, int waveCount) {
        this.predatorCount = predatorCount;
        this.preyCount = preyCount;
        this.coralCount = coralCount;
        this.islandCount = islandCount;
        this.waveCount = waveCount;
    }

    public int getPredatorCount() {
        return predatorCount;
    }

    public int getPreyCount() {
        return preyCount;
    }

    public int getCoralCount() {
        return coralCount;
    }

    public int getIslandCount() {
        return islandCount;
    }

    public int getWaveCount() {
        return waveCount;
    }
}
