import java.awt.*;
import javax.swing.*;

import matrix.MatrixView;
import matrix.MatrixViewFloat;

public class Drehmatrizen extends JPanel
{
    MatrixViewFloat alpha;

    MatrixViewFloat beta;

    MatrixViewFloat gamma;

    public Drehmatrizen()
    {
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(200, 0));
        setBorder(BorderFactory.createTitledBorder("Zeichenfläche "));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        float[][] d =
        {
            { 1, 2, 3, 9 },
            { 4, 5, 5, 9 },
            { 6, 7, 8, 9 },
            { 6, 7, 8, 9 } };

        alpha = new MatrixViewFloat(d, "Alpha");
        beta = new MatrixViewFloat(d, "Beta");
        gamma = new MatrixViewFloat(d, "Gamma");

        this.add(alpha);
        this.add(beta);
        this.add(gamma);

    }

    public void MatrixUpdateDrehmatrizen(float[][] m_alpha, float[][] m_beta, float[][] m_gamma)
    {
        alpha.setMatrix(m_alpha);
        beta.setMatrix(m_beta);
        gamma.setMatrix(m_gamma);

    }

}
