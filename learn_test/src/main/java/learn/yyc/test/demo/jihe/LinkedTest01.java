package learn.yyc.test.demo.jihe;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/5/29 0029 下午 15:37
 */
public class LinkedTest01 {


    public static void main(String[] args) {
        Node node = new Node("a");
        Node node1 = new Node("b");
        Node node2 = new Node("c");
        Node node3 = new Node("d");
        Node node4 = new Node("e");
        node3.setNext(node4);
        node2.setNext(node3);
        node1.setNext(node2);
        node.setNext(node1);

//        System.out.println(getLastK(node, 2));

        Node nodeResult = fanzhuan(node);
        System.out.println(123);
    }


    private  static String getLastK(Node node, int k) {
        Node temp = node;
        while (node.getNext() != null) {
            k--;
            node = node.getNext();
            if (k <= 0) {
                temp = temp.getNext();
            }
        }
        return temp.getData();
    }

    private static Node fanzhuan(Node node){

        Node fanzhuan = null;
        while (node.getNext() != null){
            Node next = node.getNext();
            node.setNext(fanzhuan);
            fanzhuan = node;
            node = next;
        }
        node.setNext(fanzhuan);
        fanzhuan = node;
        // A->B->C->D->NULL
        // A->NULL
        // B->A
        //
        //
        //
        return fanzhuan;
    }


}
