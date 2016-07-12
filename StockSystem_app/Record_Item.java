/** Record_item models a item (product) */
public class Record_Item
{ // the names of the fields describe their contents:
    private String name_item;
    private Key_Item id_number;
    private double wholesale_price;
    private double retail_price;
    private int quantity;

    /** Constructor Record_item constructs the item.
     * @param n - name of a sale item
     * @param num - the item's ID-number
     * @param wp - whole price of the item
     * @param rp - retail price of the item
     * @param  q - the quantity in stock      */
    public Record_Item(String n, Key_Item num, double wp, double rp, int q)
    {   name_item = n;
        id_number = num;
        wholesale_price = wp;
        retail_price = rp;
        quantity = q;
    }

    /** getkey  returns the key that identifies the item
     * @return the key  */
    public Key_Item getKey() { return id_number; }

    /** getNameOfItem returns the item's name
     * @return the name */
    public String getNameOfItem() { return name_item; }

    /** getWholesalePrice returns the wholesale price of item (product)
     * @return the wholesale price */
    public double getWholesalePrice() { return wholesale_price; }

    /** getRetailPrice returns the retail price of item (product)
     * @return the retail price */
    public double getRetailPrice() { return retail_price; }

    /** getQuantity returns the quantity of item in stock
     * @return - the quantity
     */
    public int getQuantity(){ return quantity;}

    /** orderProduct returns the quantity of item that has remained in stock when the product is ordered
     * @param how - the quanity of order
     * @return - the remain quantity of item
     */
    public int orderProduct(int how){
        if (how <0) { how =0;}
        quantity = quantity-how;
        return quantity;
    }
}