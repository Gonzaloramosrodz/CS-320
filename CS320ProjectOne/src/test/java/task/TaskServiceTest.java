package task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Author: Gonzalo Ramos
 * Course: CS 320
 * Project: Project One
 * Date: 4/11/2025
 */

public class TaskServiceTest {

    private TaskService service;

    @BeforeEach
    void initializeServiceBeforeEachTest() {
        service = new TaskService();
    }

    @Test
    void shouldAddTaskSuccessfully() {
        Task task = new Task("T123", "Submit Form", "Complete online form");
        service.addTask(task);
        assertEquals("Submit Form", service.getTask("T123").getName());
    }

    @Test
    void shouldPreventDuplicateTaskId() {
        service.addTask(new Task("T123", "Initial", "Details"));
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(new Task("T123", "Duplicate", "New details"));
        });
    }

    @Test
    void shouldDeleteTaskById() {
        service.addTask(new Task("T123", "Submit", "Task"));
        service.deleteTask("T123");
        assertThrows(IllegalArgumentException.class, () -> service.getTask("T123"));
    }

    @Test
    void shouldUpdateTaskNameOnly() {
        service.addTask(new Task("T123", "Old Name", "Task description"));
        service.updateTaskName("T123", "New Name");
        assertEquals("New Name", service.getTask("T123").getName());
    }

    @Test
    void shouldUpdateTaskDescriptionOnly() {
        service.addTask(new Task("T123", "Task", "Old Description"));
        service.updateTaskDescription("T123", "New updated description");
        assertEquals("New updated description", service.getTask("T123").getDescription());
    }

    @Test
    void shouldFailUpdatingNameForMissingTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskName("MissingID", "Any Name");
        });
    }

    @Test
    void shouldFailDeletingTaskThatDoesNotExist() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("NotFoundID");
        });
    }
}
