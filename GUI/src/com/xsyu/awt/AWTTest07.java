package com.xsyu.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ClassName: AWTTest07
 * Package: com.xsyu.awt
 * Description:面板与布局的嵌套使用
 *
 * @Author: Mr.weizechao
 * @Create: 2022/12/31 - 14:02
 * @Version: v1.0
 */
public class AWTTest07 {
    public static void main(String[] args) {
        Frame frame = new Frame("Hello World!");
        frame.setSize(500, 300);
        frame.setAlwaysOnTop(true);
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



        GridLayout gridLayout = new GridLayout();
        gridLayout.setRows(2);
        frame.setLayout(gridLayout);
        /**
         * 演示1：
         */
//        Panel panel1 = new Panel();
//        panel1.setBackground(Color.PINK);
//
//        Panel panel2 = new Panel();
//        panel2.setBackground(Color.ORANGE);
//
//        frame.add(panel1);
//        frame.add(panel2);


        /**
         * 演示2：
         */
        Panel top = new Panel();
        top.setBackground(Color.PINK);
        //设置为流式布局
        top.setLayout(new FlowLayout());
        for (int i = 0; i < 5; i++) {
            top.add(new Button("Flow" + i));
        }
        frame.add(top);

        Panel button = new Panel();
        button.setBackground(Color.ORANGE);
        //设置为网格布局
        button.setLayout(new GridLayout());
        for (int i = 0; i < 5; i++) {
            button.add(new Button("Grid" + i));
        }
        frame.add(button);

        frame.setVisible(true);
    }
}
