package com.training.collections.set.treeset;

import com.training.collections.list.GenericIterator;
import com.training.collections.set.GenericSet;
import utilities.DuplicatedElementException;

import java.util.NoSuchElementException;

public class GenericAVLTree<T extends Comparable <T>> implements GenericSet<T> {
    GenericTreeNode<T> root;
    int currentSize;

    @Override
    public void add(T data)
    {
        root = insertNode(root, data);
        currentSize++;
    }

    @Override
    public void remove(T data) {
        root = removeNode(root, data);
    }

    @Override
    public void removeAll() {
        currentSize = 0;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean contains(T data) {
        return containsNode(root, data);
    }

    @Override
    public GenericIterator<T> iterator() {
        return new GenericTreeIterator<>(root, false);
    }

    @Override
    public GenericIterator<T> reverseIterator() {
        return new GenericTreeIterator<>(root, true);
    }

    private GenericTreeNode<T> insertNode(GenericTreeNode<T> node, T data) {
        if (node == null)
            return (new GenericTreeNode<>(data));
        if (data.equals(node.data)) {
            throw new DuplicatedElementException(data.toString());
        }
        if (data.compareTo(node.data) < 0) {
            node.left = insertNode(node.left, data);
        }
        else {
            node.right = insertNode(node.right, data);
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int branchDifference = getHeightDifference(node);

        if (branchDifference > 1)
        {
            if (data.compareTo(node.left.data) > 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }
        if (branchDifference < -1)
        {
            if (data.compareTo(node.left.data) < 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }
        return node;
    }

    private GenericTreeNode<T> removeNode(GenericTreeNode<T> node, T data) {

        if (node == null) {
            throw new NoSuchElementException("Non existing element :" + data);
        }
        if (data.compareTo(node.data) < 0) {
            node.left = removeNode(node.left, data);
        }
        else if (data.compareTo(node.data) > 0) {
            node.right = removeNode(node.right, data);
        }
        else {
            if ((node.left == null) && (node.right == null)) {
                node = null;
            }
            else if (node.left == null) {
                node = node.right;
            }
            else if (node.right == null) {
                node = node.left;
            }
            else {
                GenericTreeNode<T> temporal = getMostLeftNode(node.right);
                node.data = temporal.data;
                node.right = removeNode(node.right, temporal.data);
            }
        }
        if (node == null)
            return null;

        node.height = 1 + Math.max(height(root.left), height(root.right));

        int branchDifference = getHeightDifference(node);
        if (branchDifference > 1)
        {
            if (getHeightDifference(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }
        if (branchDifference < -1)
        {
            if (getHeightDifference(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }
        return node;
    }

    private boolean containsNode(GenericTreeNode<T> node, T data) {
        if (node == null) {
            return false;
        }
        if (data.compareTo(node.data) < 0) {
            return containsNode(node.left, data);
        }
        else if (data.compareTo(node.data) > 0) {
            return containsNode(node.right, data);
        }
        return true;
    }

    private int height(GenericTreeNode<T> node) {
        if (node == null){
            return 0;
        }
        return node.height;
    }

    private int getHeightDifference(GenericTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private GenericTreeNode<T> getMostLeftNode(GenericTreeNode<T> node) {
        GenericTreeNode<T> temporal = node;
        while (temporal.left != null) {
            temporal = temporal.left;
        }
        return temporal;
    }

    private GenericTreeNode<T> getMostRightNode(GenericTreeNode<T> node) {
        GenericTreeNode<T> temporal = node;
        while (temporal.right != null) {
            temporal = temporal.right;
        }
        return temporal;
    }

    private GenericTreeNode<T> rotateRight(GenericTreeNode<T> nodeA) {
        GenericTreeNode<T> nodeB = nodeA.left;
        GenericTreeNode<T> nodeTemporal = nodeB.right;
        nodeB.right = nodeA;
        nodeA.left = nodeTemporal;
        nodeA.height = Math.max(height(nodeA.left), height(nodeA.right)) + 1;
        nodeB.height = Math.max(height(nodeB.left), height(nodeB.right)) + 1;
        return nodeB;
    }

    private GenericTreeNode<T> rotateLeft(GenericTreeNode<T> nodeB) {
        GenericTreeNode<T> nodeA = nodeB.right;
        GenericTreeNode<T> nodeTemporal = nodeA.left;
        nodeA.left = nodeB;
        nodeB.right = nodeTemporal;
        nodeB.height = Math.max(height(nodeB.left), height(nodeB.right)) + 1;
        nodeA.height = Math.max(height(nodeA.left), height(nodeA.right)) + 1;
        return nodeA;
    }
}

