import java.util.ArrayList;

/*
node rishe
esm , book , parent , ye arraye az bache hash
constructor har kodom
*/

public class Node {
    String name;
    Book book;
    Node parent;
    ArrayList<Node> childs=new ArrayList<Node>();

    public Node(String name,Book book,Node parent){
        this.name=name;
        this.book=book;
        this.parent=parent;

    }

    // tabdil be reshte

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", book=" + book +
                ", parent=" + parent +
                '}';
    }
}
