package ru.tododecider;

import java.util.ArrayList;
import java.util.List;

public class TaskDecider {
    private List<Task> allTasks = new ArrayList<>(); // or queue? or set?

    public Task getTopTask(){
        if(allTasks.isEmpty()) {
            System.out.println("Нет свободных задач");
            return null;
        } else {
            return allTasks.get(0);
        }
    }

    public void addTask(Task t) {
        allTasks.add(t);
    }

    public void executeTopTask(){
        if(!allTasks.isEmpty()) {
            allTasks.remove(0);
        }
    }

    public void cancelTopTask(){
        if(!allTasks.isEmpty()) {
            allTasks.remove(0);
        }
    }

    public void postponeTopTask(){
        if(!allTasks.isEmpty()) {
            Task top = getTopTask();
            allTasks.remove(0);
            allTasks.add(top);
        }
    }

}
