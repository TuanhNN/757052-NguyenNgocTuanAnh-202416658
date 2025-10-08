import javax.swing.JOptionPane;

public class LinearEquationWithOneVariable {
    public static void main(String[] args) {
        double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a: "));
        double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter b: "));

        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "Infinite solutions!");
            } else {
                JOptionPane.showMessageDialog(null, "No solution! Please enter different a.");
            }
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "Answer x = " + x);
        }
    }
}
