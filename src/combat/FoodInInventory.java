package combat;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import combat.combat_instance.EatFood;

public class FoodInInventory extends BranchTask {
    @Override
    public TreeTask successTask() {
        return new EatFood();
    }

    @Override
    public TreeTask failureTask() {
        return new Retreat();
    }

    @Override
    public boolean validate() {
        return Inventory.contains("Shrimp");
    }
}
