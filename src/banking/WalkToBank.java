package banking;

import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.web.Web;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class WalkToBank extends LeafTask {
    private final Area bankArea;

    public WalkToBank() {
        bankArea = new Area.Polygonal(new Coordinate(0, 0, 0), new Coordinate(1, 1, 0),
                new Coordinate(2, 2, 0), new Coordinate(3, 3, 0));
    }

    @Override
    public void execute() {
        final WebPath bankPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(bankArea);
        if (bankPath != null) bankPath.step();
    }
}
