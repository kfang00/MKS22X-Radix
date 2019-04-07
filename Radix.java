import java.util.*;
public class Radix{

  public static void radixsort(int[]data){
    int hold = data[0];
    int count = 10;
    int idx = 0;
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int b = 0 ; b < 20; b++) {
      buckets[b] = new MyLinkedList<>();
    }
    MyLinkedList<Integer> sorted = new MyLinkedList<>();
    for (int i = 0 ; i < data.length; i ++) {
      buckets[10].add(data[i]);
      if (hold < Math.abs(data[i])) {
        hold = data[i]; //finding the largest number
      }
    }
    //System.out.println(hold);
    for (int s = 0; s < ((hold + "").length()); s++) { //until you have looped through all the digits of the largest number
      for (int c = 0 ; c < buckets.length; c ++) {
	if (buckets[c].size() > 0 ) {
	  sorted.extend(buckets[c]);
        }
      }
      //System.out.println(sorted.toString());
      for (int t=0; t<data.length; t++) {
        int h = (int)sorted.removeFront();
	if (h < 0) { //negatives
	  buckets[9 + ((h % count) / (count / 10))].add(h);
        }
 	else { //positives
          buckets[((h % count) / (count / 10)) + 10].add(h);
	}
      }
      count = count * 10; //accessing the next place
    }
    for (int f = 0 ; f < buckets.length; f ++) {
	if (buckets[f].size() > 0 ) {
	  sorted.extend(buckets[f]);
        }
      }
    for (int x = 0 ; x < data.length; x ++) {
        data[x] = (int)sorted.removeFront(); //placing it back into data
    }

     

  }


  public static void main(String[]args){
  int[] a = {22,53,34,55,66,31,31,51,51,61,71,61,51};
    radixsort(a);
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=10; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Radix.radixsort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
  //int[] data = {-103,45,-241,861,359,-175,920,-4};
  //radixsort(data);
}

}

