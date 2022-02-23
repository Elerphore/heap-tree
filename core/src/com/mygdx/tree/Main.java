package com.mygdx.tree;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.kotcrab.vis.ui.widget.ButtonBar;

public class Main extends ApplicationAdapter {
	Interface anInterface;
	BinaryTree binaryTree;

	private void initInterface() {
        anInterface = new Interface();
        anInterface.createButton("Add", 100, 50, 50, 25);
        anInterface.createButton("Delete", 100, 50, 300, 25);
    }

    private void initNodes() {
        binaryTree = new BinaryTree();

        binaryTree.insertNode(3);
        binaryTree.insertNode(1);
        binaryTree.insertNode(8);
        binaryTree.insertNode(9);
        binaryTree.insertNode(4);
        binaryTree.insertNode(5);
    }

	@Override
	public void create () {
        initInterface();
        initNodes();
	}

	@Override
	public void render () {
        ScreenUtils.clear(1, 0, 0, 1);

		anInterface.renderButtons();
		anInterface.renderNodes(binaryTree.getNodes());
		binaryTree.renderTree();

        System.out.println(binaryTree.toString());
    }
	
	@Override
	public void dispose () {
        anInterface.dispose();
	}
}
