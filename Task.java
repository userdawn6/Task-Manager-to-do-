public class Task {
    private String title;
    private String description;
    private String deadline;
    private boolean isCompleted;

    public Task(String title, String description, String deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.isCompleted = false;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDeadline() { return deadline; }
    public void setDeadline(String deadline) { this.deadline = deadline; }

    public boolean isCompleted() { return isCompleted; }
    public void setCompleted(boolean completed) { isCompleted = completed; }

    @Override
    public String toString() {
        return title + "," + description + "," + deadline + "," + isCompleted;
    }

    public static Task fromString(String taskString) {
        String[] parts = taskString.split(",");
        Task task = new Task(parts[0], parts[1], parts[2]);
        task.setCompleted(Boolean.parseBoolean(parts[3]));
        return task;
    }
}