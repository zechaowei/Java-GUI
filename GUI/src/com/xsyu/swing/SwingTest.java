package com.xsyu.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ClassName: AWTTest
 * Package: com.xsyu.swing
 * Description:Swing的基本使用
 *
 * @Author: Mr.weizechao
 * @Create: 2023/1/3 - 0:05
 * @Version: v1.0
 */
public class SwingTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World!");
        frame.setSize(500, 300);
        frame.setAlwaysOnTop(true);
        //frame.setBackground(Color.ORANGE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2 - frame.getWidth() / 2);
        int y = (int) (screenSize.getHeight() / 2 - frame.getHeight() / 2);
        frame.setLocation(x, y);


        /**
         * JButton特点
         * 1、点击关闭按钮会自动隐藏
         * 2、按钮具有金属特色
         */
        frame.setLayout(null);
        JButton jButton = new JButton("This is the button");
        jButton.setBounds(0, 0, 150, 30);
        frame.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("JButton is clicked!");
            }
        });

        //AWT组件中的按钮可以存在于Swing组件上
        Button button = new Button("This is a regular button");
        button.setBounds(0, 40, 150, 30);
        frame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button is clicked!");
            }
        });

        /**
         * 菜单选项
         */
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Menu");
        JMenuItem jMenuItem1 = new JMenuItem("That's choice number one");
        JMenuItem jMenuItem2 = new JMenuItem("That's choice number two");
        jMenu.add(jMenuItem1);
        jMenu.add(jMenuItem2);
        jMenuBar.add(jMenu);
        frame.setJMenuBar(jMenuBar);

        //设置监听器
        jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Option number one is clicked!");
            }
        });
        jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Option number two is clicked!");
            }
        });

        //设置快捷键操作
        jMenuItem1.setAccelerator(KeyStroke.getKeyStroke("ctrl U"));
        jMenuItem2.setAccelerator(KeyStroke.getKeyStroke("ctrl Y"));

        /**
         * 点击关闭按钮结束程序
         * EXIT_ON_CLOSE:直接退出程序
         * DISPOSE_ON_CLOSE:点击关闭按钮后，需要结束一些资源，程序结束比较缓慢
         * HIDE_ON_CLOSE:隐藏窗口
         * DO_NOTHING_ON_CLOSE:点击关闭按钮无任何反应
         */
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        //frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        frame.setVisible(true);
    }
}
