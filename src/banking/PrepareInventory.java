package banking;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import combat.EnemySpotted;

public class PrepareInventory extends LeafTask {
    @Override
    public void execute() {
        final int baggedFood = Inventory.getQuantity("Shrimp");
        if (baggedFood >= 15) return;
        Bank.withdraw("Shrimp", 15 - baggedFood);
        Execution.delayUntil(() -> Inventory.getQuantity("Shrimp") == 15, EnemySpotted.LONG_SLEEP);
    }
}
