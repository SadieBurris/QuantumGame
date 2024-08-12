import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.event.MouseMotionAdapter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;

public class FrameDraw extends JPanel {
    private GameController controller;
    private boolean onSecondSwap;
    private String prevLocReq;
    private ArrayList<String> buttonFinder;

    public FrameDraw(GameController controller) {
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.controller = controller;
        prevLocReq = "0 0";
        buttonFinder = new ArrayList();
        buttonFinder.add("not");
        buttonFinder.add("hadamard");
        buttonFinder.add("swap");

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                handleClick(e.getX(), e.getY());
            }
        });
    }

    public void handleClick(int x, int y) {
        if(y > 180) {
            switch(x / (370 / 3)) {
                case 0: controller.play("n"); break;
                case 1: controller.play("h"); break;
                case 2: controller.play("s"); onSecondSwap = false; break;
            }
        } else {
            int row = Math.clamp((x - 50) / 40, 0, 2);
            int col = Math.clamp((y - 50) / 40, 0, 2);
            if(controller.getSelectedGate().equals("swap")) {
                if(onSecondSwap) {
                    controller.play(prevLocReq + " " + row + " " + col);
                    onSecondSwap = false;
                } else {
                    onSecondSwap = true;
                }
            } else {
                controller.play(row + " " + col);
            }
            prevLocReq = row + " " + col;
        }
        repaint();
    }

    public void drawBoard(Graphics g, int offset) {
        g.drawRect(offset, 50, 120, 120);
        g.drawRect(offset + 40, 50, 40, 120);
        g.drawRect(offset, 90, 120, 40);
        String whichBoard = offset > getPreferredSize().width / 2 ? "  Goal" : "Current";
        g.drawString(whichBoard, offset + 10, 40);
        drawQubits(g, offset);
    }

    public void drawQubits(Graphics g, int offset) {
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                if(offset > getPreferredSize().width / 2) {
                    g.drawString(controller.getGrids()[1].get(row, col).toString(), 12 + offset + row * 40, 80 + col * 40); //change which grid it gets
                } else {
                    g.drawString(controller.getGrids()[0].get(row, col).toString(), 12 + offset + row * 40, 80 + col * 40); //change which grid it gets
                }
            }
        }
    }

    public void drawButtons(Graphics g) {
        for(int i = 0; i < 3; i++) {
            if(buttonFinder.indexOf(controller.getSelectedGate()) == i) {
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(120 * i + 10, 180, 110, 30);
            }
            g.drawRect(120 * i + 10, 180, 110, 30);
        }
        g.setColor(Color.BLACK);
        g.setFont(new Font("Dialog", Font.PLAIN, 20));
        g.drawString("Not", 48, 203);
        g.drawString("Hadamard", 138, 203);
        g.drawString("Swap", 279, 203);
    }

    public Dimension getPreferredSize() {
        return new Dimension(370, 220);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Dialog", Font.PLAIN, 30));

        drawBoard(g, 50);
        drawBoard(g, 200);
        drawButtons(g);

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
