public class Driver {
  public static void main(String[] args) {
    URHashTable<String, String> table = new URHashTable<String, String>();
    table.put("a", "z");
    table.put("b", "y");
    table.put("c", "x");
    table.put("d", "w");
    table.put("e", "v");
    table.put("f", "u");
    table.put("g", "t");
    table.print();
    for (String key : table) {
      System.out.println(key);
    }
  }
}
