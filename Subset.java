//Subset.java
import java.util.*;
import java.lang.*;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class Subset { // extends Deque

public static void main(String[] args)  {
    RandomizedQueue<String> queue = new RandomizedQueue<String>();
    Subset f = new Subset();
    int arg = 0;
    arg= Integer.parseInt(args[0]);
    while(!StdIn.isEmpty() && queue.size()<=arg-1){
       String s = StdIn.readString();
        queue.enqueue(s);
    }
    while(arg >0){
        System.out.println(queue.dequeue());
        arg = arg -1;
    } 
     }

}

