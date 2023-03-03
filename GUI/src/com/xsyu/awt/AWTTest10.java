package com.xsyu.awt;

import java.awt.*;

/**
 * ClassName: AWTTest10
 * Package: com.xsyu.awt
 * Description:弹出对话框
 *
 * @Author: Mr.weizechao
 * @Create: 2023/1/1 - 15:11
 * @Version: v1.0
 */
public class AWTTest10 {
    public static void main(String[] args) {
        Frame frame = new Frame("Hello World!");
        frame.setSize(500, 300);
        frame.setBackground(Color.ORANGE);
        frame.setAlwaysOnTop(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() / 2 - frame.getWidth() / 2);
        int y = (int) (screenSize.getHeight() / 2 - frame.getHeight() / 2);
        frame.setLocation(x, y);


        /**
         * 设置对话框
         * 函数：Dialog(窗口, title, modal)
         * modal:ture表示对话框一直显示在“窗口”上面
         */
//        Dialog dialog = new Dialog(frame, "Prompt", true);
//        dialog.setSize(300, 100);
//        dialog.setBackground(Color.PINK);
//        dialog.setResizable(false);
//        dialog.add(new Button("Determines whether you want ti exit the program?"), BorderLayout.NORTH);//对话框默认采用边界布局
//        dialog.add(new Button("Cancel"), BorderLayout.WEST);
//        dialog.add(new Button("Don't quit"), BorderLayout.EAST);
//        int i = (int) (screenSize.getWidth() / 2 - dialog.getWidth() / 2);
//        int j = (int) (screenSize.getHeight() / 2 - dialog.getHeight() / 2);
//        dialog.setLocation(i ,j);
//
//
//        dialog.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                //以下两种方式都可以关闭对话框
//                //dialog.dispose();
//                dialog.setVisible(false);
//            }
//        });
//
//
//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                dialog.setVisible(true);
//            }
//        });


        /**
         * 文件对话框
         * 点击关闭按钮时，弹出文件选择框，选择文件
         */
//        FileDialog fileDialog = new FileDialog(frame, "请选择文件", FileDialog.LOAD);
//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                fileDialog.setVisible(true);
//                System.out.println("选择的文件为:  " + fileDialog.getDirectory() + fileDialog.getFile());
//            }
//        });

        frame.setVisible(true);
    }
}
