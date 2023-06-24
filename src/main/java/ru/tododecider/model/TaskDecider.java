package ru.tododecider.model;

import org.springframework.stereotype.Component;

import java.util.PriorityQueue;
import java.util.Queue;

@Component
public class TaskDecider {
    private Queue<Task> allTasks = new PriorityQueue<>(); // or queue? or set?


    public Task getTopTask(){
        return allTasks.peek();
    }

    public void addTask(Task t) {
        allTasks.add(t);
    }

    public void executeTopTask(){
        allTasks.poll();
    }

    public void cancelTopTask(){
        allTasks.poll();
    }

    public void postponeTopTask(){
        if(!allTasks.isEmpty()) {
            Task top = getTopTask();
            allTasks.poll();
            allTasks.add(top);
        }
    }

}
