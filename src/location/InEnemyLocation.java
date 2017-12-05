package location;

import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import combat.EnemySpotted;
import combat.combat_instance.WalkToEnemySpot;

public class InEnemyLocation extends BranchTask {
    private final Area enemyLocation;

    public InEnemyLocation(final Area enemyLocation) {
        this.enemyLocation = enemyLocation;
    }

    @Override
    public TreeTask successTask() {
        return new EnemySpotted(enemyLocation);
    }

    @Override
    public TreeTask failureTask() {
        return new WalkToEnemySpot();
    }

    @Override
    public boolean validate() {
        return enemyLocation.contains(Players.getLocal());
    }
}
