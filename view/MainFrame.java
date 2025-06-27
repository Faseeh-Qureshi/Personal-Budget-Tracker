package view;

import controller.BudgetController;
import model.*;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private BudgetController controller;

    public MainFrame(BudgetController controller) {
        this.controller = controller;
        setTitle("Personal Budget Tracker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 1, 10, 10));

  //Add the implementation logic for the main frame here
    }
}
