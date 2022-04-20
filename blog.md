[Home](https://avabrooks.github.io/avarepository/) | [Blog](https://avabrooks.github.io/avarepository/blog) | [Tech Talk Repl](https://replit.com/@avabrooks/Tri-3-TT#README.md)

## [Week 3](https://replit.com/@avabrooks/Tri-3-TT0#src/Calculator.java): Sorts
### **Challenge:**


### **Data Table:**

| Sort      | Speed (Milliseconds) |
| ----------- | ----------- |
| Bubble     | 1379 |
| Merge   | 11    |
| Insertion   | 818    |
| Select   |325 |

### Analysis 

The most efficient sort program was the Insertion Sort. The time that it took the bubble sort algorithm to sort the given list was 0.000149. The time that it took the insertion algorithm was 0.000002, and it took the Merge sort 0.000004. The select sort took 0.000023. Out of these, the fastest was the insertion sort. This indicates that the insertion sort was the most fastest, and thus in our definition, the most efficient program to sort through the list. 
  * **Analysis:**
     * After hypothesizing that the merge sort or insertion sort was going to be the fastest and the bubble sort was going to be the slowest, I was somewhat right. After averaging my results, the merge sort is consistently the fastest (in milliseconds) usually averaging 11 milliseconds while the bubble sort could take 1379 milliseconds(a much longer time than the merge sort). However, comparisons-wise, the insertion sort consistently has the least amount of comparisons. While bubble and selection sort have the same number of comparisons based on the number of items being sorted. For swaps, the selection sort has the least amount of swaps, however, because it takes a while for all of the comparisons, it is still not as fast as the merge sort. For this case, based on the averages I have produced, I argue that the best sort is the **merge sort**. While multiple methods are required(at least in the way I approached it), these multiple methods allow for a faster sort with fewer comparisons. The merge sort is never the slowest in terms of time and is very efficient in comparison to the other sorts and their average number of swaps and comparisons. 
  * [Build](https://replit.com/@avabrooks/Tri-3-TT#src/Sorts.java):
    *  Bubble Sort:
   
    ```
      //bubble sort method
    public void bubbleSort(ArrayList<Integer> list){
      // call intialize to set all common variables to 0
      initialize();
      size = list.size();
      //set variable start to the time in milliseconds that sort starts
      long start = System.currentTimeMillis();
      for (int i = 0; i < list.size() - 1; i++) {
        for (int j = list.size() - 1; j > i; j--) {
          comparisons++;
          //comparisons happen here during this if statement
            if (list.get(j - 1) > list.get(j)) {
              //swaps counted here so added to the count
                swaps++;
                int tmp = list.get(j - 1);
                list.set(j -1, list.get(j));
                list.set(j, tmp);
            }
         }
      }
      //take the time in milliseconds after sorted and subtract the start time
      milliseconds = System.currentTimeMillis() - start; 

    }
      milliseconds = System.currentTimeMillis() - start; 

    }
    ```
    
    *  Selection Sort:
    
    ```
     //selections ort method
      public void selectionSort(ArrayList<Integer> list){
        // call intialize to set all common variables to 0
        initialize();
        size = list.size();
        //set variable start to the time in milliseconds that sort starts
        long start = System.currentTimeMillis();

        //set variables to 0
        int smallInt = 0;
        int j=0;
        int smallIntIndex = 0;      

        for(int i=1;i<list.size();i++){
          smallInt = list.get(i-1);
          smallIntIndex = i-1;

          for(j=i;j<list.size();j++){
            comparisons++;
            //comparisons at the if statements
              if(list.get(j)<smallInt){
                  smallInt = list.get(j);
                  smallIntIndex = j;
              }
          }
          swaps++;
          //swaps before the .set(s)
          int temp = list.get(smallIntIndex);
          list.set(smallIntIndex, list.get(i-1));
          list.set(i-1, temp);

        }
        //take the time in milliseconds after sorted and subtract the start time
        milliseconds = System.currentTimeMillis() - start; 
      }
    ```
    
    *  Insertion Sort:
    
    ```
        //insertion sort method
      public void insertionSort(ArrayList<Integer> list){
        // call intialize to set all common variables to 0
        initialize();
        size = list.size();
        //set variable start to the time in milliseconds that sort starts
        long start = System.currentTimeMillis();

        for (int j = 1; j < list.size(); j++) {
            int current = list.get(j);
            int i = j-1;
            comparisons++;
            while ((i > -1) && ((list.get(i).compareTo(current)) == 1)) {
              //swap for the first set
                swaps++;
                list.set(i+1, list.get(i));
                i--;
            }
          //two places for a swap for insertion sort
            swaps++;
            list.set(i+1, current);
        }
        //take the time in milliseconds after sorted and subtract the start time
        milliseconds = System.currentTimeMillis() - start; 
      }
    ```
    
    *  Merge Sort:
    
  ```
          public void mergeSort(ArrayList<Integer> list){
        // call intialize to set all common variables to 0
        initialize();
        size = list.size();
        //set variable start to the time in milliseconds that sort starts
        long start = System.currentTimeMillis();
        //call other method created for 2 part merge sort 
        mergeSortInternal(list);
        //take the time in milliseconds after sorted and subtract the start time
        milliseconds = System.currentTimeMillis() - start; 
      }

      //private method to sort each side and merge
      private void mergeSortInternal(ArrayList<Integer> list){

        //create two ArrayLists for merge sort(left adn right)
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        int center;

        //comparisons for if statements
        comparisons++;
        if (list.size() == 1) {    
            return;
        } 
        else {
            center = list.size()/2;
            for (int i=0; i<center; i++) {
                    left.add(list.get(i));
            }

            for (int i=center; i<list.size(); i++) {
                    right.add(list.get(i));
            }

          //call for both left and right 
            mergeSortInternal(left);
            mergeSortInternal(right);

          //compares the two sides to merge them together
            mergeInternal(left, right, list);
            }
      }

      //private method that merges the left and right after they are sorted
      private void mergeInternal(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> whole) {
      //set variables 
      int leftIndex = 0;
      int rightIndex = 0;
      int wholeIndex = 0;

      while (leftIndex < left.size() && rightIndex < right.size()) {
        // if statements = comparisons 
        comparisons++;
        if ( (left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
          swaps++;
            whole.set(wholeIndex, left.get(leftIndex));
            leftIndex++;
          } 
        else {
          swaps++;
              whole.set(wholeIndex, right.get(rightIndex));
              rightIndex++;
          }
          wholeIndex++;
      }

      ArrayList<Integer> rest;
      int restIndex;
        comparisons++;
      if (leftIndex >= left.size()) {
          rest = right;
          restIndex = rightIndex;
      } else {
          rest = left;
          restIndex = leftIndex;
      }

      for (int i=restIndex; i<rest.size(); i++) {
        swaps++;
          whole.set(wholeIndex, rest.get(i));
          wholeIndex++;
            }
        }
  ```
    
  * Build a [GitHub page](https://avabrooks.github.io/avarepository/TTW3) that describes Sort implementations and the Big O complexity of these Sorts.
  * Establish analytics including: time, comparisons and swaps.
    * Analyitics are unconvered after running sorts [here](https://replit.com/@avabrooks/Tri-3-TT#src/Sorts.java)
    
      ```
      //method to print stats for a single run of each test
      public void printStats(){
        System.out.println("    Size: "+ size);
        System.out.println("    Milliseconds: " + milliseconds);
        System.out.println("    Comparisons: " + comparisons);
        System.out.println("    Swaps: " + swaps);
      }
      
       // create list with random numbers from 0-1000000
       public static ArrayList<Integer> createList(int size){
         ArrayList<Integer> unsorted = new ArrayList<Integer>();
         Random r = new Random();
         for (int i  = 0; i < size; i++){
           unsorted.add(r.nextInt(1000000));
         }
         //returns the unsorted list to be called for each sort type 
         return unsorted; 
       }
       
       
       public static void main(String[] args) {
          Sorts s = new Sorts();

        /*  
          For each sort type, method is called once for a random set of 5000 data pieces and stats are printed
        */

          ArrayList<Integer> bubbleList = createList(5000);
          s.bubbleSort(bubbleList);
          System.out.println("Bubble Sort:");
          s.printStats();
          System.out.println("\n");
      ```
      
  * Average the results for each each Sort, run each at least 12 times and 5000 elements. You should throw out High and Low when doing analysis.
       
       ```
       //create and define all variables used to find averages
          long totalMilliseconds = 0;
          long averageMilliseconds = 0;
          long totalComparisons = 0;
          long averageComparisons = 0;
          long totalSwaps = 0;
          long averageSwaps = 0;
          long count = 13;

          for (int i = 0; i < count; i++){
            bubbleList = createList(5000);
            s.bubbleSort(bubbleList);
            totalMilliseconds += s.getMilliseconds();
            totalComparisons += s.getComparisons();
            totalSwaps += s.getSwaps();
          }

          System.out.println("Averages:");

          averageMilliseconds = totalMilliseconds/count;
          averageComparisons = totalComparisons/count;
          averageSwaps = totalSwaps/count;

          System.out.println("Bubble Sort: ");
          System.out.println("    Time: " + averageMilliseconds);
          System.out.println("    Comparisons: " + averageComparisons);
          System.out.println("    Swaps: " + averageSwaps);
          System.out.println("\n");
        ```
        
    * Averages printed after each run [here](https://replit.com/@avabrooks/Tri-3-TT#src/Sorts.java)
  
  * Make your final/judgement on best sort considering Data Structure loading, Comparisons, Swaps, Big O complexity, and Time(above)
### **Notes:**
 * Merge sort will likely have to be at least two method
   * Divide
   * Add
   * Could potentially make a third to make sorting easier for 5000 pieces
 * Use for loop to create averages of each of the sort analytics
  * Loop through and then store as variable?
  * Can calculate through Math functions or simple variable divison 
 * Hypothesis: Insertion or Merge sort will likely be the fastest while Bubble sort will likely be the slowest, purely based upon the overall generics of how these sorts work 



## [Week 2](https://replit.com/@avabrooks/Tri-3-TT0#src/Calculator.java): Calculator
#### Plans: 
* Build a calculator to process expressions and ultimately change RPN to a calculation.
    * Created a new stack calculation:
         ```
         Stack calculation = new Stack();
        ```
    * Created for loop to process RPN:
         ```
          for (String token : this.reverse_polish) {
         ```
    * If statement checks to see if token is a number(aka not an operator) then pushes to stack 
         ```
         if (!isOperator(token)) {
      
          // Push number to stack
          double d = Double.parseDouble(token);
          calculation.push(d);
        ```
    * Otherwise pop top two entries 
         ```
         else{
        // Pop the two top entries
        double d1 = (Double)calculation.pop();
        double d2 = (Double)calculation.pop();
        double r = 0d;
       ```
    * Created multiple if statements to check which operator it is
    
      ```
             if (token.charAt(0) == '*'){
             r = d1 * d2;
               }
               else if (token.charAt(0) == '/'){
                 r = d2 / d1;
               }
               else if (token.charAt(0) == '%'){
                 r = d2 % d1;
               }
               else if (token.charAt(0) == '+'){
                 r = d1 + d2;
               }
               else if (token.charAt(0) == '-'){
                 r = d2 - d1;
               } 
      ``` 
      
    * Final result is popped
         ```
         this.result = (Double)calculation.pop();
        ```
### Notes:
* Inputted turns into expressions -> tokens -> reverse Polish Notation
* Use **Stacks** from last week:
   * Keeps track of last item inserted into Push entry and Pop extraction 
   * Similar real world example to a 'stack of plates' 
   * push = enque / add
   * pop = deque / remove
* Need to write the rpnToResult method
    * Must convert RPN to final result 
    * Check tokens to see if operator and number to complete calculations 
* Operators need precedence(ie multiplication above addition)
    * reverse potential variables(ie d2 before d1)
        * Created problems with calculations using mod and division 

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


# Reflections for Trimester 3:

### 3/7: What can I do with Tech to improve mine or others education?

Technology is an essential part of our modern-day society. From simple text messages to a wide range of social media posts, technology is a tool that aides global communication and connection. Personally, through my creation of various websites in AP CSP and AP CSA, I have focused on a myriad of topics. With my most recent contribution being a tutoring site, this is a prime example of how I can use tech to improve the education of myself and others. In a very literal sense, this website can help connect tutors and tutees in need of help. While this can be done over other sites, the most recent creation was a one-stop-shop for all things Del Norte tutoring. By making things more easily accessible to the general public, finding resources can be easier for people, especially those who are younger. While websites just touch the brink of technology's potential, the work we produce in AP CSA can continue to provide connections among people worldwide.

For my education, technology has always played a large part in my personal development. Coming from Design 39, I was already pretty familiar with technology and its potential. While we relied on technology less at Del Norte, finally taking a computer science course my junior year allowed me to take on new endeavors with technology. For example, technology allowed me to develop better collaboration skills as well as leadership skills as I transitioned between roles in scrum teams. Experiencing more of a real-world environment in terms of a technology job allowed me to further my education towards a point where other classes would not guide me towards. Understanding the interworkings of technology, particularly in web development has helped me better understand how technology works and the methods behind the large impact that technology has on our daily lives.

For the education of others, exposing my own knowledge and learnings from my past 2 years in computer science at Del Norte can help the productivity and overall knowledge of my peers. A perfect example of this would be through Night at the Museum. While people may only see code or a running MVC front end for a few minutes, by highlighting the positives of technology and computer science, the small amounts of exposure can build up to a larger scale impact. As I continue on to college and eventually the 'real world,' using my learnings of technology will continue to help me progress through life and I can continue to educate and expose others to the interworkings of technology.

