package banking;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import combat.EnemySpotted;

public class OpenBank extends LeafTask {
    @Override
    public void execute() {
        Bank.open();
        Execution.delayUntil(Bank::isOpen, EnemySpotted.SHORT_SLEEP);
    }
}
