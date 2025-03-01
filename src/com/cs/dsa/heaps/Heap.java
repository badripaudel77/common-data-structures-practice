package com.cs.dsa.heaps;

import java.util.ArrayList;
import java.util.List;

/**
 * Heap is a "complete binary tree" that satisfies the heap property, where any given node is:
 * 1. Greater than its child notes, root node is the largest of all (This is called: Max Heap)
 * 2 Smaller than its child notes, root node is the smallest of all (This is called: Min Heap)
 *
 * Max heap (Here, every parent node is greater than or equal to its children)
 *        50
 *       /  \
 *     30    40
 *    /  \   /  \
 *   10   5 20  30
 *
 *   Min heap (Here,every parent node is smaller than or equal to its children)
 *         5
 *       /   \
 *     10      20
 *    /  \     /
 *   30   50  40
 *
 *   Parent of i = (i-1)/2
 *   Left child of i = 2 * i + 1 // we start from 0th index, so adding one
 *   Right child of i = 2 * i  + 1 + 1 = 2 * i + 2
 *   Just visualize how we achieve first
 */

// This is demo for max-heap
public class Heap {
    ArrayList<Integer> heaps; // using AL as we can have duplicates.

    public Heap() {
        heaps = new ArrayList<>();
    }

    private int getParent(int index) {
        return (index -1)/2;
    }

    private int getLeftChild(int index) {
        return 2 * index + 1;
    }

    private int getRightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int current, int parent) {
        int temp = heaps.get(current);
        heaps.set(current, heaps.get(parent));
        heaps.set(parent, temp);
    }

    private List<Integer> getHeaps() {
        return new ArrayList<>(this.heaps);
    }

    // After adding, have to make sure the max heap or min heap property is satisfied
    /**
     * @param item
     * Add item to the heap (List)
     * Check if this is in the correct position, meaning if it is greater than it's parent,
     * need to swap until we reach the top
     */
    public void insert(int item) {
        heaps.add(item);
        int current = heaps.size() -1; // current

        while(current > 0 && heaps.get(current) > heaps.get(getParent(current))) {
            swap(current, getParent(current));
            current = getParent(current);
        }
    }

    // Removing from heap is removing the top element and moving the leaf node to the first position.
    // However, it shouldn't break the rule of heap(it should be placed at the correct position)
    public Integer remove() {
        if(heaps.size() == 0) {
            return null;
        }
        if(heaps.size() == 1) {
            return heaps.remove(0);
        }
        int max = heaps.get(0);
        int removed = heaps.remove(heaps.size()-1); // Remove the top element
        heaps.set(0, removed); // set last element to the first position, and remove last element
        heapifyDown(0);
        System.out.println("Top Element with value " + max + " removed from the heap and heapified.");
        return max;
    }

    private void heapifyDown(int i) {
        int max = i; // current max index, need to be updated based on left or right node's value.
        while (true) {
            int left = getLeftChild(max); // index of left child
            int right = getRightChild(max); // index of right child
            if(left < heaps.size() && heaps.get(left) > heaps.get(max)) {
                max = left;
            }

            if(right < heaps.size() && heaps.get(right) > heaps.get(max)) {
                max = right;
            }
            if(max != i) {
                swap(i, max);
                i = max;
            }
            else {
                return; // breaks the while loop.
            }
        }
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(this.heaps);
    }

    // Ex: find the Kth Smallest element in the heap
    public int findKthSmallest(int[] nums, int k) {
        // Create a heap and insert elements in the heap
        // when heap size exceeds k, just remove element from the max heap, and return the element
        Heap maxHeap = new Heap();
        if(k > nums.length) {
            System.out.println(k + "th smallest element doesn't even exist.");
            return -1; // not possible.
        }
        for(int num: nums) {
            maxHeap.insert(num);
            int heapSize = maxHeap.getHeap().size();
            while(heapSize > k) {
                maxHeap.remove(); // removes the top element, which is the largest of all.
                heapSize--;
            }
        }
        int result = maxHeap.remove();
        System.out.println(k + "th smallest element in the array is " + result);
        return result;
    }


    public static void main(String[] args) {
        Heap heap = new Heap();

        System.out.println(heap.getHeaps());

        heap.insert(99);
        heap.insert(75);
        heap.insert(80);

        System.out.println(heap.getHeaps());
        heap.insert(55);
        heap.insert(60);
        heap.insert(50);
        heap.insert(65);
        System.out.println(heap.getHeaps());

        heap.remove();
        heap.remove();
        heap.remove();
        System.out.println(heap.getHeaps());

        heap.findKthSmallest(new int[]{1,2,3,4,5,6,7}, 3);
        heap.findKthSmallest(new int[]{5,7,45,12, 55, 100}, 6);
    }
}
