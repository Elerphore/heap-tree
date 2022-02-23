package com.mygdx.tree;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private List<Integer> nodes = new ArrayList();
    private ShapeRenderer shapeRender = new ShapeRenderer();

    public BinaryTree() {}

    private int getTreeSize() { return this.nodes.size() - 1; }

    private void sort(int index) {
        while(index != 0 && this.getParent(index) > this.getNode(index)) {
            int temp = this.getParent(index);
            this.setParent(index, this.getNode(index));
            this.setNode(index, temp);

            index = this.getParentIndex(index);
        }
    }

    public void insertNode(int node) {
        this.nodes.add(node);
        int index = this.getTreeSize();

        this.sort(index);
    }

    public void decreaseNode(int index, int key) {
        this.nodes.set(index, key);
        this.sort(index);
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public int getParent(int index) {
        return nodes.get((index - 1) / 2);
    }

    public void setParent(int index, int key) {
        this.nodes.set((index - 1) / 2, key);
    }

    public int getLeftSibling(int index) {
        if(!this.isLeaf(index)) {
            return nodes.get((2 * index));
        } return 999;
    }

    public int getRightSibling(int index) {
        if(!this.isLeaf(index)) {
            return nodes.get((2 * index) + 1);
        } return 999;

    }

    public int getSize() {
        return this.nodes.size();
    }

    public int getNode(int index) {
        return this.nodes.get(index);
    }

    public void setNode(int index, int key) {
        this.nodes.set(index, key);
    }

    private Boolean isLeaf(int index) {
        int size = this.getTreeSize();
        return (index > (size / 2) && index <= size);
    }

    public List<Integer> getNodes() {
        return this.nodes;
    }

    public void renderTree() {
        int size = this.getTreeSize();
        int index = 0;

        while(index < size) {
            shapeRender.begin(ShapeRenderer.ShapeType.Line);
            shapeRender.circle(300,400 - (index * 50) , 25);
            shapeRender.end();

            index++;
        }
    }

    @Override
    public String toString() {
        String msg = "";
        int size = this.getTreeSize();
        int index = 0;

        while(index < size) {
                msg +=
                        "Node: " + this.getNode(index)
                                + " Parent: " + this.getParent(index)
                                + " Left: " + this.getLeftSibling(index)
                                + " Right: " + this.getRightSibling(index) + "\n";
            index++;
        }

        return msg;
    }
}
