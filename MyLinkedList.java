import java.util.List;

public class MyLinkedList<E>{
  private class Node{
    private Integer data;
    private Node next,prev;

    public Node(Integer data1, Node next1, Node prev1) {
	data1 = data;
	next1 = next;
	prev1 = prev;
    }

    public Node next() {
    	return next;
    }

    public Node prev() {
	return prev;
    }

    public void setNext(Node other) {
	next = other;
    }

    public void setPrev(Node other) {
	prev = other;
    }

    public Integer getData() {
	return data;
    }

    public Integer setData(Integer i) {
	data = i;
	return data;
    }

    public String toString() {
	return "" + data;
    }
  }

  private int length;
  private Node start,end;

  public MyLinkedList() {
    length = 0;
    start = new Node(null, null, null);
    end = new Node(null, null, null);
  }

  public int size() {
    return length;
  }

  public boolean add(Integer value) {
    if (length == 0) {
      start.setData(value); //if list is empty, then adding a node would mean start and end node would be equal to value
      end.setData(value);
    }
    else if (length == 1) {
      Node add = new Node(null, null, null);
      add.setData(value);
      add.setPrev(start);
      start.setNext(add);
      end = add;
    }
    else { //otherwise one must create a new node and set the end reference to it (essentially adding it on)
      Node add = new Node(null, null, null);
      add.setData(value);
      end.setNext(add);
      add.setPrev(end);
      end = add; //the added node would be the new end
    }
    length = length + 1;
    return true;
  }

  public String toString() {
    Node current = start;
    int a = 0;
    if (size() == 0) {
      return "[]";
    }
    String str = "[";
    while (a < (size() -1)) {
      str = str + current.getData() + ", ";
      current = current.next();
      a++;
    }
    return str + current.getData() +"]";
  }

  /*public String toString2() {
    Node current = start;
    int a = 0;
    int b = 0;
    if (size() == 0) {
      return "[]";
    }
    String str = "[";
    while (a < (size() -1)) {
      while (b < (current[a].size() - 1)) {
      str = str + current.getData() + ", ";
      current = current.next();
      b++;
      }
      a++;
    }
    return str + current.getData() +"]";
  }*/

  private Node nthNode(int index) {
    Node current = new Node(null, null, null);
    current = start;
    for (int a = 0; a < index; a++) {
      current = current.next(); //get the next node until you have reached the node of the specified index
    }
    return current;
  }

  public Integer get(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException(); //if the index is out of range
    }
    else {
      return nthNode(index).getData(); //Returns the element at the specified position in this list
    }
  }

  public Integer set(int index,Integer value) {
    Node store = new Node(null, null, null);
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException(); //if the index is out of range
    }
    else {
      store = nthNode(index);
      Integer hold = store.getData();
      store.setData(value); //Replaces the element at the specified position in this list with the specified element
      return hold; //the element previously at the specified position
    }
  }

  public boolean contains(Integer value) {
    Node current = new Node(null, null, null);
    current = start;
    if (current.getData().equals(value)) {
      return true;
    }
    for (int a = 0; a < (size() - 1); a++) {
      current = current.next();
      if (current.getData().equals(value)) {
        return true; //Returns true if this list contains the specified element
      }
    }
    return false;
  }

  public int indexOf(Integer value) {
    Node current = new Node(null, null, null);
    current = start;
    if (current.getData().equals(value)) {
      return 0;
    }
    for (int a = 0; a < (size() - 1); a++) {
      current = current.next();
      if (current.getData().equals(value)) {
        return (a + 1); // Returns the index of the first occurrence of the specified element in this list
      }
    }
    return -1; //returns -1 if this list does not contain the element
  }

  public void add(int index,Integer value) {
    Node add = new Node(null, null, null);
    add.setData(value);
    Node store = new Node(null, null, null);
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException(); //if the index is out of range
    }
    else {
      if (index == size()) {
	add(value);
      }
      else if (index == 0) {
        start.setPrev(add);
        add.setNext(start);
        start = add;
      }
      else {
        store = nthNode(index);
	store.prev().setNext(add);
	add.setPrev(store.prev());
        store.setPrev(add);
        add.setNext(store); //Inserts the specified element at the specified position in this list
      }
      length = length + 1;
    }
  }

  public Integer remove(int index) {
    Node store = new Node(null, null, null);
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException(); //if the index is out of range
    }
    else {
      store = nthNode(index);
      Integer hold = store.getData();
      if (size() == 1) { //if only one element
        start = new Node(null, null, null);
      }
      else if (index == (size() - 1)) {//if you want to remove the last element
	end.prev().setNext(null);
        end = end.prev();
      }
      else if (index == 0) {
        start = start.next();
	start.setPrev(null);
      }
      else {
        store.next().setPrev(store.prev());
        store.prev().setNext(store.next()); //Removes the element at the specified position in this list
      }
      length = length - 1;
      return hold;
    }

  }

  public boolean remove(Integer value) {//indexOf() would also be useful
    int idx = 0;
    if (indexOf(value) == -1) {
      return false; //If this list does not contain the element, the list is unchanged
    }
    else {
      idx = indexOf(value);
      remove(idx); //Removes the first occurrence of the specified element from this list, if it is present
      return true; //true if this list contained the specified element
    }
  }

  public void extend(MyLinkedList other){
        //in O(1) runtime, move the elements from other onto the end of this
        //The size of other is reduced to 0
        //The size of this is now the combined sizes of both original lists
    end.setNext(other.start); //connecting the two
    other.start.setPrev(end);
    end = other.end; //new end
    length = length + other.size(); //new length
    other.length = 0;
    }

  public Integer removeFront() {
    Node hold = start;
    start = start.next();
    start.setPrev(null);
    return hold.getData();
  }
}
