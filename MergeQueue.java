package src;
import java.util.Queue;
import java.util.PriorityQueue;


class MergeQueue {
    public static void main(String[] args) {
      // create two queues
      // Priority Queue: allows for 'natural ordering'
        Queue first = new PriorityQueue<String>();
        Queue second = new PriorityQueue<String>();

      //add objects to first queue
        first.add("1");
        first.add("4");
        first.add("5");
        first.add("8");

      //add objects to second quue
        second.add("2");
        second.add("3");
        second.add("6");
        second.add("7");

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
    }

    public static Queue<String> merge(Queue<String> first, Queue<String> second) {
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
    }
}