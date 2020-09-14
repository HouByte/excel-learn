package cn.bugio.Excel.ExcelData;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.converters.string.StringImageConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * @description:
 * @author: Vincent Vic
 * @email: vincent-vic@qq.com
 * @time: 2020/9/11 21:54
 */

@NoArgsConstructor
@Data
public class ImageData {

 //使用抽象文件表示一个图片
 private File file;
 //使用输入流保存一个图片
 private InputStream inputStream;
 /**
  *当使用String类型保存一个图片的时候需 要使用tringImageConverter转换器
  */
 @ExcelProperty(converter = StringImageConverter.class)
 private String string;
 //使用二进制数据保存为一个图片
 private byte[] byteArray;
 //使用网络链接保存一个图片
 private URL url;


}
