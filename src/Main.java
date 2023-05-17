import viewPackage.MainWindow;

import javax.swing.*;
import java.io.File;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        new MainWindow();




    }
}
