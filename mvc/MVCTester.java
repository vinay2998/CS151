import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class MVCTester {

    public static void main(String[] args) {

     final Model data = new Model();     
     final JTextArea output = new JTextArea();
     final JTextArea input = new JTextArea();

     JButton add = new JButton("Add");
     JFrame frame = new JFrame();
   
     frame.add(output, BorderLayout.NORTH);
     frame.add(input, BorderLayout.CENTER);
     frame.add(add, BorderLayout.SOUTH);

     frame.setSize(500, 500);
     frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
     frame.setVisible(true);


     ChangeListener listener = new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                output.setText(data.toString(data)); 
            }
    };

    data.addChangeListener(listener);
    
    add.addActionListener(new ActionListener()
    {
            public void actionPerformed(ActionEvent e) {
                data.add(input.getText());
                data.add("\n");
            }
    });
    }
}