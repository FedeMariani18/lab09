package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller<String> {

    private String str;
    private final List<String> history = new ArrayList<>();

    @Override
    public void print() {
        if (str == null) {
            throw new IllegalStateException("Error: The string is unset");
        }
        System.out.println(this.str);   //NOPMD requested by the exercise
        history.add(this.str);
    }

    @Override
    public void read(final String input) {
        setStr(input);
    }

    /** 
     * Set the next string to print.
     * 
     * @param str
     *          the string to set
    */
    public void setStr(final String str) {
        if (str == null) {
            throw new IllegalArgumentException("Error: the string can't be null");
        }
        this.str = str;
    }

    /** 
     * @return the last string managed.
    */
    public String getStr() {
        return this.str;
    }

    /**
     * @return the history of all the string printed in a list of string.
     */
    public List<String> getStringHistory() {
        return List.copyOf(this.history);
    }
}
