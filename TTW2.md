[Home](https://avabrooks.github.io/avarepository/) | [Blog](https://avabrooks.github.io/avarepository/blog) | [Tech Talk Repl](https://replit.com/@avabrooks/Tri-3-TT#README.md)

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
