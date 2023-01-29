package es.dar.tr25;

public class MatchException extends Exception
{
    public MatchException()
    {
        super();
    }

    public MatchException(String message)
    {
        super(message);
    }

    public MatchException(String message, Throwable exception)
    {
        super(message,exception);
    }
}
