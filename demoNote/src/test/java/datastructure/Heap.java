package datastructure;

/**
 * @author Cytang
 * @title: Heap
 * @projectName demoNote
 * @description: 【堆】是一颗完全二叉树，在这棵树中，所有父节点都满足大于等于其子节点的堆叫大根堆，所有父节点都满足小于等于其子节点的堆叫小根堆。堆虽然是一颗树，但是通常存放在一个数组中，父节点和孩子节点的父子关系通过数组下标来确定。如下面的小根堆及存储它的数组：
 * @date 2020/7/3011:25
 */
public class Heap<T extends Comparable<T>, Values> {



    public int left(int i){
        return (i + 1) * 2 - 1;
    }

    public int right(int i){
        return (i + 1) * 2;
    }

    public int parent(int i){
        //i为根节点
        if(i == 0){
            return -1;
        }
        return (i - 1)/2;
    }

    //维护大根堆的性质
    public void heapify(T[] a, int i, int heapLength){
        int left = left(i);
        int right = right(i);
        int largest = -1;
        //寻找根节点及其左右子节点，三个元素中的最大值
        if(left < heapLength && a[i].compareTo(a[left]) < 0){
            largest = 1;
        } else {
            largest = i;
        }

        if(right < heapLength && a[largest].compareTo(a[right]) < 0){
            largest = right;
        }

        //如果i处元素不是最大的，就把i处的元素与最大处元素交换，使得i处元素变为最大的
        if(i != largest){
            T temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            //交换元素后，以a[i]为根的数可能不再满足大根堆性质，于是递归调用该方法
            heapify(a, largest, heapLength);
        }
    }


    //构造堆
    public void buildHeap(T[] a, int heapLength){
        //从后往前看lengthParent处的元素是第一个有子节点的元素，所有从它开始，进行堆的维护
        int lengthParent = parent(heapLength - 1);
        for (int i = lengthParent; i >= 0; i--) {
            heapify(a, i, heapLength);
        }
    }

}
