package view;

import Util.inputUtil;
import service.TodolistService;

public class TodolistView {

    private final TodolistService todolistService;

    public TodolistView(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    public void showTodolist() {
        while (true) {
            todolistService.showTodoList();

            System.out.println("MENU");
            System.out.println("1. Checklist");
            System.out.println("2. Tambah");
            System.out.println("3. Hapus");
            System.out.println("4. Keluar");
            var input =inputUtil.input("Pilih");
            if (input.equals("1")){
                checkList();
            } else if (input.equals("2")) {
                addTodolist();
            } else if (input.equals("3")) {
                removeTodolist();
            } else if (input.equals("4")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public void checkList(){
        System.out.println("Checklist TODO LIST");
        var input = inputUtil.input("Tambah (x jika batal) ");

        if (input.equals("x") || input.equals("X")) {
//            batal
        } else {
            todolistService.checkListTodoList(Integer.valueOf(input));
        }
    }

    public void addTodolist() {
        System.out.println("Menammbah TODO lIST");
        var input = inputUtil.input("Tambah (x jika batal) ");

        if (input.equals("x") || input.equals("X")) {
//            batal
        } else {
            todolistService.addTodoList(input);
        }
    }

    public void removeTodolist() {
        System.out.println("Menghapus TODO LIST");
        var number = inputUtil.input("Hapus (x jika batal) ");

        if (number.equals("x") || number.equals("X")) {
//            batal
        } else {
            todolistService.removeTodolist(Integer.valueOf(number));
        }
    }
}
