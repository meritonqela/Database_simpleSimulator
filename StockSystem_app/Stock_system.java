import javax.swing.*;
/** Stock_system application that models a market (stock) in the simplest way,
  * Strock_system provides you to add products in stock, to delete them, to view details of a product, to view all products in stock,
  * to buy a product (in this case you register in market as a customer), you also can print all daily report of all purchases,
  * and print purchases of one customer.
  * Remark - Stock_system do not protect it self from 'bad inputs'
  * @date 18 Maj 2016
  * @author Meriton Qela, Kaltrina Veseli, Endrit Bytyqi, Endrit Hoti   */

public class Stock_system {


    public static void main (String [] args) {

        Database dataBase = new Database(5000); // create the database for items, purchases and customers

        JOptionPane.showMessageDialog(null, "Welcome in stock system");
        boolean process = true; // application will be open until this variable process change to false
        while (process) {
            String input = JOptionPane.showInputDialog(
                    "1. Add new product \n " +
                    "2. Delete product \n " +
                    "3. View a product details\n"+
                    "4. View all products in stock\n"+
                    "5. Buy a product\n"+
                    "6. Print daily report for all purchases\n"+
                    "7. View purchases of one customer\n"+
                    "0. Exit");

            if (input.equals("1")) {
                String input_1 = JOptionPane.showInputDialog("Name of product:");
                int id = new Integer(JOptionPane.showInputDialog("ID of product:")).intValue();
                double wprice = new Double(JOptionPane.showInputDialog("Wholeprice of product")).doubleValue();
                double rprice = new Double(JOptionPane.showInputDialog("Retailprice of product")).doubleValue();
                int q = new Integer(JOptionPane.showInputDialog("Quanity of the new product")).intValue();
                // creation of the new item(product) and placement it in the database
                Record_Item item = new Record_Item(input_1, new Key_Item(id) , wprice, rprice , q);
                dataBase.insert(item);
            }

            if (input.equals("2")){
                int id = new Integer(JOptionPane.showInputDialog("Type the ID of product you want to delete:")).intValue();
                // deletes the item (product) with it's ID, from the database
                dataBase.delete(new Key_Item(id));

            }

            if (input.equals("3")) {

                int id = new Integer(JOptionPane.showInputDialog("Type the ID of product you want to view:")).intValue();
                Record_Item product = dataBase.find(new Key_Item(id));
                // finds the item(product) with it's ID and shows the details of it
                if (product != null){
                    JOptionPane.showMessageDialog(null, "Name:"+product.getNameOfItem()+
                            "\n Wholeprice:"+product.getWholesalePrice()+
                            "\n Retailprice"+product.getRetailPrice()+
                            "\n Quantity in stock"+product.getQuantity());
                }
                else {JOptionPane.showMessageDialog(null, "No product");}
            }

            if (input.equals("4")){
                // looks all the record of items in the database and prints those that are not null(empty)
                for (int i = 1; i <=dataBase.getRecordLengthItems() ; i++ )
                {
                    Record_Item product = dataBase.find(new Key_Item(i));
                    if (product != null){
                        System.out.println("Name: "+product.getNameOfItem()+"  ID of product: "+i+" -- Wholeprice: "+product.getWholesalePrice()+
                                " -- Retailprice: "+product.getRetailPrice()+" -- Quantity in stock: "+product.getQuantity() );
                    }
                }
            }

            if (input.equals("5")){
                String name = JOptionPane.showInputDialog("Type your name");
                int costumer = new Integer(JOptionPane.showInputDialog("Type your ID:")).intValue();
                String address = JOptionPane.showInputDialog("Type your address please:");
                int id = new Integer(JOptionPane.showInputDialog("Type the ID of product you want to buy:")).intValue();
                // looks for the product with it's ID , that customer has desired
                Record_Item product = dataBase.find(new Key_Item(id));
                if (product == null){JOptionPane.showMessageDialog(null, "No product found ");}
                else { String quanity = JOptionPane.showInputDialog("How many/much  "+product.getNameOfItem() +"  do you want to buy");
                    int c = new Integer(quanity).intValue();
                    if (product.getQuantity()< c){JOptionPane.showMessageDialog(null, "We dont have that quanity ");}
                    else {   product.orderProduct(c);
                        String pay = JOptionPane.showInputDialog("How do you want to pay:\n ----Type---\n--CASH--or--CCARD--");
                        // creation of the new purchase and inserting it in database
                        Purchase blerja = new Purchase(new Key_purchaser(costumer),product,c,pay);
                        dataBase.insert(blerja);
                        // creation of the new customer and inserting it in database
                        Customer costu = new Customer(new Key_customer(costumer),blerja,name, address);
                        dataBase.insert(costu);
                        JOptionPane.showMessageDialog(null, "Thank you! ");}
                }

            }

            if (input.equals("6")){
                // looks all the record of purchases in the database and prints those that are not null(empty)
                System.out.println("Daily report:");
                for (int i = 1; i<=dataBase.getRecordLengthPurchase() ;i++){
                    Purchase p = dataBase.find(new Key_purchaser(i));
                    if (p!=null){System.out.println("Costumer ID: "+i+" Product ID: "+p.getKeyOfItem().getNumberCode()+"  Quantity ordered:  "
                            +p.getQuanity()+ "   Means of payment:   "+p.meansOfPayment());}
                }
            }

            if (input.equals("7")){
                // prints the customer's name, address, his orders ..etc
                int id = new Integer( JOptionPane.showInputDialog("Type ID of the customer:")).intValue();
                Customer c = dataBase.find(new Key_customer(id));
                if (c==null){JOptionPane.showMessageDialog(null, "There's no customer with this ID");}
                 else {
                    System.out.println("Name of customer:  ["+c.getName()+"]  ID : ["+id+"]  Address:  ["+c.getAddress()+"]  Item purchased by him:  ["+c.getShopping().getRecordOfItem().getNameOfItem()+
                    "]  Quantity ordered:  ["+c.getShopping().getQuanity()+"]");
                }
            }


            if (input.equals("0")) {
                // process change to false , and application closes
                JOptionPane.showMessageDialog(null, "You choose to exit! ");
                process = false; }


        }
    }


}