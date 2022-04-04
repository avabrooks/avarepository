package src;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Menu {
    Map<Integer, MenuRow> menu = new HashMap<>();

    // tester method
      public static void main(String[] args) {
          Driver.main(args);
      }

    public Menu(MenuRow[] rows) {
        int j = 0;
        for (MenuRow row : rows) {
            // Create hashmap 
            menu.put(j++, new MenuRow(row.getTitle(), row.getAction()));
        }
    }

    // getter to get row from Menu
    public MenuRow get(int j) {
        return menu.get(j);
    }

    // use for loop to iterate through the rows to print each one
    public void print() {
        for (Map.Entry<Integer, MenuRow> pair : menu.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue().getTitle()); //gets the key for the menu and prints number 
        }
    }


}

class MenuRow {
    String title;       
    Runnable action; // Java Runnable is an interface that is to be implemented by a class whose instances are intended to be executed by a thread

    // constructor 
    public MenuRow(String title, Runnable action) {
        this.title = title;
        this.action = action; // defines Runnable action
    }

    // getter for action
      public Runnable getAction() {
          return this.action;
      }

    // getter for title 
    public String getTitle() {
        return this.title;
    }
  

    //runs the action 
    public void run() {
        action.run();
    }
}

// Driver class to create menu
class Driver {
  public static void runMenu(Menu current){
      while (true) {
  
              System.out.println("Choose a Week:");
              // print rows
              current.print();
  
              // Scan for input
              try {
                  Scanner sc = new Scanner(System.in);
                  int selection = sc.nextInt();
  
                  // menu action
                  try {
                      MenuRow row = current.get(selection);
                      // stop menu condition
                      if (row.getTitle().equals("Exit"))
                          return;
                      // run option
                    System.out.println(row.getTitle());
                      row.run();
                  } catch (Exception e) {
                      System.out.printf("Invalid selection %d\n", selection);
                  }
              } catch (Exception e) {
                  System.out.println("Not a number");
              }
          }
    }

  
    public static void main(String[] args) {
        // Row initialize
        MenuRow[] rows = new MenuRow[]{
                new MenuRow("Back", () -> main(null)),
                new MenuRow("Switch Numbers", () -> SwitchNumbers.main(null)), 
                new MenuRow("Matrix", () -> Matrix.main(null))
        };

      MenuRow[] rows1 = new MenuRow[]{
                new MenuRow("Back", () -> main(null)),
                new MenuRow("Queue", () -> MyQueue.main(null)),
                new MenuRow("Stack", () -> MyStack.main(null)),
                new MenuRow("Merged Queues", () -> MergeQueue.main(null))
        };
      
      MenuRow[] rows2 = new MenuRow[]{
                new MenuRow("Back", () -> main(null)),
                new MenuRow("Calculator", () -> Calculator.main(null)),
        };


      MenuRow[] rows3 = new MenuRow[]{
                new MenuRow("Back", () -> main(null)),
                new MenuRow("Sorts", () -> Sorts.main(null)),
        };

        // Menu construction
        Menu menu0 = new Menu(rows);
        Menu menu1 = new Menu(rows1);
        Menu menu2 = new Menu(rows2);
        Menu menu3 = new Menu(rows3);

      MenuRow[] techtalks = new MenuRow[]{
        new MenuRow("Week 0", () -> runMenu(menu0)),
        new MenuRow("Week 1", () -> runMenu(menu1)),
        new MenuRow("Week 2", () -> runMenu(menu2)),
        new MenuRow("Week 3", () -> runMenu(menu3))
      };

      Menu techtalksmenu = new Menu(techtalks);

      runMenu(techtalksmenu);
    }
  }


