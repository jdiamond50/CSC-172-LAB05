abstract public class UR_HashTable<Key,Value> {

  protected static final int INIT_CAPACITY = 5 ;
  protected int n; // size of the data set
  protected int m ; // size of the hash table
  protected Key[] keys;
  Value[] vals;
  int inserts, collisions;

  // Constuctors
  // public UR_HashTable() {}
  // public UR_HashTable(int cap) { }

  abstract public void put (Key key, Value val) throws Exception ;

  abstract public Value get (Key key) throws Exception ;

  abstract public void delete(Key key) throws Exception ;

  abstract public int size() ;

  abstract public boolean isEmpty() ;

  abstract public boolean contains(Key key) throws Exception ;

  abstract public Iterable<Key> keys() ;

  // Useful helpers
  // private int hash(Key key) ;
  // private void resize(int capacity) ;

}
