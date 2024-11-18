package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String str;
    private List<String> history = new ArrayList<>();

    @Override
    public void print() {
        if (str == null) {
            throw new IllegalStateException("Error: The string is unset");
        }
        System.out.println(this.str);
        history.add(this.str);
    }
    @Override
    public List<String> read() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    /** */
    public void setStr(final String str) {
        if (str == null) {
            throw new IllegalArgumentException("Error: the string can't be null");
        }
        this.str = str;
    }

    /** */
    public String getStr() {
        return str;
    }

    /** */
    public List<String> getStringHistory() {
        return List.copyOf(this.history);
    }


}
