package src.main.java.rpggame.model;

import java.awt.Graphics; // Add this import

public class Tile {
    public boolean walkable;
    public int x, y;
    public int size;

    public Tile(int x, int y, int size, boolean walkable) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.walkable = walkable;
    }

    public void draw(Graphics g, int px, int py) {
        if (walkable) {
            g.setColor(java.awt.Color.GREEN);
        } else {
            g.setColor(java.awt.Color.DARK_GRAY);
        }
        g.fillRect(px, py, size, size);
    }
}