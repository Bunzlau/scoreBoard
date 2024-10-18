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
}