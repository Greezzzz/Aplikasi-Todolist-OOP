package test.service;

import entity.Todolist;
import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;
import view.TodolistView;

public class TodolistServiceTest {
    public static void main(String[] args) {

        TestCheckList();
    }

    public static void TestShowTodolist() {
        TodolistRepositoryImpl todolistRepository = new TodolistRepositoryImpl();
        todolistRepository.data[0] = new Todolist("Belajar java dasar");
        todolistRepository.data[1] = new Todolist("Belajar java OOP");
        todolistRepository.data[2] = new Todolist("Belajar java Classes");

        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

        todolistService.showTodoList();

    }

    public static void TestAddTodolist() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        todolistService.addTodoList("Belajar Java Dasar");
        todolistService.addTodoList("Belajar Java OOP");
        todolistService.addTodoList("Belajar Java Classes");

        todolistService.showTodoList();
    }

    public static void TestRemoveTodolist() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        todolistService.addTodoList("Belajar Java Dasar");
        todolistService.addTodoList("Belajar Java OOP");
        todolistService.addTodoList("Belajar Java Classes");
        todolistService.showTodoList();
        todolistService.removeTodolist(6);
        todolistService.removeTodolist(2);
        todolistService.showTodoList();
    }

    public static void TestCheckList() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        todolistService.addTodoList("Belajar Java Dasar");
        todolistService.addTodoList("Belajar Java OOP");
        todolistService.addTodoList("Belajar Java Classes");
        todolistService.showTodoList();
        todolistService.checkListTodoList(3);
        todolistService.showTodoList();
    }

}
