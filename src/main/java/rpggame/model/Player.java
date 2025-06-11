package src.main.java.rpggame.model;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
    public int tileX, tileY;
    private final int size;

    public Player(int tileX, int tileY, int size) {
        this.tileX = tileX;
        this.tileY = tileY;
        this.size = size;
    }

    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, size, size);
    }

}
