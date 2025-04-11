import javax.swing.*;



import java.awt.*;

public class Controller extends JPanel
{
    DrawingPanel pl;
    
    public Controller(DrawingPanel pl)
    {
        this.pl = pl;
        setBackground(Color.LIGHT_GRAY);
        setMaximumSize(null);
        setPreferredSize(new Dimension(200,0));
        setBorder(BorderFactory.createTitledBorder("Controller "));
        
        this.add(new ComplexSlider(" X-Rotation", -360, 360, 0, 400, pl::updateXRotation));
        this.add(new ComplexSlider(" Z-Rotation", -360, 360, 0, 400, pl::updateZRotation));
        this.add(new ComplexSlider(" Y-Rotation", -360, 360, 0, 400, pl::updateYRotation));
        this.add(new ComplexSlider(" Skalierung",    0,  10, 1,  10, pl::updateSkalierung));
        this.add(new ComplexSlider(" X-Trans", 0, 1900, 0, 900, pl::updateXTranslation));
        this.add(new ComplexSlider(" Y-Trans", 0, 1900, 0, 900, pl::updateYTranslation));
        this.add(new ComplexSlider(" Z-Trans", 0, 1900, 0, 900, pl::updateZTranslation));
        this.add(new ComplexSlider(" X-Zentrum", -500, 500, 0, 600, pl::updateXZentrum));
        this.add(new ComplexSlider(" Y-Zentrum", -500, 500, 0, 600, pl::updateYZentrum));
        this.add(new ComplexSlider(" Z-Zentrum", -500, 500, 0, 600, pl::updateZZentrum));
        
      
    }
}
