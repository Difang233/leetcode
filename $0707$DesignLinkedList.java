public class $0707$DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtIndex(0,1);
        linkedList.addAtIndex(0,2);
        linkedList.addAtIndex(2,2);
        linkedList.deleteAtIndex(3);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
    }
}

class MyLinkedList {
    public int val;

    public MyLinkedList next;

    public MyLinkedList() {

    }

    public MyLinkedList(int val){
        this.val = val;
    }

    public MyLinkedList(int val, MyLinkedList next){
        this.val = val;
        this.next = next;
    }

    public int get(int index) {
        //索引的取值范围是[0, length - 1]
        if (index < 0){
            return -1;
        }
        //当前实例作为头节点
        MyLinkedList p = this;
        for (int i = 0; i <= index; i++) {
            if (p.next == null){
                return -1;
            }
            p = p.next;
        }
        return p.val;
    }

    public void addAtHead(int val) {
        MyLinkedList newNode = new MyLinkedList(val, this.next);
        this.next = newNode;
    }

    public void addAtTail(int val) {
        MyLinkedList newNode = new MyLinkedList(val), p = this;
        while (p.next != null){
            p = p.next;
        }
        p.next = newNode;
    }

    public void addAtIndex(int index, int val) {
        index = index < 0 ? 0 : index;
        //找到index前一个节点
        MyLinkedList p = this;
        for (int i = 0; i < index; i++) {
            if (p.next == null){
                return;
            }
            p = p.next;
        }
        MyLinkedList newNode = new MyLinkedList(val, p.next);
        p.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0){
            return;
        }
        MyLinkedList p = this;
        for (int i = 0; i < index; i++) {
            if (p.next == null){
                return;
            }
            p = p.next;
        }
        p.next = p.next == null ? null : p.next.next;
    }
}