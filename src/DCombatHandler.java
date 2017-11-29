import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.TreeBot;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class DCombatHandler extends TreeBot {

    /**
     * Set the base coordinates to the player's start location
     * and maximum venturing distance to 15 when searching for enemy
     *
     * @return {@link TreeTask}
     */
    @Override
    public TreeTask createRootTask() {
        return new EnemySpotted(Players.getLocal().getPosition(), 15);
    }
}
