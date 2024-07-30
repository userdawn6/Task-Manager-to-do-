import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TaskTable extends AbstractTableModel {
    private final String[] columnNames = {"Title", "Description", "Deadline", "Done"};
    private List<Task> tasks;

    public TaskTable(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Task task = tasks.get(rowIndex);
        switch (columnIndex) {
            case 0: return task.getTitle();
            case 1: return task.getDescription();
            case 2: return task.getDeadline();
            case 3: return task.isCompleted();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}