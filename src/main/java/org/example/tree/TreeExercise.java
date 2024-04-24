package org.example.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;

public class TreeExercise {


    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(1,null,null);
        Node<Integer> n2 = new Node<>(2,n1,null);
        Node<Integer> n3 = new Node<>(3,null,null);
        Node<Integer> n4 = new Node<>(4,null,null);
        Node<Integer> n5 = new Node<>(5,null,n4);
        Node<Integer> n6 = new Node<>(6,n2,n5);
        Node<Integer> n7 = new Node<>(7,null,null);
        Node<Integer> n8 = new Node<>(8,null,null);
        Node<Integer> n9 = new Node<>(9,null,null);
        n1.right = n3;
        n1.left = n7;
        n7.right = n8;
        n4.left = n9;
        Tree<Integer> tree = new Tree<>(n6);

        Integer sum = tree.sum();
        System.out.println("sum = " + sum);

        int height = tree.height();
        System.out.println("height = " + height);

        tree.inorderTraverse();
        System.out.println();
        tree.preorderTraverse();
        System.out.println();
        tree.postorderTraverse();
        System.out.println();
        tree.delete(n5);
        tree.preorderTraverse();
    }






    private static class Tree<T>{
        T data;
        Node<T> root;
        Node<T> cur;
        public Tree(Node<T> root){
            this.root = root;
            cur = root;
        }

        void visit(Node<T> node){
            System.out.println("node.data = " + node.data);
        }
        boolean isEmpry(){
            return root == null;
        }


        public int sum(){

            return sum(root);
        }

        private int sum(Node<T> target) {
            int sumVal = 0;
            //Base Case
            if(target == null){
                return 0;
            }else{
                sumVal = (Integer) target.data;
                //recursiveCase
               sumVal += sum(target.left);
               sumVal += sum(target.right);
            }

            return sumVal;
        }

        public int height(){
            return height(root);
        }

        private int height(Node<T> target){
           int heightPlus =0;

           //BaseCase 더 이상 내려갈 수 없음
            if(target == null){
                return 0;
            }else {
                int myHeight = 1;
                int leftheight = myHeight + height(target.left);
                int rightheight = myHeight + height(target.right);
                heightPlus = leftheight > rightheight ? leftheight:rightheight;
            }

            return heightPlus;
        }

        public void preorderTraverse(){
            preorderTraverse(root,(val) -> {
                System.out.print((Integer)val+" ");
            });
        }

        public void preorderTraverse(Node<T> target, Consumer<T> action){
            //Base Case
            if(target == null){
                return;
            }
            action.accept(target.data);
            preorderTraverse(target.left,action);
            preorderTraverse(target.right,action);
        }
        public void inorderTraverse(){
            inorderTraverse(root,(val) -> {
                System.out.print((Integer)val+" ");
            });
        }

        public void inorderTraverse(Node<T> target, Consumer<T> action){
            if(target == null){
                return;
            }
            inorderTraverse(target.left,action);
            action.accept(target.data);
            inorderTraverse(target.right,action);
        }
        public void postorderTraverse(){
            postorderTraverse(root,(val) -> {
                System.out.print((Integer)val+" ");
            });
        }

        public void postorderTraverse(Node<T> target, Consumer<T> action){
            if(target == null){
                return;
            }
            postorderTraverse(target.left,action);
            postorderTraverse(target.right,action);
            action.accept(target.data);

        }

        //재귀호출 x
        public void levelOrder(){
            //흠
            Queue<Node>q = new LinkedList<>();
            Node current = root;
            while (current != null){
                   Visit(current);
                   if(current.left != null)
                       q.add(current.left);
                   if(current.right != null)
                       q.add(current.right);
                   if(q.isEmpty())return;
                   current = q.peek();
                   q.poll();
            }

        }

        private void Visit(Node current) {
        }

        public void iterativePreorder(){
            if(root != null)return;
            Stack<Node> s = new Stack<>();
            s.push(root);
            while (!s.isEmpty()){
                    Node current = s.peek();
                    s.pop();
                    visit(current);

                    if(current.right != null){
                        s.push(current.right);
                    }
                    if(current.left != null)
                        s.push(current.left);

            }
        }
        public void iterativeInorder(){
            if(root != null)return;
            Stack<Node> s = new Stack<>();
            Node current = root;
            while (current != null || !s.isEmpty()){

            }
        }
        public void iterativePostorder(){
            if(root != null)return;
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(root);

            while (!s1.isEmpty()){

            }
            while (!s2.isEmpty()){

            }

        }

        public void delete(Node<T> target){
            //아아.. 오케 postoprder로 도렴ㄴ서 삭제 밑에꺼 작동?

            deletePostOrder(root,target);
        }

        public void deletePostOrder(Node<T> prent,Node<T> target){

            if(prent == null){
                return;
            }else{

                deletePostOrder(prent.left,target);
                deletePostOrder(prent.right,target);


                if(prent.left != null && prent.left == target){
                    prent.left = deleteFrom(prent.left);
                }else if(prent.right != null && prent.right == target){
                    prent.right = deleteFrom(prent.right);
                }

            }
        }

        public Node<T> deleteFrom(Node<T> target){

            if(target == null){
                return null;
            }else{

                target.left = deleteFrom(target.left);
                target.right = deleteFrom(target.right);

            }


            return null;
        }
    }




    private static class Node<T>{
        T data;
        Node<T> left;
        Node<T> right;


        public Node (T data, Node<T> left, Node<T> right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
