package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

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
     * @param f
     */
    public void setCurrentFile(final File f) {
        this.file = f;
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
     * @param input
    */
    public void write(final String input) {
        try (PrintStream ps = new PrintStream(this.file)) {
            ps.println(input);
        } catch (IOException e) {
            System.out.println(e.getMessage()); //NOPMD: simpliest way to handle an error
        }
    }
}
