package com.training.collections.set.avltreeset;

import com.training.collections.Iterator;
import com.training.collections.set.Set;
import com.training.collections.exceptions.DuplicatedElementException;

import java.util.NoSuchElementException;

public class AVLTreeSet<T extends Comparable <T>> implements Set<T> {
    private AVLTreeNode<T> root;
    private int currentSize;

    @Override
    public void add(T data)
    {
        root = insertNode(root, data);
        currentSize++;
    }

    @Override
    public void remove(T data) {
        root = removeNode(root, data);
        currentSize --;
    }

    @Override
    public void removeAll() {
        root = removeAllNodes(root);
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
    public Iterator<T> iterator() {
        return new AVLTreeIterator<>(root, false);
    }

    @Override
    public Iterator<T> reverseIterator() {
        return new AVLTreeIterator<>(root, true);
    }

    private AVLTreeNode<T> insertNode(AVLTreeNode<T> node, T data) {
        if (node == null)
            return (new AVLTreeNode<>(data));
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
            if (data.compareTo(node.right.data) < 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }
        return node;
    }

    private AVLTreeNode<T> removeNode(AVLTreeNode<T> node, T data) {

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
                AVLTreeNode<T> temporal = getMostLeftNode(node.right);
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

    private AVLTreeNode<T> removeAllNodes(AVLTreeNode<T> node) {
        if (node != null) {
            if (node.left != null) {
                removeAllNodes(node.left);
            }
            if (node.right != null) {
                removeAllNodes(node.right);
            }
            node = null;
        }
        return node;
    }

    private boolean containsNode(AVLTreeNode<T> node, T data) {
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

    private int height(AVLTreeNode<T> node) {
        if (node == null){
            return 0;
        }
        return node.height;
    }

    private int getHeightDifference(AVLTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private AVLTreeNode<T> getMostLeftNode(AVLTreeNode<T> node) {
        AVLTreeNode<T> temporal = node;
        while (temporal.left != null) {
            temporal = temporal.left;
        }
        return temporal;
    }

    private AVLTreeNode<T> rotateRight(AVLTreeNode<T> nodeA) {
        AVLTreeNode<T> nodeB = nodeA.left;
        AVLTreeNode<T> nodeTemporal = nodeB.right;
        nodeB.right = nodeA;
        nodeA.left = nodeTemporal;
        nodeA.height = Math.max(height(nodeA.left), height(nodeA.right)) + 1;
        nodeB.height = Math.max(height(nodeB.left), height(nodeB.right)) + 1;
        return nodeB;
    }

    private AVLTreeNode<T> rotateLeft(AVLTreeNode<T> nodeB) {
        AVLTreeNode<T> nodeA = nodeB.right;
        AVLTreeNode<T> nodeTemporal = nodeA.left;
        nodeA.left = nodeB;
        nodeB.right = nodeTemporal;
        nodeB.height = Math.max(height(nodeB.left), height(nodeB.right)) + 1;
        nodeA.height = Math.max(height(nodeA.left), height(nodeA.right)) + 1;
        return nodeA;
    }
}

