package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 4;
    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    /** */
    public SimpleGUIWithFileChooser() {
        final JPanel canvas = new JPanel(new BorderLayout());
        final JPanel topCanvas = new JPanel(new BorderLayout());
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextArea txtArea = new JTextArea();
        final JButton save = new JButton("Save");
        final JButton browse = new JButton("Browse...");
        final JTextField txtField = new JTextField(controller.getFilePath());
        txtField.setEditable(false);
        canvas.add(txtArea, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);
        canvas.add(topCanvas, BorderLayout.NORTH);
        topCanvas.add(txtField, BorderLayout.CENTER);
        topCanvas.add(browse, BorderLayout.LINE_END);

        /*
         * handler
         */
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.write(txtArea.getText());
                txtArea.insert("", 0);
            }
        });

        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fChooser = new JFileChooser();
                final var res = fChooser.showSaveDialog(frame);
                if (res == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrentFile(fChooser.getSelectedFile());
                    txtField.setText(controller.getFilePath());
                } else if (res != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(frame, "An error has occured during the choose of the file");
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
        new SimpleGUIWithFileChooser().display();
    }
}
