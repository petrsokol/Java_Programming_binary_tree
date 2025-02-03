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
    bst.printRecursively(bst.root);

    System.out.println(bst.contains(6));
    System.out.println(bst.contains(4));
    System.out.println(bst.contains(7));

    TreeNode n1 = new TreeNode(16);
    n1.right = new TreeNode(24);
    bst.add(n1);
    bst.printRecursively(bst.root);
    bst.printOrdered();

    bst.pop(4);
    bst.printOrdered();
    bst.printRecursively(bst.root);
    bst.add(4);

    bst.pop(8);
    bst.printOrdered();
    bst.printRecursively(bst.root);

    bst.add(8);
    bst.printOrdered();
    bst.printRecursively(bst.root);

    bst.pop(16);
    bst.printOrdered();
    bst.printRecursively(bst.root);

    int a = bst.get(7);
    assert(a != 7);
  }
}