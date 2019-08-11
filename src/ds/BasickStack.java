package ds;

public class BasickStack<X> implements Stack<X>{
    private X[] data; // for storing elements
    private int stackPointer; // size of stack

    public BasickStack() {
        data = (X[]) new Object[1000]; //initialize and cast generic type
        stackPointer = 0;

    }

    public void push(X newItem) {
        if (stackPointer == 0) {
            try {
                throw new IllegalAccessException("No more items on the stack");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        data[stackPointer++] = newItem;

    }

    public X pop() {
        return data[--stackPointer];

    }

    public boolean contains(X item) {
        boolean found = false;

        for( int i = 0; i< stackPointer; i++){
            if(data[i].equals(item)){
                found = true;
                break;
            }
        }

        return found;

    }

    public X access(X item) {
        while(stackPointer > 0){
            X tmpItem = pop();
            if(item.equals(tmpItem)){
                return tmpItem;
            }
        }

        // if we didn't find the item in the stack thow an exception
        throw new IllegalArgumentException("Colud not find item on the stack: " + item);

    }

    public int size(){
        return stackPointer;
    }


}
