import java.util.Scanner;

public class Main {

    public static String[] todo = new String[10];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ViewHome();
    }

    public static void ShowTodo() {
        System.out.println("TODOLIST");
        for (int i = 0; i < todo.length; i++) {
            var temp = todo[i];
            var no = i + 1;

            if (temp != null) {
                System.out.println(no + ". " + temp);
            }
        }
    }

//    public static void testShowTodo() {
//        todo[0] = "Satu";
//        todo[1] = "dua";
//        ShowTodo();
//    }

    public static void AddTodo(String add) {
        var isFull = true;
        //mengecek apakah full?
        for (int i = 0; i < todo.length; i++) {
            if (todo[i] == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            var temp = todo;
            todo = new String[todo.length * 2];

            for (int i = 0; i < temp.length; i++) {
                todo[i] = temp[i];
            }
        }


        //tambahkan posisi data ke array null
        for (int i = 0; i < todo.length; i++) {
            if (todo[i] == null) {
                todo[i] = add;
                break;
            }
        }
    }

//    public static void testAddTodo() {
//        for (int i = 0; i <= 29; i++) {
//            AddTodo("Coba" + (i + 1));
//        }
//        ShowTodo();
//    }

    public static boolean RemoveTodo(Integer number) {
        if ((number - 1) >= todo.length) {
            return false;
        } else if (todo[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < todo.length; i++) {
                if (i == (todo.length - 1)) {
                    todo[i] = null;
                } else {
                    todo[i] = todo[i + 1];
                }
            }
            return true;
        }
    }

//    public static void testRemoveTodo() {
//        for (int i = 0; i <= 5; i++) {
//            AddTodo("Coba" + (i + 1));
//        }
//        ShowTodo();
//        var result = RemoveTodo(20);
//        System.out.println(result);
//
//        ShowTodo();
//    }

    public static String input(String info) {
        System.out.print(info + ": ");
        String data = scanner.nextLine();
        return data;
    }

    public static void ViewHome() {
        while (true) {
            ShowTodo();

            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");
            var input = input("Pilih");
            if (input.equals("1")) {
                ViewAdd();
            } else if (input.equals("2")) {
                viewRemove();
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }

    }

//    public static void testViewHome() {
//        for (int i = 0; i <= 5; i++) {
//            AddTodo("Coba" + (i + 1));
//        }
//        ViewHome();
//    }

    public static void ViewAdd() {
        System.out.println("Menammbah TODO lIST");
        var input = input("Tambah (x jika batal) ");

        if (input.equals("x") || input.equals("X")) {
//            batal
        } else {
            AddTodo(input);
        }
    }

//    public static void testViewAdd() {
//        ViewAdd();
//        ShowTodo();
//    }

    public static void viewRemove() {
        System.out.println("Menghapus TODO LIST");
        var number = input("Hapus (x jika batal) ");

        if (number.equals("x") || number.equals("X")) {
//            batal
        } else {
            boolean success = RemoveTodo(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus list ke - " + number);
            }
        }
    }

//    public static void testViewRemove() {
//        for (int i = 0; i <= 5; i++) {
//            AddTodo("Coba" + (i + 1));
//        }
//        ShowTodo();
//        viewRemove();
//        ShowTodo();
//    }
}
