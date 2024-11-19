package it.unibo.mvc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final String TITLE="SIMPLE GUI";
    private final JFrame frame = new JFrame(TITLE);

    public SimpleGUI(final Controller controller){
        try{
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            JTextArea textArea = new JTextArea();
            JButton button = new JButton("Save");
            panel.add(textArea);
            panel.add(button,BorderLayout.SOUTH);
            frame.setContentPane(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e){
                    try{
                        controller.write(textArea.getText());
                    }catch(Exception io){
                        System.out.println("can't write this");
                    }
                }
            });
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String... args){
        try{
            final SimpleGUI s = new SimpleGUI(new Controller());
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
