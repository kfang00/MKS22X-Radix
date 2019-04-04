public class Radix{

  public static void radixsort(int[]data){
    int hold = data[0];
    int count = 0;
    int idx = 0;
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[21];
    for (int b = 0 ; b < buckets.length; b++) {
      buckets[b] = new MyLinkedList<Integer>();
      if (count < data.length) {
      buckets[b].add(data[count]);
      System.out.println(buckets[b].toString());
      if (hold < Math.abs(data[count])) {
        hold = data[count];
      }
      }
      count++;
    }
    count = 10;
    while ((hold / count) != 0) {
      for (int c = 0 ; c < buckets.length; c ++) {
	if (buckets[c].size() > 0 ) {
	  System.out.println(buckets[c].toString());
	  buckets[20].extend(buckets[c]);
  	  //System.out.println(buckets[20].toString());
        }
      }
      //System.out.println(buckets[20].toString());
      while (buckets[20].size() != 0) {
        int h = buckets[20].removeFront();
	if (h < 0) {
	  buckets[9 + ((h % count) / (count / 10))].add(h);
          
        }
 	else {
          buckets[((h % count) / (count / 10)) + 10].add(h);
	  //System.out.println(buckets[((h % count) / (count / 10)) + 10].toString());
	}
      }
      count = count * 10;
    }
//System.out.println(buckets[20].toString());
     

  }

  public static void main(String[] args) {
    int[] a = {12,4345,345,2,6,1,43,345};
    radixsort(a);
  }

}
