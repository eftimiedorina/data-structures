package ds;

public class CircularQueue {
    private int front; // get the front item from the queue
    private int rear; //get the las item from the queue
    private int[] data;
    private int size;


    public CircularQueue(int k) {
        size = k;
        this.front = -1;
        this.rear = -1;
        data = new int[size];

    }


    public boolean enQueue(int value) {
        if (isFull()) {

            return false;
        } else {
            if (front == -1) {

                front = 0;
            }
            rear = (rear + 1) % size; // going round and round concept
            data[rear] = value;
            return true;
        }
    }


    public boolean deQueue() {
        int item;
        if (isEmpty()) {

            return false;
        } else {
            item = data[front];
            if (front == rear) {
                // only one element in queue, reset queue after removal
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;

            }
            return true;
        }
    }


    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return data[front];
        }

    }


    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            return data[rear];
        }

    }

    public boolean isEmpty() {
        if (front == -1) {
            return true;
        } else {
            return false;
        }

    }


    public boolean isFull() {
        if (front == 0 && rear == size - 1) {
            return true;
        } else if (front == rear + 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(3); // set the size to be 3
        circularQueue.enQueue(1);  // return true
        circularQueue.enQueue(2);  // return true
        circularQueue.enQueue(3);  // return true
        circularQueue.enQueue(4);  // return false, the queue is full
        circularQueue.Rear();  // return 3
        circularQueue.isFull();  // return true
        circularQueue.deQueue();  // return true
        circularQueue.enQueue(4);  // return true
        circularQueue.Rear();  // return 4
    }
}

