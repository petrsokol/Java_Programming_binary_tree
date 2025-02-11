public class Main
{
  public static void main (String[] args)
  {

    // empty tree
    System.out.print("/*---------------------------------------*/\n");
    System.out.print(">> creating empty tree...\n");
    BinarySearchTree bst = new BinarySearchTree();
    bst.print();

    // adding first number
    System.out.print("/*---------------------------------------*/\n");
    System.out.println(">> adding first node...");
    bst.add(8);
    bst.print();

    // adding another as branch
    System.out.print("/*---------------------------------------*/\n");
    System.out.println(">> adding another node...");
    bst.add(5);
    bst.print();

    // adding more branches
    System.out.print("/*---------------------------------------*/\n");
    System.out.println(">> adding more nodes...");
    bst.add(3);
    bst.add(4);
    bst.add(6);
    bst.add(12);
    bst.print();

    // testing the contains() method
    System.out.print("/*---------------------------------------*/\n");
    System.out.println(">> testing bst.contains()...");
    System.out.println(bst.contains(6));
    System.out.println(bst.contains(4));
    System.out.println(bst.contains(7));

    // adding a branch with sub-branches
    System.out.print("/*---------------------------------------*/\n");
    System.out.println(">> adding a complex branch...");
    TreeNode n1 = new TreeNode(16);
    n1.right = new TreeNode(24);
    bst.add(n1);
    bst.print();

    // popping number at the end of chain
    System.out.print("/*---------------------------------------*/\n");
    System.out.println(">> try popping end of chain...");
    bst.pop(4);
    bst.print();
    bst.add(4);

    // popping the root
    System.out.print("/*---------------------------------------*/\n");
    System.out.println(">> try popping the root");
    bst.pop(8);
    bst.print();
    bst.add(8);

    // popping a node with successors
    System.out.print("/*---------------------------------------*/\n");
    System.out.println(">> try popping middle of chain...");
    bst.pop(16);
    bst.print();
    bst.add(16);

    System.out.print("/*---------------------------------------*/\n");
    System.out.println(">> testing bst.get()");
    int a = bst.get(7);
    assert(a != 7);
  }
}