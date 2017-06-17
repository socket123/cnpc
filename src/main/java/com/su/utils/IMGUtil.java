package com.su.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class IMGUtil {
    // base64字符串转化成图片
    public static boolean GenerateImage(String imgStr, String name, String imgFilePath) { // 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return false;

        File f = new File(imgFilePath); // 输入要删除的文件位置
        if (f.exists())
            f.delete();
        org.apache.commons.codec.binary.Base64 decoder = new org.apache.commons.codec.binary.Base64();
        try {
            // Base64解码
            byte[] b = decoder.decode(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void mkdir(String imgFilePath) { // 对字节数组字符串进行Base64解码并生成图片
        File logoSaveFile = new File(imgFilePath);
        if (!logoSaveFile.exists())
            logoSaveFile.mkdirs();
    }
}
