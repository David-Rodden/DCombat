package banking;

import com.runemate.game.api.hybrid.entities.Npc;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import combat.InCombatWithEnemy;

public class HealthAboveThreshold extends BranchTask {
    private final Npc target;

    public HealthAboveThreshold(final Npc target) {
        this.target = target;
    }

    @Override
    public TreeTask successTask() {
        return new InCombatWithEnemy(target);
    }

    @Override
    public TreeTask failureTask() {
        return new InBankLocation();
    }

    @Override
    public boolean validate() {
        return Players.getLocal().getHealthGauge().getPercent() < 50 && Inventory.contains("Shrimp");
    }
}
