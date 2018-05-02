package com.util.dataStructure.Array;
/*
 * Given a sorted integer array of length n, 
 * create a balanced Binary Search Tree using elements of the array.

 */
public class HeightBalancedBSTfromSortedArray {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        Node root = generateHeightBalancedBSTfromSortedArray(array,0,array.length-1);
        Node.inorderTraversal(root);
    }

    private static Node generateHeightBalancedBSTfromSortedArray(int[] array,int left,int right) {
        // TODO Auto-generated method stub
        if(array.length==0 || array ==null || left >right){
            return null;
        }
        Node root=null;

        int mid = (left+right)/2;
        root = new Node(array[mid]);
        root.left =generateHeightBalancedBSTfromSortedArray(array,left,mid-1);
        root.right =generateHeightBalancedBSTfromSortedArray(array,mid+1,right);


        return root;
    }

}

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data=data;
    }

    public static void inorderTraversal(Node root){
        if(root ==null){
            return;
        }
        inorderTraversal(root.left);

        /* then print the data of node */
        System.out.print(root.data + " ");

        inorderTraversal(root.right);
    }
}