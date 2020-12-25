package com.hzw.e_set_map.b_linkedlistset;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description
 * @createTime 2020/12/25 10:36 AM
 */
public class LinkedListSet<E> implements Set<E> {

  private LinkedList<E> linkedList;

  public LinkedListSet(){
    linkedList = new LinkedList<E>();
  }
  public void add(E e) {
    if (!linkedList.contains(e)) {
      linkedList.addFirst(e);
    }
  }

  public void remove(E e) {

    linkedList.removeElement(e);
  }

  public boolean contains(E e) {
    return linkedList.contains(e);
  }

  public int getSize() {
    return linkedList.getSize();
  }

  public boolean isEmpty() {
    return linkedList.isEmpty();
  }
}
