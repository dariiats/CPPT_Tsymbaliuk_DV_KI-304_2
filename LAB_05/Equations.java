package LAB_05;

/**
 * Class <code>Equations</code> provides a method for calculating
 * the mathematical expression <b>y = 1 / cos(4x)</b>.
 * <p>
 * The input angle <code>x</code> is given in degrees and converted
 * internally into radians before performing the calculation.
 * </p>
 * <p>
 * The class uses exception handling to detect invalid or undefined
 * values, such as division by zero when <code>cos(4x) = 0</code>,
 * and throws a custom {@link CalcException} in these cases.
 * </p>
 *
 * <p><b>Example of usage:</b></p>
 * <pre>
 * Equations eq = new Equations();
 * double result = eq.calculate(30);
 * System.out.println(result); // Output: -2.0
 * </pre>
 *
 * @author Daria Tsymbaliuk
 * @version 1.0
 */
class Equations {

    /**
     * Calculates the value of the mathematical expression:
     * <blockquote>
     *     y = 1 / cos(4x)
     * </blockquote>
     *
     * @param x the angle in degrees
     * @return the calculated value of the expression
     * @throws CalcException if the expression is undefined, such as when
     *                       <code>cos(4x) = 0</code> or if the result is not a number
     */
    public double calculate(double x) throws CalcException {
        double y, rad;
        rad = x * Math.PI / 180.0; // convert degrees to radians

        try {
            y = 1 / Math.cos(4 * rad);

            // Validate the result: check for NaN, infinity, or division by zero
            if (Double.isNaN(y) || Double.isInfinite(y) || Math.cos(4 * rad) == 0) {
                throw new ArithmeticException();
            }
        } 
        catch (ArithmeticException ex) {
            // Provide meaningful error messages for specific cases
            if (Math.cos(4 * rad) == 0)
                throw new CalcException("Exception reason: Illegal value of X for cosine calculation (cos(4x) = 0)");
            else
                throw new CalcException("Unknown reason for the exception during expression calculation");
        }

        return y;
    }
}
