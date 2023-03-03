package com.xsyu.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;

/**
 * ClassName: AWTTest12
 * Package: com.xsyu.awt
 * Description:窗口修饰
 *
 * @Author: Mr.weizechao
 * @Create: 2023/1/1 - 22:51
 * @Version: v1.0
 */
public class AWTTest12 {
    public static void main(String[] args) {
        Frame frame = new Frame("Hello World!");
        frame.setSize(500, 300);
        frame.setBackground(Color.ORANGE);
        frame.setAlwaysOnTop(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2 - frame.getWidth() / 2);
        int y = (int) (screenSize.getHeight() / 2 - frame.getHeight() / 2);
        frame.setLocation(x, y);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        /**
         * 窗口修饰
         * 将窗口设定为非修饰状态
         */
        frame.setUndecorated(true);
        //设置窗口圆角
        frame.setShape(new RoundRectangle2D.Double(0, 0, frame.getWidth(), frame.getHeight(), 30, 30));

        frame.setVisible(true);
    }
}
