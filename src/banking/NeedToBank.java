package banking;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class NeedToBank extends BranchTask {
    @Override
    public TreeTask successTask() {
        return null;
    }

    @Override
    public TreeTask failureTask() {
        return null;
    }

    @Override
    public boolean validate() {
        return Players.getLocal().getHealthGauge().getPercent() < 50 && Inventory.contains("");
    }
}
