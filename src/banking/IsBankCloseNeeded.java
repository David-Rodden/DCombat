package banking;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsBankCloseNeeded extends BranchTask {
    private final BranchTask parent;

    public IsBankCloseNeeded(final BranchTask parent) {
        this.parent = parent;
    }

    @Override
    public TreeTask successTask() {
        return new CloseBank();
    }

    @Override
    public TreeTask failureTask() {
        return parent;
    }

    @Override
    public boolean validate() {
        return Bank.isOpen();
    }
}
