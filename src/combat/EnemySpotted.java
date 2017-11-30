package combat;

import com.runemate.game.api.hybrid.entities.Npc;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.queries.results.LocatableEntityQueryResults;
import com.runemate.game.api.hybrid.region.Npcs;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class EnemySpotted extends BranchTask {
    public static final int SHORT_SLEEP = 1000, LONG_SLEEP = 4000;
    private final Coordinate startPosition;
    private final int maxRadius;
    private Npc target;

    public EnemySpotted(final Coordinate startPosition, final int maxRadius) {
        this.startPosition = startPosition;
        this.maxRadius = maxRadius;
    }

    @Override
    public TreeTask successTask() {
        return new AttackEnemy(this, target);
    }

    @Override
    public TreeTask failureTask() {
        return null;
    }

    @Override
    public boolean validate() {
        final LocatableEntityQueryResults<Npc> targets = Npcs.newQuery().filter(npc -> npc.isVisible() && npc.getName().equals("Rat") && npc.getTarget() == null && npc.distanceTo(startPosition) <= maxRadius).results();
        return !targets.isEmpty() && (target = targets.nearest()) != null;
    }
}
