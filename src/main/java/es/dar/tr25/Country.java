package es.dar.tr25;

public class Country
{

    private String name;

    public Country()
    {
        this.name = "";

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }
}
