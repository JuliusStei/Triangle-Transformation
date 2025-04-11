import javax.swing.*;

import java.awt.*;
import java.util.Hashtable;

public class ComplexSlider extends JPanel
{
    private static final float CONVERSION_FACTOR = 10.0F;

    public ComplexSlider(String name, float min_value, float max_value, float default_value, int spacing, MatrixUpdater func)
    {
        this.setPreferredSize(new Dimension(200, 65));
        JSlider slider = new JSlider((int) (min_value * CONVERSION_FACTOR), (int) (max_value * CONVERSION_FACTOR), (int) (default_value * CONVERSION_FACTOR));

        
        Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
        labelTable.put((int) (min_value * CONVERSION_FACTOR), new JLabel(" " + min_value));
        labelTable.put((int) (((min_value * CONVERSION_FACTOR) + (max_value * CONVERSION_FACTOR)) / 2), new JLabel(" " + ((max_value + min_value)) / 2));
        labelTable.put((int) (max_value * CONVERSION_FACTOR), new JLabel("" + max_value));

        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        slider.setMinorTickSpacing(spacing);
        slider.setLabelTable(labelTable);
        add(slider);

        setBorder(BorderFactory.createTitledBorder(String.format("%s: %.1f", name, default_value)));

        slider.addChangeListener(e ->
        {
            float curr_value = ((JSlider) e.getSource()).getValue() / CONVERSION_FACTOR;
            setBorder(BorderFactory.createTitledBorder(String.format("%s: %.1f", name, curr_value)));

            func.updateMatrix(curr_value);

        });
    }

}
/*
 * interface MatrixUpdater { public void updateMatrix(float value); }
 */
