package com.company;

/**
 * Created by LalinPethiyagoda on 15/10/2015.
 */
public class Display extends DisplaySuperClass {
@Override
    public void displayMe(){
        System.out.println("inside sub-class");
        super.displayMe();
    }

    public Display(){
        super();
    }
    public static void main(String[] args) {
        DisplaySuperClass m = new Display();
        m.displayMe();

        int x = 3;
        int y = 1;
        if (x = y)
            System.out.println("Not equal");
        else
            System.out.println("Equal");
    }

    }
}
