public class Radix{

  public static void radixsort(int[]data){
    int hold = data[0];
    int count = 0;
    int idx = 0;
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[21];
    for (int b = 0 ; b < data.length; b ++) {
      buckets[b] = new MyLinkedList<Integer>();
      buckets[b].add(data[count]);
      if (hold < Math.abs(data[count])) {
        hold = data[count];
      }
      count++;
    }
    count = 10;
    while ((hold / 10) != 0) {
      for (int c = 0 ; c < 21; c ++) {
	if (buckets[c].size() != 0 ) {
	  buckets[21].extend(buckets[c]);
        }
      }
      while (buckets[20].size() != 0) {
        int h = buckets[20].removeFront();
        buckets[(h % count) / (count / 10)].add(h);
      }
    }
System.out.println(buckets[20].toString());
     

  }

  public static void main(String[] args) {
    int[] a = {34,56,3,46,36,3,6};
    radixsort(a);
  }

}
