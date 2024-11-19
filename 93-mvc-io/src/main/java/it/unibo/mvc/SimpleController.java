package it.unibo.mvc;

import java.io.File;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private static final String PATH=System.getProperty("user.home");
    private static final String DEFAULT_FILE = "output.txt";
    private File file;

    public SimpleController(){
        file = new File(PATH + System.getProperty("file.separator") + DEFAULT_FILE);
    }

    public SimpleController(File file){
        setFile(file);
    }

    public void setFile(final File file){
        if(file.exists())
            this.file=file;
        else
            throw new IllegalArgumentException();
    }

    @Override
    public List<String> History() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getStringToPrint() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void printString() throws IllegalStateException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setStringToPrint() {
        // TODO Auto-generated method stub
        
    }

}
