package es.dar.tr25;

public class Manager
{

    private int id;
    private String name;
    private Country nameCountry;

    public Manager()
    {
        this.id = -1;
        this.name = "";
        this.nameCountry = new Country();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Country getNameCountry()
    {
        return nameCountry;
    }

    public void setNameCountry(Country nameCountry)
    {
        this.nameCountry = nameCountry;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameCountry=" + nameCountry +
                '}';
    }
}
