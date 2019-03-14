package exception;

public class IgnoreException extends Exception {
    public IgnoreException(String ignoreString)
    {
        //print exception string
       super(ignoreString);
    }
}
