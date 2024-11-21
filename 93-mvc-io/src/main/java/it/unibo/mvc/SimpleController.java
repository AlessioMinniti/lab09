package it.unibo.mvc;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private static final String PATH=System.getProperty("user.home");
    private static final String DEFAULT_FILE = "output.txt";
    private File file;
    private List<String> stringsToPrint;

    public SimpleController(){
        file = new File(PATH + System.getProperty("file.separator") + DEFAULT_FILE);
        stringsToPrint=new LinkedList<>();
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
        return stringsToPrint;
    }

    @Override
    public String getStringToPrint() {
        // TODO Auto-generated method stub
        return stringsToPrint.getLast();
    }

    @Override
    public void printString() throws IllegalStateException {
        // TODO Auto-generated method stub
        try(OutputStream output = new FileOutputStream(file);
            DataOutputStream data=new DataOutputStream(output)) {
            data.writeChars(stringsToPrint.getLast());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void setStringToPrint(String str) throws NullPointerException{
        // TODO Auto-generated method stub
        stringsToPrint.add(str);
    }

}
