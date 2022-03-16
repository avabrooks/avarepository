[Home](https://avabrooks.github.io/avarepository/) | [Techtalks](https://avabrooks.github.io/avarepository/techtalks) | [Reflections](https://avabrooks.github.io/avarepository/reflections) 

## Week 1: Linked Lists
* Plans:
* Notes: 
     * **Linked Lists**
          * Able to store and manage objects
          * opaqueObject means specific type is not known, as LinkedList are not specific to a data type
          * Use various setters for the nodes as wel as the opaqueObject
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


## [Week 0](https://replit.com/@avabrooks/Tri-3-TT0#README.md): Data Structures
 * Plans: 
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
 * Notes: 
     - Data Structure: method of organizing data
     - **Programming Paradigms:** approach/method to write software applications 
          - Imperative: statements to change a program's state - "how"
               - Types:
                    - Procedural
                    - Python known for this 
          - **Object Oriented:** classes and objects
     - Common data structures among Imperative and OO
