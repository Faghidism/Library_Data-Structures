import java.util.ArrayList;

public class Tree {

    // ye node rishe dare

    Node root;

    public Tree() {
        this.root = new Node("root", null, null);
    }


    // tavabe piyade sazi shode



    // ye esm migire, ye node add mishe to bache root
    public void addCategory(String name) {
        Node node = new Node(name, null, root);
        root.childs.add(node);
    }


    // esm va node tree ro migire
    // bazghashti har node ro bachehasho migarde
    // har bacehe dobare search mishe
    // age yeki bod node T bar mogarde
    // age nabod null bar migarde

    public Node searchCategory(String name, Node T) {
        if (T == null) {
            return null;
        }
        if (T.name.equals(name)) {
            return T;
        }
        Node node1;
        for (int i = 0; i < T.childs.size(); i++) {
            node1 = searchCategory(name, T.childs.get(i));
            if (node1 != null) {
                return node1;
            }
        }
        return null;
    }

    // ye esm va subname migire
    // az search category estefadse mikone
    // va name add mishe be bache category

    public void addSubCategory(String name, String subName) {
        Node node = searchCategory(name, root);
        Node node1 = new Node(subName, null, node);
        node.childs.add(node1);
    }

    // esm book va category ke gharare ezafe beshe ro migire
    // search mikone age peyda kard ye node node misaze ba bokk add mishe

    public void addBook(Book book, String name) {
        Node node1 = searchCategory(name, root);
        Node node = new Node(book.name, book, node1);
        node1.childs.add(node);
    }

    // esm niode search miskone
    // bache hash ro migire
    // va to bache hash search mikone age = name bod remove mishe

    public void removeBook(String book, String name) {
        Node node1 = searchCategory(name, root);
        ArrayList<Node> nodes = node1.childs;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).name.equals(book)) {
                nodes.remove(i);
                break;
            }
        }
    }

    // esm search mokone , parent ro migire va az parent list child ro migire
    // va to list child name ro search mikone age = bod delet mishe

    public void removeCategory(String name) {
        Node node1 = searchCategory(name, root);
        Node parent = node1.parent;
        ArrayList<Node> nodes = parent.childs;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).name.equals(node1.name)) {
                nodes.remove(i);
                break;
            }
        }
    }

    // esm book ro migire  va ba category search mikone
    // age = bod return mishe

    public Book searchBook(String book) {
        Node node1 = searchCategory(book, root);
        return node1.book;
    }

    // be sorat bazghasti node haro search mikone
    // age ba node daryafti = bod print mikone

    public void listBook(Node T){
        if (T == null) {
            return;
        }
        if (T.book!=null) {
            System.out.println(T.book);
        }
        Node node1;
        for (int i = 0; i < T.childs.size(); i++) {
            listBook(T.childs.get(i));

        }

    }

    // esm category migire search mikone va bache hasho mighire
    // if else = age book bod print mishe age na mire to category va bache hasho check mikone

    public void listBookCategory(String categoryName){

        Node category =searchCategory(categoryName,root);
        for (int i = 0; i < category.childs.size(); i++) {
            if (category.childs.get(i).book!=null){
                System.out.println(category.childs.get(i).book);
            }else {
                listBookCategory(category.childs.get(i).name);
            }
        }

    }

    // az max heap estefade shode
    // add mikone book ke search shode be max heap

    public void order (String book,MaxHeap maxHeap){
        Book book1=searchBook(book);
        maxHeap.insert(book1);
    }

    // max heap print mikone

    public void listOrder(MaxHeap maxHeap){
        maxHeap.print();
        Book book=maxHeap.extractMax();
        System.out.printf("%s is done\n",book);
    }


}
