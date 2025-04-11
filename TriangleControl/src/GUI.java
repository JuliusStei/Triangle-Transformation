import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import matrix.MatrixViewFloat;

public class GUI
{

    public GUI()
    {
        JFrame frame = new JFrame("Einführung Computergrafik");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(1200, 1600);
       
      
        frame.setLocation(100, 100);
        frame.setLayout(new BorderLayout());

        Drehmatrizen drehPanel = new Drehmatrizen();
        frame.add(drehPanel, BorderLayout.WEST);

        Transformationsmatrizen transPanel = new Transformationsmatrizen();
        frame.add(transPanel, BorderLayout.NORTH);

        DrawingPanel drawPanel = new DrawingPanel(transPanel, drehPanel); 
        
        Zeichenflaeche z = new Zeichenflaeche(transPanel,drehPanel);
               

        
        z.add(drawPanel);
        frame.add(z, BorderLayout.CENTER);

        
        Controller controllerPanel = new Controller(drawPanel);
        frame.add(controllerPanel, BorderLayout.EAST);

        
        frame.setVisible(true);
    }

}
