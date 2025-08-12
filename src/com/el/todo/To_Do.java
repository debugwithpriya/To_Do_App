package com.el.todo;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;

	public class To_Do {
	    public static void main(String[] args) {
	        JFrame frame = new JFrame("To-Do List");
	        frame.setSize(400, 300);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLayout(new BorderLayout());

	        JTextField taskField = new JTextField(20);
	        JButton addButton = new JButton("Add");
	        JButton deleteButton = new JButton("Delete");

	        DefaultListModel<String> taskListModel = new DefaultListModel<>();
	        JList<String> taskList = new JList<>(taskListModel);

	        JPanel topPanel = new JPanel();
	        topPanel.setLayout(new FlowLayout());
	        topPanel.add(taskField);
	        topPanel.add(addButton);
	        topPanel.add(deleteButton);

	        frame.add(topPanel, BorderLayout.NORTH);
	        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);

	        addButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String task = taskField.getText().trim();
	                if (!task.isEmpty()) {
	                    taskListModel.addElement(task);
	                    taskField.setText("");
	                }
	            }
	        });

	        deleteButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                int selectedIndex = taskList.getSelectedIndex();
	                if (selectedIndex != -1) {
	                    taskListModel.remove(selectedIndex);
	                }
	            }
	        });

	        frame.setVisible(true);
	    }
	


}
