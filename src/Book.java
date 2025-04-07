/*
class Book
esm ketab + esm nevisande + pricesh
constructor har kodom
*/

public class Book {
    String name;
    String writerName;
    int price;

    public Book(String name,String writerName, int price){
        this.name=name;
        this.writerName=writerName;
        this.price=price;
    }

    // tabdil be reshte

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", writerName='" + writerName + '\'' +
                ", price=" + price +
                '}';
    }
}
