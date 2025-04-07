
// arraye book + size + maxsize

public class MaxHeap {
    private Book[] Heap;
    private int size;
    private int maxsize;

    // constructor in 3 ta

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new Book[this.maxsize];
    }

    // andis pedar

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    // andis farzand chap

    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    // andis farzand rast

    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    // check mikone nide ozv barg derakht hast ya na

    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    // swap kardan node ha

    private void swap(int fpos, int spos) {
        Book tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // tabe maxHeapify

    private void maxHeapify(int pos) {
        if (isLeaf(pos))
            return;

        if (Heap[pos].price < Heap[leftChild(pos)].price
                || Heap[pos].price < Heap[rightChild(pos)].price) {

            if (Heap[leftChild(pos)].price
                    > Heap[rightChild(pos)].price) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    // age price >= on farzand bod swap beshan

    public void insert(Book element) {
        Heap[size] = element;

        int current = size;
        while (Heap[current].price > Heap[parent(current)].price || Heap[current].price == Heap[parent(current)].price) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    // print tree

    public void print() {

        for (int i = 0; i < size / 2; i++) {

            System.out.print("Parent Node : " + Heap[i]);

            if (leftChild(i)
                    < size) // if the child is out of the bound
                // of the array
                System.out.print(" Left Child Node: "
                        + Heap[leftChild(i)]);

            if (rightChild(i)
                    < size) // if the right child index must not
                // be out of the index of the array
                System.out.print(" Right Child Node: "
                        + Heap[rightChild(i)]);

            System.out.println(); // for new line
        }
    }

    // node max ro ke andis 0 dare return mikone va yeki az andis kam mikone

    public Book extractMax() {
        Book popped = Heap[0];
        Heap[0] = Heap[--size];
        maxHeapify(0);
        return popped;
    }
}