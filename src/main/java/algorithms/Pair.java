package algorithms;

public class Pair<T1,T2>
{
    private T1 s;
    private T2 t;

    Pair(T1 s, T2 t)
    {
        this.s = s;
        this.t = t;
    }

    public T1 first()
    {
        return s;
    }

    public T2 second()
    {
        return t;
    }
}