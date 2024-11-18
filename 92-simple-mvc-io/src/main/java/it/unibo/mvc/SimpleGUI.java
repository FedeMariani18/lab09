package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 4;
    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    /** */
    public SimpleGUI() {
        final JPanel canvas = new JPanel(new BorderLayout());
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextArea txtArea = new JTextArea();
        final JButton save = new JButton("Save");
        canvas.add(txtArea, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);

        /*
         * handler
         */
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.write(txtArea.getText());
            }
        });
    } 

    /** */
    public void build() {
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
        new SimpleGUI().build();
    }

}
