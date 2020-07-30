package datastructure.tree;

import lombok.Value;

/**
 * @author Cytang
 * @title: AllTree
 * @projectName demoNote
 * @description: 平衡二叉树（AVL）
 * @date 2020/7/3011:01
 */
public class AllTree<Key extends Comparable<Key>, Values>{
    private Node root;

    private int height(Node t){
        return t == null ? -1 : t.height;
    }

    //左左情况单旋转
    private Node rotateWithLeftChild(Node k2){
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k1.size = k2.size;
        k2.size = size(k2.right) + size(k2.left) + 1;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        //返回新的根
        return k1;
    }

    //右右情况单旋转
    private Node rotateWithRightChild(Node k2){
        Node k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k1.size = k2.size;
        k2.size = size(k2.right) + size(k2.left) + 1;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        //返回新的根
        return k1;
    }

    //左右情况
    private Node doubleWithLeftChild(Node k3){
        try{
            k3.left = rotateWithRightChild(k3.left);
        } catch (NullPointerException e){
            System.out.println("k.left.right为：" + k3.left.right);
            throw e;
        }
        return rotateWithLeftChild(k3);
    }

    //右左情况
    private Node doubleWithRightChild(Node k3){
        try{
            k3.right = rotateWithLeftChild(k3.right);
        } catch (NullPointerException e){
            System.out.println("k.right.left为：" + k3.right.left);
            throw e;
        }
        return rotateWithRightChild(k3);
    }

    //AVL查找操作与BST相同，AVL的删除与插入操作在BST基础上需要检查是否平衡，如果不平衡就要使用旋转操作来维持平衡
    private Node balance(Node x){
        if(balanceFactor(x) < -1){
            if(balanceFactor(x.right) > 0){
                x.right = rotateWithLeftChild(x.right);
            }
            x = rotateWithRightChild(x);
        } else if(balanceFactor(x) > 1){
            if(balanceFactor(x.left) < 0){
                x.left = rotateWithRightChild(x.left);
            }
            x = rotateWithLeftChild(x);
        }
        return x;
    }

    private int balanceFactor(Node x){
        return height(x.left) - height(x.right);
    }

    public class Node{
        private Key key;
        private Value val;
        private Node left, right;
        //比二叉查找树的Node多一个高度属性，为了便于判断树是否平衡
        private int height;
        private int size;

        public Node(Key key, Value val, int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }
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
