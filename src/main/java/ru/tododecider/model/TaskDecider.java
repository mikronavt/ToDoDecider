package ru.tododecider.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tododecider.dao.TaskDao;

import java.util.PriorityQueue;
import java.util.Queue;

@Component
public class TaskDecider {
    private final TaskDao taskDao;
    private Queue<Task> allTasks;
    @Autowired
    public TaskDecider(TaskDao taskDao){
        this.taskDao = taskDao;
        initAllTasks();
    }

    private void initAllTasks(){
        if(allTasks == null || allTasks.isEmpty()) {
            allTasks = new PriorityQueue<>(taskDao.getAllTasks());
        }
    }


    public Task getTopTask(){
        initAllTasks();
        return allTasks.peek();
    }

    public void addTask(Task t) {
        allTasks.add(t);
        taskDao.save(t);
    }

    public void executeTopTask(){
        Task t = allTasks.poll();
        taskDao.delete(t.getName());
    }

    public void cancelTopTask(){
        Task t = allTasks.poll();
        taskDao.delete(t.getName());
    }

    public boolean noTasks(){
        initAllTasks();
        return allTasks.isEmpty();
    }

    public void postponeTopTask(){
        if(!noTasks()) {
            allTasks.add(allTasks.poll());
        }
    }

}
