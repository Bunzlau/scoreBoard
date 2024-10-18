package scoreBoard;

import java.time.LocalDateTime;
import java.util.Objects;

public class Match {
    private Team homeWayTeam;
    private Team awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;
    private final LocalDateTime localDateTime;

    public Match(Team homeWayTeam, Team awayTeam, int awayTeamScore,
            int homeTeamScore, LocalDateTime localDateTime) {
        this.homeWayTeam = homeWayTeam;
        this.awayTeam = awayTeam;
        this.awayTeamScore = awayTeamScore;
        this.homeTeamScore = homeTeamScore;
        this.localDateTime = localDateTime;
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

    public void setHomeWayTeam(Team homeWayTeam) {
        this.homeWayTeam = homeWayTeam;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
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
        return homeTeamScore == match.homeTeamScore && awayTeamScore == match.awayTeamScore && Objects.equals(
                homeWayTeam, match.homeWayTeam) && Objects.equals(awayTeam, match.awayTeam)
                && Objects.equals(localDateTime, match.localDateTime);
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
