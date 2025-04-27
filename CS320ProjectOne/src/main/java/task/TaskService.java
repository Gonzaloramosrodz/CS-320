package task;

/**
 * Author: Gonzalo Ramos
 * Course: CS 320
 * Project: Project One
 * Date: 4/11/2025
 */

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> taskMap = new HashMap<>();

    public void addTask(Task task) {
        if (taskMap.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate Task ID");
        }
        taskMap.put(task.getTaskId(), task);
    }

    public void deleteTask(String taskId) {
        if (!taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("Task not found");
        }
        taskMap.remove(taskId);
    }

    public void updateTaskName(String taskId, String name) {
        Task task = getTask(taskId);
        task.setName(name);
    }

    public void updateTaskDescription(String taskId, String description) {
        Task task = getTask(taskId);
        task.setDescription(description);
    }

    public Task getTask(String taskId) {
        Task task = taskMap.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task not found");
        }
        return task;
    }
}
