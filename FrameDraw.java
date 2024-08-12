import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;

public class FrameDraw extends JPanel {
    private GameController controller;

    public FrameDraw(GameController controller) {
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.controller = controller;

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                
            }
        });
    }

    public void drawBoard(Graphics g, int offset) {
        g.drawRect(offset, 50, 120, 120);
        g.drawRect(offset + 40, 50, 40, 120);
        g.drawRect(offset, 90, 120, 40);

        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                g.drawString(controller.getGrids()[0].get(row, col).toString(), 12 + offset + row * 40, 80 + col * 40);
            }
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(370, 220);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Dialog", Font.PLAIN, 30));

        drawBoard(g, 50);
        drawBoard(g, 200);

        // Draw Text
        //g.drawRect(50, 50, 120, 120);
        //g.drawRect(200, 50, 120, 120);
        //g.drawRect(90, 50, 40, 120);
        //g.drawRect(240, 50, 40, 120);
        //g.drawRect(50, 90, 120, 40);
        //g.drawRect(50 + 150, 90, 120, 40);
        /*g.setColor(Color.RED);
        g.fillRect(squareX,squareY,squareW,squareH);
        g.setColor(Color.BLACK);
        g.drawRect(squareX,squareY,squareW,squareH);*/
    }  
}
