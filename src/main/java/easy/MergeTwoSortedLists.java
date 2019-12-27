package easy;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode next = new ListNode(0);
        ListNode result = next;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                next.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                next.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            next = next.next;
        }
        next.next = l1 == null ? l2 : l1;
        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(final String... args) {
        final MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        final ListNode result = mergeTwoSortedLists.mergeTwoLists(buildList(1, 1, 2, 3), buildList(1, 2, 3, 3, 4));
        print(result);
    }

    private static void print(ListNode result) {
        while(result.next != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println(result.val);
    }

    private static ListNode buildList(final int... ints) {
        ListNode next = new ListNode(0);
        ListNode result = next;
        for(int i : ints) {
            next.next = new ListNode(i);
            next = next.next;
        }
        return result.next;
    }
}
