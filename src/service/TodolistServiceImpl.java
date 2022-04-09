package service;

import entity.Todolist;
import repository.TodolistRepository;

public class TodolistServiceImpl implements TodolistService {
    private TodolistRepository todolistRepository;

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
                System.out.println(no + ". " + temp);
            }
        }
    }

    @Override
    public void addTodoList(String todo) {

    }

    @Override
    public void removeTodolist(Integer number) {

    }
}
