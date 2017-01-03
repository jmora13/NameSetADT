

import java.util.*;

/**
 *
 * @author Justin Wong
 */
public class NameSetADT extends Bag {

//Effect:  constructor to create a NameSet which can store CAPACITY  elements
//Precondition: NONE
//Postcondition: an empty NameSet object exists
    public NameSetADT() {
        super();
    }

//Effect: Determines if this NameSet is empty
//Precondition:  NONE
//Postcondition: this NameSet object is unchanged
//Returns: true if this NameSet is empty, false otherwise
    public boolean isEmpty() {
        if (manyItems == 0) {
            return true;
        } else {
            return false;
        }
    }

//Effect: Determines if this NameSet is empty
//Precondition:  NONE
//Postcondition: this NameSet object is unchanged
//Returns: true if this NameSet is empty, false otherwise   
    public boolean isFull() {
        if (data.length == manyItems) {
            return true;
        } else {
            return false;
        }
    }

//Effect: inserts newItem into the NameSet
//Precondition: this NameSet is not full
//Postcondition: if newItem was not already in this set, newItem has been added to the set
//Returns:  true if item was added, false     
    public boolean addOne(String newItem) {

        if (!isFull() && !isThere(newItem)) {
            super.add(newItem);
            return true;
        } else {
            return false;
        }

    }

//Effect: inserts newItem into the NameSet
//Precondition: this NameSet is not full 
//Postcondition: if newItem was not in this set,newItem has been stored at the front of the set, with other items moved down
//Returns: true if item was added, false otherwise   
    public boolean addFirst(String newItem) {

        if (!isFull() && !isThere(newItem)) {
            super.add(newItem);
            for (int i = 0; i < data.length - 1; i++) {
                data[i + 1] = data[i];
            }
            data[0] = newItem;
            System.out.print("New Item has been added.");
            manyItems++;
            return true;
        } else {
            return false;
        }

    }

//Effect: first item in the NameSet is removed
//Precondition:  the NameSet is not empty
//Postcondition: a value has been removed from this NameSet
//Returns: the string which was removed from the set      
    public String eraseFirst() {
        String target = data[0];
        if (!isEmpty()) {
            data[0] = null;
            for (int i = 0; i < data.length - 1; i++) {
                data[i] = data[i + 1];
            }
            manyItems--;
        }
        return target;

    }

//Effect: determines if a value is contained in the NameSet
//Precondition:  NONE
//Postcondition: this NameSet object is unchanged
//Returns: returns true if this NameSet contains ‘item’, otherwise false is returned    
    public boolean isThere(String item) {
        for (int i = 0; i < manyItems; i++) {
            if (item.equals(data[i])) {
                return true;
            }

        }
        return false;
    }

//Effect: creates a NameSet that is the intersection of two NameSet objects
//Precondition:  None
//Postcondition:  both NameSet parameters are unchanged
//Returns: returns a NameSet object which contains elements which are contained in BOTH set1 
//          and set2    
    public static NameSetADT intersect(NameSetADT set1, NameSetADT set2) {
    	int count = 0;
        NameSetADT set3 = new NameSetADT();
        //if ((set1.manyItems + set2.manyItems) >= set3.data.length) {
        //   set3.ensureCapacity(set1.manyItems + set2.manyItems);
        //}
        for (int i = 0; i < set1.data.length; i++) {
                for (int j = 0; j < set2.data.length; j++) {
                    if (set1.data[i].equals(set2.data[j])) {
                         count++;
                         set3.ensureCapacity(count);
                         set3.addOne(set1.data[i]);
                         //System.arraycopy(set1.data, 0, set3.data, 0, set1.manyItems);
                         //System.arraycopy(set2.data, 0, set3.data, set1.manyItems, set2.manyItems);
                         //set3.manyItems = set1.manyItems + set2.manyItems;
                    }
                }
            }
        return set3;
    }

//Effect:  determines if two NameSets are equal
//Precondition: NONE
//Postcondition: this NameSet object is unchanged
//Returns:  returns true if this NameSet contains the same elements as in aNameSet
//             (storage order is not important for equality)    
    public boolean equal(Object aNameSet) {
        if (aNameSet == null) {
            return false;
        } else if (aNameSet instanceof NameSetADT) {
            NameSetADT bag2 = (NameSetADT) aNameSet;
            if (this.size() != bag2.size()) {
                return false;
            }
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < bag2.data.length; j++) {
                    if (data[i].equals(bag2.data[j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

//Effect: compares the length of two NameSets
//Precondition: NONE
//Postcondition: this NameSet object is unchanged
//Returns:  returns true if this NameSet contains more names than aNameSet
    public boolean greaterThan(NameSetADT aNameSet) {

        if (aNameSet == null) {
            return false;
        } else if (aNameSet instanceof NameSetADT) {
            NameSetADT temp = (NameSetADT) aNameSet;
            if (manyItems > temp.manyItems) {
                return true;
            }
            return false;
        }
        return false;

    }

//Effect:outputs a string containing the elements of this NameSet in format{int, int,int, etc }    
//If NameSet is empty,  {  }   is output
//Returns:  a string containing a representation of this object  
    public String toString() {
        String result = Arrays.toString(data);
        return result;
    }

}