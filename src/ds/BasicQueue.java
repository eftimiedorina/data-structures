package ds;

public class BasicQueue<X> implements Queue<X>{
    private X[] data;

    // beginning and the end of the queue
    private int front;
    private int end;

    public BasicQueue() {
        this(1000);
    }

    public BasicQueue(int size) {
        this.front = -1;
        this.end = -1;
        data = (X[]) new Object[size];
    }

    public int size() {
        // if the queue is empty return 0
        if (front == -1 && end == -1) {
            return 0;
        }

        // otherwise we add one to get the inclusive subtraction value
        else {
            return end - front + 1;
        }
    }

    public void enQueue(X item) {
        // first see if the queue is full
        if ((end + 1) % data.length == front) {
            throw new IllegalStateException("The Queue is full!");
        }
        // otherwise check to see if any items have been added to the queue yet
        else if (size() == 0) {
            front++;
            end++;
            data[end] = item;
        }
        // otherwise add the item to the end of the queue
        else {
            end++;
            data[end] = item;
        }

    }

    public X deQueue() {
        X item = null;
        if (size() == -1) {
            throw new IllegalStateException("The Queue is empty!");
        }
        // otherwise if this is the last item on the queue,
        // the queue needs to get reset to empty
        else if (front == end) {
            item = data[front];
            data[front] = null;
            front = -1;
            end = -1;
        }
        // otherwisw grab the front of the queue, return it and adjust the front pointer
        else {
            item = data[front];
            data[front] = null;
            front++;
        }

        return item;
    }

    public boolean contains(X item){
        boolean found = false;

        if(size() == 0){
            return found;
        }

        for(int i = front; i<end; i++){
            if(data[i].equals(item)){
                found = true;
                break;
            }
        }
        return found;

    }

    public X access(int position){
        if(size() == 0 || position > size()){
            throw new IllegalArgumentException("No items in the queue or the position is grater than size");
        }

        int trueIndex = 0;
        for(int i = front; i < end; i++){
            if(trueIndex == position){
                return data[i];
            }
            trueIndex++;
        }

        // if we didn't find the item throw an exception
        throw new IllegalArgumentException("Could not get queue item at position " + position);

    }
}