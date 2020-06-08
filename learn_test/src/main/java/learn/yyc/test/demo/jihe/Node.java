package learn.yyc.test.demo.jihe;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/5/29 0029 下午 15:37
 */

public class Node {
    private Node next;

    private Node pre;

    private String data;

    public Node() {
    }

    public Node(String data) {
        this.data = data;
    }

    public Node(Node next, Node pre, String data) {
        this.next = next;
        this.pre = pre;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
