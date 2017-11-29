package combat;

import com.runemate.game.api.hybrid.entities.Npc;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import combat.combat_instance.EstablishCombat;

public class AttackEnemy extends BranchTask {
    private final Npc target;
    private final BranchTask parent;

    AttackEnemy(final BranchTask parent, final Npc target) {
        this.parent = parent;
        this.target = target;
    }

    /**
     * If in combat, proceed to checking whether we need to eat
     *
     * @return {@link TreeTask}
     */
    @Override
    public TreeTask successTask() {
        return null;
    }

    /**
     * If target doesn't exist, backtrack to spotting enemy
     * If not in combat with enemy, establish a combat instance
     *
     * @return {@link TreeTask}
     */
    @Override
    public TreeTask failureTask() {
        return target == null ? parent : new EstablishCombat(target);
    }

    @Override
    public boolean validate() {
        return target != null && target.getTarget().equals(Players.getLocal());
    }
}
