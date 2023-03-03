package com.xsyu.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ClassName: AWTTest05
 * Package: com.xsyu.awt
 * Description:布局的使用：边框布局、流式布局、卡片布局
 *
 * @Author: Mr.weizechao
 * @Create: 2022/12/30 - 20:41
 * @Version: v1.0
 */
public class AWTTest05 {
    public static void main(String[] args) throws InterruptedException {
        Frame frame = new Frame("Hello World!");
        frame.setSize(500, 300);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2 - frame.getWidth() / 2);
        int y = (int) (screenSize.getHeight() / 2 - frame.getHeight() / 2);
        frame.setLocation(x, y);
        frame.setAlwaysOnTop(true);
        //frame.setResizable(false);
        frame.setBackground(Color.ORANGE);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        /**
         * 边框布局
         */
        frame.setLayout(new BorderLayout());
        BorderLayout borderLayout = new BorderLayout();
        frame.setLayout(borderLayout);
        //设置边框之间的距离
        borderLayout.setHgap(50);
        borderLayout.setVgap(50);
        //在添加组件时，可以在后面加入约束
        frame.add(new Button("Button of 1"), BorderLayout.WEST);
        frame.add(new Button("Button of 2"), BorderLayout.EAST);
        frame.add(new Button("Button of 3"), BorderLayout.SOUTH);
        frame.add(new Button("Button of 4"), BorderLayout.NORTH);
        frame.add(new Button("Button of 5"), BorderLayout.CENTER);

        /**
         * 流式布局
         */
//        FlowLayout flowLayout = new FlowLayout();
//        //设置为左对齐
//        flowLayout.setAlignment(FlowLayout.LEFT);
//        frame.setLayout(flowLayout);
//
//        frame.setLayout(new FlowLayout());
//        frame.add(new Button("Button of 1"));
//        frame.add(new Button("Button of 2"));
//        frame.add(new Button("Button of 3"));
//        frame.add(new Button("Button of 4"));
//        frame.add(new Button("Button of 5"));
//        frame.add(new Button("Button of 6"));


        /**
         * 卡片布局
         * 实验1：sleep函数：3秒之间循环播放“我是1号”和“我是2号”，配合下面的sleep函数
         * 实验2：通过setRows(i)函数，将按钮分为i行
         */
        //实验1
//        CardLayout cardLayout = new CardLayout();
//        frame.setLayout(cardLayout);
//        frame.add(new Label("one"));
//        frame.add(new Label("two"));

        //实验2
//        GridLayout layout = new GridLayout();
//        frame.setLayout(layout);
//        layout.setRows(2);;
//        for (int i = 0; i < 10; i++) {
//            frame.add(new Button("Button of " + i));
//        }

        frame.setVisible(true);

        //配合卡片布局使用
//        while (true){
//            Thread.sleep(3000);
//            //使用CardLayout对象来进行切换
//            cardLayout.next(frame);
//        }
    }
}