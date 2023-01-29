package es.dar.tr25;

public class Season
{
    private String seasonName;

    public Season()
    {
    }

    public String getSeasonName()
    {
        return seasonName;
    }

    public void setSeasonName(String seasonName)
    {
        this.seasonName = seasonName;
    }

    @Override
    public String toString()
    {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                '}';
    }
}
