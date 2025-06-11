package src.main.java.rpggame.view;

import src.main.java.rpggame.model.*;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private Player player;

    private static final int TILE_SIZE = 64;
    private static final int MAP_WIDTH = 25;
    private static final int MAP_HEIGHT = 19;
    private Tile[][] tiles;

    public GamePanel() {
        player = new Player(10, 5, TILE_SIZE); // Start at tile (10,5)

        // Initialize tiles
        tiles = new Tile[MAP_WIDTH][MAP_HEIGHT];
        for (int x = 0; x < MAP_WIDTH; x++) {
            for (int y = 0; y < MAP_HEIGHT; y++) {
                boolean walkable = Math.random() > 0.2; // Random walkable tiles
                tiles[x][y] = new Tile(x, y, TILE_SIZE, walkable);
            }
        }

        setFocusable(true);
        requestFocusInWindow();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int newX = player.tileX;
                int newY = player.tileY;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                        newY--;
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        newY++;
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:
                        newX--;
                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                        newX++;
                        break;
                }
                // Check bounds and walkable
                if (newX >= 0 && newX < MAP_WIDTH && newY >= 0 && newY < MAP_HEIGHT
                    && tiles[newX][newY].walkable) {
                    player.tileX = newX;
                    player.tileY = newY;
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Center of the panel in pixels
        int centerX = panelWidth / 2;
        int centerY = panelHeight / 2;

        // Offset so that the player's tile is always at the center
        int offsetX = centerX - player.tileX * TILE_SIZE - TILE_SIZE / 2;
        int offsetY = centerY - player.tileY * TILE_SIZE - TILE_SIZE / 2;

        // Draw all tiles with the calculated offset
        for (int x = 0; x < MAP_WIDTH; x++) {
            for (int y = 0; y < MAP_HEIGHT; y++) {
                int drawX = x * TILE_SIZE + offsetX;
                int drawY = y * TILE_SIZE + offsetY;
                tiles[x][y].draw(g, drawX, drawY);
            }
        }

        // Draw player at the center of the panel
        player.draw(g, centerX - TILE_SIZE / 2, centerY - TILE_SIZE / 2);
    }
}