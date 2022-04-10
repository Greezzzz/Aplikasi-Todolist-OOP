package service;

import entity.Todolist;
import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;

public class TodolistServiceImpl implements TodolistService {
    private final TodolistRepository todolistRepository;

    public TodolistServiceImpl(TodolistRepository todolistRepository) {

        this.todolistRepository = todolistRepository;
    }

    @Override
    public void showTodoList() {
        Todolist[] todo = todolistRepository.getAll();
        System.out.println("TODOLIST");
        for (int i = 0; i < todo.length; i++) {
            var temp = todo[i];
            var no = i + 1;

            if (temp != null) {
                System.out.println(no + ". " + temp.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        Todolist todolist = new Todolist(todo);
        todolistRepository.add(todolist);
        System.out.println("SUKSES MENAMBAH TODO : " + todo);
    }

    @Override
    public void removeTodolist(Integer number) {
        boolean success = todolistRepository.remove(number);
        if (success) {
            System.out.println("SUKSES MENGHAPUS TODO : " + number);
        } else {
            System.out.println("GAGAL MENGHAPUS TODO : " + number);
        }
    }

    @Override
    public void checkListTodoList(Integer number) {
        boolean success = todolistRepository.checkList(number);
        if (success) {
            System.out.println("SELESAI : " + number);
        } else {
            System.out.println("TIDAK ADA LIST : " + number);
        }
    }
}
