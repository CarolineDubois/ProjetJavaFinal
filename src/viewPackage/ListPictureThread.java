package viewPackage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ListPictureThread extends Thread{

    private File[] pictures = {
            new File("src\\picturesThread\\picture1.jpg"),
            new File("src\\picturesThread\\picture2.jpg"),
            new File("src\\picturesThread\\picture3.jpg"),
            new File("src\\picturesThread\\picture4.jpg"),
            new File("src\\picturesThread\\picture5.jpg"),
    };


    private int nbFiles;
    private JLabel label;
    private BufferedImage bufferedImage;
    private ImageIcon imageIcon;
    private ThreadPanel threadPanel;

    public ListPictureThread(ThreadPanel threadPanel) {
        this.threadPanel = threadPanel;
        this.label = threadPanel.getThreadLabel();
        this.nbFiles = pictures.length;
    }

    @Override
    public void run() {
        int i = 0;
        while(true) {
            try {
                if(i > nbFiles - 1)
                    i = 0;

                bufferedImage = ImageIO.read(pictures[i]);
                Image image = bufferedImage.getScaledInstance(400, 700, Image.SCALE_DEFAULT);

                imageIcon = new ImageIcon(image);
                label.setIcon(imageIcon);
                i++;
                threadPanel.repaint();
                Thread.sleep(3000);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());

            }
        }
    }
}
