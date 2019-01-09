package com.imooc.course.utils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码工具类
 */
public class CaptcahCode {
    /**
     * 验证生成的方法
     */
    public static String drawImage(HttpServletResponse response) {
        //定义一字符串的拼接的StringBuilder
        StringBuilder builder = new StringBuilder();
        //准备产生4个字符串的随机数
        for (int i = 0; i < 4; i++) {//循环四次 产生四个字母拼接
            builder.append(randomChar());
        }
        String code = builder.toString();

        //定义图片的宽度和高度
        int width = 120;
        int height = 25;
        //简历bufferedImage对象，指定图片的长度和宽度以及色彩  BufferedImage 缓冲流 输出图片
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        //获取到 Graphics2D    绘制对象，开始绘制验证码
        Graphics2D graphics2D = bufferedImage.createGraphics();
        //设置文字的字体和大小
        Font font = new Font("微软雅黑", Font.PLAIN, 20);
        //设置字体的颜色
        Color color = new Color(0, 0, 0);
        //设置字体
        graphics2D.setFont(font);
        //设置颜色
        graphics2D.setColor(color);
        //设置背景
        graphics2D.setBackground(new Color(226,226,240));
        //开始绘制对象
        graphics2D.clearRect(0,0,width,height);
        //绘制形状，获取矩形对象
        FontRenderContext context = graphics2D.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, context);//把验证码放入矩形对象中
        //计算文字的坐标和间距
        double x = (width - bounds.getWidth()) / 2;//从宽度的一半开始
        double y = (height - bounds.getHeight()) / 2;//从高度的一半开始
        double ascent = bounds.getY();//获取Y坐标
        double baseY = y - ascent;
        graphics2D.drawString(code, (int) x, (int) baseY);//绘制文字
        //结束绘制
        graphics2D.dispose();
        //
        try {
            //输出
            ImageIO.write(bufferedImage,"jpg",response.getOutputStream());
            //刷新响应流
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回文字以便对比输入是否正确
        return code;
    }

    /**
     * 此方法用户产生随机字母和数字
     */
    private static char randomChar() {
        //定义验证需要的字母和数字
        String string = "QWERTYUIOPASDFGHJKLZXCVBNM0123456789";
        //定义一个随机对象
        Random random = new Random();//Random随机对象
        return string.charAt(random.nextInt(string.length()));
    }
}
