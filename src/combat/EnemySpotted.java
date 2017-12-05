package combat;

import banking.HealthAboveThreshold;
import com.runemate.game.api.hybrid.entities.Npc;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.queries.results.LocatableEntityQueryResults;
import com.runemate.game.api.hybrid.region.Npcs;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class EnemySpotted extends BranchTask {
    public static final int SHORT_SLEEP = 1000, LONG_SLEEP = 4000;
    private final Area enemyLocation;
    private Npc target;

    public EnemySpotted(final Area enemyLocation) {
        this.enemyLocation = enemyLocation;
    }

    @Override
    public TreeTask successTask() {
        return new HealthAboveThreshold(target);
    }

    @Override
    public TreeTask failureTask() {
        return null;
    }

    @Override
    public boolean validate() {
        final LocatableEntityQueryResults<Npc> targets = Npcs.newQuery().filter(npc -> npc.isVisible() && npc.getName().equals("Rat") && npc.getTarget() == null && enemyLocation.contains(npc)).results();
        return !targets.isEmpty() && (target = targets.nearest()) != null;
    }
}
