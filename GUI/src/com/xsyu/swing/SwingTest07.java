package com.xsyu.swing;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ClassName: SwingTest07
 * Package: com.xsyu.swing
 * Description:自定义主题(二)
 *
 * @Author: Mr.weizechao
 * @Create: 2023/1/4 - 23:25
 * @Version: v1.0
 */
public class SwingTest07 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World!");
        frame.setSize(500, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.ORANGE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2 - frame.getWidth() / 2);
        int y = (int) (screenSize.getHeight() / 2 - frame.getHeight() / 2);
        frame.setLocation(x, y);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int value = JOptionPane.showConfirmDialog(frame, "确定退出吗?", "提示", JOptionPane.YES_NO_OPTION);
                if (value == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });

        JButton button = new JButton("This is a button!");
        button.setBounds(20, 60, 90, 30);
        button.setUI(new TestButtonUI());
        frame.add(button);

        frame.setVisible(true);
    }

    //设计ButtonUI，继承自带的ButtonUI即可
    static class TestButtonUI extends ButtonUI {
        @Override
        public void paint(Graphics g, JComponent c) {
            int width = c.getWidth(), height = c.getHeight();
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, width, height);
            g.setColor(Color.BLACK);
            JButton button = (JButton) c;
            g.drawString(button.getText(), 0, 20);
        }
    }
}
