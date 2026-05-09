/*
 * lab 7 ex 2
 * this file is the whole bottom up merge sort question
 * merge combines two sorted queues, and bottomupmergesort keeps merging pairs until one queue stays
 * queue is used because taking from the front in order fits merge sort really well
 */
package com.exercise2.rojina.saberi;

import java.util.LinkedList;
import java.util.Queue;

public class Exercise2Main {

    // two sorted queues into one sorted
    public static <T extends Comparable<T>> Queue<T> merge(Queue<T> q1, Queue<T> q2) {
        Queue<T> merged = new LinkedList<>();

        if (q1 == null) {
            q1 = new LinkedList<>();
        }
        if (q2 == null) {
            q2 = new LinkedList<>();
        }

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek().compareTo(q2.peek()) <= 0) {
                merged.offer(q1.poll());
            } else {
                merged.offer(q2.poll());
            }
        }

        while (!q1.isEmpty()) {
            merged.offer(q1.poll());
        }

        while (!q2.isEmpty()) {
            merged.offer(q2.poll());
        }

        return merged;
    }

    // bottom up
    public static <T extends Comparable<T>> Queue<T> bottomUpMergeSort(T[] data) {
        Queue<Queue<T>> queueOfQueues = new LinkedList<>();

        if (data == null || data.length == 0) {
            return new LinkedList<>();
        }

        // each item has its own queue
        for (T value : data) {
            Queue<T> singleQueue = new LinkedList<>();
            singleQueue.offer(value);
            queueOfQueues.offer(singleQueue);
        }

        // merging pairs
        while (queueOfQueues.size() > 1) {
            Queue<T> first = queueOfQueues.poll();
            Queue<T> second = queueOfQueues.poll();

            if (second == null) {
                queueOfQueues.offer(first);
            } else {
                Queue<T> merged = merge(first, second);
                queueOfQueues.offer(merged);
            }
        }

        return queueOfQueues.poll();
    }

    // print
    public static <T> void printQueue(Queue<T> queue) {
        if (queue == null || queue.isEmpty()) {
            System.out.println("(empty)");
            return;
        }

        for (T value : queue) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main
    public static void main(String[] args) {
        // Rojina Saberi
        // 301533334

        Integer[] data = {7, 2, 9, 1, 5, 3, 8, 4, 6};

        System.out.println("Original data:");
        for (int value : data) {
            System.out.print(value + " ");
        }
        System.out.println();

        Queue<Integer> sortedQueue = bottomUpMergeSort(data);

        System.out.println("\nSorted data in ascending order:");
        printQueue(sortedQueue);
    }
}
