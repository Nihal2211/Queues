//Deque.java
import java.util.*; 
import java.lang.*;    

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first; 
    private Node<Item> last;
    private Item item;
    private int N; 
    
    private class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> previous;
    }
    
    public Deque()     {
     first = null; 
     last = null;
     N= 0; 
     assert check();}    
          
   public boolean isEmpty( )                 
   {return first == null;}
  
   public int size()   
   {return N; }  
   
 public void addFirst(Item item)    {
    if (item == null) throw new NullPointerException("Can't add null value");
     Node<Item> oldfirst = first;
     first = new Node<Item>();
     first.item = item;
     
     N++;
    
           if  (N==1) {last = first; 
                        
                        }
            else {first.next= oldfirst;
                first.previous = null;
                 oldfirst.previous = first;}
            
      }  
   
   public void addLast(Item item)  { 
      if (item == null) throw new NullPointerException("Can't add null value");
       Node<Item> oldlast = last;
       last = new Node<Item>();
       last.item = item;
       last.next=null;
       if (isEmpty()) first = last;
       else          
       {oldlast.next= last;
       last.previous = oldlast;}
        N++;
   }        
   public Item removeFirst() {
       if (isEmpty()) throw new NoSuchElementException("Stack underflow");
       Item f;
         f = first.item;  
        if (first.next == null) { last = null; };// save item to return
        first = first.next;            // delete first node   
         N--;
        assert check();
        return f;  
     }               
   public Item removeLast()  {
       if (isEmpty()) throw new NoSuchElementException("Stack underflow");
       int a = 1;
       Item f;
       f = last.item;
          
       if (N!=1) {
            
           last =last.previous;
           last.next =null;  
        }
       
       else if (N == 1){
           
           first = last =null;
       }
        N--;
       return f ;
    }   
    
    private boolean check() {
        if (N == 0) {
            if (first != null) return false;
        }
        else if (N == 1) {
            if (first == null)      return false;
            if (first.next != null) return false;
        }
        else {
            if (first.next == null) return false;
        }

        int numberOfNodes = 0;
        for (Node<Item> x = first; x != null; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != N) return false;

        return true;
    }

   public Iterator<Item> iterator()  {return new ListIterator();} 
   private class ListIterator implements Iterator<Item> {
        private Node<Item> current = first;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            item = current.item;
            current = current.next; 
            return item;
        }
 
   }
   public static void main(String[] args)  {
         Deque<Integer> d = new Deque<Integer>(); 
         //System.out.println(d.size());
         d.addFirst(1);
         System.out.println(d.size());
         d.addLast(3);
         System.out.println(d.size());
         // d.addFirst(1);
          // System.out.println(d.size());
} 
       //java.lang.NullPointerException

}