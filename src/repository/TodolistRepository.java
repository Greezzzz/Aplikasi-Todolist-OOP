package repository;

import entity.Todolist;

public interface TodolistRepository {

    Todolist[] getAll();

    void add(Todolist todolist);

    boolean remove(Integer number);

    boolean checkList(Integer num);
}
