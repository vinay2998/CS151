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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

     final Model data = new Model();

     JButton add = new JButton("Add");
   
     final JTextArea output = new JTextArea();

     output.setBackground(Color.GRAY);
     output.setForeground(Color.white);

     //output.setEditable(false);
     final JTextArea input = new JTextArea();


     JFrame frame = new JFrame();
   
     //add panels to frame
     frame.add(input,BorderLayout.NORTH);
     frame.add(output,BorderLayout.CENTER);
     frame.add(add,BorderLayout.SOUTH);   


     frame.setSize(300, 500);
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

    //action listener
    add.addActionListener(new ActionListener()
    {
            public void actionPerformed(ActionEvent e) {
                data.add(input.getText().trim());
                data.add("\n");
            }
    });
    }
}