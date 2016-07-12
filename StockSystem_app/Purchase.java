/**Purchase is the record for the purchase that contains the id of the purchaser,
  * items and quantities ordered of each , and the means of payment  */
public class Purchase {
    // the names of the fields describe their contents:
    private Record_Item item;
    private Key_purchaser id_number_purchaser;
    private int quantity_item;
    private String payment;

    /** Constructor Purchase construct the purchase
     * @param id_p - the ID number of a purchaser
     * @param product - the object of product (item)
     * @param q - quantity ordered
     * @param p - means of payment
     */
    public Purchase(Key_purchaser id_p, Record_Item product, int q, String p) {
        id_number_purchaser = id_p;
        item = product;
        quantity_item = q;
        payment = p;
    }

    /** getKeyOfPurchaser returns the key that identifies the customer (purchaser)
     * @return - the key  */
    public Key_purchaser getKeyOfPurchaser() {
        return id_number_purchaser;
    }

    /** getKeyOfItem  returns the key that identifies the item
     * @return the key  */
    public Key_Item getKeyOfItem() {
        return item.getKey();
    }

    /** getRecordOfItem returns the object of item
     * @return - the item  */
    public Record_Item getRecordOfItem() {
        return item;
    }

    /** getQuantity returns the quantity ordered by purchaser
     * @return - the quanity ordered  */
    public int getQuanity() {
        return quantity_item;
    }

    /** meansOfPayment returns the means of payment form purchaser
     *  e.g, "CASH" or "CreditCard"
     * @return - means of payment   */
    public String meansOfPayment() {
        return payment;
    }

}