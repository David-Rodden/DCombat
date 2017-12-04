package banking;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import combat.EnemySpotted;

public class CloseBank extends LeafTask {
    @Override
    public void execute() {
        Bank.close();
        Execution.delayUntil(() -> !Bank.isOpen(), EnemySpotted.LONG_SLEEP);
    }
}
