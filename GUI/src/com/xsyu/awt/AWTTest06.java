package com.xsyu.awt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ClassName: AWTTest06
 * Package: com.xsyu.awt
 * Description: Chatgpt生成代码
 *
 * @Author: Mr.weizechao
 * @Create: 2022/12/30 - 22:20
 * @Version: v1.0
 */
public class AWTTest06 {
    public static void main(String[] args) {
        // 创建一个窗口
        JFrame frame = new JFrame("My Window");
        frame.setSize(400, 300);
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2 - frame.getWidth() / 2);
        int y = (int) (screenSize.getHeight() / 2 - frame.getHeight() / 2);
        frame.setLocation(x, y);
        // 创建一个按钮
        JButton button = new JButton("Click me!");
        frame.add(button);

        //关闭按钮
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        button.addActionListener(e -> {
            System.out.println("按钮被点击了！");
        });
        // 显示窗口
        frame.setVisible(true);
    }
}