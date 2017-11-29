package combat.combat_instance;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class EatFood extends LeafTask {
    /**
     * Eat food if player's health falls below 50%
     */
    @Override
    public void execute() {
        if (Inventory.contains("Placeholder"))
            Inventory.getItems("Placeholder").first().interact("Eat");
    }
}
