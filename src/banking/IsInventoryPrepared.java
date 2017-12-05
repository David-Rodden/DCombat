package banking;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsInventoryPrepared extends BranchTask {
    private final BranchTask parent;

    IsInventoryPrepared(final BranchTask parent) {
        this.parent = parent;
    }

    @Override
    public TreeTask successTask() {
        return !Bank.isOpen() ? parent : new IsBankCloseNeeded(this);
    }

    @Override
    public TreeTask failureTask() {
        return new IsBankOpen(this);
    }

    @Override
    public boolean validate() {
        return Inventory.getQuantity("Shrimp") == 15;
    }
}
