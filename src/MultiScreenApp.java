import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiScreenApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MultiScreenApp() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create panels for different screens
        JPanel screen1 = createScreen1();
        JPanel screen2 = createScreen2();

        // Add panels to main panel with card layout
        mainPanel.add(screen1, "Screen1");
        mainPanel.add(screen2, "Screen2");
        add(mainPanel);

        // Set up frame
        setTitle("Multi-Screen Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JPanel createScreen1() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("This is Screen 1", JLabel.CENTER);
        JButton button = new JButton("Go to Screen 2");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Screen2");
            }
        });

        panel.add(label, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createScreen2() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("This is Screen 2", JLabel.CENTER);
        JButton button = new JButton("Go to Screen 1");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Screen1");
            }
        });

        panel.add(label, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MultiScreenApp().setVisible(true);
            }
        });
    }
}
