import java.awt.*;

import javax.swing.*;

import matrix.MatrixViewFloat;

public class Transformationsmatrizen extends JPanel

{
    MatrixViewFloat translation;

    MatrixViewFloat rueck;

    MatrixViewFloat rotation;

    MatrixViewFloat skalierung;

    MatrixViewFloat zentrum;

    MatrixViewFloat gesamt;

    public Transformationsmatrizen()
    {

        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(0, 110));
        setBorder(BorderFactory.createTitledBorder("Transformationsmatrizen "));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        float[][] d =
        {
            { 1, 2, 3, 9 },
            { 4, 5, 5, 9 },
            { 6, 7, 8, 9 },
            { 6, 7, 8, 9 } };

        translation = new MatrixViewFloat(d, "Translation");
        rueck = new MatrixViewFloat(d, "Rück");
        rotation = new MatrixViewFloat(d, "Rotation");
        skalierung = new MatrixViewFloat(d, "Skalierung");
        zentrum = new MatrixViewFloat(d, "Zentrum");
        gesamt = new MatrixViewFloat(d, "Gesamt");
        
        this.add(translation);
        this.add(rueck);
        this.add(rotation);
        this.add(skalierung);
        this.add(zentrum);
        this.add(gesamt);

    }

    public void MatrixUpdateTransformationen(float[][] m_translation, float[][] m_rueck, float[][] m_rotation, float[][] m_skalierung, float[][] m_zentrum, float[][] m_gesamt)
    {
        translation.setMatrix(m_translation);
        rueck.setMatrix(m_rueck);
        rotation.setMatrix(m_rotation);
        skalierung.setMatrix(m_skalierung);
        zentrum.setMatrix(m_zentrum);
        gesamt.setMatrix(m_gesamt);
    }

}
