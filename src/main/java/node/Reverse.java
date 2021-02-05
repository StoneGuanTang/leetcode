package node;

/**
 * 反转链表
 * create by tgss on 2019/6/18 14:46
 **/
public class Reverse {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        new Reverse().reverseList(listNode);
    }

    public ListNode reverseList (ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
