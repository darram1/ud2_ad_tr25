package es.dar.tr25;

import java.util.ArrayList;
import java.util.List;

public class Team
{
    private int teamID;
    private String teamName;

    private List<Manager> manager;

    private Country teamCountry;

    public Team()
    {
        this.teamID = -1;
        this.teamName = "";
        this.manager = new ArrayList<Manager>();
        this.teamCountry = new Country();
    }

    public int getTeamID()
    {
        return teamID;
    }

    public void setTeamID(int teamID)
    {
        this.teamID = teamID;
    }

    public Country getTeamCountry()
    {
        return teamCountry;
    }

    public void setTeamCountry(Country teamCountry)
    {
        this.teamCountry = teamCountry;
    }

    public List<Manager> getManager() {
        return manager;
    }

    public void setManager(List<Manager> manager) {
        this.manager = manager;
    }

    public String getTeamName()
    {
        return teamName;
    }

    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamID=" + teamID +
                ", teamName='" + teamName + '\'' +
                ", manager=" + manager +
                ", teamCountry=" + teamCountry +
                '}';
    }
}
