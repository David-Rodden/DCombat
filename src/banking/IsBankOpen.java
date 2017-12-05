package banking;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsBankOpen extends BranchTask {
    private final IsInventoryPrepared parent;

    IsBankOpen(final IsInventoryPrepared parent) {
        this.parent = parent;
    }

    @Override
    public TreeTask successTask() {
        return new WithdrawEssentials();
    }

    @Override
    public TreeTask failureTask() {
        return parent.validate() ? parent : new OpenBank();
    }

    @Override
    public boolean validate() {
        return Bank.isOpen();
    }
}
