[Home](https://avabrooks.github.io/avarepository/) | [Blog](https://avabrooks.github.io/avarepository/blog) | [Tech Talk Repl](https://replit.com/@avabrooks/Tri-3-TT#README.md)

## MCQ [Results](https://apclassroom.collegeboard.org/8/assessments/results/45761405/performance):

<img src="src/main/resources/static/images/Screenshot (167).png"
     alt="Markdown Monster icon"
     style="float: left; margin-right: 10px;" />

## MCQ Corrections:
* **10**: printSome Method
     * for the output to be " 0 10 " the expression i % num2  and i % 2 has to equal 0. This can only happen in the values from 0 to 19, not 0 to 9. Since they are both divisible by 5 and even, " 0 10 " will be printed. Only 0 would be printed if 10, 5 was inputted rather than the correct answer of 20,5. 
* **13**: Boolean expression with a, b, and c
     * Need to use DeMorgan's Law!!!
     * !(a && b) = !a || !b thus !a || !b || c
* **19**: sum array elements
     * Need to double the first element in every row because of neseted loops to traverse through 2D arrays
     * first element in each row doubled then sum all the elements
* **21**: strArr Method
     * order is not through increase in length
     * shortest string is found each time for arr[0] to arr[3]
     * for last iteration there are no values after arr[3] thus then spring is assigned last 
* **22**: strArr Method
     * line 12 is executed every time a new smallest value is indentified rather than each time a string was shorter
     * updated for 'day' 'of' when j has the value of 0 + updated once for 'for' when j has value of 1 + updated 'year' when j has value of 4
* **23**: print in row major order
     * since its a 2D array, the outer loop stores each row in j(1D array)
     * inner loop stores each element of j in k then prints k
     * j is int[]
* **27**: conditions for Boolean expressions
     * need to review boolean expression symbols and what they mean
     * can use truth tables for extra help
     * entire expression is either true || false or false || true or true, thus b has to be false because both (a && b) and (!a &&b) will evaluate to false regardless of value a
* **28**: sing the Song
     * no error since does not attempt to access a substring that begins at an index less than 0
     * method removes all occurences of 'ng' 
*  **33**: array with A through L
     *  accidentally reversed the positions of the two for loops 
*  **36**: comparing looping methods
     *  doesn't work when a is 6 and b is 4 because methodOne would return 1 and methodTwo would return 2, however when a % b is equal to 0, the methods will be executed the same amount of times
*  **38**: sum of ArrayList values
     *  although 1 is a correct answer, 2 is also correct because since an enhanced foor loop is used, it can traverse the valueList array, where inside the loop, the getNum method is called to access the num variable
*  **40**: remove a method
     *  a message cannot even be executed because a complier error will occur since obj1 is declared as an object of type A. However, since there is no message method in class A(if it is removed), then the statement in line 3 won't compile anymore thus creating an error
 


### Overall Concept Summary:
     While I am not taking the test, I have found that I had a common problem with the strArr method as well as 2D arrays. While I made very few 'stupid' mistakes, I did notice that I had a bit of a learning gap in the area of 2D arrays and traversing through them. I also need to brush up on DeMorgan's law for Boolean expression rules, however these are little things that with some practice(if I was taking the AP exam) would cure. Although I'm not taking the test, having profeciency with 2D arrays is essential for comp sci so I plan on doing a bit of review/practice on my own to gain more personal growth in that area for potential PBL work. 
