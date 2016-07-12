/** Database  implements a database of items, purchases and customers */
public class Database {
    private Record_Item[] base_of_items;   // the collection of items
    private Purchase[] base_of_purchase;// the collection of purchases
    private Customer[] base_of_customer; // the collection of customers
    private int NOT_FOUND = -1;  // int used to denote when a record not found

    /** Constructor  Database  initializes the database
     * @param initial_size - the size of the database */
    public Database(int initial_size) {
        if ( initial_size > 0 ) {
            base_of_items = new Record_Item[initial_size];
            base_of_purchase = new Purchase[initial_size];
            base_of_customer = new Customer[initial_size];
        } else {
            base_of_items = new Record_Item[1];
            base_of_purchase = new Purchase[1];
            base_of_customer = new Customer[1];
        }
    }

    /** findLocation  is a helper method that searches  base_of_items  for a record
     *  whose key is  k.   If found, the index of the record is returned,
     *  else  NOT_FOUND  is returned.  */
    private int findLocation(Key_Item k){
        int result = NOT_FOUND;
        boolean found = false;
        int i = 0;
        while ( !found  &&  i != base_of_items.length )
        { if ( base_of_items[i] != null  &&  base_of_items[i].getKey().equals(k) )
        { found = true;
            result = i;
        }
        else { i = i + 1; }
        }
        return result;
    }

    /** findLocation  is a helper method that searches  base_of_purchase  for a record
     *  whose key is  k.   If found, the index of the record is returned,
     *  else  NOT_FOUND  is returned.  */
    private int findLocation(Key_purchaser k)
    { int result = NOT_FOUND;
        boolean found = false;
        int i = 0;
        while ( !found  &&  i != base_of_purchase.length )
        { if ( base_of_purchase[i] != null  &&  base_of_purchase[i].getKeyOfPurchaser().equals(k) )
        { found = true;
            result = i;
        }
        else { i = i + 1; }
        }
        return result;
    }

    /** findLocation  is a helper method that searches  base_of_customer  for a record
     *  whose key is  k.   If found, the index of the record is returned,
     *  else  NOT_FOUND  is returned.  */
    private int findLocation(Key_customer k)
    { int result = NOT_FOUND;
        boolean found = false;
        int i = 0;
        while ( !found  &&  i != base_of_customer.length )
        { if ( base_of_customer[i] != null  &&  base_of_customer[i].getID().equals(k) )
        { found = true;
            result = i;
        }
        else { i = i + 1; }
        }
        return result;
    }

    /** find  locates a record(item) in the database based on a key
     * @param k - the key of the desired record
     * @return (the address of) the desired record;
     *  return  null if record not found.  */
    public Record_Item find(Key_Item k)
    { Record_Item answer = null;
        int index = findLocation(k);
        if ( index != NOT_FOUND )
        { answer = base_of_items[index]; }
        return answer;
    }

    /** find  locates a record(purchase) in the database based on a key
     * @param k - the key of the desired record
     * @return (the address of) the desired record;
     *  return  null if record not found.  */
    public Purchase find(Key_purchaser k)
    { Purchase answer = null;
        int index = findLocation(k);
        if ( index != NOT_FOUND )
        { answer = base_of_purchase[index]; }
        return answer;
    }

    /** find  locates a record(customer) in the database based on a key
     * @param k - the key of the desired record
     * @return (the address of) the desired record;
     *  return  null if record not found.  */
    public Customer find(Key_customer k)
    { Customer answer = null;
        int index = findLocation(k);
        if ( index != NOT_FOUND )
        { answer = base_of_customer[index]; }
        return answer;
    }

    /** insert inserts a new record(item) into the database.
     * @param r - the record
     * @return true, if record added; return false if record not added because
     *   another record with the same key already exists in the database */
    public boolean insert(Record_Item r)
    { boolean success = false;
        if ( findLocation(r.getKey()) == NOT_FOUND )  // r  not already in  base?
        { // find an empty element in  base  for insertion of  r:
            boolean found_empty_place = false;
            int i = 0;
            while ( !found_empty_place  &&  i != base_of_items.length )
            // so far, all of  base[0]..base[i-1]  are occupied
            { if ( base_of_items[i] == null )   // is this element empty?
            { found_empty_place = true; }
            else { i = i + 1; }
            }
            if ( found_empty_place )
            { base_of_items[i] = r; }
            else { // array is full!  So, create a new one to hold more records:
                Record_Item[] temp = new Record_Item[base_of_items.length * 2];
                for ( int j = 0;  j != base_of_items.length;  j = j + 1 )
                { temp[j] = base_of_items[j]; } // copy  base  into  temp
                temp[base_of_items.length] = r;   // insert  r  in first free element
                base_of_items = temp;   // change  base  to hold address of  temp
            }
            success = true;
        }
        return success;
    }

    /** insert inserts a new record(purchase) into the database.
     * @param r - the record
     * @return true, if record added; return false if record not added because
     *   another record with the same key already exists in the database */
    public boolean insert(Purchase r)
    { boolean success = false;
        if ( findLocation(r.getKeyOfPurchaser()) == NOT_FOUND )  // r  not already in  base?
        { // find an empty element in  base  for insertion of  r:
            boolean found_empty_place = false;
            int i = 0;
            while ( !found_empty_place  &&  i != base_of_purchase.length )
            // so far, all of  base[0]..base[i-1]  are occupied
            { if ( base_of_purchase[i] == null )   // is this element empty?
            { found_empty_place = true; }
            else { i = i + 1; }
            }
            if ( found_empty_place )
            { base_of_purchase[i] = r; }
            else { // array is full!  So, create a new one to hold more records:
                Purchase[] temp = new Purchase[base_of_purchase.length * 2];
                for ( int j = 0;  j != base_of_purchase.length;  j = j + 1 )
                { temp[j] = base_of_purchase[j]; } // copy  base  into  temp
                temp[base_of_purchase.length] = r;   // insert  r  in first free element
                base_of_purchase = temp;   // change  base  to hold address of  temp
            }
            success = true;
        }
        return success;
    }

    /** insert inserts a new record(customer) into the database.
     * @param c - the record
     * @return true, if record added; return false if record not added because
     *   another record with the same key already exists in the database */
    public boolean insert(Customer c)
    { boolean success = false;
        if ( findLocation(c.getID()) == NOT_FOUND )  // r  not already in  base?
        { // find an empty element in  base  for insertion of  r:
            boolean found_empty_place = false;
            int i = 0;
            while ( !found_empty_place  &&  i != base_of_customer.length )
            // so far, all of  base[0]..base[i-1]  are occupied
            { if ( base_of_customer[i] == null )   // is this element empty?
            { found_empty_place = true; }
            else { i++; }
            }
            if ( found_empty_place )
            { base_of_customer[i] = c; }
            else { // array is full!  So, create a new one to hold more records:
                Customer[] temp = new Customer[base_of_customer.length * 2];
                for ( int j = 0;  j != base_of_customer.length;  j = j + 1 )
                { temp[j] = base_of_customer[j]; } // copy  base  into  temp
                temp[base_of_customer.length] = c;   // insert  r  in first free element
                base_of_customer = temp;   // change  base  to hold address of  temp
            }
            success = true;
        }
        return success;
    }


    /** delete removes a record in the database based on a key
     * @param k - the record's key (identification)
     * @return true, if record is found and deleted; return false otherwise  */
    public boolean delete(Key_Item k)
    { boolean result = false;
        int index = findLocation(k);
        if ( index != NOT_FOUND )
        { base_of_items[index] = null;
            result = true;
        }
        return result;
    }

    public boolean delete(Key_purchaser k)
    { boolean result = false;
        int index = findLocation(k);
        if ( index != NOT_FOUND )
        { base_of_purchase[index] = null;
            result = true;
        }
        return result;
    }

    public boolean delete(Key_customer k)
    { boolean result = false;
        int index = findLocation(k);
        if ( index != NOT_FOUND )
        { base_of_customer[index] = null;
            result = true;
        }
        return result;
    }


    // three methods that returns the length of desired record (item , purchase or customer)
    public int getRecordLengthItems(){return base_of_items.length;}
    public int getRecordLengthPurchase(){return base_of_purchase.length;}
    public int getRecordLengthCustomer(){return base_of_customer.length;}

}