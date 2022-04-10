package test.view;

import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;
import view.TodolistView;

public class TodolistViewTest {
    public static void main(String[] args) {
        TestTodolistView();
    }


    public static void TestTodolistView() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);
        todolistService.addTodoList("Belajar Java Dasar");
        todolistService.addTodoList("Belajar Java OOP");
        todolistService.addTodoList("Belajar Java Classes");

        todolistView.showTodolist();
    }
}
