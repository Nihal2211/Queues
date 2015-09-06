//RandomizedQueue
//if (isEmpty()) throw new NoSuchElementException("Stack underflow");
     //   return first.item;

import java.util.*;
import java.lang.*;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int N;
    private Item[] a;
     private Item item;
    
    public RandomizedQueue() {
     a = (Item[]) new Object[1];}                // construct an empty randomized queue
   
    public boolean isEmpty() {
     return N==0; }                
   
    public int size()  {
     return N;}   
    
    private void resize(int capacity) {
        assert capacity >= N;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            if (a[i]!=null){
                temp[i] = a[i];}
        }
        a = temp;
    }
    
    public void enqueue(Item item) {         // add the item
      if (item == null) throw new NullPointerException("Can't add null value");
      if (N == a.length) resize(2* a.length + 1);    
      a[N++] = item;}
    
     public Item dequeue() {
         if (isEmpty()) throw new NoSuchElementException("Can't do this");
         
         int iterate =0 ;
        iterate = StdRandom.uniform(N);
         Item f = a[iterate];
         a[iterate]=a[N-1];
         
         a[N-1] = null; 
         
         // to avoid loitering
          N=N-1;
          if (N == a.length/4) {resize(a.length/2);}
         return f;}                   // remove and return a random item
    
    public Item sample()  {                   // return (but do not remove) a random item
        if (isEmpty()) throw new NoSuchElementException("Can't do this");
        int iterate =0 ;
        iterate = StdRandom.uniform(N);
        return a[iterate];}
        
    public Iterator<Item> iterator()   { return new ReverseArrayIterator();}      // return an independent iterator over items in random order
    
     private class ReverseArrayIterator implements Iterator<Item> {
        private int i;
        

        public ReverseArrayIterator() {
            i = N-1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }
    }
     
    public static void main(String[] args)  {
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
        queue.enqueue(1);
        queue.dequeue();
        System.out.println(queue.size());
         queue.enqueue(2);
       // System.out.println(queue.size());
   
        }
    } // unit testing
