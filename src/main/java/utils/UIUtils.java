package main.java.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Genius Doan on 4/11/2017.
 */
public class UIUtils {
    public static ImageIcon makeIcon(Class<?> context, String imgName, int width, int height) {
        try {
            Image img = ImageIO.read(context.getResource(imgName));
            img = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static void setEmptyBorder(JButton button) {
        if (button != null) {
            Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
            button.setBorder(emptyBorder);
        }
    }
}
