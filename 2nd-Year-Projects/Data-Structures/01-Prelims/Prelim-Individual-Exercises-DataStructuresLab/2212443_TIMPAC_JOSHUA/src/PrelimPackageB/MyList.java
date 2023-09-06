package PrelimPackageB;

import java.util.NoSuchElementException;

public interface MyList<Friends> {

        public FriendsList addElement();
        public int getSize();
        public int grow();
        public int insert(Friends data) throws ListOverflowException;
        public Friends getElement(Friends data) throws NoSuchElementException;
        public boolean delete(Friends data); // returns false if the data is not deleted in the list
        public int search(Friends data); // returns index of data, else -1 is return
    }
