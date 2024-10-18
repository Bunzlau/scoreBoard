package scoreBoard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
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
        final Match match = new Match(homeTeam, awayTeam, INITIAL_STATE_OF_THE_GAME,
                INITIAL_STATE_OF_THE_GAME);
        matches.add(match);
        return match;
    }

    public List<Match> getMatches() {
        return Collections.unmodifiableList(matches);
    }

    public void finishTheGame(Match match){
        matches.remove(match);
    }

    public Optional<Match> updateGameScore(Team homeTeam, Team awayTeam, int homeScore,
            int awayScore) {
        if (Objects.isNull(homeTeam) || Objects.isNull(awayTeam)) {
            throw new IllegalArgumentException("Home and Away teams cannot be null");
        }

        Optional<Match> optionalMatch = findMatch(homeTeam, awayTeam);
        optionalMatch.ifPresent(match -> {
            match.updateScore(homeScore, awayScore);
            logger.info("Current match status: {} {}:{}:{}", match.getHomeWayTeam(),
                    match.getAwayTeam(), match.getHomeTeamScore(), match.getAwayTeamScore());
        });

        return optionalMatch;
    }

    public List<Match> getSummaryOfTheGames() {
        return matches.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private Optional<Match> findMatch(Team homeTeam, Team awayTeam) {
        return matches.stream()
                .filter(match -> match.getHomeWayTeam().equals(homeTeam) && match.getAwayTeam()
                        .equals(awayTeam))
                .findFirst();
    }
}
