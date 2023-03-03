package com.xsyu.awt;

import java.awt.*;
import java.awt.event.*;

/**
 * ClassName: AWT_Test02
 * Package: com.xsyu.awt
 * Description:监听器的使用
 *
 * @Author: Mr.weizechao
 * @Create: 2022/12/30 - 15:10
 * @Version: v1.0
 */
public class AWTTest02 {
    public static void main(String[] args) {
        Frame frame = new Frame("Hello World!");
        frame.setSize(500, 300);
        frame.setAlwaysOnTop(true);
        frame.setBackground(Color.orange);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2 - frame.getWidth() / 2);
        int y = (int) (screenSize.getHeight() / 2 - frame.getHeight() / 2);
        frame.setLocation(x, y);

        /**
         * 窗口关闭时执行
         * 点击关闭按钮时，控制台输出Hello World!  ----->   System.out.println("Hello World!");
         * 点击关闭按钮时，直接结束                ----->   System.exit(0);
         * 点击关闭按钮时，窗口隐藏                ----->   frame.dispose();
         */
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //System.out.println("Hello World!");
                System.exit(0);
                //frame.dispose();
            }
        });

        /**
         * 键盘输入时执行
         * 控制台获取键盘输入的内容            ----->  System.out.println(e.getKeyChar());
         */
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("键盘输入的内容为：" + e.getKeyChar());
            }
        });

        /**
         * 鼠标点击时执行
         * 鼠标点击窗口时，获取鼠标在窗口的位置            ----->     System.out.println(e.getX() + "," + e.getY());
         * 鼠标点击窗口时，获取鼠标在整个屏幕的位置         ----->     System.out.println("鼠标在屏幕中的位置：" + e.getXOnScreen() + "," + e.getYOnScreen());
         */
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("鼠标在窗口中的位置：" + e.getX() + "," + e.getY());
                System.out.println("鼠标在屏幕中的位置：" + e.getXOnScreen() + "," + e.getYOnScreen());
                System.out.println(e.getButton());
                if (e.getButton() == 1) {
                    System.out.println("点击鼠标左键" + e.getButton());
                } else if (e.getButton() == 3) {
                    System.out.println("点击鼠标右键" + e.getButton());
                }else if(e.getButton() == 2){
                    System.out.println("点击鼠标中键" + e.getButton());
                }
            }
        });

        /**
         * 鼠标滚动时执行
         * 鼠标中间滚动时，控制台输出3，说明鼠标在移动        ----->     System.out.println(e.getScrollAmount());
         */
        frame.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println("鼠标滚动：" + e.getScrollAmount());
            }
        });
        frame.setVisible(true);
    }
}