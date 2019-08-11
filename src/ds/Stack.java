package ds;

public interface Stack<X> {
    public abstract void push(X newItem);
    public abstract X pop();
    public abstract boolean contains(X item);
    public abstract X access(X item);
    public abstract int size();
}
