package com.xsyu.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ClassName: SwingTest05
 * Package: com.xsyu.swing
 * Description:预设选项窗口
 * 是/否 按钮
 * 是/否/取消  按钮
 * 文本输入内容
 * 单纯提示
 *
 * @Author: Mr.weizechao
 * @Create: 2023/1/4 - 21:57
 * @Version: v1.0
 */
public class SwingTest05 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World!");
        frame.setSize(500, 300);
        //frame.setAlwaysOnTop(true);
        frame.getContentPane().setBackground(Color.ORANGE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2 - frame.getWidth() / 2);
        int y = (int) (screenSize.getHeight() / 2 - frame.getHeight() / 2);
        frame.setLocation(x, y);

        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        /**
         * 是/否 按钮
         */
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int value = JOptionPane.showConfirmDialog(frame, "Are you sure you want out?", "提示", JOptionPane.YES_NO_OPTION);
                if(value == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });

        /**
         * 是/否/取消  按钮
         */
//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                int value = JOptionPane.showConfirmDialog(frame, "Are you sure you want out?", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
//                if (value == JOptionPane.OK_OPTION){
//                    System.exit(0);
//                }
//            }
//        });

        /**
         * 文本输入内容
         */
//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.out.println(JOptionPane.showInputDialog(frame, "Please enter the text content:"));
//            }
//        });
//      //test2
//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                String str = JOptionPane.showInputDialog("毕业后的你，将何去何从呢？");
//                System.out.println(str);
//            }
//        });


        /**
         * 单纯提示
         */
//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                JOptionPane.showMessageDialog(frame,"信息有误！");
//            }
//        });

        frame.setVisible(true);
    }
}
