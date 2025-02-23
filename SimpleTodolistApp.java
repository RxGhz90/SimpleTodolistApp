public class SimpleTodolistApp {
    private static String[] todolist = new String[5];

    public static void main(String[] args) {
        testAddTodolist();
        // testShowTodolist();
    }

    /**
     * Show todolist
     */
    public static void showTodolist() {
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
    public static void removeTodolist() {}


    /**
     * For view each fucntion todolist
     */
    public static void viewShowTodolist() {}

    public static void viewAddTodolist() {}

    public static void viewRemoveTodolist() {}
}