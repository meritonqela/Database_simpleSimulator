/** Key_customer models a ID number of customer
 *  consisting of a number code (catalog number) */
public class Key_customer {
    private int number_code;

    /** Constructor Key_customer constructs a catalog number
     * @param num - the integer number code, e.g.,  "1884"  */
    public Key_customer(int num)

    {
        number_code = num;
    }

    /** equals returns whether the catalog number held within this object
     *  is identical to the catalog number held within  c
     * @param c - the other catalog number
     * @return true, if this catalog number equals  c; return false, otherwise */
    public boolean equals(Key_customer c) {
        int d = c.getNumberCode();
        return ( d == number_code );
    }

    /** getNumberCode returns the number code (ID number)
     * @return the number code, e.g.,  "1884 " */
    public int getNumberCode() { return number_code; }

}