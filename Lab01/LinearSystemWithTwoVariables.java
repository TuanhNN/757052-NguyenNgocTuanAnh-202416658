import javax.swing.JOptionPane;

public class LinearSystemWithTwoVariables {
    public static void main(String[] args) {
        String val = JOptionPane.showInputDialog("Input args: a11 a12 a21 a22 b1 b2");
        String[] vals = val.split(" ");
        if (vals.length != 6) {
            JOptionPane.showMessageDialog(null, "Not enough values");
            System.exit(0);
        }

        double a11 = Double.parseDouble(vals[0]);
        double a12 = Double.parseDouble(vals[1]);
        double a21 = Double.parseDouble(vals[2]);
        double a22 = Double.parseDouble(vals[3]);
        double b1  = Double.parseDouble(vals[4]);
        double b2  = Double.parseDouble(vals[5]);

        double det  = a11 * a22 - a12 * a21;
        double detX = b1 * a22 - b2 * a12;
        double detY = a11 * b2 - a21 * b1;

        String message;

        if (det == 0) {
            if (detX == 0 && detY == 0) {
                message = "Infinite solutions";
            } else {
                message = "No solution";
            }
        } else {
            double x1 = detX / det;
            double x2 = detY / det;
            message = "x1 = " + x1 + ", x2 = " + x2;
        }

        JOptionPane.showMessageDialog(null, message);
        System.exit(0);
    }
}
