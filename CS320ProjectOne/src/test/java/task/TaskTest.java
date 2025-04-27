package task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Author: Gonzalo Ramos
 * Course: CS 320
 * Project: Project One
 * Date: 4/11/2025
 */

public class TaskTest {

    @Test
    void shouldCreateTaskWithValidValues() {
        Task task = new Task("A123", "My Task", "This is a sample description.");
        assertEquals("A123", task.getTaskId());
        assertEquals("My Task", task.getName());
        assertEquals("This is a sample description.", task.getDescription());
    }

    @Test
    void shouldFailIfTaskIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("TOOLONG12345", "Valid", "Valid description");
        });
    }

    @Test
    void shouldFailIfNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("ID123", "This name is longer than twenty characters", "Desc");
        });
    }

    @Test
    void shouldFailIfDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("ID123", "Name", "This description is way too long and definitely exceeds the fifty character maximum allowed.");
        });
    }

    @Test
    void shouldFailIfTaskIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Name", "Description");
        });
    }

    @Test
    void shouldAllowNameToBeUpdated() {
        Task task = new Task("T001", "Old Name", "Same Description");
        task.setName("Updated Name");
        assertEquals("Updated Name", task.getName());
    }

    @Test
    void shouldAllowDescriptionToBeUpdated() {
        Task task = new Task("T001", "Name", "Old Desc");
        task.setDescription("New Desc");
        assertEquals("New Desc", task.getDescription());
    }
}
