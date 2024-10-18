package scoreBoard;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScoreBoardTest {

    ScoreBoard scoreBoard;

    @BeforeEach
    void restartScoreBoard() {
        scoreBoard = new ScoreBoard();
    }

    @Test
    public void shouldStartTheGameWithInitialValue() {
        final Match match = scoreBoard.startGame(new Team(Country.ARGENTINA.getCountryName()),
                new Team(Country.AUSTRALIA.getCountryName()));
        final List<Match> matches = scoreBoard.getMatches();

        assertTrue(matches.contains(match));
    }

    @Test
    public void shouldUpdateTheScoreDuringTheMatch(){
        final Team argentina = new Team(Country.ARGENTINA.getCountryName());
        final Team australia = new Team(Country.AUSTRALIA.getCountryName());
        scoreBoard.startGame(argentina,
                australia);
        final Match updatedMatch = scoreBoard.updateGameScore(argentina, australia, 1, 0);

        assertEquals(updatedMatch.getAwayTeamScore(), 0);
        assertEquals(updatedMatch.getHomeTeamScore(), 1);


    }
}