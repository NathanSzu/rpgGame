package src.main.java.rpggame.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player {
    public int tileX, tileY;
    private int size;

    public Player(int tileX, int tileY, int size) {
        this.tileX = tileX;
        this.tileY = tileY;
        this.size = size;
    }

    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, size, size);
    }

    public void move(int dx, int dy) {
        tileX += dx;
        tileY += dy;
    }

    public void handleKeyPress(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                move(-1, 0);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                move(1, 0);
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                move(0, -1);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                move(0, 1);
                break;
        }
    }
}
