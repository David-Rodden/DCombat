package combat.combat_instance;

import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class WalkToEnemySpot extends LeafTask {
    private final Area enemyArea;

    public WalkToEnemySpot() {
        this.enemyArea = new Area.Polygonal(new Coordinate(0, 0, 0), new Coordinate(1, 1, 0),
                new Coordinate(2, 2, 0), new Coordinate(3, 3, 0));
    }

    @Override
    public void execute() {
        final WebPath enemyPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(enemyArea);
        if (enemyPath != null) enemyPath.step();
    }
}
