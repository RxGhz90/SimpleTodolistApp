import java.util.Scanner;

public class SimpleTodolistApp {
    private static Scanner scanner = new Scanner(System.in);
    private static String[] todolist = new String[5];

    public static void main(String[] args) {
        testViewRemoveTodolist();
        // testViewAddTodolist();
        // testViewShowTodolist();
        // testInputData();
        // testRemoveTodolist();
        // testAddTodolist();
        // testShowTodolist();
    }

    /**
     * Show todolist
     */
    public static void showTodolist() {
        System.out.println("TODOLIST");
        for (int i = 0; i < todolist.length; i++) {
            var todo = todolist[i];
            var listNo = i + 1;

            if (todo != null) {
                System.out.println(listNo + ". " + todo);
            }
        }
    }

    public static void testShowTodolist() {
        todolist[0] = "Working as developer";
        todolist[1] = "Buy grocerries";
        todolist[3] = "Drink juice";
        showTodolist();
    }

    /**
     * Add todolist
     */
    public static void addTodolist(String todo) {
        // need to check is full or not
        var isfull = true;
        for (String todolist1 : todolist) {
            if (todolist1 == null) {
                isfull = false;
                break;
            }
        }

        // isfull is true then resize array
        if (isfull) {
            var temp = todolist;
            todolist = new String[todolist.length * 2];

            System.arraycopy(temp, 0, todolist, 0, temp.length);
        }

        // need to add iteam which array is null
        for (int i = 0; i < todolist.length; i++) {
            if (todolist[i] == null) {
                todolist[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodolist() {
        for (int i = 0; i < 7; i++) {
            addTodolist("Example TODO" + (i + 1));
        }
        showTodolist();
    }

    /**
     * Remove todolist
     */
    public static boolean removeTodolist(Integer number) {
        if ((number - 1) >= todolist.length) {
            return false;
        
        } else if (todolist[number - 1] == null) {
            return false;
        
        } else {
            for (var i = number - 1; i < todolist.length; i++) {
                if (i == todolist.length - 1) {
                    todolist[i] = null;

                } else {
                    todolist[i] = todolist[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodolist() {
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");

        // invalid number 1
        var result = removeTodolist(20);
        System.out.println(result);

        // valid number 
        result = removeTodolist(2);
        System.out.println(result);

        // valid number but deleted
        result = removeTodolist(5);
        System.out.println(result);

        showTodolist();
    }

    public static String inputData(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInputData() {
        var name = inputData("Nama");
        System.out.println("Hi " + name);

        name = inputData("Channel");
        System.out.println("Hi " + name);
    }


    /**
     * For view each fucntion todolist
     */
    public static void viewShowTodolist() {
        while (true) { 
            showTodolist();
             
            System.out.println("MENU: ");
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("3. Exit");

            var input = inputData("Choose the action");
            if (input.equals("1")) {
                viewAddTodolist();

            } else if (input.equals("2")) {
                viewRemoveTodolist();
            
            } else if (input.equals("3")) {
                break;
            
            } else {
                System.out.println("Invalid input. Choose eiher 1 or 2.");
            }
        }
    }

    public static void testViewShowTodolist() {
        addTodolist("SATU");
        addTodolist("DUA");
        addTodolist("TIGA");
        addTodolist("EMPAT");
        addTodolist("LIMA");

        viewShowTodolist();
    }

    public static void viewAddTodolist() {
        System.out.println("Add TODOLIST");
        var todo = inputData("Todo (x to cancel)");

        if (todo.equals("x")) {
            // Cancel
        } else {
            addTodolist(todo);
        }
    }

    public static void testViewAddTodolist() {
        addTodolist("SATU");
        addTodolist("DUA");

        viewAddTodolist();
        showTodolist();
        
    }

    public static void viewRemoveTodolist() {
        System.out.println("Remove TODOLIST");
        var number = inputData("Todo number (x to cancel)");

        if (number.equals("x")) {
            // Cancel
        } else {
            var success = removeTodolist(Integer.valueOf(number));

            if (!success) {
                System.out.println("Failed to delete todolist : " + number);
            }
        }
    }

    public static void testViewRemoveTodolist() {
        addTodolist("SATU");
        addTodolist("DUA");
        addTodolist("TIGA");
        addTodolist("EMPAT");

        showTodolist();
        viewRemoveTodolist();
        showTodolist();
    }
}