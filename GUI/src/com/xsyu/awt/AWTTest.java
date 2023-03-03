package com.xsyu.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ClassName: AWTTest
 * Package: com.xsyu.awt
 * Description:窗口的创建和配置
 *
 * @Author: Mr.weizechao
 * @Create: 2022/12/30 - 12:29
 * @Version: v1.0
 */
public class AWTTest {
    public static void main(String[] args) {
        //设置窗口标题
        //Frame frame = new Frame();
        Frame frame = new Frame("Hello World");
        //frame.setTitle("Hello World");
        //设置窗口大小
        frame.setSize(500, 300);
        //设置窗口大小和位置
        // frame.setBounds(500, 500, 500, 300);
        //设置背景颜色
        frame.setBackground(Color.orange);
        //设置窗口置顶
        frame.setAlwaysOnTop(true);
        //设置窗口大小固定
        frame.setResizable(false);
        //设置窗口出现的位置
        //frame.setLocation(500,500);

        //设置窗口位置始终出现在屏幕中央
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2 - frame.getWidth() / 2);
        int y = (int) (screenSize.getHeight() / 2 - frame.getHeight() / 2);
        frame.setLocation(x, y);

        //设置窗口内鼠标样式
        frame.setCursor(new Cursor(Cursor.WAIT_CURSOR));

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //设置窗口是否可见
        frame.setVisible(true);
    }
}