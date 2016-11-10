class StackWithLlinkedList{
  private LinkedList<E> list= new LinkedList<E>();

  public E peek(){
    return list.peek();
  }
  public E pop(){
    return list.poll();
  }
  public void push(E item){
    list.addFirst(item);
  }
}
