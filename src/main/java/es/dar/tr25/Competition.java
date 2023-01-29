package es.dar.tr25;

public class Competition
{
    private String countryName;

    public Competition()
    {

    }

    public String getCountryName()
    {
        return countryName;
    }

    public void setCountryName(String countryName)
    {
        this.countryName = countryName;
    }

    @Override
    public String toString()
    {
        return "Competition{" +
                "countryName='" + countryName + '\'' +
                '}';
    }
}
