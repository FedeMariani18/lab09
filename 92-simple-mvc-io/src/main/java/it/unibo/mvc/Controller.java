package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String DEFAULT_PATH = System.getProperty("user.home")
            + File.separator
            + "output.txt";

    private File file =  new File(DEFAULT_PATH);

    /**
     * Set the current file of the class to f.
     * 
     * @param f 
     *          file where to write
     */
    public void setCurrentFile(final File f) {
        this.file = f;
    }

    /**
     * Set the current file of the class to f.
     * 
     * @param fileName 
     *          String name of the file where to write 
     */
    public void setCurrentFile(final String fileName) {
        setCurrentFile(new File(fileName));
    }

    /** 
     * @return the current file handled by the class
    */
    public File getFile() {
        return this.file;
    }

    /** 
     * @return the path of the file in a string
    */
    public String getFilePath() {
        return this.file.getPath();
    }

    /** 
     * Write some text on the current file.
     * 
     * @param input
    *              the text to write on the file
    */
    public void write(final String input) {
        try (PrintStream ps = new PrintStream(this.getFilePath(), StandardCharsets.UTF_8)) {
            ps.println(input);
        } catch (IOException e) {
            System.out.println(e.getMessage()); //NOPMD: simpliest way to handle an error
        }
    }
}
