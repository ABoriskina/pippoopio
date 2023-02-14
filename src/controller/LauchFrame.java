package controller;

import object.AntWarrior;
import object.AntWorker;

import java.time.Duration;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import java.time.Instant;
import java.util.TimerTask;


public class LauchFrame extends JComponent {
    JFrame frame;
    JPanel panel = new JPanel();

    Instant timeStampOfStart;
    boolean tIsPressed = false;

    public LauchFrame() {
        frame = new JFrame();
        frame.setTitle("Anthill");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLocation(550, 300);
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.setFocusTraversalKeysEnabled(false);
        frame.addKeyListener(new UserKeyListener());
        frame.setFocusable(true);
        panel.setLayout(null);

    }

    public void paintAntWarrior(int x, int y) {
        AntWarrior antWarrior = new AntWarrior();
        JLabel l = antWarrior.beBorn(x, y);
        frame.getContentPane();
        panel.add(l);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(panel);
        frame.setVisible(true);
    }

    public void paintAntWorker(int x, int y) {
        AntWorker antWorker = new AntWorker();
        JLabel l = antWorker.beBorn(x, y);

        frame.getContentPane();
        panel.add(l);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(panel);
        frame.setVisible(true);

    }



    public class UserKeyListener extends KeyAdapter implements ActionListener {

        JLabel timeLabel = new JLabel();
        TimerTask timerTask = new TimeHelper(this, LauchFrame.this);
        java.util.Timer timer = new java.util.Timer();
        public void showTime(){
            panel.remove(timeLabel);
            panel.revalidate();
            panel.repaint();
            long timeDuration = Duration.between(timeStampOfStart,Instant.now()).toMillis();
            timeLabel = new JLabel(Long.toString(timeDuration) + " ms");
            panel.add(timeLabel);
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            timeLabel.setBounds(570,600, 100,100);
            frame.add(panel);
            frame.setVisible(true);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 66) {
                //обработОЧКА нажатия клавиши B
                timeStampOfStart = Instant.now();
                Random rand = new Random();
                int upperbound = 300;
                int int_randomX = rand.nextInt(upperbound);
                int int_randomY = rand.nextInt(upperbound);
                paintAntWarrior(int_randomX, int_randomY);

            }

            if (e.getKeyCode() == 67) {
                //обработОЧКА нажатия клавиши C просто нужно для загрузки работяги
                Random rand = new Random();
                int upperbound = 300;
                int int_randomX = rand.nextInt(upperbound);
                int int_randomY = rand.nextInt(upperbound);
                paintAntWorker(int_randomX, int_randomY);

            }

            if (e.getKeyCode() == 69) {
                //обработОЧКА нажатия клавиши E
            }
            if (e.getKeyCode() == 84) {
                //обработОЧКА нажатия клавиши T
                if (tIsPressed){
                    timer.cancel();
                    tIsPressed = false;
                }
                else{

                    timer.schedule(timerTask, 1000, 10);
                    tIsPressed = true;
                }
            }

        }
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
}