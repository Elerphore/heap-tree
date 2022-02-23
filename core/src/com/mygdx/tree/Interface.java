package com.mygdx.tree;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.List;

public class Interface {
    SpriteBatch spriteBatch = new SpriteBatch();
    BitmapFont font = new BitmapFont();

    static class Button {
        String text;
        int width, height, posX, posY;
        SpriteBatch spriteBatch = new SpriteBatch();
        BitmapFont font = new BitmapFont();

        public Button(String text,
                int width,
                int height,
                int posX,
                int posY) {

            this.text = text;
            this.width = width;
            this.height = height;
            this.posX = posX;
            this.posY = posY;
        }
    }

    private final ShapeRenderer shapeRenderer = new ShapeRenderer();
    private final List<Button> buttons = new ArrayList<>();

    public Interface() { }

    public void createButton(String text, int width, int height, int posX, int posY) { buttons.add(new Button(text, width, height, posX, posY)); }

    public void renderButtons() {
        for(Button button : this.buttons) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(100, 100, 100, 255);
            shapeRenderer.rect(button.posX, button.posY, button.width, button.height);
            shapeRenderer.end();

            button.spriteBatch.begin();
            button.font.setColor(Color.BLACK);
            button.font.draw(button.spriteBatch, button.text, button.posX + (button.width / 2), button.posY + (button.height / 2));
            button.spriteBatch.end();
        }
    }

    public void renderNodes(List<Integer> nodes) {
        int index = 0;
        for(Integer node : nodes) {
            spriteBatch.begin();
            font.draw(spriteBatch, node.toString(),10 * index , 300);
            spriteBatch.end();

            index++;
        }
    }

    public void dispose() {
        this.spriteBatch.dispose();;
        this.shapeRenderer.dispose();
        this.font.dispose();

        for(Button button : this.buttons) {
            button.font.dispose();
            button.spriteBatch.dispose();
        }

    }
}
