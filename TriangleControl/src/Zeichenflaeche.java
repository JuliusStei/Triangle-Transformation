import java.awt.*;
import javax.swing.*;

public class Zeichenflaeche extends JPanel
{
    Transformationsmatrizen t;
    Drehmatrizen d;
    
    public Zeichenflaeche(Transformationsmatrizen t, Drehmatrizen d)
    {
        this.t = t;
        this.d = d;
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createTitledBorder("Drehmatrizen "));
        
        
        
    }
}
