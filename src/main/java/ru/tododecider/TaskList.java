package ru.tododecider;

import java.util.List;

public class TaskList {
    private List<Task> allTasks; // or queue? or set?

    public Task getTopTask(){
        if(allTasks == null || allTasks.isEmpty()) {
            System.out.println("Нет свободных задач");
            return null;
        } else {
            return allTasks.get(0);
        }
    }
}
