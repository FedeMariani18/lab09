package it.unibo.mvc;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private SimpleController controller = new SimpleController();

    /** */
    public SimpleGUI() {
        final JPanel canvas = new JPanel(new BorderLayout());
        final JPanel buttonCanvas = new JPanel(new FlowLayout(FlowLayout.CENTER));
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextArea txtArea = new JTextArea();
        final JButton print = new JButton("Print");
        final JButton history = new JButton("Show history");
        final JTextField txtField = new JTextField();
        canvas.add(txtArea, BorderLayout.CENTER);
        canvas.add(txtField, BorderLayout.NORTH);
        canvas.add(buttonCanvas, BorderLayout.SOUTH);
        buttonCanvas.add(print);
        buttonCanvas.add(history);

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setStr(txtField.getText());
                controller.print();
            }
        });

        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                txtArea.setText(null);
                for (String s: controller.getStringHistory()) {
                    txtArea.append(s + "\n");
                }
            }
        });
    }

    /** */
    public void display() {
        /*
         * Resize the page
        */
        frame.pack();

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);

        frame.setLocationByPlatform(true);
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
    }

    /** 
     * @param args
    */
    public static void main(final String... args) {
        new SimpleGUI().display();
    }
}
