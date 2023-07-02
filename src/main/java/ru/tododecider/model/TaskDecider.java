package ru.tododecider.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tododecider.dao.TaskDao;

import java.util.Collections;
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
        return allTasks.peek(); //todo поменять на элемент
    }

    public void addTask(Task t) {
        if(t!=null) {
            allTasks.add(t);
            taskDao.save(t);
        }
    }

    public void executeTopTask(){
        if(!noTasks()) {
            Task t = allTasks.remove();
            taskDao.delete(t.getName());
        }
    }

    public void cancelTopTask(){
        if(!noTasks()) {
            Task t = allTasks.remove();
            taskDao.delete(t.getName());
        }
    }

    public boolean noTasks(){
        return allTasks.isEmpty();
    }

    public void postponeTopTask(){
        if(!noTasks()) {
            Task t = allTasks.remove();
            t.setWaiting(0);
            t.updatePriority();
            incrementAllTasksWaiting();
            allTasks.add(t);
        }
    }

    public void incrementAllTasksWaiting(){
        for (Task t:allTasks) {
            t.setWaiting(t.getWaiting() + 1);
            t.updatePriority();
        }
    }
}
