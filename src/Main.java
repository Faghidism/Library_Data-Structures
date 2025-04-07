import java.util.Scanner;


/*
Farid Afrakhte    990122680092
Golsa Saberi      1399012268096
*/

public class Main {

    public static void initialize(Tree tree){
        Node parent=tree.root;
        Node node=new Node("university",null,parent);
        parent.childs.add(node);
        node=new Node("public",null,parent);
        parent.childs.add(node);

        parent=parent.childs.get(0);
        node=new Node("engineering",null,parent);
        parent.childs.add(node);
        node=new Node("humanities",null,parent);
        parent.childs.add(node);
        node=new Node("Science",null,parent);
        parent.childs.add(node);

        parent=parent.parent.childs.get(1);
        Book book=new Book("janatan va morgh daryayi","aaa",50000);
        node=new Node("janatan va morgh daryayi",book,parent);
        parent.childs.add(node);
        node=new Node("fantasises",null,parent);
        parent.childs.add(node);

        book=new Book("lord of rings","aaa",70000);
        node=new Node("lord of rings",book,parent);
        parent.childs.get(1).childs.add(node);

        parent=tree.root.childs.get(0).childs.get(0);
        node=new Node("electricity",null,parent);
        parent.childs.add(node);
        node=new Node("computer",null,parent);
        parent.childs.add(node);

        parent=parent.childs.get(1);
        book=new Book("data structure","aaa",75000);
        node=new Node("data structure",book,parent);
        parent.childs.add(node);
        book=new Book("operation system","aaa",75000);
        node=new Node("operation system",book,parent);
        parent.childs.add(node);
        book=new Book("assembly","aaa",75000);
        node=new Node("assembly",book,parent);
        parent.childs.add(node);

    }

    public static void command(String order,Tree T,MaxHeap maxHeap){
        String[] orders=order.split(" ");
        if(orders[0].equals("add")){
            if(orders[1].equals("category")){
                T.addCategory(orders[2]);
            }

            if(orders[1].equals("subcategory")){
                T.addSubCategory(orders[4],orders[2]);
            }

            if(orders[1].equals("book")){
                Book book=new Book(orders[2],orders[3],Integer.parseInt(orders[4]));
                T.addBook(book,orders[6]);
            }
        }

        if(orders[0].equals("remove")){
            if(orders[1].equals("book")){
                T.removeBook(orders[2],orders[4]);
            }

            if(orders[1].equals("category")){
                T.removeCategory(orders[2]);
            }
        }

        if(orders[0].equals("search")){
            T.searchBook(orders[2]);
        }

        if(orders[0].equals("list")){
            if (orders.length==2 && orders[1].equals("books")) {
                T.listBook(T.root);
            }
        }

        if(orders[0].equals("list")){
            if (orders.length>2) {
                T.listBookCategory(orders[3]);
            }
        }

        if(orders[0].equals("order")){
            T.order(orders[1],maxHeap);
        }

        if(orders[0].equals("list")){
            if (orders.length==2 && orders[1].equals("orders")) {
                T.listOrder(maxHeap);
            }
        }



    }

    public static void main(String[] args) {

        // tarif tree

        Tree tree=new Tree();

        initialize(tree);
        MaxHeap maxHeap=new MaxHeap(20);
        Scanner scanner=new Scanner(System.in);
        while (true){
            command(scanner.nextLine(),tree,maxHeap);
        }

    }

}

