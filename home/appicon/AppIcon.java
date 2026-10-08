package booksmart.home.appicon;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AppIcon {

    private static Image appIcon;

    static {
        try {

            URL iconPath = AppIcon.class.getResource("/booksmart/img/navbar_logo.png");
            ImageIcon icon = new ImageIcon(iconPath);
            AppIcon.appIcon = icon.getImage();

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Invalid icon path...");
        }
    }

    public static void applyIcon(JFrame frame) {
        if (frame != null) {
            frame.setIconImage(appIcon);
        }
    }
}
