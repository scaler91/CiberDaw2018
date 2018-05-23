/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers;

import hack.beers.vista.LoginV;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author alxayu97
 */
public class HackBeers extends JFrame {

    JFrame frame = new JFrame();

    public HackBeers() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Panel());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        new HackBeers();
        LoginV log = new LoginV();
        log.setVisible(true);
    }

}

class Panel extends JPanel {

    Timer timer;

    Panel() {
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        refreshScreen();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("arial", Font.PLAIN, 24));
        g.setColor(Color.yellow);
        g.drawString("Hack&Beers", 200, 200);
    }

    public void refreshScreen() {
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.setRepeats(true);
        // Aprox. 60 FPS
        timer.setDelay(17);
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(650, 480);
    }
}
