import matrix.*;
import javax.swing.*;



import java.awt.*;

public class DrawingPanel extends JPanel
{
    Transformationsmatrizen t;

    Drehmatrizen d;

    private static final int RADIUS = 5;
    
    private float[] p0 = 
                {0,0,0,1};

    private float[] p1 = // BLUE
    { 0, 150, 0, 1 };

    private float[] p2 = // RED
    { 150, 0, 0, 1 };

    private float[] p3 = // YELLOW
    { 0, 0, 150, 1 };

    private float[] p4 = // GREEN
    { 150, 150, 150, 1 };

    public static float[][] x_rotation_;

    public float[][] z_rotation_;

    public float[][] y_rotation_;
    
    public float[][] rotation;

    public float[][] skalierung;

    public float[][] translation;

    public float[][] t_ges;
    
    public float[][] rueck;
    
    public float[][] zentrum;

    public DrawingPanel(Transformationsmatrizen t, Drehmatrizen d)
    {
        this.t = t;
        this.d = d;

       setBackground(Color.WHITE);
       
        z_rotation_ = new float[4][4];
        x_rotation_ = new float[4][4];
        y_rotation_ = new float[4][4];
        skalierung = new float[4][4];
        translation = new float[4][4];
        rueck = new float[4][4];
        zentrum = new float[4][4];

        for (int i = 0; i < 4; ++i)
        {
            x_rotation_[i][i] = 1.0F;
            z_rotation_[i][i] = 1.0F;
            y_rotation_[i][i] = 1.0F;
            skalierung[i][i] = 1.0F;
            translation[i][i] = 1.0F;
            rueck[i][i] = 1.0F;
            zentrum[i][i] = 1.0F;
        }

    }

    @Override
    protected void paintComponent(Graphics g)
    {
        float[][] t_1 =
                    {
                        { 1,0,0,0},
                        { 0,1,0,0 },
                        { 0,0,1,0 },
                        { 0,0,0,1} };
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set the draw color to black

        // Translate the origin to the center of the drawing panel
        g2d.translate(getSize().width / 2, getSize().height / 2);
        // And invert the y axis
        g2d.scale(1, -1);

        // Calculate the complete transformation matrix here
   
        //Berechnung
        t_1=  Matrix.matMult(t_1, translation);
        t_1 = Matrix.matMult(t_1, rueck);
        t_1 = Matrix.matMult(t_1, x_rotation_);
        t_1 = Matrix.matMult(t_1, z_rotation_);
        t_1 = Matrix.matMult(t_1, y_rotation_);  
        t_1 = Matrix.matMult(t_1, skalierung);
        t_ges = Matrix.matMult(t_1, zentrum);
        
  
        //Rotation
        rotation = Matrix.matMult(z_rotation_, x_rotation_);
        rotation = Matrix.matMult(rotation, y_rotation_);
        
        t.MatrixUpdateTransformationen(translation, rueck, rotation, skalierung, zentrum, t_ges);
        d.MatrixUpdateDrehmatrizen(z_rotation_, x_rotation_, y_rotation_);

        // Apply the transformations to the points
        float[] p1t = Matrix.matMult(t_ges, p1);
        float[] p2t = Matrix.matMult(t_ges, p2);
        float[] p3t = Matrix.matMult(t_ges, p3);
        float[] p4t = Matrix.matMult(t_ges, p4);

        g.setColor(Color.BLUE);
        g2d.fillOval((int) p1t[0] - RADIUS, (int) p1t[1] - RADIUS, RADIUS * 1, RADIUS * 1);
        g.setColor(Color.RED);
        g2d.fillOval((int) p2t[0] - RADIUS, (int) p2t[1] - RADIUS, RADIUS * 1, RADIUS * 1);
        g.setColor(Color.YELLOW);
        g2d.fillOval((int) p3t[0] - RADIUS, (int) p3t[1] - RADIUS, RADIUS * 1, RADIUS * 1);
        g.setColor(Color.GREEN);
        g2d.fillOval((int) p4t[0] - RADIUS, (int) p4t[1] - RADIUS, RADIUS * 1, RADIUS * 1);

        // ... and then the connecting edges
        // The stroke defines the width of the lines
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.RED);
        
        g2d.drawLine((int) p1t[0], (int) p1t[1], (int) p2t[0], (int) p2t[1]);
        g2d.setColor(Color.YELLOW);
        g2d.drawLine((int) p3t[0], (int) p3t[1], (int) p2t[0], (int) p2t[1]);
        g2d.setColor(Color.ORANGE);
        g2d.drawLine((int) p1t[0], (int) p1t[1], (int) p3t[0], (int) p3t[1]);
        g2d.setColor(Color.GREEN);
        g2d.drawLine((int) p4t[0], (int) p4t[1], (int) p2t[0], (int) p2t[1]);
        g2d.setColor(Color.BLUE);
        g2d.drawLine((int) p4t[0], (int) p4t[1], (int) p1t[0], (int) p1t[1]);
        g2d.setColor(Color.BLACK);
        g2d.drawLine((int) p4t[0], (int) p4t[1], (int) p3t[0], (int) p3t[1]);
        

    }

    public void updateXRotation(float alpha)
    {
        // Build the x rotation matrix according to formula
        float cos = (float) Math.cos(Math.toRadians(alpha));
        float sin = (float) Math.sin(Math.toRadians(alpha));

        x_rotation_[1][1] = cos;
        x_rotation_[1][2] = -sin;
        x_rotation_[2][1] = sin;
        x_rotation_[2][2] = cos;

        repaint();
    }

    public void updateZRotation(float alpha)
    {
        // Build the z rotation matrix according to formula
        float cos = (float) Math.cos(Math.toRadians(alpha));
        float sin = (float) Math.sin(Math.toRadians(alpha));

        z_rotation_[0][0] = cos;
        z_rotation_[0][1] = -sin;
        z_rotation_[1][0] = sin;
        z_rotation_[1][1] = cos;

        /*
         * z_rotation_[0][0] z_rotation_[0][1] z_rotation_[0][2] z_rotation_[0][3]
         * z_rotation_[1][0] z_rotation_[1][1] z_rotation_[1][2] z_rotation_[1][3]
         * z_rotation_[2][0] z_rotation_[2][1] z_rotation_[2][2] z_rotation_[2][3]
         * z_rotation_[3][0] z_rotation_[3][1] z_rotation_[3][2] z_rotation_[3][3]
         * 
         * 
         */

        repaint();
    }

    public void updateYRotation(float alpha)
    {
        // Build the z rotation matrix according to formula
        float cos = (float) Math.cos(Math.toRadians(alpha));
        float sin = (float) Math.sin(Math.toRadians(alpha));

        y_rotation_[0][0] = cos;
        y_rotation_[0][2] = sin;

        y_rotation_[2][0] = -sin;
        y_rotation_[2][2] = cos;

        repaint();
    }

    public void updateSkalierung(float s)
    {
        skalierung[0][0] = s;
        skalierung[1][1] = s;
        skalierung[2][2] = s;

        repaint();
    }

    public void updateXTranslation(float x)
    {
        translation[0][3] = x;

        repaint();
    }

    public void updateYTranslation(float y)
    {
        translation[1][3] = y;

        repaint();
    }

    public void updateZTranslation(float z)
    {
        translation[2][3] = z;

        repaint();
    }
    
    public void updateXZentrum(float x)
    {
        rueck[0][3] = x;
        zentrum[0][3] = -x;
        repaint();
    }
    
    public void updateYZentrum(float y)
    {
        rueck[1][3] = y;
        zentrum[1][3] = -y;
        repaint();
    }
    
    public void updateZZentrum(float z)
    {
        rueck[2][3] = z;
        zentrum[2][3] = -z;
        repaint();
    }
}
