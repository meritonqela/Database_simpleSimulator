/** Customer models a customer  */
public class Customer {

    // the names of the fields describe their contents:
    private Purchase shopping;
    private Key_customer catalog_number;
    private String name;
    private String address;


    /** Constructor Customer constructs the book.
     * @param num - the key(ID number) of the customer
     * @param p - the object of purchase
     * @param n - the name of the customer
     * @param a - the address of the customer   */
    public Customer(Key_customer num,Purchase p, String n, String a)
    {   catalog_number = num;
        shopping = p;
        name = n;
        address = a;
    }

    /** getID  returns the key that identifies the customer
     * @return the key   */
    public Key_customer getID() { return catalog_number; }

    /** getName returns the customer's name
     * @return the name  */
    public String getName() { return name; }

    /** getAddress returns the customer's address
     * @return the address  */
    public String getAddress() { return address; }

    /** getShopping returns the purchase of the customer
     * @return - the purchase(object) of customer  */
    public Purchase getShopping() { return shopping; }


}
