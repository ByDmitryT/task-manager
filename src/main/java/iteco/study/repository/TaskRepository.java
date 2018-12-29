package iteco.study.repository;

import iteco.study.api.repository.ITaskRepository;
import iteco.study.entity.Task;
import lombok.Getter;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
public class TaskRepository implements ITaskRepository {

    private final Map<String, Task> tasksMap = new LinkedHashMap<>();

    @Override
    public Task addTask(final Task task) {
        final String taskId = task.getId();
        tasksMap.put(taskId, task);
        return task;
    }

    @Override
    public Task getTaskByOrderIndex(final int taskOrderIndex) {
        final List<Task> tasks = getTasks();
        return tasks.get(taskOrderIndex);
    }

    @Override
    public Task getTaskById(String taskId) {
        return tasksMap.get(taskId);
    }

    @Override
    public Task updateTask(final Task task) {
        tasksMap.put(task.getId(), task);
        return task;
    }

    @Override
    public Task deleteTaskByOrderIndex(final int taskOrderIndex) {
        final Task task = getTaskByOrderIndex(taskOrderIndex);
        return deleteTaskById(task.getId());
    }

    @Override
    public Task deleteTaskById(final String taskId) {
        return tasksMap.remove(taskId);
    }

    @Override
    public boolean isTaskCreated(String taskId) {
        return tasksMap.containsKey(taskId);
    }

    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(tasksMap.values());
    }

    @Override
    public void saveData() throws IOException {
        final File file = new File("task_data");
        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(getTasks());
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public void loadData() throws IOException, ClassNotFoundException {
        final File file = new File("task_data");
        final FileInputStream fileInputStream = new FileInputStream(file);
        final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        final List tasks = (List) objectInputStream.readObject();
        for (final Object task : tasks) {
            if (task instanceof Task) {
                addTask((Task) task);
            }
        }
        objectInputStream.close();
        fileInputStream.close();
    }
}
