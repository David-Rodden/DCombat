package combat.combat_instance;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import javafx.animation.Animation;

public class EatFood extends LeafTask {
    /**
     * Eat food if player's health falls below 50%
     */
    @Override
    public void execute() {
        if (!Inventory.contains("Shrimp")) return;
        Inventory.getItems("Shrimp").first().interact("Eat");
        Execution.delayUntil(() -> Players.getLocal().getAnimationId() == -1);
    }
}
