[Home](https://avabrooks.github.io/avarepository/) | [Techtalks](https://avabrooks.github.io/avarepository/techtalks) | [Reflections](https://avabrooks.github.io/avarepository/reflections) 

## Week 2: Calculator
#### Plans: 
* Build a calculator to process expressions and ultimately change RPN to a calculation.
* Build in Power of operator ^: 2 ^ 1 = 2, 2 ^ 2 = 4, 2 ^ 3 = 8
* Extra credit. Build variable assignment and evaluation into your expressions (a = 2; a + 1).
* Extra credit. Investigate Wikipedia article and pseudo code and try adding a SQRT(). Try building Pythagoras expression.
### Notes:
* Inputted turns into expressions -> tokens -> reverse Polish Notation
* Need to write the rpnToResult method
* Operators need precedence(ie multiplication above addition)

## [Week 1:](https://replit.com/@avabrooks/Tri-3-TT0#src/Menu.java) Linked Lists
### Plans:
 * Challenge #1:
     * Add and Delete elements from Queue. Working with the code that is given, you will need to adjust Add and write Delete, to output from the Queue as follows.
         * Created class 'MyQueue' that implemented Iterable<*T>
         * Used LinkedList to create a queue called 'list'
         * Created two methods: enqueue and dequeue
             * Enqueue
             ```
             //enqueue method creates LinkedList then adds data
             public void enqueue(T data) {
                if (list == null){
                  list = new LinkedList<T>();
                }
                list.add(data);     
              }
              ```
             * Dequeue
             ```
              //dequeue method removes items from last
             public T dequeue(){
                return list.removeLast();
              }
             ```
         * Used Iterator<T*> and Iterable to iterate over the objects in the queue
         * [.iterator](https://www.w3schools.com/java/java_iterator.asp)
         ```
         // iterable method necessary to iterate using Generic T
           public Iterator<T> iterator() {
            return ((Iterable<T>) list).iterator();
          }
         ```
         * Created print printInfo method to format printed output
         
         ```
         
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
              }
              
          ``` 
          
 * Challenge #2:
     * Perform a merge or combination of 2 Queue's that are ordered. This is a foundation step for future Merge sorting. IMO, this algorithm is easier if you "peek" at data at the head of the queue, prior to performing dequeue action.
         * Created two [priority queues](https://www.geeksforgeeks.org/priority-queue-class-in-java/)
             * Allows for objects to be sorted 'naturally' -> easy to do with integers based upon value 
         * Add Strings of integers to each queue
         * Created 'merge' method 
         
         ```
             Queue<String> mergedQueue = new PriorityQueue<String>();

            // While both of the queues are not empty
            while (!first.isEmpty() && !second.isEmpty()) {
              // use .peek() method to see head of queue
                String left = first.peek();
                String right = second.peek();

              // use .compareTo to compare Strings
                if (left.compareTo(right) < 0) {
                    mergedQueue.add(first.poll());
                } else {
                    mergedQueue.add(second.poll());
                }
            }
            return mergedQueue;
            
        ```
         
         * Called method along with toString method to format queues and print formatted merged queue
         
         ```
         
             // use toString method to format queues as we added strings
            System.out.println("First queue: ");
            System.out.println(first.toString());
            System.out.println("Second queue: ");
            System.out.println(second.toString());

              //call merge method
                Queue output = MergeQueue.merge(first, second);

              //print merged queue
                System.out.println("Merged queue: ");
                System.out.println(output.toString());
                
        ```
        
 * Challenge #3:
     * Build a stack and use it to reverse the order of a Queue. 
         * Used LinkedList to create Stack 
         * Created push method
         ```
           // push method used to add objects to stack 
          public void push(T data) {
            if (list == null){
              list = new LinkedList<T>();
            }
            list.push(data);     
          }
         ```
         * Used same iterator from challenge 1 to iterate through T data type
         * Added 1, 2, 3 to queue
         ```
         // create queue to add integers
          MyQueue<Integer> queue = new MyQueue<Integer>();
          queue.enqueue(1);
          queue.enqueue(2);
          queue.enqueue(3);
         ```
         * Created a stack and called push method to print out reversed output
         ```
         // create stack
          MyStack<Integer> stack = new MyStack<Integer>();
          // use for loop to iterate through the queue
          for (Integer item : queue){
            // call push method to add objects to the stack 
            stack.push(item);
          }
          // print stack 
          System.out.println(stack.printInfo());
       ```

### Notes: 
  * **Linked Lists**
       * Able to store and manage objects
       * opaqueObject means specific type is not known, as LinkedList are not specific to a data type
       * Use various setters for the nodes as wel as the opaqueObject
       
       ```
         public class MyQueue<T> implements Iterable<T> {
             LinkedList<T> list;
    ```
    
  * **Queues** are built using Linked List objects
      * **Have** a linked list
  * Queue terms:
       * First = head node
       * Back = tail node
       * Current = current
       * enque = adding
           * add to tail
       * deque = deleting
           * remove from head
  * **Stacks**
       * Keeps track of last item inserted into Push entry and Pop extraction 
       * Similar real world example to a 'stack of plates' 
       * push = enque / add
       * pop = deque / remove
* Generic T: able to put a generic T to use any data type 
   * Understanding [Generic T](https://docs.oracle.com/javase/tutorial/java/generics/types.html)
   * Don't have to use 'T' but commonly used letter for data type 
   * Must train to be iterable
   ```
       // iterable method necessary to iterate using Generic T
      public Iterator<T> iterator() {
        return ((Iterable<T>) list).iterator();
      }
   ```


## [Week 0](https://replit.com/@avabrooks/Tri-3-TT0#README.md): Data Structures
### Plans: 
 - Create Java [menu](https://replit.com/@avabrooks/Tri-3-TT0#src/Menu.java) using data structures
    - can use java Runnable function to aide in creating menu for defining title and action based upon menu selection 
    - Use java scanner(similar to old menu) to get user input
    - Create rows as objects to initialize each row for 'title' and 'action'  
    - Use loops(similar to old menu) to continue to run menu 

 - Swap [method](https://replit.com/@avabrooks/Tri-3-TT0#src/SwitchNumbers.java) to swap 2 numbers
    - Hack: create IntByReference, swapToLowHighOrder and toString methods
    - swapToLowHighOrder
      - compare values
      - use this.value to comapre the two given numbers
      ```
      //method to compare values
       public void swapToLowHighOrder(SwitchNumbers i) {
      if (this.value > i.value) {
        int y = this.value;
        this.value = i.value;
        i.value = y;
             }
          }
      ```

    - toString method
      - return a string rather than object to print 
      - %d used for integers
      ```
       //toString method to return string rather than object
       public String toString() {
            return (String.format("%d", this.value)); //%d used for integers 
        }
       ```
 - Formatted [matrix](https://replit.com/@avabrooks/Tri-3-TT0#src/Matrix.java)
    - Hack: create toString method using nested for loops to format output of a matrix
    - toString method
       - Create two methods to format matrix(one regular, one reverse)
       - Use nested for loops(columns vs. rows?)
       - Can use StringBuilder to help change sequence
     ```
     // toString method to format matrix
       public String toString() {
        StringBuilder output = new StringBuilder();
        //use for loop to iterate through rows
        for (int[] row : matrix) {
        // nested loop for columns 
        for (int cell : row) {
            output.append((cell==-1) ? " " : String.format("%d",cell)).append(" "); 
            }
         }
        return output.toString();
        }
        ```
### Notes: 
 - Data Structure: method of organizing data
 - **Programming Paradigms:** approach/method to write software applications 
      - Imperative: statements to change a program's state - "how"
           - Types:
                - Procedural
                - Python known for this 
      - **Object Oriented:** classes and objects
 - Common data structures among Imperative and OO
