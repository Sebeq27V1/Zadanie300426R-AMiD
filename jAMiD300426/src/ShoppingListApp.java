import javax.swing.*;

public class ShoppingListApp extends JFrame {

    JFrame frame = new JFrame("Shopping list");
    private JTextField itemInput;
    private JPanel panel1;
    private JButton addButton;
    private JList itemslist;
    private JButton deleteButton;
    private DefaultListModel<String> listModel;

    public ShoppingListApp() {
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        listModel = new DefaultListModel<>();
        itemslist.setModel(listModel);

        addButton.addActionListener(e -> {
            String text = itemInput.getText();
            if (!text.isEmpty()) {
                listModel.addElement(text);
                itemInput.setText("");
            }
        });
        deleteButton.addActionListener(e -> {
            int selectedIndex = itemslist.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        });


    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShoppingListApp::new);
    }


}
