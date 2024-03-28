package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.table.DefaultTableModel;

public class ResizableJFrame extends JFrame {
    private JPanel mainPanel;
    private double widthRatio = 0.5; // Tỉ lệ chiều rộng
    private double heightRatio = 0.5; // Tỉ lệ chiều cao
    private JTable table;

    public ResizableJFrame() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        getContentPane().add(mainPanel);
        mainPanel.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 11, 616, 306);
        mainPanel.add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
        	}
        ));
        scrollPane.setViewportView(table);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                resizeComponents();
            }
        });
    }


    private void resizeComponents() {
        Component[] components = mainPanel.getComponents();
        Dimension newSize = mainPanel.getSize();
        for (Component component : components) {
            Dimension preferredSize = component.getPreferredSize();
            component.setSize((int) (newSize.width * widthRatio), (int) (newSize.height * heightRatio));
            component.setPreferredSize(new Dimension((int) (newSize.width * widthRatio), (int) (newSize.height * heightRatio)));
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ResizableJFrame frame = new ResizableJFrame();
            frame.setSize(600, 400); // Kích thước ban đầu của JFrame
            frame.setVisible(true);
        });
    }
}
