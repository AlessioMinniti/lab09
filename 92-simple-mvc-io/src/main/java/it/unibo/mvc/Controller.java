package it.unibo.mvc;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String PATH=System.getProperty("user.home");
    private static final String DEFAULT_FILE = "output.txt";
    private File file;

    public Controller(){
        file = new File(PATH + System.getProperty("file.separator") + DEFAULT_FILE);
    }

    public void setFile(final File file){
        if(file.exists())
            this.file=file;
        else
            throw new IllegalArgumentException();
    }

    public File getFile(){
        return file;
    }

    public String getPath(){
        return PATH;
    }

    public void write(final String str) throws IOException{
        try(final OutputStream output = new FileOutputStream(file.getPath())){
            try(final DataOutputStream dataOutput=new DataOutputStream(output)){
                dataOutput.writeChars(str);
            }
        }
    }
}
