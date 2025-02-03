
/*====================================================================================================================*/

public class BinarySearchTree
{
  /*------------------------------------------------------------------------------------------------------------------*/

  TreeNode root;

  /*------------------------------------------------------------------------------------------------------------------*/

  public BinarySearchTree ()
  {
    this.root = null;
  }

  /*------------------------------------------------------------------------------------------------------------------*/

  private void addRecursively (TreeNode node, TreeNode parent)
  {
    // add to the left
    if (node.value < parent.value) {
      if (parent.left == null) {
        System.out.printf("Added node %d as left branch of %d\n", node.value, parent.value);
        parent.left = node;
        return;
      }
      addRecursively(node, parent.left);
    }

    // add to the right
    if (node.value > parent.value) {
      if (parent.right == null) {
        System.out.printf("Added node %d as right branch of %d\n", node.value, parent.value);
        parent.right = node;
        return;
      }
      addRecursively(node, parent.right);
    }

    // value is equal
    if (node.value == parent.value) {
      System.out.printf("values of node and parent equal, added inbetween\n", node.value, parent.value);
      node.left = parent.left;
      parent.left = node;
      return;
    }
  }

  /*------------------------------------------------------------------------------------------------------------------*/

  public void add (int value)
  {
    // create a node to add
    TreeNode node = new TreeNode(value);

    // if list is empty, add to root
    if (root == null) {
      root = node;
      return;
    }

    // if value is less or equal, add to the right branch (recursively)
    addRecursively(node, root);
  }

  /*------------------------------------------------------------------------------------------------------------------*/

  public void pop (int value)
  {

  }

  /*------------------------------------------------------------------------------------------------------------------*/

  public int get (int value)
  {
    return 0;
  }

  /*------------------------------------------------------------------------------------------------------------------*/

  public boolean contains (int value)
  {
    return false;
  }

  /*------------------------------------------------------------------------------------------------------------------*/

  private void printOrderedRecursively (TreeNode parent)
  {
    // print left branch first - contains lower values
    if (parent.left == null) {
      // is at bottom of the chain
      System.out.printf("%d ", parent.value);
      if (parent.right != null)
        printOrderedRecursively(parent.right);
      return;
    } else {
      // continue to the bottom
      printOrderedRecursively(parent.left);
    }

    // print yourself
    System.out.printf("%d ", parent.value);

    // print higher values to the right
    if (parent.right != null)
      printOrderedRecursively(parent.right);
  }

  /*------------------------------------------------------------------------------------------------------------------*/

  public void printOrdered ()
  {
    System.out.printf("printing binary tree...\n");
    if (root == null) {
      System.out.printf("This tree is empty.\n");
      return;
    }

    printOrderedRecursively(root);
    System.out.printf("\n");

  }

  /*------------------------------------------------------------------------------------------------------------------*/

  public void printByLayers ()
  {

  }
}

/*====================================================================================================================*/