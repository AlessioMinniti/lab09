package it.unibo.mvc;

import javax.swing.JFrame;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    public SimpleGUI(SimpleController controller){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String... args){
        try{
            final SimpleGUI s = new SimpleGUI(new SimpleController());
            s.display();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void display(){
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }
}
