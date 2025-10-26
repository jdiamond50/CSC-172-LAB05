// lab partner: Norman Sackett

import java.util.Arrays;
import java.util.Iterator;

public class URHashTable<Key,Value> extends UR_HashTable<Key,Value> implements Iterable<Key> {

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
      collisions++;
    }
    // insert key, val
    if (keys[(index + increment) % m] == null) inserts++;
    keys[(index + increment) % m] = key;
    vals[(index + increment) % m] = val;
    n++;
  }

  public Value get (Key key) {
    for (int i = 0; i < keys.length; i++) {
      if (keys[i] != null && keys[i].equals(key)) return vals[i];
    }
    return null;
  }

  public void delete(Key key) {
    for (int i = 0; i < keys.length; i++) {
      if (keys[i] != null && keys[i].equals(key)) {
        keys[i] = null;
        vals[i] = null;
        inserts--;
      }
    }
  }

  public int size() {
    return inserts;
  }

  public boolean isEmpty() {
    return this.size() == 0;
  }

  public boolean contains(Key key) {
    for (int i = 0; i < keys.length; i++) {
      if (keys[i] != null && keys[i].equals(key)) return true;
    }
    return false;
  }

  public Iterable<Key> keys() {
    return this;
  }

  private class URHashTableIterator implements Iterator<Key> {
    private int index = 0;
    private int numCounted = 0;

    public boolean hasNext() {
      return numCounted < inserts;
    }

    public Key next() {
      while (index < m) {
        if (keys[index] != null) break;
        index++;
      }
      numCounted++;
      index++;
      // System.out.println("key found at index " + (index-1));
      // System.out.println("numCounted: " + numCounted);
      return keys[index-1];
    }

    public void remove() { throw new UnsupportedOperationException(); }
  }

  // returns the iterator
  public Iterator<Key> iterator() {
    return new URHashTableIterator();
  }

  private int hash(Key key) {
    return key.hashCode() % m;
  }

  @SuppressWarnings("unchecked")
  private void resize(int capacity) {
    inserts = 0;

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
