package Stepic.Tasks.NewRobot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    int x = 0;
    int y = 0;
    JButton calculateNewPoint;
    JButton reset;

    public static void main(String[] args) {
        new GUI().go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        calculateNewPoint = new JButton("Calculate new point");
        calculateNewPoint.addActionListener(new PointListener());

        reset = new JButton("Reset");
        reset.addActionListener(new ResetListener());

        panel.add(new JTextField());
        panel.add(calculateNewPoint);
        panel.add(reset);

        MyDrawPanel myDrawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, myDrawPanel);
        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(1366, 768);
        frame.setVisible(true);

        while (x != 200 && y != 600) {
            x++;
            y--;

            myDrawPanel.repaint();

            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class PointListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            calculateNewPoint.setText("new text");
        }
    }

    class ResetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            reset.setText("new text reset");
        }
    }

    class MyDrawPanel extends JPanel {

        public void paintComponent(Graphics g) {
            g.setColor(Color.black);
            g.drawLine(0,384, 1366, 384);
            g.drawLine(683, 0, 683, 768);

            g.setColor(Color.red);
            g.fillOval((int) (x + 683 - 1.5), (int) (y + 384 - 1.5), 3, 3);
        }
    }
}