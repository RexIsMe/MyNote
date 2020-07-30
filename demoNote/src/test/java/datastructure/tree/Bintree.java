package datastructure.tree;

import lombok.Value;

import java.util.HashMap;

/**
 * @author Cytang
 * @title: Bintree
 * @projectName demoNote
 * @description: 二叉查找树（BST）
 * @date 2020/7/309:08
 */
public class Bintree<Key extends Comparable<Key>, Values> {
    private Node root;

    private class Node{
        private Key key;
        private Value val;
        private Node left, right;
        private int size;

        public Node(Key key, Value val, int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    public Bintree() {
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null){
            return 0;
        } else {
            return x.size;
        }
    }

    //查找
    public Value get(Key key){
        return get(root, key);
    }

    private Value get(Node x, Key key){
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            return get(x.left, key);
        } else if(cmp > 0){
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    //插入
    public void put(Key key, Value val){
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val){
        if(x == null){
            return new Node(key, val, 1);
        }

        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            return put(x.left, key, val);
        } else if(cmp > 0){
            return put(x.right, key, val);
        } else {
            x.val = val;
        }

        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }


    public Key min(){
        return min(root).key;
    }

    private Node min(Node x){
        if(x.left == null){
            return x;
        } else {
            return min(x.left);
        }
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    /**
     * 删除以x为根基诶单的子树最小值
     * @param x
     * @return
     */
    private Node deleteMin(Node x){
        if(x.left == null){
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key){
        if(x == null){
            return null;
        }

        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = delete(x.left, key);
        } else if(cmp > 0){
            x.right = delete(x.right, key);
        } else {
            //没有右子树，把左子树挂在源节点父节点上
            if(x.right == null){
                return x.left;
            }
            //没有左子树，把右子树挂在源节点父节点上
            if(x.left == null){
                return x.right;
            }
            //用右子树中最小的节点来替代被删除的节点，仍然保证树的有序性
            Node t= x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }



}
