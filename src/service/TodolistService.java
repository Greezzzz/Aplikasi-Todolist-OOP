package service;

public interface TodolistService {

    void showTodoList();
    void addTodoList(String todo);
    void removeTodolist(Integer number);
    void checkListTodoList(Integer number);
}
