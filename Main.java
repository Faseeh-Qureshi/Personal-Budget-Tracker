import controller.BudgetController;
import view.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BudgetController controller = new BudgetController();
            new MainFrame(controller);
        });
    }
}
