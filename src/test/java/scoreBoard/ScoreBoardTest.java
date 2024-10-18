package scoreBoard;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScoreBoardTest {

    private ScoreBoard scoreBoard;

    private Team mexico;
    private Team canada;
    private Team brazil;
    private Team spain;
    private Team germany;
    private Team france;

    @BeforeEach
    void setUp() {
        scoreBoard = new ScoreBoard();
        initializeTeams();
    }

    private void initializeTeams() {
        mexico = new Team(Country.MEXICO.getCountryName());
        canada = new Team(Country.CANADA.getCountryName());
        brazil = new Team(Country.BRAZIL.getCountryName());
        spain = new Team(Country.SPAIN.getCountryName());
        germany = new Team(Country.GERMANY.getCountryName());
        france = new Team(Country.FRANCE.getCountryName());
    }

    private void startAndSetScore(Team homeTeam, Team awayTeam, int homeScore, int awayScore) {
        scoreBoard.startGame(homeTeam, awayTeam);
        scoreBoard.updateGameScore(homeTeam, awayTeam, homeScore, awayScore);
    }

    @Test
    public void shouldStartTheGameWithInitialValue() {
        final Match match = scoreBoard.startGame(mexico, canada);
        final List<Match> matches = scoreBoard.getMatches();

        assertTrue(matches.contains(match), "The match should be added to the list of matches");
    }

    @Test
    public void shouldUpdateTheScoreDuringTheMatch() {
        startAndSetScore(mexico, canada, 3, 2);

        Match updatedMatch = scoreBoard.updateGameScore(mexico, canada, 1, 0);
        assertEquals(1, updatedMatch.getHomeTeamScore(), "Home team score should be 1");
        assertEquals(0, updatedMatch.getAwayTeamScore(), "Away team score should be 0");
    }

    @Test
    public void shouldReturnSortedSummaryForTheGames() {
        startAndSetScore(mexico, canada, 3, 2);
        startAndSetScore(brazil, spain, 2, 2);
        startAndSetScore(germany, france, 1, 1);

        List<Match> summary = scoreBoard.getSummaryOfTheGames();

        assertEquals(5, summary.get(0).getHomeTeamScore() + summary.get(0).getAwayTeamScore(), "Match with highest score should be first");
        assertEquals(mexico, summary.get(0).getHomeWayTeam());

        assertEquals(4, summary.get(1).getHomeTeamScore() + summary.get(1).getAwayTeamScore(), "Match with second highest score should be second");
        assertEquals(brazil, summary.get(1).getHomeWayTeam());

        assertEquals(2, summary.get(2).getHomeTeamScore() + summary.get(2).getAwayTeamScore(), "Match with lowest score should be last");
        assertEquals(germany, summary.get(2).getHomeWayTeam());

        assertEquals(3, summary.size(), "There should be 3 matches in total");
    }
}