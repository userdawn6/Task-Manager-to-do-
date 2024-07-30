import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UI extends JFrame {
    private List<Task> tasks = new ArrayList<>();
    private JTable taskTable;
    private TaskTable table;


    public UI() {
        setTitle("Task manager(to-do)");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            tasks = FileManager.loadTasks();
        } catch (IOException e) {
            e.printStackTrace();
        }

        table = new TaskTable(tasks);
        taskTable = new JTable(table);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(taskTable), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(3, 1));
        JTextField titleField = new JTextField();
        JTextField descriptionField = new JTextField();
        JTextField deadlineField = new JTextField();
        inputPanel.add(new JLabel("Task name:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("About task:"));
        inputPanel.add(descriptionField);
        inputPanel.add(new JLabel("Deadline:"));
        inputPanel.add(deadlineField);


        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.setBackground(new Color(255, 165, 0)); // Orange background
        addTaskButton.setForeground(new Color(0, 0, 0));
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String description = descriptionField.getText();
                String deadline = deadlineField.getText();
                Task task = new Task(title, description, deadline);
                tasks.add(task);
                table.fireTableDataChanged();
                try {
                    FileManager.saveTasks(tasks);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton deleteTaskButton = new JButton("Delete Task");
        deleteTaskButton.setBackground(new Color(255, 165, 0)); // Orange background
        deleteTaskButton.setForeground(new Color(0, 0, 0));
        deleteTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = taskTable.getSelectedRow();
                if (selectedRow >= 0) {
                    tasks.remove(selectedRow);
                    table.fireTableRowsDeleted(selectedRow, selectedRow);
                    try {
                        FileManager.saveTasks(tasks);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });        JButton completeTaskButton = new JButton("Mark as done");
        completeTaskButton.setBackground(new Color(255, 165, 0)); // Orange background
        completeTaskButton.setForeground(new Color(0, 0, 0));
        completeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = taskTable.getSelectedRow();
                if (selectedRow >= 0) {
                    Task task = tasks.get(selectedRow);
                    task.setCompleted(true);
                    table.fireTableRowsUpdated(selectedRow, selectedRow);
                    try {
                        FileManager.saveTasks(tasks);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addTaskButton);
        buttonPanel.add(deleteTaskButton);
        buttonPanel.add(completeTaskButton);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        add(panel);
        /*.setVisible(true);*/
    }
}
