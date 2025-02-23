public class SimpleTodolistApp {
    private static String[] todolist = new String[10];

    public static void main(String[] args) {
        testShowTodolist();
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
    public static void addTodolist() {}

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