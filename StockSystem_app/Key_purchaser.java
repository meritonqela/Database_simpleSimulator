/** Key_purchaser models a id number of purchase
 *  consisting of a number code (catalog number) */
public class Key_purchaser
{
    private int number_code;

    /** Constructor Key_purchaser constructs a catalog number
     * @param num - the integer number code, e.g.,  7625 */
    public Key_purchaser(int num)
    {
        number_code = num;
    }


    /** equals returns whether the catalog number held within this object
     *  is identical to the catalog number held within  c
     * @param c - the other catalog number
     * @return true, if this catalog number equals  c; return false, otherwise */
    public boolean equals(Key_purchaser c) {
        int d = c.getNumberCode();
        return ( d == number_code );
    }

    /** getNumberCode returns the number code of item
     * @return the number code, e.g.,  "7688"  */
    public int getNumberCode() { return number_code; }

}
