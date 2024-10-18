package scoreBoard;

import java.time.LocalDateTime;
import java.util.Objects;

public class Match implements Comparable<Match> {

    private final Team homeWayTeam;
    private final Team awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;
    private final LocalDateTime localDateTime;

    public Match(Team homeWayTeam, Team awayTeam, int awayTeamScore,
            int homeTeamScore) {
        this.homeWayTeam = homeWayTeam;
        this.awayTeam = awayTeam;
        this.awayTeamScore = awayTeamScore;
        this.homeTeamScore = homeTeamScore;
        this.localDateTime = LocalDateTime.now();
    }

    public Team getHomeWayTeam() {
        return homeWayTeam;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void updateScore(int homeScore, int awayScore) {
        if (homeScore < 0 || awayScore < 0) {
            throw new IllegalArgumentException("Score cannot be negative");
        }
        this.homeTeamScore = homeScore;
        this.awayTeamScore = awayScore;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeWayTeam, awayTeam, homeTeamScore, awayTeamScore, localDateTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Match match = (Match) o;
        return homeTeamScore == match.homeTeamScore && awayTeamScore == match.awayTeamScore
                && Objects.equals(
                homeWayTeam, match.homeWayTeam) && Objects.equals(awayTeam, match.awayTeam)
                && Objects.equals(localDateTime, match.localDateTime);
    }

    @Override
    public int compareTo(Match otherMatch) {
        final int matchTotalScoreThis = this.homeTeamScore + this.awayTeamScore;
        final int matchTotalScoreOther =
                otherMatch.getHomeTeamScore() + otherMatch.getAwayTeamScore();
        int matchScoreComparison = Integer.compare(matchTotalScoreOther, matchTotalScoreThis);

        if (matchScoreComparison == 0) {
            return otherMatch.getLocalDateTime().compareTo(this.getLocalDateTime());
        }
        return matchScoreComparison;
    }

    @Override
    public String toString() {
        return "Match{" +
                "homeWayTeam=" + homeWayTeam +
                ", awayTeam=" + awayTeam +
                ", homeScore=" + homeTeamScore +
                ", awayScore=" + awayTeamScore +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
