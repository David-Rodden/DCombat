package banking;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.region.Banks;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class CloseToBank extends BranchTask {
    private final BranchTask parent;

    public CloseToBank(final BranchTask parent) {
        this.parent = parent;
    }

    /**
     * If near bank and is open,
     *
     * @return {@link TreeTask}
     */
    @Override
    public TreeTask successTask() {
        return new OpenBank();
    }

    /**
     * If we cannot find bank, walk to bank area
     * If we have food, go back to parent
     *
     * @return {@link TreeTask}
     */
    @Override
    public TreeTask failureTask() {
        return parent;
    }

    @Override
    public boolean validate() {
        final GameObject nearestBank = Banks.getLoadedBankBooths().nearest();
        return !Bank.isOpen() && nearestBank != null && nearestBank.isVisible();
    }
}
