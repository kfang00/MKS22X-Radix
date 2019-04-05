public class Radix{

  public static void radixsort(int[]data){
    int hold = data[0];
    int count = 10;
    int idx = 0;
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int b = 0 ; b < buckets.length; b++) {
      buckets[b] = new MyLinkedList<Integer>();
    }
    MyLinkedList sorted = new MyLinkedList();
    for (int i = 0 ; i < sorted.size(); i ++) {
      buckets[0].add(data[i]);
      System.out.println(buckets[0].toString());
      if (hold < Math.abs(data[i])) {
        hold = data[i];
      }
    }
    while ((hold / count) != 0) {
      for (int c = 0 ; c < buckets.length; c ++) {
	if (buckets[c].size() > 0 ) {
	  System.out.println(buckets[c].toString());
	  sorted.extend(buckets[c]);
  	  //System.out.println(buckets[20].toString());
        }
      }
      //System.out.println(buckets[20].toString());
      while (sorted.size() != 0) {
        int h = (int)sorted.removeFront();
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
