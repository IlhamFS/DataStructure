import java.util.*;
class Heap(){
protected int capacity;
 protected int size;
 protected double[] items;

 public Heap(){
   this.capacity = 10;
   this.size = 0;
   this.items = new double[capacity];
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
   return index >= 0;
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
   double temp = items[indexOne];
   items[indexOne] = items[indexTwo];
   items[indexTwo] = temp;
 }

 public void ensureCapacity(){
   if(size == capacity){
     capacity = capacity * 2;
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

 public double poll(){
   isEmpty("poll");
   double head = items[0];
   items[0] = items[size-1];
   size--;
   heapifyDown();
   return head;
 }

 public void add(double value){
   ensureCapacity();
   items[size - 1] = value;
   heapifyUp();
 }

 public void heapifyUp(){
   int index = size - 1;
   while(hasParent(index) && parent(index) < items[index]){
       swap(getParent(index), index);
       index = getParentIndex(index);
   }
 }

 public void heapifyDown(){
       int index = 0;
       while(hasLeftChild(index)){
         if(leftChild(index) < items[index]){
           if(rightightChild(index) < leftChild(index) && hasRightChild(index)){
             swap(getRightChildIndex(index), index);
             index = getRightChildIndex(index);
           }else{
             swap(getLeftChildIndex(index), index);
             index = getLeftChildIndex(index);
           }
         }
       }
 }
