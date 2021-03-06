package repository;

import entity.Todolist;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

public class TodolistRepositoryImpl implements TodolistRepository {
    public Todolist[] data = new Todolist[10];

    @Override
    public Todolist[] getAll() {
        return data;
    }

    public boolean isFull() {
        var isFull = true;
        //mengecek apakah full?
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIsFull() {
        if (isFull()) {
            var temp = data;
            data = new Todolist[data.length * 2];

            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void add(Todolist todolist) {
        resizeIsFull();
        //tambahkan posisi data ke array null
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todolist;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer number) {
        if ((number - 1) >= data.length) {
            return false;
        } else if (data[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }

    public String encode(String encode){
        String base = Base64.getEncoder().encodeToString(encode.getBytes());
        return base;
    }

    public void writeFile(String write) {
        try {
            FileWriter writer = new FileWriter("src/Data/History.txt",true);
            writer.write(encode(write)+"\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }
    @Override
    public boolean checkList(Integer num) {
        if ((num - 1) >= data.length) {
            return false;
        } else if (data[num - 1] == null) {
            return false;
        } else {
            writeFile(String.valueOf(data[num-1].getTodo()));
            for (int i = (num - 1); i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
}
