package com.xsyu.swing;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName: SwingTest02
 * Package: com.xsyu.swing
 * Description:Swing组件介绍(一)   ---->   进度条
 *
 * @Author: Mr.weizechao
 * @Create: 2023/1/4 - 15:43
 * @Version: v1.0
 */
public class SwingTest02 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World!");
        frame.setSize(500, 300);
        //设置背景颜色，frame.getContentPane().setBackground(Color.xxx)方法
        frame.getContentPane().setBackground(Color.ORANGE);
        frame.setLayout(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2 - frame.getWidth() / 2);
        int y = (int) (screenSize.getHeight() / 2 - frame.getHeight() / 2);
        frame.setLocation(x, y);

        //设置进度条
        JProgressBar bar = new JProgressBar();
        //进度条最大值
        bar.setMaximum(100);
        //目前进度条的值
        bar.setValue(50);
        bar.setBounds(20, 20, 200, 10);
        frame.add(bar);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
