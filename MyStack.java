package src; 

import java.util.Iterator;
import java.util.LinkedList;

// MyStack class
public class MyStack<T> implements Iterable<T> {
  // Created LinkedList using Generic T datatype
  LinkedList<T> list;

  // method to format printed info
  public String printInfo(){
    StringBuilder output = new StringBuilder();

    output.append("Item Count: " + list.size() + ", data: ");
    
  if (list.size() == 0){
    output.append("null");
      }
    else{    
      // data type = Generic T
      for (T item : this)
        output.append(item + " ");
      }
    return output.toString();
  }

  // push method used to add objects to stack 
  public void push(T data) {
    if (list == null){
      list = new LinkedList<T>();
    }
    list.push(data);     
  }
    
  // iterable method necessary to iterate using Generic T
  public Iterator<T> iterator() {
    return ((Iterable<T>) list).iterator();
  }
    
    //tester method
    public static void main(String[] args) {
      // create queue to add integers
      MyQueue<Integer> queue = new MyQueue<Integer>();
      queue.enqueue(1);
      queue.enqueue(2);
      queue.enqueue(3);
      System.out.println(queue.printInfo());
      // create stack
      MyStack<Integer> stack = new MyStack<Integer>();
      // use for loop to iterate through the queue
      for (Integer item : queue){
        // call push method to add objects to the stack 
        stack.push(item);
      }
      // print stack 
      System.out.println(stack.printInfo());
      
    }

}