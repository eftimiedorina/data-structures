package apps;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Dorina",54.32);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(12.18); // it is update the customer class
        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance()); // printing 12.18

        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(1);
        intList.add(2);
        intList.add(3);

        for(int i=0; i<intList.size(); i++){
            System.out.println(i + ": " + intList.get(i));
        }

        intList.add(1, 2);

        for(int i=0; i<intList.size(); i++){
            System.out.println(i + ": " + intList.get(i));
        }

    }
}
