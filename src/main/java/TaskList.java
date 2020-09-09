import java.util.List;

/**
 * TaskList contains the task list e.g., it has operations to add/delete tasks in the list
 */
public class TaskList {
    private List<Task> tasks;

    TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns search results that contain the search from commands
     * @param commands
     * @return string of search results
     */
    public String getSearchResult(String[] commands) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i);
            if (currentTask.name.contains(commands[1])) {
                stringBuilder.append((i+1) + "." + currentTask.toString() + '\n');
            }
        }
        return stringBuilder.subSequence(0, stringBuilder.length() - 1).toString();
    }

    /**
     * Returns the number of the tasks in the TaskList
     * @return the size of the task list
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Adds a task to the task list
     * @param task
     * @return the task that has been added to the task list
     */
    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    /**
     * Marks a task in the TaskList as done
     * @param commands
     * @return the task that has been marked as done
     * @throws DukeException
     */
    public Task markTaskDone(String[] commands) throws DukeException {
        int index = Parser.getTaskIndex(commands, tasks);
        Task task = tasks.get(index);
        task.markDone();
        return task;
    }

    /**
     * Deletes a task that is in the index specified by the command
     * @param commands
     * @return the deleted task
     * @throws DukeException
     */
    public Task deleteTask(String[] commands) throws DukeException {
        int index = Parser.getTaskIndex(commands, tasks);
        Task task = tasks.remove(index);
        return task;
    }

    /**
     * Gets the tasks
     * @return a List of Tasks
     */
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            stringBuilder.append((i+1) + "."+ tasks.get(i) +"\n");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
