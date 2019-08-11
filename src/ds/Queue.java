package ds;

public interface Queue<X> {
    public abstract int size();
    public abstract void enQueue(X item);
    public abstract X deQueue();
    public abstract boolean contains(X item);
    public abstract X access(int position);
}
