package com.sree.myappfeb.designPatterns.MVC;


import java.util.*;

public class ModelMvc extends Observable {

    // declaring a list of integer
    private List<Integer> List;

    // constructor to initialize the list
    public ModelMvc(){
        // reserving the space for list elements
        List = new ArrayList<Integer>(3);

        // adding elements into the list
        List.add(0);
        List.add(0);
        List.add(0);
    }

    // defining getter and setter functions

    // function to return appropriate count
    // value at correct index
    public int getValueAtIndex(final int the_index) throws IndexOutOfBoundsException{
        return List.get(the_index);
    }

    // function to make changes in the activity button's
    // count value when user touch it
    public void setValueAtIndex(final int the_index) throws IndexOutOfBoundsException{
        List.set(the_index,List.get(the_index) + 1);
        setChanged();
        notifyObservers();
    }

}

