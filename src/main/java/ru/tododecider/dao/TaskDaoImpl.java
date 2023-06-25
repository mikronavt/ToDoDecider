package ru.tododecider.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.tododecider.model.Task;

import java.util.List;

@Component
public class TaskDaoImpl implements TaskDao{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Task task) {
        jdbcTemplate.update("INSERT INTO Task VALUES(?)",
                task.getName());
    }

    @Override
    public void delete(String name) {
        jdbcTemplate.update("DELETE FROM Task WHERE name=?", name);
    }

    @Override
    public List<Task> getAllTasks() {
        return jdbcTemplate.query("SELECT * FROM Task", new BeanPropertyRowMapper<>(Task.class));
    }
}
