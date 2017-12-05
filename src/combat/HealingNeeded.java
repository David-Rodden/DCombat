package combat;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class HealingNeeded extends BranchTask {
    @Override
    public TreeTask successTask() {
        return new FoodInInventory();
    }

    @Override
    public TreeTask failureTask() {
        return null;
    }

    @Override
    public boolean validate() {
        return false;
    }
}
