package cn.bugio.Excel.dome1;

import cn.bugio.Excel.ExcelData.*;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * @description:
 * @author: Vincent Vic
 * @email: vincent-vic@qq.com
 * @time: 2020/9/11 15:13
 */

public class WriteTest {

    /**
     * 简单写 方式1
     */
    @Test
    public void test01(){
        //创建文档
        String fileName = "user1.xlsx";
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User(i,"user"+i,"男",1000.00 * (i%5),new Date());
            users.add(user);
        }
        //向Excel写入数据
        EasyExcel.write(fileName,User.class).sheet("用户信息").doWrite(users);
    }

    /**
     * 简单写 方式2
     */
    @Test
    public void test02(){
        //创建文档
        String fileName = "user2.xlsx";
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User(i,"user"+i,"男",1000.00 * (i%5),new Date());
            users.add(user);
        }
        //向Excel写入数据
        ExcelWriter excelWriter = EasyExcel.write(fileName, User.class).build();
        //创建sheet对象
        WriteSheet writeSheet = EasyExcel.writerSheet("用户信息").build();
        excelWriter.write(users,writeSheet);
        excelWriter.finish();

    }

    /**
     * 排除模板中的属性
     */
    @Test
    public void test03(){
        //创建文档
        String fileName = "user3.xlsx";
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User(i,"user"+i,"男",1000.00 * (i%5),new Date());
            users.add(user);
        }
        //设置排除属性
        Set<String> set = new HashSet<>();
        set.add("hireDate");
        set.add("salary");
        //向Excel写入数据
        ExcelWriter excelWriter = EasyExcel.write(fileName, User.class).excludeColumnFiledNames(set).build();
        //创建sheet对象
        WriteSheet writeSheet = EasyExcel.writerSheet("用户信息").build();
        excelWriter.write(users,writeSheet);
        excelWriter.finish();

    }

    /**
     * 指定模板中的属性
     */
    @Test
    public void test04(){
        //创建文档
        String fileName = "user4.xlsx";
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User(i,"user"+i,"男",1000.00 * (i%5),new Date());
            users.add(user);
        }
        //设置排除属性
        Set<String> set = new HashSet<>();
        set.add("hireDate");
        set.add("salary");
        //向Excel写入数据
        ExcelWriter excelWriter = EasyExcel.write(fileName, User.class).includeColumnFiledNames(set).build();
        //创建sheet对象
        WriteSheet writeSheet = EasyExcel.writerSheet("用户信息").build();
        excelWriter.write(users,writeSheet);
        excelWriter.finish();

    }

    /**
     * 复杂头
     */
    @Test
    public void test05(){
        //创建文档
        String fileName = "user5.xlsx";
        List<ComplexHeadUser> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ComplexHeadUser user = new ComplexHeadUser(i,"user"+i,new Date());
            users.add(user);

        }
        //向Excel写入数据
        ExcelWriter excelWriter = EasyExcel.write(fileName, ComplexHeadUser.class).build();
        //创建sheet对象
        WriteSheet writeSheet = EasyExcel.writerSheet("用户信息").build();
        excelWriter.write(users,writeSheet);
        excelWriter.finish();

    }

    /**
     * 输入重复写到同一个Excel表的同一个sheet标签中
     */
    @Test
    public void test06(){
        //创建文档
        String fileName = "user6.xlsx";
        List<ComplexHeadUser> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ComplexHeadUser user = new ComplexHeadUser(i,"user"+i,new Date());
            if (i % 5 ==0){
                users.add(user);
            }
            users.add(user);

        }
        //向Excel写入数据
        ExcelWriter excelWriter = EasyExcel.write(fileName, ComplexHeadUser.class).build();
        //创建sheet对象
        WriteSheet writeSheet = EasyExcel.writerSheet("用户信息").build();
        for (int i = 0; i <5 ; i++) {
            excelWriter.write(users,writeSheet);
        }
        excelWriter.finish();

    }

    /**
     * 日期数字格式化
     */
    @Test
    public void test07(){
        //创建文档
        String fileName = "user7.xlsx";
        List<UserByStyle> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            UserByStyle user = new UserByStyle(i,"user"+i,"男",1000.123 * (i%5),new Date());
            users.add(user);

        }
        //向Excel写入数据
        ExcelWriter excelWriter = EasyExcel.write(fileName, UserByStyle.class).build();
        //创建sheet对象
        WriteSheet writeSheet = EasyExcel.writerSheet("用户信息").build();
        excelWriter.write(users,writeSheet);
        excelWriter.finish();

    }

    /**
     * 写入图片
     */
    @Test
    public void test08() throws IOException {
        //创建文档
        String fileName = "user8.xlsx";
        //构建数据
        List<ImageData> imageDatas = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            ImageData imageData = new ImageData();
            imageData.setFile(new File("img"+File.separator+i+".jpg"));
            imageData.setInputStream(new FileInputStream(new File("img"+File.separator+i+".jpg")));
            imageData.setString("img"+File.separator+i+".jpg");
            imageData.setUrl(new URL("https://cn.bing.com/images/search?view=detailV2&ccid=Yj14kv%2f7&id=3F06C312C89CD72AE5FF2FD1145E448B0C305411&thid=OIP.Yj14kv_7nCYQ6BtxbL9peAHaEI&mediaurl=https%3a%2f%2fupload-images.jianshu.io%2fupload_images%2f5644137-b98d20362ccd9bd8.png&exph=370&expw=664&q=%e9%98%bf%e9%87%8cmaven%e5%ba%93&simid=608043322034487965&ck=E7429343632817A1E29C5D4C8F502D63&selectedIndex=2&FORM=IRPRST"));

            int length = (int)new File("img"+File.separator+i+".jpg").length();
            byte[] b = new byte[length];
            FileInputStream in = new FileInputStream("img"+File.separator+i + ".jpg");
            in.read(b,0,length);
            imageData.setByteArray(b);
            imageDatas.add(imageData);

        }
        //向Excel写入数据
        ExcelWriter excelWriter = EasyExcel.write(fileName, ImageData.class).build();
        //创建sheet对象
        WriteSheet writeSheet = EasyExcel.writerSheet("用户信息").build();
        excelWriter.write(imageDatas,writeSheet);
        excelWriter.finish();

    }

    /**
     * 设置行高、列宽
     */
    @Test
    public void test09(){
        //创建文档
        String fileName = "user9.xlsx";
        List<WidthAndHeightData> infos = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            WidthAndHeightData info = new WidthAndHeightData("user"+i,new Date(),100.32*(i%4));
            infos.add(info);
        }
        //向Excel写入数据
        ExcelWriter excelWriter = EasyExcel.write(fileName, WidthAndHeightData.class).build();
        //创建sheet对象
        WriteSheet writeSheet = EasyExcel.writerSheet("用户信息").build();
        excelWriter.write(infos,writeSheet);
        excelWriter.finish();

    }

    /**
     * 合并单元格
     */
    @Test
    public void test11(){
        //创建文档
        String fileName = "user11.xlsx";
        List<DemoMergeData> infos = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            DemoMergeData info = new DemoMergeData("user"+i,new Date(),100.32*(i%4));
            infos.add(info);
        }
        //向Excel写入数据
        ExcelWriter excelWriter = EasyExcel.write(fileName, DemoMergeData.class).build();
        //创建sheet对象
        WriteSheet writeSheet = EasyExcel.writerSheet("用户信息").build();
        excelWriter.write(infos,writeSheet);
        excelWriter.finish();

    }

    /**
     * 设置样式
     */
    @Test
    public void test10(){
        //创建文档
        String fileName = "user10.xlsx";
        List<DemoStyleData> infos = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            DemoStyleData info = new DemoStyleData("user"+i,new Date(),100.32*(i%4));
            infos.add(info);
        }
        //向Excel写入数据
        ExcelWriter excelWriter = EasyExcel.write(fileName, DemoStyleData.class).build();
        //创建sheet对象
        WriteSheet writeSheet = EasyExcel.writerSheet("用户信息").build();
        excelWriter.write(infos,writeSheet);
        excelWriter.finish();

    }
}
