import java.util.LinkedList;
class QueueWithLinkedList<E>{
  private LinkedList<E> list = new LinkedList<E>();
  public void enqueue(E item){
    list.addLast(item);
  }
  public E dequeue(){
    return list.poll();
  }
  public boolean isEmpty(){
    return list.isEmpty();
  }
  public boolean hasItems(){
    return !list.isEmpty();
  }
  public int size(){
    return list.size();
  }
  public void addItems(QueueWithLinkedList<? extends E> q){
    while(q.hasItems())
      list.enqueue(q.dequeue());
  }
}
