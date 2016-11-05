import java.util.*;

abstract class Heap{
  protected int capacity;

  protected in size;

  protected int[] items;

  public Heap(){
    this.capacity = 10;
    this.size = 0;
    this.items = new int[capactiy];
  }

  public int getLeftChildIndex(int parentIndex){
    return 2 * parentIndex + 1;
  }
  public int getRightChildIndex(int parentIndex){
    return 2 * parentIndex + 2;
  }
  public int getParentIndex(int childrenIndex){
    return (childrenIndex - 1)/2;
  }
  public boolean hasLeftChild(int index){
    return getLeftChildIndex(index) < size;
  }
  public boolean hasRightChild(int index){
    return getRightChildIndex(index) < size;
  }
  public boolean hasParent(int index){
    return hasParent(index) >= 0;
  }
  public int leftChild(int index){
    return items[getLeftChildIndex(index)];
  }
  public int rightChild(int index){
    return items[getRightChildIndex(index)];
  }
  public int parent(int index){
    return items[getParentIndex(index)];
  }
  public void swap(int indexOne, int indexTwo){
    int temp = items[indexOne];
    items[indexOne] = items[indexTwo];
    items[indexTwo] = temp;
  }
  public void ensureCapacity(){
    if(size == capacity){
      capacity = capicity * 2;
      items = Arrays.copyOf(items, capacity);
    }
  }
  public int peek(){
    isEmpty("peek");
    return items[0];
  }
  public void isEmpty(String methodName){
    if(size == 0){
      throw new IllegalStateException("You cannot perform '" + methodName + "'");
    }
  }

}
