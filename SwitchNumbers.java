package src;
//import java.lang.Integer

//class for number swap
public class SwitchNumbers {
  //attribute
    private int value;
  
  //constructor
    public SwitchNumbers(Integer value) {
        this.value = value;
    }

   // Hack: create IntByReference, swapToLowHighOrder and toString methods

    //toString method to return string rather than object
    public String toString() {
          return (String.format("%d", this.value)); //%d used for integers 
      }

    

    //method to compare values
    public void swapToLowHighOrder(SwitchNumbers i) {
        if (this.value > i.value) {
            int y = this.value;
            this.value = i.value;
            i.value = y;
        }
    }

  

    public static void swap(int n0, int n1) {
      //define ints
        SwitchNumbers a = new SwitchNumbers(n0);
        SwitchNumbers b = new SwitchNumbers(n1);
      //print numbers before
        System.out.println("Before Swap: " + a + " " + b);
      // call sort method 
        a.swapToLowHighOrder(b); 
      // print after sort
        System.out.println("After Swap: " + a + " " + b);
        System.out.println(" ");
    }

  
    // call methods created to sort two numbers 
    public static void main(String[] ags) {
      //input numbers to print out
        SwitchNumbers.swap(27, 15);
        SwitchNumbers.swap(-4, -30);
        SwitchNumbers.swap(1, -98);

      /* 
        int a = 10;
        int b = 20;
        System.out.println(Integer.compare(a, b));
    
      */
        
    }

}
