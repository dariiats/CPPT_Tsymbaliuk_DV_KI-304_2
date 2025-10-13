package LAB_04;

/**
 * Class <code>CalcException</code> extends {@link ArithmeticException}
 * and represents custom exceptions that occur during mathematical calculations.
 * <p>
 * This exception class is used in the {@link Equations} class to provide
 * more descriptive error messages for calculation errors, such as
 * division by zero or invalid mathematical operations.
 * </p>
 * 
 * <p>Example of use:</p>
 * <pre>
 * if (Math.cos(4 * rad) == 0)
 *     throw new CalcException("Exception reason: cos(4x) = 0 → division by zero");
 * </pre>
 * 
 * @author Daria Tsymbaliuk
 * @version 1.0
 */
class CalcException extends ArithmeticException {

    /**
     * Default constructor without parameters.
     * <p>
     * Creates an instance of <code>CalcException</code> without a specific message.
     * </p>
     */
    public CalcException() {
        super();
    }

    /**
     * Parameterized constructor that accepts a detailed message.
     * <p>
     * Creates an instance of <code>CalcException</code> with a specified cause message.
     * </p>
     *
     * @param cause a string describing the reason for the exception
     */
    public CalcException(String cause) {
        super(cause);
    }
}
