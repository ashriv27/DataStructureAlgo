package com.redblack.insertion;

/**
 * @author Aviral Shrivastava
 */

// Define node class which contain its attributes like color ,data

class Node {
	int data;
	Node parent;
	Node left;
	Node right;
	int color;
}

public class RBTree {
	private Node root;
	private Node TNULL;

//Code to balance the R-B tree after insertion of new node
	private void balanceInsert(Node k, RBTree rbt) {
		Node u;
		while (k.parent.color == 1) {
			if (k.parent == k.parent.parent.right) {
				u = k.parent.parent.left;
				if (u.color == 1) {
					System.out.println("Updating colors: " + k.data + "'s uncle to black and " + k.data
							+ "'s parent to black and " + k.data + "'s grandparent to red");
					u.color = 0;
					k.parent.parent.color = 1;
					k.parent.color = 0;
					k = k.parent.parent;
					System.out.println();
					rbt.printTree();
				} else {
					if (k == k.parent.left) {
						k = k.parent;
						System.out.println();
						System.out.println("-----Rotate Right-----");
						rightRotate(k, rbt);
					}
					System.out.println("Changing " + k.data + "'s parent color to black" + " and changing " + k.data
							+ "'s grandparent color to red");
					k.parent.parent.color = 1;
					k.parent.color = 0;
					System.out.println();
					rbt.printTree();
					System.out.println();
					System.out.println("---Rotate Left----");
					leftRotate(k.parent.parent, rbt);
				}
			} else {
				u = k.parent.parent.right;
				if (u.color == 1) {
					System.out.println("Updating colors: " + k.data + "'s uncle to black and" + k.data
							+ "'s parent to black and " + k.data + "'s grandparent to red");
					u.color = 0;
					k.parent.color = 0;
					k.parent.parent.color = 1;
					k = k.parent.parent;
					System.out.println();
					rbt.printTree();
				} else {
					if (k == k.parent.right) {
						k = k.parent;
						System.out.println();
						System.out.println("---Rotate Left-----");
						leftRotate(k, rbt);
					}
					k.parent.color = 0;
					k.parent.parent.color = 1;
					System.out.println();
					System.out.println("---Rotate Right----");
					rightRotate(k.parent.parent, rbt);
				}
			}
			if (k == root) {
				break;
			}
		}
		root.color = 0;
	}

	private void print(Node root, String start, boolean last) {
		if (root != TNULL) {
			System.out.print(start);
			if (last) {
				System.out.print("R----");
				start += "   ";
			} else {
				System.out.print("L----");
				start += "|  ";
			}

			// Considering Red color as 1 and black as 0
			String sColor = root.color == 1 ? "RED" : "BLACK";
			System.out.println(root.data + "(" + sColor + ")");
			print(root.left, start, false);
			print(root.right, start, true);
		}
	}

	public RBTree() {
		TNULL = new Node();
		TNULL.color = 0;
		TNULL.left = null;
		TNULL.right = null;
		root = TNULL;
	}

	public Node minimum(Node node) {
		while (node.left != TNULL) {
			node = node.left;
		}
		return node;
	}

	public Node maximum(Node node) {
		while (node.right != TNULL) {
			node = node.right;
		}
		return node;
	}

	public Node successor(Node x) {
		if (x.right != TNULL) {
			return minimum(x.right);
		}

		Node y = x.parent;
		while (y != TNULL && x == y.right) {
			x = y;
			y = y.parent;
		}
		return y;
	}

	public Node predecessor(Node x) {
		if (x.left != TNULL) {
			return maximum(x.left);
		}

		Node y = x.parent;
		while (y != TNULL && x == y.left) {
			x = y;
			y = y.parent;
		}

		return y;
	}

	public void leftRotate(Node x, RBTree rbt) {
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
		System.out.println("\n----After Left Rotate-------\n");
		rbt.printTree();
	}

	public void rightRotate(Node x, RBTree rbt) {
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
		System.out.println("\n----After Right Rotate----\n");
		rbt.printTree();
	}

	public void insert(int key, RBTree rbt) {
		Node node = new Node();
		node.parent = null;
		node.data = key;
		node.left = TNULL;
		node.right = TNULL;
		node.color = 1;

		Node y = null;
		Node x = this.root;

		while (x != TNULL) {
			y = x;
			if (node.data < x.data) {
				x = x.left;
			} else {
				x = x.right;
			}
		}

		node.parent = y;
		if (y == null) {
			root = node;
		} else if (node.data < y.data) {
			y.left = node;
		} else {
			y.right = node;
		}

		if (node.parent == null) {
			node.color = 0;
			return;
		}

		if (node.parent.parent == null) {
			return;
		}

		System.out.println();
		rbt.printTree();
		System.out.println();
		balanceInsert(node, rbt);
	}

	// Balance the tree after deletion of a node
	private void balanceDelete(Node x, RBTree rbt) {
		Node s;
		while (x != root && x.color == 0) {
			if (x == x.parent.left) {
				s = x.parent.right;
				if (s.color == 1) {
					System.out.println("\n Updating " + x.data + "'s uncle color to black and " + x.data
							+ "'s parent color to red");
					s.color = 0;
					x.parent.color = 1;
					System.out.println("\n After chaning colors of nodes, tree looks like");
					rbt.printTree();
					System.out.println("--Now Rotate Left--");
					leftRotate(x.parent, rbt);
					s = x.parent.right;
				}

				if (s.left.color == 0 && s.right.color == 0) {

					s.color = 1;
					x = x.parent;
				} else {
					if (s.right.color == 0) {
						s.left.color = 0;
						s.color = 1;
						rightRotate(s, rbt);
						s = x.parent.right;
					}

					s.color = x.parent.color;
					x.parent.color = 0;
					s.right.color = 0;
					leftRotate(x.parent, rbt);
					x = root;
				}
			} else {
				s = x.parent.left;
				System.out.println(
						"\n Updating " + x.data + "'s uncle color to black and " + x.data + "'s parent color to red");
				if (s.color == 1) {
					s.color = 0;
					x.parent.color = 1;
					System.out.println("\n After chaning colors of nodes, tree looks like");
					rbt.printTree();
					rightRotate(x.parent, rbt);
					s = x.parent.left;
				}

				if (s.right.color == 0 && s.right.color == 0) {
					System.out.println("\n Updating " + x.data + "'s uncle color to red");
					s.color = 1;
					x = x.parent;
				} else {
					if (s.left.color == 0) {
						System.out.println(
								"\n Updating " + x.data + "'s uncle color to red and " + x.data + "'s color to black");
						s.right.color = 0;
						s.color = 1;
						System.out.println("\n Then rotate left");
						leftRotate(s, rbt);
						s = x.parent.left;
					}

					System.out.println("\n change uncle's color to its parent color and assign black to parent");
					s.color = x.parent.color;
					x.parent.color = 0;
					s.left.color = 0;
					System.out.println("\n Then rotate right");
					rightRotate(x.parent, rbt);
					x = root;
				}
			}
		}
		x.color = 0;
	}

	private void rbTransplant(Node a, Node b) {
		if (a.parent == null) {
			root = b;
		} else if (a == a.parent.left) {
			a.parent.left = b;
		} else {
			a.parent.right = b;
		}
		b.parent = a.parent;
	}

	private void deleteNodeHelper(Node node, int key, RBTree rbt) {
		Node z = TNULL;
		Node x, y;
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
			System.out.println("Not found key in tree");
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
		}
		System.out.println();
		rbt.printTree();
		if (yOriginalColor == 0) {
			balanceDelete(x, rbt);
		}
	}

	public Node getRoot() {
		return this.root;
	}

	public void deleteNode(int data, RBTree rbt) {
		deleteNodeHelper(this.root, data, rbt);
	}

	public void printTree() {
		print(this.root, "", true);
	}

	public static void main(String[] args) {
		RBTree rbt = new RBTree();
		rbt.insert(9, rbt);
		rbt.insert(1, rbt);
		rbt.insert(12, rbt);
		rbt.insert(0, rbt);
		rbt.insert(4, rbt);
		rbt.insert(11, rbt);
		rbt.insert(18, rbt);
		rbt.insert(2, rbt);
		rbt.insert(7, rbt);
		rbt.insert(14, rbt);
		rbt.insert(19, rbt);
		rbt.insert(5, rbt);
		rbt.insert(13, rbt);
		rbt.insert(15, rbt);
		System.out.println();
		System.out.println("-----------Original Tree--------------");
		rbt.printTree();
		System.out.println();
		System.out.println("-----Inserting 16 in tree-----------");
		rbt.insert(16, rbt);
		System.out.println("\n Final Tree after inserting 16");
		rbt.printTree();
		System.out.println();
		System.out.println("\n Now Deleting 1 from tree");
		rbt.deleteNode(1, rbt);
		System.out.println("\n Final Tree after deleting 1");
		rbt.printTree();
	}
}