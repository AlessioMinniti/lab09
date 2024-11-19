package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private static final String TITLE="SIMPLE GUI WITH FILE CHOOSER";
    private final JFrame frame = new JFrame(TITLE);
    
    public SimpleGUIWithFileChooser(Controller controller){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JTextField field = new JTextField(controller.getPath());
        field.setEditable(false);
        JTextArea textArea = new JTextArea();
        JButton browse = new JButton("Browse...");
        JButton save = new JButton("Save");
        JPanel innerPanel=new JPanel();
        innerPanel.setLayout(new BorderLayout());
        innerPanel.add(field, BorderLayout.CENTER);
        innerPanel.add(browse, BorderLayout.EAST);
        panel.add(textArea);
        panel.add(save,BorderLayout.SOUTH);
        panel.add(innerPanel,BorderLayout.NORTH);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JFileChooser fileChooser = new JFileChooser();
                int val = fileChooser.showSaveDialog(innerPanel);

                if(val == JFileChooser.APPROVE_OPTION){
                    controller.setFile(fileChooser.getSelectedFile());
                    field.setText(controller.getPath());
                }
                else if(val != JFileChooser.CANCEL_OPTION){
                    JOptionPane.showMessageDialog(frame,new Exception(),"error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e){
                try{
                    controller.write(textArea.getText());
                }catch(Exception io){
                    System.out.println("can't write this");
                }
            }
        });
    }

    public void display(){
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String... args){
        try{
            final SimpleGUIWithFileChooser s = new SimpleGUIWithFileChooser(new Controller());
            s.display();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
