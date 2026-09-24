package edu.hbuas.campustodo.service;

import edu.hbuas.campustodo.model.Priority;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskServicePriorityTest {

    @Test
    void shouldAssignDefaultMediumPriority() {
        TaskService service = new TaskService();

        var task = service.addTask("完成需求评审");

        assertEquals(Priority.MEDIUM, task.getPriority());
    }

    @Test
    void shouldFilterTasksByPriority() {
        TaskService service = new TaskService();
        service.addTask("高优先级任务", Priority.HIGH);
        service.addTask("普通任务", Priority.MEDIUM);
        service.addTask("低优先级任务", Priority.LOW);

        var high = service.filterByPriority(Priority.HIGH);

        assertEquals(1, high.size());
        assertEquals("高优先级任务", high.get(0).getTitle());
    }

    @Test
    void shouldReturnEmptyListWhenNoTaskMatches() {
        TaskService service = new TaskService();
        service.addTask("普通任务", Priority.MEDIUM);

        var result = service.filterByPriority(Priority.HIGH);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldRejectNullPriorityWhenFiltering() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class,
                () -> service.filterByPriority(null));
    }
}
