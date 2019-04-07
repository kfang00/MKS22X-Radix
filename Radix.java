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
      //buckets[1].add(data[i]);
      //System.out.println(buckets[10].toString());
      if (hold < Math.abs(data[i])) {
        hold = data[i];
      }
    }
    //System.out.println(hold);
    for (int s = 0; s < ((hold + "").length()); s++) {
      for (int c = 0 ; c < buckets.length; c ++) {
	if (buckets[c].size() > 0 ) {
	  //System.out.println(buckets[c].toString());
	  sorted.extend(buckets[c]);
  	  //System.out.println(sorted.toString());
        }
      }
      //System.out.println(sorted.toString());
      for (int t=0; t<data.length; t++) {
      //System.out.println(sorted.toString());
        int h = (int)sorted.removeFront();
        System.out.println(h);
        System.out.println(sorted.toString());
        
	if (h < 0) {
	  buckets[9 + ((h % count) / (count / 10))].add(h);
          //System.out.println(sorted.toString());
        }
 	else {
          System.out.println(sorted.toString());
          buckets[((h % count) / (count / 10)) + 10].add(h);
          System.out.println(((h % count) / (count / 10)) + 10);
	  System.out.println(sorted.toString());
	}
      
      }
      count = count * 10;
    }
    for (int f = 0 ; f < buckets.length; f ++) {
	if (buckets[f].size() > 0 ) {
	  //System.out.println(buckets[c].toString());
	  sorted.extend(buckets[f]);
  	  //System.out.println(sorted.toString());
        }
      }
    for (int x = 0 ; x < data.length; x ++) {
        data[x] = (int)sorted.removeFront();
        System.out.println(data[x]);
    }

//System.out.println(data.toString());
     

  }


  public static void main(String[]args){
  int[] a = {12,4345,345,2,6,1,43,345, -12, 41, 23524, 24};
    radixsort(a);
  /*System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
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
  }*/
  //int[] data = {-103,45,-241,861,359,-175,920,-4};
  //radixsort(data);
}

}

