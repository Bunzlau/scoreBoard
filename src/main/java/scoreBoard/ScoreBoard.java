package scoreBoard;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScoreBoard {
    final static int INITIAL_STATE_OF_THE_GAME = 0;
    private static final Logger logger = LoggerFactory.getLogger(ScoreBoard.class);
    private final List<Match> matches;

    public ScoreBoard() {
        matches = new ArrayList<>();
    }

    public Match startGame(Team homeTeam, Team awayTeam) {
        final Match match = new Match(homeTeam, awayTeam, INITIAL_STATE_OF_THE_GAME, INITIAL_STATE_OF_THE_GAME,
                LocalDateTime.now());

        matches.add(new Match(homeTeam, awayTeam, INITIAL_STATE_OF_THE_GAME, INITIAL_STATE_OF_THE_GAME,
                LocalDateTime.now()));

        return match;
    }

    public List<Match> getMatches() {
        return Collections.unmodifiableList(matches);
    }

    public Match updateGameScore(Team homeTeam, Team awayTeam, int homeScore, int awayScore) {
        Match updatedMatch = null;
        if (Objects.isNull(homeTeam) && Objects.isNull(awayTeam)) {
            throw new IllegalArgumentException("Home and Away teams cannot be null");
        }
        for (Match match : matches) {
            if (match.getAwayTeam().equals(awayTeam) && match.getHomeWayTeam().equals(homeTeam)) {
                match.setAwayTeamScore(awayScore);
                match.setHomeTeamScore(homeScore);

                logger.info("Current match status :{} {}:{}:{}", match.getHomeWayTeam(),
                        match.getAwayTeam(), match.getHomeTeamScore(), match.getAwayTeamScore());
                updatedMatch = match;

            }
        }
        return updatedMatch;
    }
    public List<Match> getSummaryOfTheGames(){
        List<Match> sortedMatchers = new ArrayList<>(matches);
        Collections.sort(sortedMatchers);
        return sortedMatchers;
    }

}
