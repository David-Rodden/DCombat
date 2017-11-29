package combat.combat_instance;

import com.runemate.game.api.hybrid.entities.Npc;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class EstablishCombat extends LeafTask {
    private final Npc target;

    public EstablishCombat(final Npc target) {
        this.target = target;
    }

    @Override
    public void execute() {
        if (target != null) target.interact("Attack");
    }
}
