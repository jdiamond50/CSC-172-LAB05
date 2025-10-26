// lab partner: Norman Sackett

public class Driver {
  public static void main(String[] args) throws Exception {
    URHashTable<String, String> table = new URHashTable<String, String>();

    System.out.println("---------- put() tests ----------");
    System.out.println("adding (a,z)");
    table.put("a", "z");
    System.out.println("adding (b,y)");
    table.put("b", "y");
    System.out.println("adding (c,x)");
    table.put("c","x");
    System.out.println("adding (d,w)");
    table.put("d","w");
    System.out.println("adding (e,v)");
    table.put("e","v");
    System.out.println("adding (f,u)");
    System.out.println("(must resize here)");
    table.put("f","u");
    table.print();
    System.out.println("adding (e,t) - repeat key");
    table.put("e","t");
    System.out.println("adding (f,s) - repeat key");
    table.put("f","s");
    table.print();
    System.out.println("adding (null,r)");
    try {
      table.put(null, "r");
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("adding (g,null)");
    try {
      table.put("g", null);
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("---------- get() tests ----------");
    System.out.print("getting d: ");
    System.out.println(table.get("d"));
    System.out.print("getting c: ");
    System.out.println(table.get("c"));
    System.out.print("getting g: ");
    System.out.println(table.get("g"));
    try {
      System.out.println("getting null:");
      table.get(null);
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("---------- delete() tests ----------");
    System.out.println("deleting a:");
    table.delete("a");
    table.print();
    System.out.println("deleting c:");
    table.delete("c");
    table.print();
    System.out.println("deleting g:");
    table.delete("g");
    table.print();
    try {
      System.out.println("deleting null:");
      table.delete(null);
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("---------- size() tests ----------");
    System.out.println("table.size(): " + table.size());
    System.out.println("deleting d");
    table.delete("d");
    System.out.println("table.size(): " + table.size());
    System.out.println("deleting all elements");
    table.delete("e");
    table.delete("f");
    table.delete("b");
    System.out.println("table.size(): " + table.size());

    System.out.println("---------- isEmpty() tests ----------");
    System.out.println("table.isEmpty(): " + table.isEmpty());
    System.out.println("adding a");
    table.put("a", "z");
    System.out.println("table.isEmpty(): " + table.isEmpty());

    System.out.println("---------- contains() tests ----------");
    System.out.println("table.contains(a): " + table.contains("a"));
    System.out.println("deleting a:");
    table.delete("a");
    System.out.println("table.contains(a): " + table.contains("a"));
    try {
      System.out.print("table.contains(null): ");
      System.out.println(table.contains(null));
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("---------- iteration tests ----------");
    table.put("a", "z");
    table.put("b", "y");
    table.put("c","x");
    table.put("d","w");
    table.put("e","v");
    table.print();
    System.out.println("iterating over table with enhanced for loop");
    for (String key : table) {
      System.out.println(key);
    }
  }

}
