package it.unibo.mvc;

import java.util.*;
import java.lang.*;

/**
 *
 */
public interface Controller {
    public void setStringToPrint();

    public String getStringToPrint();

    public List<String> History();

    public void printString() throws IllegalStateException;
}
