package banking;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class InBankLocation extends BranchTask {
    @Override
    public TreeTask successTask() {
        return new IsInventoryPrepared(this);
    }

    @Override
    public TreeTask failureTask() {
        return new WalkToBank();
    }

    @Override
    public boolean validate() {
        return false;
    }
}
