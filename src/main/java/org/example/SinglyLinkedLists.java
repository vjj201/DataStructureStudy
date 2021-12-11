package org.example;

public class SinglyLinkedLists {
    //首節點
    private final SinglyLinkedNode head;
    //長度
    private int length;

    //初始化
    public SinglyLinkedLists() {
        head = new SinglyLinkedNode(0, null);
    }

    //添加節點
    public void addLinkedList(SinglyLinkedNode node) {
        SinglyLinkedNode temp = head.next;
        if (temp == null) {
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        length++;
        temp.next = node;
    }

    //是否為空
    public boolean isEmpty() {
        return head.next == null;
    }

    //刪除節點
    public void removeLinkedList(Integer id) {
        if (isEmpty()) {
            System.out.println("列表為空");
            return;
        }
        SinglyLinkedNode temp = head;
        boolean flag = false;
        while (temp.next != null) {
            if (temp.next.id.equals(id)) {
                SinglyLinkedNode node = temp.next;
                if (node.next == null) {
                    flag = true;
                }
                break;
            }
            temp = temp.next;
        }
        length--;
        if (flag) {
            temp.next = null;
            return;
        }
        temp.next = temp.next.next;
    }

    //顯示
    public void showAllList() {
        if (isEmpty()) {
            System.out.println("列表為空");
            return;
        }
        SinglyLinkedNode temp = head;
        while (temp.next != null) {
            System.out.println(temp);
        }
    }

    //修改節點
    public void updateNode(SinglyLinkedNode node) {
        if (isEmpty()) {
            System.out.println("列表為空");
            return;
        }
        SinglyLinkedNode temp = head;
        while (temp.next != null) {
            if (temp.id.equals(node.id)) {
                temp.value = node.value;
                return;
            }
            temp = temp.next;
        }
    }

    class SinglyLinkedNode {
        private Integer id;
        private String value;
        private SinglyLinkedNode next;

        public SinglyLinkedNode(Integer id, String value) {
            this.id = id;
            this.value = value;
        }

        @Override
        public String toString() {
            return "SinglyLinkedNode{" +
                    "id=" + id +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}

