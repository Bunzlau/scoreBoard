package scoreBoard;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
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

    public Match startGame(Team homeTeam, Team awayTeam) {
        final Match match = new Match(homeTeam, awayTeam, INITIAL_STATE, INITIAL_STATE,
                LocalDateTime.now());

        matches.add(new Match(homeTeam, awayTeam, INITIAL_STATE, INITIAL_STATE,
                LocalDateTime.now()));

        return match;
    }

    public List<Match> getMatches(){
        return Collections.unmodifiableList(matches);
    }

}
