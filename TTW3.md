[Home](https://avabrooks.github.io/avarepository/) | [Blog](https://avabrooks.github.io/avarepository/blog) | [Tech Talk Repl](https://replit.com/@avabrooks/Tri-3-TT#README.md)

## [Week 3](https://replit.com/@avabrooks/Tri-3-TT0#src/Calculator.java): Sorts
### **Challenge:**
  * **Analysis:**
     * After hypothesizing that the merge sort or insertion sort was going to be the fastest and the bubble sort was going to the slowest, I was somewhat right. After averaging my results, the merge sort is consistently the fastest sort(in milliseconds) usually ranging from 3-8 milliseconds while the bubble sort could take 300-400 milliseconds(a much longer time than the merge sort). However, comparisons wise, the insertion sort consistenyl has the least amount of comparisons. While bubble and selection sort have the same number ofc oparisons based upon the number of items being sorted. For swaps, the selection sort has the least amount of swaps, however because it takes a while for all of the comparisons, it is still not as fast as the merge sort. For this case, based upon the averages I have produced, I argue that the best sort is the **merge sort**. While multiple methods are required(at least in the way I approached it), these multiple methods allow for a faster sort with less comparisons. The merge sort is never slowest in terms of time and is very effecient in comparison to the other sorts and their avergae number of swaps and comparisons. 
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
