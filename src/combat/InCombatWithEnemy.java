package combat;

import com.runemate.game.api.hybrid.entities.Npc;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class InCombatWithEnemy extends BranchTask {
    private final Npc target;

    public InCombatWithEnemy(final Npc target) {
        this.target = target;
    }

    @Override
    public TreeTask successTask() {
        return new HealingNeeded();
    }

    @Override
    public TreeTask failureTask() {
        return new AttackEnemy(this, target);
    }

    @Override
    public boolean validate() {
        return false;
    }
}
