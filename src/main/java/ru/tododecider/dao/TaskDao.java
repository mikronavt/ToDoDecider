package ru.tododecider.dao;

import ru.tododecider.model.Task;

import java.util.List;

public interface TaskDao {
    public void save(Task task);
    public void delete(String name);
    public List<Task> getAllTasks();
}
