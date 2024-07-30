        JButton completeTaskButton = new JButton("Mark as done");
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
