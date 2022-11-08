package lab3;

import java.util.*;

public class Question2 {

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	static TreeNode insertTreeNode(TreeNode root, int data) {

		if (root == null) {
			return new TreeNode(data);
		}
		if (root.data > data) {
			root.left = insertTreeNode(root.left, data);
		} else {
			root.right = insertTreeNode(root.right, data);
		}
		return root;
	}

	public static void main(String[] args) {

		TreeNode root = null;

		root = insertTreeNode(root, 40);
		root = insertTreeNode(root, 20);
		root = insertTreeNode(root, 50);
		root = insertTreeNode(root, 10);
		root = insertTreeNode(root, 60);
		root = insertTreeNode(root, 30);
		root = insertTreeNode(root, 70);

		int sum = 130;

		boolean result = findSumPair(root, sum);

		if (!result) {
			System.out.println("No Such pair Exists");
		}

	}

	static boolean findSumPair(TreeNode root, int sum) {
		HashSet<Integer> data = new HashSet<Integer>();
		return isPairExists(root, data, sum);
	}

	static boolean isPairExists(TreeNode root, HashSet<Integer> data, int sum) {
		if (root == null)
			return false;

		int c = sum - root.data;

		if (data.contains(c)) {
			System.out.println("The sum pair exists for the sum " + sum);
			System.out.println("The pair's are : " + root.data +" & " + c);
			return true;
		} else {
			data.add(root.data);
		}

		return isPairExists(root.left, data, sum) || isPairExists(root.right, data, sum);
	}

}
