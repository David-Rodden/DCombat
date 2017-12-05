import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.TreeBot;
import com.runemate.game.api.script.framework.tree.TreeTask;
import combat.EnemySpotted;
import location.InEnemyLocation;

public class DCombatHandler extends TreeBot {


    @Override
    public void onStart(final String... $) {
        // set start position player
        super.onStart($);
    }

    /**
     * Set the base coordinates to the player's start location
     * and maximum venturing distance to 15 when searching for eneSmy
     *
     * @return {@link TreeTask}
     */
    @Override
    public TreeTask createRootTask() {
        // must set with the location in which enemies are defined
        return new InEnemyLocation(null);
    }
}
