package combat.combat_instance;

import com.runemate.game.api.hybrid.entities.Npc;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class CheckCombatStatus extends BranchTask {
    private final BranchTask parent;
    private final Npc target;

    public CheckCombatStatus(final BranchTask parent, final Npc target) {
        this.parent = parent;
        this.target = target;
    }

    /**
     * If everything is going well, do nothing until monster dies
     *
     * @return {@link TreeTask}
     */
    @Override
    public TreeTask successTask() {
        return !target.isValid() ? parent : null;
    }

    /**
     * If low health, eat food
     *
     * @return {@link TreeTask}
     */
    @Override
    public TreeTask failureTask() {
        return new EatFood();
    }

    /**
     * Check whether health is below 50% to engage eating process
     *
     * @return {@literal boolean}
     */
    @Override
    public boolean validate() {
        return Players.getLocal().getHealthGauge().getPercent() < 50;
    }
}
