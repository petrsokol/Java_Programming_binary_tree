
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
      System.out.print("values of node and parent equal, added inbetween\n");
      node.left = parent.left;
      parent.left = node;
    }
  }

  /*------------------------------------------------------------------------------------------------------------------*/

  public void add (int value)
  {
    // create a node to add
    TreeNode node = new TreeNode(value);

    // add a node
    add(node);
  }

  /*------------------------------------------------------------------------------------------------------------------*/

  public void add(TreeNode node)
  {
    if (node == null)
      return;

    // if list is empty, add to root
    if (root == null) {
      root = node;
      return;
    }

    // if value is less or equal, add to the right branch (recursively)
    addRecursively(node, root);
  }

  /*------------------------------------------------------------------------------------------------------------------*/

  private void popRecursively (int value, TreeNode parent)
  {
    if (parent == null)
      return;

    if (parent.left != null && parent.left.value == value) {
      TreeNode tmp = parent.left;
      parent.left = parent.left.left;
      add(tmp.right);
      tmp.discard();
      return;
    }

    if (parent.right != null && parent.right.value == value) {
      TreeNode tmp = parent.right;
      parent.right = parent.right.left;
      add(tmp.right);
      tmp.discard();
      return;
    }

    popRecursively(value, parent.right);
    popRecursively(value, parent.left);
  }

  /*------------------------------------------------------------------------------------------------------------------*/

  public void pop (int value)
  {
    // tree is empty
    if (root == null) {
      System.out.print("The tree is empty already.\n");
      return;
    }

    // tree does not contain the value
    if (!this.contains(value)) {
      System.out.printf("This tree does not contain %d,\n-> no reason to pop.\n", value);
      return;
    }

    // popping the root
    if (root.value == value) {
      TreeNode tmp = root;
      root = root.left;
      add(tmp.right);
      tmp.discard();
      return;
    }

    popRecursively(value, root);
  }

  /*------------------------------------------------------------------------------------------------------------------*/

  public int get (int value)
  {
    if (this.contains(value))
      return value;
    else {
      System.out.printf("This tree does not contain the value of %d\n", value);
      return -1;
    }
  }

  /*------------------------------------------------------------------------------------------------------------------*/

  private boolean containsRecursively (TreeNode parent, int value)
  {
    if (parent == null)
      return false;

    if (parent.value == value)
      return true;

    return containsRecursively(parent.left, value) || containsRecursively(parent.right, value);
  }

  /*------------------------------------------------------------------------------------------------------------------*/

  public boolean contains (int value)
  {
    if (root == null)
      return false;

    return containsRecursively(root, value);
  }

  /*------------------------------------------------------------------------------------------------------------------*/


  public void print ()
  {
    System.out.print("printing binary tree...\n");

    // tree is empty
    if (root == null) {
      System.out.print("This tree is empty.\n");
      return;
    }

    // tree is not empty
    printRecursively(root);
    System.out.print("\n");
  }

  /*------------------------------------------------------------------------------------------------------------------*/

  public void printRecursively (TreeNode parent)
  {
    // print left branch -> always contains the smallest of values
    if (parent.left != null) {
      printRecursively(parent.left);
    }

    // print itself (after no left branches reamin)
    System.out.println(parent);

    // print right branch -> always contains higher values
    if (parent.right != null)
      printRecursively(parent.right);
  }
}

/*====================================================================================================úterý ve tři================*/