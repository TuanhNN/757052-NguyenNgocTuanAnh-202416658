import javax.swing.JOptionPane;

public class SecondDegreeEquationWithOneVariable {
    public static void main(String[] args) {
        double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a: "));
        double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter b: "));
        double c = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter c: "));

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    JOptionPane.showMessageDialog(null, "Infinite solutions!");
                } else {
                    JOptionPane.showMessageDialog(null, "No solution!");
                }
            } else {
                double x = -c / b;
                JOptionPane.showMessageDialog(null, "Answer x = " + x);
            }
        } else {
            double d = b * b - 4 * a * c;
            if (d < 0) {
                JOptionPane.showMessageDialog(null, "No solution!");
            } else if (d == 0) {
                double x = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "Double root x = " + x);
            } else {
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                JOptionPane.showMessageDialog(null, "Answer x1 = " + x1 + "\nAnswer x2 = " + x2);
            }
        }
    }
}
