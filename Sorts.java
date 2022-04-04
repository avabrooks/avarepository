package src;
import java.util.*;

class Sorts {
    long milliseconds;
    int comparisons;
    int swaps;
    int size;

    private void initialize(){
        size = 0;
        milliseconds = 0;
        comparisons = 0;
        swaps = 0;
    }

    public long getMilliseconds(){
        return this.milliseconds;
    }

    public int getComparisons(){
        return this.comparisons;
    }

    public int getSwaps(){
        return this.swaps;
    }

    public void bubbleSort(ArrayList<Integer> list){
        initialize();
        size = list.size();
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                comparisons++;
                if (list.get(j - 1) > list.get(j)) {
                    swaps++;
                    int tmp = list.get(j - 1);
                    list.set(j -1, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
        milliseconds = System.currentTimeMillis() - start;

    }

    public void selectionSort(ArrayList<Integer> list){
        initialize();
        size = list.size();
        long start = System.currentTimeMillis();

        int smallInt = 0;
        int j=0;
        int smallIntIndex = 0;

        for(int i=1;i<list.size();i++){
            smallInt = list.get(i-1);
            smallIntIndex = i-1;

            for(j=i;j<list.size();j++){
                comparisons++;
                if(list.get(j)<smallInt){
                    smallInt = list.get(j);
                    smallIntIndex = j;
                }
            }
            swaps++;
            int temp = list.get(smallIntIndex);
            list.set(smallIntIndex, list.get(i-1));
            list.set(i-1, temp);

        }
        milliseconds = System.currentTimeMillis() - start;
    }

    public void insertionSort(ArrayList<Integer> list){
        initialize();
        size = list.size();
        long start = System.currentTimeMillis();

        for (int j = 1; j < list.size(); j++) {
            int current = list.get(j);
            int i = j-1;
            comparisons++;
            while ((i > -1) && ((list.get(i).compareTo(current)) == 1)) {
                swaps++;
                list.set(i+1, list.get(i));
                i--;
            }
            swaps++;
            list.set(i+1, current);
        }
        milliseconds = System.currentTimeMillis() - start;
    }

    public void mergeSort(ArrayList<Integer> list){
        initialize();
        size = list.size();
        long start = System.currentTimeMillis();
        mergeSortInternal(list);
        milliseconds = System.currentTimeMillis() - start;
    }

    private void mergeSortInternal(ArrayList<Integer> list){

        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        int center;

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

            mergeSortInternal(left);
            mergeSortInternal(right);

            mergeInternal(left, right, list);
        }
    }

    private void mergeInternal(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
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

    public void printStats(){
        System.out.println("    Size: "+ size);
        System.out.println("    Milliseconds: " + milliseconds);
        System.out.println("    Comparisons: " + comparisons);
        System.out.println("    Swaps: " + swaps);
    }

    public static ArrayList<Integer> createList(int size){
        ArrayList<Integer> unsorted = new ArrayList<Integer>();
        Random r = new Random();
        for (int i  = 0; i < size; i++){
            unsorted.add(r.nextInt(1000000));
        }
        return unsorted;
    }

    public static void printList(ArrayList<Integer> list, int count){
        Random r = new Random();
        for (int i  = 0; i < count; i++){
            System.out.println(list.get(i));
        }
    }


    public static void main(String[] args) {
        Sorts s = new Sorts();
        ArrayList<Integer> bubbleList = createList(5000);
        s.bubbleSort(bubbleList);
        System.out.println("Bubble Sort:");
        s.printStats();
        System.out.println("\n");

        ArrayList<Integer> selectionList = createList(5000);
        s.selectionSort(selectionList);
        System.out.println("Selection Sort:");
        s.printStats();
        System.out.println("\n");

        ArrayList<Integer> insertionList = createList(5000);
        s.insertionSort(insertionList);
        System.out.println("Insertion Sort:");
        s.printStats();
        System.out.println("\n");

        ArrayList<Integer> mergeList = createList(5000);
        s.mergeSort(mergeList);
        System.out.println("Merge Sort:");
        s.printStats();
        //printList(mergeList, 20);
        System.out.println("\n");

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

        totalMilliseconds = 0;
        totalComparisons = 0;
        totalSwaps = 0;
        for (int i = 0; i < count; i++){
            selectionList = createList(5000);
            s.selectionSort(selectionList);
            totalMilliseconds += s.getMilliseconds();
            totalComparisons += s.getComparisons();
            totalSwaps += s.getSwaps();
        }


        averageMilliseconds = totalMilliseconds/count;
        averageComparisons = totalComparisons/count;
        averageSwaps = totalSwaps/count;

        System.out.println("Selection Sort: ");
        System.out.println("    Time: " + averageMilliseconds);
        System.out.println("    Comparisons: " + averageComparisons);
        System.out.println("    Swaps: " + averageSwaps);
        System.out.println("\n");

        totalMilliseconds = 0;
        totalComparisons = 0;
        totalSwaps = 0;
        for (int i = 0; i < count; i++){
            insertionList = createList(5000);
            s.insertionSort(insertionList);
            totalMilliseconds += s.getMilliseconds();
            totalComparisons += s.getComparisons();
            totalSwaps += s.getSwaps();
        }


        averageMilliseconds = totalMilliseconds/count;
        averageComparisons = totalComparisons/count;
        averageSwaps = totalSwaps/count;

        System.out.println("Insertion Sort: ");
        System.out.println("    Time: " + averageMilliseconds);
        System.out.println("    Comparisons: " + averageComparisons);
        System.out.println("    Swaps: " + averageSwaps);
        System.out.println("\n");

        totalMilliseconds = 0;
        totalComparisons = 0;
        totalSwaps = 0;
        for (int i = 0; i < count; i++){
            mergeList = createList(5000);
            s.mergeSort(selectionList);
            totalMilliseconds += s.getMilliseconds();
            totalComparisons += s.getComparisons();
            totalSwaps += s.getSwaps();
        }


        averageMilliseconds = totalMilliseconds/count;
        averageComparisons = totalComparisons/count;
        averageSwaps = totalSwaps/count;

        System.out.println("Merge Sort: ");
        System.out.println("    Time: " + averageMilliseconds);
        System.out.println("    Comparisons: " + averageComparisons);
        System.out.println("    Swaps: " + averageSwaps);
        System.out.println("\n");

    }

}
