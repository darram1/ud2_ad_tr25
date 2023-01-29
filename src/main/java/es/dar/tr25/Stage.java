package es.dar.tr25;

public class Stage
{
    private String stageName;

    public Stage()
    {
    }

    public String getStageName()
    {
        return stageName;
    }

    public void setStageName(String stageName)
    {
        this.stageName = stageName;
    }

    @Override
    public String toString()
    {
        return "Stage{" +
                "name='" + stageName + '\'' +
                '}';
    }
}
