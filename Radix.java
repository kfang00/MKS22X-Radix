public class Radix{

  public static void radixsort(int[]data){
    for (int a = 0; a < data.length; a++) {
      int hold = data[0];
      int count = 10;
      @SuppressWarnings("unchecked")
      MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
      for (int b = 0 ; b < buckets.length; b ++) {
        buckets[b] = new MyLinkedList<Integer>();
        buckets[b].add(data[a]);
      }

      if (hold < Math.abs(data[a])) {
        hold = data[a];
      }
      //while ((hold / 10) != 0) {

      //}
System.out.println(buckets.toString());
    }

  }

  public static void main(String[] args) {
    int[] a = {34,56,3,46,36,3,6};
    radixsort(a);
  }

}
