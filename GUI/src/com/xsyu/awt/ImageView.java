package com.xsyu.awt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * ClassName: ImageView
 * Package: com.xsyu.awt
 * Description:配合AWTTest11使用
 *
 * @Author: Mr.weizechao
 * @Create: 2023/1/1 - 17:51
 * @Version: v1.0
 */
//public class ImageView extends Component {
//    @Override
//    public void paint(Graphics g) {
//        //更改画笔颜色
////        g.setColor(Color.BLACK);
////        g.fillRect(0, 0, this.getWidth(), this.getHeight());
//        //更改画笔颜色 ------> 右半边黑色，左半边蓝色
//        g.setColor(Color.BLACK);
//        g.fillRect(0, 0, this.getWidth() / 2, this.getHeight());
//        g.setColor(Color.BLUE);
//        g.fillRect(this.getWidth() / 2, 0, this.getWidth() / 2, this.getHeight());
//        //更改画笔颜色，在区域内输出文本"Hello World!"
//        g.setColor(Color.WHITE);
//        g.drawString("Hello World!", 0, 20);
//        g.setFont(new Font("Berlin Sans FB", Font.TYPE1_FONT, 20));
//    }
//}


public class ImageView extends Component {
    private Image image;

    public ImageView(String filename){
        try (FileInputStream inputStream = new FileInputStream(filename)){
            BufferedImage image = ImageIO.read(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0,this.getWidth(), this.getHeight(), null);
    }
}