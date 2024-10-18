package scoreBoard;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScoreBoard {
    final static int INITIAL_STATE = 0;
    private static final Logger logger = LoggerFactory.getLogger(ScoreBoard.class);
    private final List<Match> matches;

    public ScoreBoard() {
        matches = new ArrayList<>();
    }

}
