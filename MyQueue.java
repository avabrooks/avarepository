package src;
import java.util.Iterator;
import java.util.LinkedList;

public class MyQueue<T> implements Iterable<T> {
  LinkedList<T> list;

  // printInfo method uses String Builder to use .append()
  public String printInfo(){
    StringBuilder output = new StringBuilder();

    output.append("Item Count: " + list.size() + ", data: ");

  // if nothing left in list, print null(last line)  
  if (list.size() == 0){
    output.append("null");
      }
    else{    
      // for each item(using generic T) append the item and a space(formatting)
      for (T item : this)
        output.append(item + " ");
      }
    // use toString since we are using strings in the queue
    return output.toString();
  }  

  //enqueue method creates LinkedList then adds data
  public void enqueue(T data) {
    if (list == null){
      list = new LinkedList<T>();
    }
    list.add(data);     
  }

  //dequeue method removes items from last
  public T dequeue(){
    return list.removeLast();
  }
    
  // iterable method necessary to iterate using Generic T
  public Iterator<T> iterator() {
    return ((Iterable<T>) list).iterator();
  }
    
    
    public static void main(String[] args) {
      // create MyQueue
      MyQueue<String> queue = new MyQueue<String>();
      System.out.println("Enqueued data: seven");
      // call enqueue method for each string
      queue.enqueue("seven");
      // call printInfo method to format added object
      System.out.println(queue.printInfo());
      System.out.println("Enqueued data: slimy");
      queue.enqueue("slimy");
      System.out.println(queue.printInfo());
      System.out.println("Enqueued data: snakes");
      queue.enqueue("snakes");
      System.out.println(queue.printInfo());
      System.out.println("Enqueued data: sallying");
      queue.enqueue("sallying");
      System.out.println(queue.printInfo());
      System.out.println("Enqueued data: slowly");
      queue.enqueue("slowly");
      System.out.println(queue.printInfo());
      System.out.println("Enqueued data: slithered");
      queue.enqueue("slithered");
      System.out.println(queue.printInfo());
      System.out.println("Enqueued data: southward");
      queue.enqueue("southward");
      System.out.println(queue.printInfo());
      String item = queue.dequeue();
      System.out.println("Dequeued data: " + item); 
      System.out.println(queue.printInfo());
      // call dequeue method 
      item = queue.dequeue();
      System.out.println("Dequeued data: " + item); 
      System.out.println(queue.printInfo());
      item = queue.dequeue();
      System.out.println("Dequeued data: " + item); 
      System.out.println(queue.printInfo());
      item = queue.dequeue();
      System.out.println("Dequeued data: " + item); 
      System.out.println(queue.printInfo());
      item = queue.dequeue();
      System.out.println("Dequeued data: " + item); 
      System.out.println(queue.printInfo());
      item = queue.dequeue();
      System.out.println("Dequeued data: " + item); 
      System.out.println(queue.printInfo());
      item = queue.dequeue();
      System.out.println("Dequeued data: " + item); 
      System.out.println(queue.printInfo());
        

    }

}
