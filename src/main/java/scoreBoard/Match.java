package scoreBoard;

import java.time.LocalDateTime;
import java.util.Objects;

public class Match {
    private Team homeWayTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;
    private final LocalDateTime localDateTime;

    public Match(Team homeWayTeam, Team awayTeam, int awayScore,
            int homeScore, LocalDateTime localDateTime) {
        this.homeWayTeam = homeWayTeam;
        this.awayTeam = awayTeam;
        this.awayScore = awayScore;
        this.homeScore = homeScore;
        this.localDateTime = localDateTime;
    }

    public Team getHomeWayTeam() {
        return homeWayTeam;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeWayTeam(Team homeWayTeam) {
        this.homeWayTeam = homeWayTeam;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeWayTeam, awayTeam, homeScore, awayScore, localDateTime);
    }

    @Override
    public String toString() {
        return "Match{" +
                "homeWayTeam=" + homeWayTeam +
                ", awayTeam=" + awayTeam +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
