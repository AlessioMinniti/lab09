package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    @SuppressWarnings("Convert2Lambda")
    public SimpleGUI(SimpleController controller){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.LINE_AXIS));
        JTextField textField= new JTextField();
        panel.add(textField,BorderLayout.NORTH);
        JTextArea textArea = new JTextArea();
        panel.add(textArea,BorderLayout.CENTER);
        JButton print = new JButton("Print");
        JButton history = new JButton("Show History");
        newPanel.add(print);
        newPanel.add(history);
        panel.add(newPanel,BorderLayout.SOUTH);
        frame.setContentPane(panel);

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.setStringToPrint(textField.getText());
                controller.printString();
            }
        });

        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                for(String s : controller.History()){
                    textArea.append(s+"\n");
                }
            }
        });
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
