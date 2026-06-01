import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TaskManager extends JFrame {

    JFrame frame = new JFrame("Task Manager");
    private JPanel panel1;
    private JList taskList;
    private JTextField taskInputTextField;
    private JButton deleteButton;
    private JLabel taskCounterLabel;
    private JButton addButton;

    private DefaultListModel<String> listModel;

    public TaskManager() {
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        listModel = new DefaultListModel<>();
        taskList.setModel(listModel);

        addButton.addActionListener(e -> {
            String text = taskInputTextField.getText();
            if (!text.isEmpty()) {
                listModel.addElement(text);
                taskInputTextField.setText("");
                updateCounter();
            }
        });
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
                updateCounter();
            }
        });

        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    int index = taskList.locationToIndex(e.getPoint());
                    if (index >= 0) {
                        listModel.remove(index);
                        updateCounter();
                    }
                }
            }
        });
    }

    public void updateCounter() {
        taskCounterLabel.setText("Liczba Zadań: " + listModel.getSize());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TaskManager::new);
    }
}
