package es.dar.tr25;

import java.util.Date;

/**
 * CLASE PADRE
 */
public class Match
{
    private Team homeTeam;
    private Team awayTeam;
    private Competition competition;
    private String date;
    private Date dateDate;

    private Stage stage;

    private Season season;

    public Match()
    {

    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Team getHomeTeam()
    {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam)
    {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam)
    {
        this.awayTeam = awayTeam;
    }

    public Competition getCompetition()
    {
        return competition;
    }

    public void setCompetition(Competition competition)
    {
        this.competition = competition;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public Date getDateDate()
    {
        return dateDate;
    }

    public void setDateDate(Date dateDate)
    {
        this.dateDate = dateDate;
    }

    @Override
    public String toString() {
        return "Match{" +
                "homeTeam=" + homeTeam.toString() +
                ", awayTeam=" + awayTeam +
                ", competition=" + competition +
                ", date='" + date + '\'' +
                ", dateDate=" + dateDate +
                ", stage=" + stage +
                ", season=" + season +
                '}';
    }
}



