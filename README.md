# CSC 172 Lab 5

Julien Diamond (jdiamo12@u.rochester.edu)

Lab Partner: Norman Sackett

### Lab Synopsis

This lab was an implementation of a hash table using linear probing. Keys and corresponding values are stored in two sepearate arrays of the same length. When the arrays are filled, they are resized to double their original size and the items are reinserted. The custom class also supports an iterator to iterate through the hash table, printing out keys in the order that they appear in the key array.

### Unit Tests

To run the unit tests, compile with `javac *.java` and then run with `java Driver`.

### Included Files

- `Driver.java`: contains the unit tests
- `makefile`: compile/run easily for my own testing purposes
- `README.md`: this file
- `UR_HashTable.java`: interface defining methods to be implemented by hash table
- `URHashTable.java`: implementaiton of hash table
