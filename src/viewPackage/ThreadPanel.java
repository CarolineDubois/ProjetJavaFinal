package viewPackage;

import javax.swing.*;
import java.awt.*;

public class ThreadPanel extends JPanel {
    private JLabel threadLabel;
    private ListPictureThread listPicture;

    public ThreadPanel() {
        threadLabel = new JLabel("", SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        this.add(threadLabel);
        listPicture = new ListPictureThread(this);
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 30));
        listPicture.start();
    }

    public JLabel getThreadLabel() {
        return threadLabel;
    }
}
