package RBT;

class Node 
{
  int data;
  Node parent;
  Node left;
  Node right;
  int color;
}

public class RedBlack {
  private Node root;
  private Node TNULL;
  static int cr,reclr,probe;
  public void leftRotate(Node x){
    Node y = x.right;
    x.right = y.left;
    if (y.left != TNULL) {
      y.left.parent = x;
    }
    y.parent = x.parent;
    if (x.parent == null) {
      this.root = y;
    } else if (x == x.parent.left) {
      x.parent.left = y;
    } else {
      x.parent.right = y;
    }
    y.left = x;
    x.parent = y;
  }
  public void rightRotate(Node x) {
    Node y = x.left;
    x.left = y.right;
    if (y.right != TNULL) {
      y.right.parent = x;
    }
    y.parent = x.parent;
    if (x.parent == null) {
      this.root = y;
    } else if (x == x.parent.right) {
      x.parent.right = y;
    } else {
      x.parent.left = y;
    }
    y.right = x;
    x.parent = y;
  }
  public void insert(int key) {
    Node z = new Node();
    z.parent = null;
    z.data = key;
    z.left = TNULL;
    z.right = TNULL;
    z.color = 1;
    Node y = null;
    Node x = this.root;
    while (x != TNULL)
    {
      y = x;
      if (z.data < x.data) 
      {
          
        x = x.left;
      } 
      else 
      {
        x = x.right;
      }
      probe+=1;
    }
    z.parent = y;
    if (y == null) {
      root = z;
    } else if (z.data < y.data) {
      y.left = z;
    } else {
      y.right = z;
    }
    if (z.parent == null) {
      z.color = 0;
      reclr+=1;
      return;
    }
    if (z.parent.parent == null) {
        reclr+=1;
      return;
    }
    insert_fixup(z);
  }
  private void insert_fixup(Node z) {
    Node y;
    while (z.parent.color == 1) {
      if (z.parent == z.parent.parent.left) {
        y = z.parent.parent.right;
        if (y.color == 1) 
        {
          y.color = 0;
          z.parent.color = 0;
          z.parent.parent.color = 1;
          reclr+=3;
          z = z.parent.parent;
        }
        else
        {
          if (z == z.parent.right) 
          {
            z = z.parent;
            leftRotate(z);
            cr+=1;
          }
          z.parent.color = 0;
          z.parent.parent.color = 1;
          reclr+=2;
          rightRotate(z.parent.parent);
          cr+=1;
        }
      } else {
       y = z.parent.parent.left;
        if (y.color == 1) 
        {
          y.color = 0;
          z.parent.color = 0;
          z.parent.parent.color = 1;
          z = z.parent.parent;
          reclr+=3;
        }
        else
        {
          if (z == z.parent.left) 
          {
            z = z.parent;
            rightRotate(z);
            cr+=1;
          }
          z.parent.color = 0;
          z.parent.parent.color = 1;
          reclr+=2;
          leftRotate(z.parent.parent);
          cr+=1;
        }
      }
      if (z == root) 
      {
        break;
      }
    }
    root.color = 0;
    reclr+=1;
  }
  private void traversal(Node node) {
    if (node != TNULL) {
      traversal(node.left);
      System.out.print(node.data + " ");
      traversal(node.right);
    }
  }
  private Node search(Node node, int key) {
    if (node == TNULL || key == node.data) {
        probe+=1;
      return node;
    }
    if (key < node.data) {
         probe+=1;
      return search(node.left, key);
    }
     probe+=1;
    return search(node.right, key);
  }
  private void rbTransplant(Node u, Node v) {
    if (u.parent == null) {
      root = v;
    } else if (u == u.parent.left) {
      u.parent.left = v;
    } else {
      u.parent.right = v;
    }
    v.parent = u.parent;
  }
  private void delete(int key) {
    Node z = TNULL;
    Node x, y;
    Node node=this.root;
    while (node != TNULL) {
      if (node.data == key) {
        z = node;
      }

      if (node.data <= key) {
        node = node.right;
      } else {
        node = node.left;
      }
    }
    if (z == TNULL) {
      System.out.println("Couldn't find key in the tree");
      return;
    }
    y = z;
    int yOriginalColor = y.color;
    if (z.left == TNULL) {
      x = z.right;
      rbTransplant(z, z.right);
    } else if (z.right == TNULL) {
      x = z.left;
      rbTransplant(z, z.left);
    } else {
      y = minimum(z.right);
      yOriginalColor = y.color;
      x = y.right;
      if (y.parent == z) {
        x.parent = y;
      } else {
        rbTransplant(y, y.right);
        y.right = z.right;
        y.right.parent = y;
      }
    rbTransplant(z, y);
    y.left = z.left;
    y.left.parent = y;
    y.color = z.color;
    reclr+=1;
    }
    if (yOriginalColor == 0) {
      fixDelete(x);
    }
  }
  private void fixDelete(Node x) {
    Node s;
    while (x != root && x.color == 0) {
      if (x == x.parent.left) {
        s = x.parent.right;
        if (s.color == 1) {
          s.color = 0;
          x.parent.color = 1;
          reclr+=2;
          leftRotate(x.parent);
          cr+=1;
          s = x.parent.right;
        }
        if (s.left.color == 0 && s.right.color == 0) {
          s.color = 1;
          reclr+=1;
          x = x.parent;
        } else {
          if (s.right.color == 0) {
            s.left.color = 0;
            s.color = 1;
            reclr+=2;
            rightRotate(s);
            cr+=1;
            s = x.parent.right;
          }
          s.color = x.parent.color;
          x.parent.color = 0;
          s.right.color = 0;
          reclr+=2;
          leftRotate(x.parent);
          cr+=1;
          x = root;
        }
      } else {
        s = x.parent.left;
        if (s.color == 1) {
          s.color = 0;
          x.parent.color = 1;
          reclr+=2;
          rightRotate(x.parent);
          cr+=1;
          s = x.parent.left;
        }
        if (s.right.color == 0 && s.right.color == 0) {
          s.color = 1;
          reclr+=1;
          x = x.parent;
        } else {
          if (s.left.color == 0) {
            s.right.color = 0;
            s.color = 1;
            reclr+=2;
            leftRotate(s);
            cr+=1;
            s = x.parent.left;
          }
          s.color = x.parent.color;
          x.parent.color = 0;
          s.left.color = 0;
          reclr+=3;
          rightRotate(x.parent);
          cr+=1;
          x = root;
        }
      }
    }
    x.color = 0;
  }
  private void printHelper(Node root, String indent, boolean last) {
    if (root != TNULL) {
      System.out.print(indent);
      if (last) {
        System.out.print("R----");
        indent += "   ";
      } else {
        System.out.print("L----");
        indent += "|  ";
      }
      String sColor = root.color == 1 ? "R" : "B";
      System.out.println(root.data + "(" + sColor + ")");
      printHelper(root.left, indent, false);
      printHelper(root.right, indent, true);
    }
  }
  public RedBlack() {
    TNULL = new Node();
    TNULL.color = 0;
    TNULL.left = null;
    TNULL.right = null;
    root = TNULL;
  }

  public void inorder() {
    traversal(this.root);
  }

  public Node searchTree(int k) {
    return search(this.root, k);
  }
  public Node minimum(Node node) {
    while (node.left != TNULL) {
      node = node.left;
    }
    return node;
  }
  public void printTree() {
    printHelper(this.root, "", true);
  }
  public static void main(String[] args) {
    RedBlack bst = new RedBlack();
    cr=0;reclr=0;
    System.out.println("-----INSERT-----");
    bst.insert(41);
    bst.printTree();
    System.out.println("Number of rotations for 41: "+cr);
    System.out.println("Number of recoloring operation: "+reclr);
    System.out.println("Number of probes: "+probe);
    probe=0;
    cr=0;reclr=0;
    bst.insert(38);
    bst.printTree();
    System.out.println("Number of rotations for 38: "+cr);
    System.out.println("Number of recoloring operation: "+reclr);
    System.out.println("Number of probes : "+probe);
    probe=0;
    cr=0;reclr=0;
    bst.insert(31);
    bst.printTree();
    System.out.println("Number of rotations for 31: "+cr);
    System.out.println("Number of recoloring operation: "+reclr);
    System.out.println("Number of probes: "+probe);
    probe=0;
    cr=0;reclr=0;
    bst.insert(12);
    bst.printTree();
    System.out.println("Number of rotations for 12: "+cr);
    System.out.println("Number of recoloring operation: "+reclr);
    System.out.println("Number of probes: "+probe);
    probe=0;
    cr=0;reclr=0;
    bst.insert(19);
    bst.printTree();
    System.out.println("Number of rotations for 19: "+cr);
    System.out.println("Number of recoloring operation: "+reclr);
    System.out.println("Number of probes: "+probe);
    probe=0;
    bst.searchTree(31);
    System.out.println("-----SEARCH-----");
    System.out.println("Number of probes for 31: "+probe);
    probe=0;
    System.out.println("-----DELETE-----");
    System.out.println("deleting 19");
    bst.delete(19);
    bst.printTree();
    System.out.println("Number of rotations for 19: "+cr);
    System.out.println("Number of recoloring operation: "+reclr);
  }
}


 