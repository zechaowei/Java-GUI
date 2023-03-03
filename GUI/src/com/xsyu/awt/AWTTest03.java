package com.xsyu.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ClassName: AWTTest03
 * Package: com.xsyu.awt
 * Description:常用组件介绍(一)
 *
 * @Author: Mr.weizechao
 * @Create: 2022/12/30 - 16:50
 * @Version: v1.0
 */
public class AWTTest03 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setTitle("Hello World!");
        frame.setSize(500, 300);
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setBackground(Color.ORANGE);
        //设置布局为空
        frame.setLayout(null);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2 - frame.getWidth() / 2);
        int y = (int) (screenSize.getHeight() / 2 - frame.getHeight() / 2);
        frame.setLocation(x, y);

        //查找本系统自带字体
        for (Font allFont : GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()) {
            System.out.println(allFont);
        }

        //设置标签
        Label label = new Label("This is label");
        label.setBounds(20, 50, 150, 30);
        //设置标签背景颜色和字体颜色
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        //设置字体
        label.setFont(new Font("Roboto Condensed", Font.BOLD, 15));
        frame.add(label);

        frame.setVisible(true);
    }
}
