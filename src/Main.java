import com.sun.source.tree.BinaryTree;

public class Main
{
  public static void main (String[] args)
  {
    System.out.println("Hello world!");

    BinarySearchTree bst = new BinarySearchTree();

    bst.add(8);
    bst.printOrdered();
    bst.add(5);
    bst.printOrdered();
    bst.add(3);
    bst.printOrdered();
    bst.add(4);
    bst.printOrdered();
    bst.add(6);
    bst.printOrdered();
    bst.add(12);
    bst.printOrdered();
  }
}