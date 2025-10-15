import java.util.Arrays;

public class URHashTable<Key,Value> extends UR_HashTable<Key,Value> {

  @SuppressWarnings("unchecked")
  public URHashTable() {
    n = 0; // size of data set
    m = INIT_CAPACITY; // size of hash hash table
    keys = (Key[]) new Object[m];
    vals = (Value[]) new Object[m];
    inserts = 0;
    collisions = 0;
  }

  public void put (Key key, Value val) {
    int index = hash(key);
    int increment = 0;
    // find next available slot
    while (keys[(index + increment) % m] != null && !keys[(index + increment) % m].equals(key)) {
      // if hash table is full, resize
      if (increment == m) {
        resize(m);
        put(key, val);
        return;
      }
      increment++;
    }
    // insert key, val
    keys[(index + increment) % m] = key;
    vals[(index + increment) % m] = val;
    n++;
  }

  // public Value get (Key key) {
  //
  // }
  //
  // public void delete(Key key) {
  //
  // }
  //
  // public int size() {
  //
  // }
  //
  // public boolean isEmpty() {
  //
  // }
  //
  // public boolean contains(Key key) {
  //
  // }
  //
  // public Iterable<Key> keys() {
  //
  // }

  private int hash(Key key) {
    return key.hashCode() % m;
  }

  @SuppressWarnings("unchecked")
  private void resize(int capacity) {
    // store old data
    Key[] oldKeys = Arrays.copyOf(keys, keys.length);
    Value[] oldVals = Arrays.copyOf(vals, vals.length);

    // create new arrays
    m *= 2;
    keys = (Key[]) new Object[m];
    vals = (Value[]) new Object[m];

    // rehash items
    for (int i = 0; i < oldKeys.length; i++) {
      if (oldKeys[i] != null) put(oldKeys[i], oldVals[i]);
    }
  }

  public void print() {
    System.out.println("[");
    for (int i = 0; i < keys.length; i++) {
      if (keys[i] != null) {
        System.out.println(" [" + keys[i].toString() + ", " + vals[i].toString() + "]");
      }
    }
    System.out.println("]");
  }

}
