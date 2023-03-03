package com.xsyu.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

/**
 * ClassName: AWTTest04
 * Package: com.xsyu.awt
 * Description:常用组件介绍(二):
 *
 * @Author: Mr.weizechao
 * @Create: 2022/12/30 - 17:37
 * @Version: v1.0
 */
public class AWTTest04 {
    public static void main(String[] args) {
        /**
         * 1、创建窗口
         * 2、设置窗口大小
         * 3、设置窗口在顶部
         * 4、设置窗口大小不可变
         * 5、设置布局为空
         * 6、设置字体样式
         * 7、点击关闭按钮退出程序
         * 8、设置按钮在屏幕中居中
         */
        Frame frame = new Frame("Hello World!");
        frame.setSize(500, 300);
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setLayout(null);

        frame.setFont(new Font("Roboto Condensed", Font.BOLD, 15));

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

        //设置文本
        TextField textField = new TextField();
        textField.setBounds(20, 100, 200, 30);
        //将文本框内的文字样式设置为*，即为密码框
        textField.setEchoChar('*');
        frame.add(textField);

        //设置文本域
        TextArea textArea = new TextArea();
        textArea.setBounds(20, 180, 200, 100);
        frame.add(textArea);


        //设置勾选框
        Checkbox checkbox = new Checkbox("Remember the password");
        checkbox.setBounds(20,140,500,30);
        frame.add(checkbox);

        //设置单选勾选框
        CheckboxGroup group = new CheckboxGroup();

        Checkbox c1 = new Checkbox("Pick me");
        c1.setBounds(250,50,200,30);
        frame.add(c1);

        Checkbox c2 = new Checkbox("What are you doing?");
        c2.setBounds(250,80,200,30);
        frame.add(c2);

        c1.setCheckboxGroup(group);
        c2.setCheckboxGroup(group);

        //设置按钮
        Button button = new Button("Button");
        button.setBounds(20, 50, 100, 50);
        button.addActionListener(e -> {
            System.out.println(new Date(e.getWhen()) + "我被点击了！");
            //文本输出
            String text = textField.getText();
            System.out.println("输出的文本是：" + text);
            //文本域输出
            String text1 = textArea.getText();
            System.out.println("输出的文本是：" + text1);
            //按钮
            System.out.println(group.getSelectedCheckbox().getLabel());
        });
        frame.add(button);

        frame.setVisible(true);
    }
}
