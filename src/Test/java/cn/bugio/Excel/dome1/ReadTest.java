package cn.bugio.Excel.dome1;

import cn.bugio.Excel.ExcelData.User;
import cn.bugio.Excel.doomain.UserData;
import cn.bugio.Excel.doomain.UserStyleData;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.junit.Test;

/**
 * @description:
 * @author: Vincent Vic
 * @email: vincent-vic@qq.com
 * @time: 2020/9/12 10:49
 */

public class ReadTest {
    /**
     * 简单读 1
     */
    @Test
    public void test01(){
        String fileName = "user1.xlsx";
        EasyExcel.read(fileName, User.class, new AnalysisEventListener<User>() {
            /**
             * 解析一行调用一次
             * @param user
             * @param analysisContext
             */
            @Override
            public void invoke(User user, AnalysisContext analysisContext) {
                System.out.println(user);
            }

            /**
             * 全部解析完调用
             * @param analysisContext
             */
            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("解析完成");
            }
        }).sheet("用户信息").doRead();
    }

    /**
     * 简单读 2
     */
    @Test
    public void test02(){
        String fileName = "user1.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName, User.class, new AnalysisEventListener<User>() {
            /**
             * 解析一行调用一次
             * @param user
             * @param analysisContext
             */
            @Override
            public void invoke(User user, AnalysisContext analysisContext) {
                System.out.println(user);
            }

            /**
             * 全部解析完调用
             * @param analysisContext
             */
            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("解析完成");
            }
        }).build();

        ReadSheet readSheet = EasyExcel.readSheet("用户信息").build();
        excelReader.read(readSheet);
        excelReader.finish();

    }

    /**
     * 指定下标
     */
    @Test
    public void test03(){
        String fileName = "user1.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName, UserData.class, new AnalysisEventListener<UserData>() {
            /**
             * 解析一行调用一次
             * @param user
             * @param analysisContext
             */
            @Override
            public void invoke(UserData user, AnalysisContext analysisContext) {
                System.out.println(user);
            }

            /**
             * 全部解析完调用
             * @param analysisContext
             */
            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("解析完成");
            }
        }).build();

        ReadSheet readSheet = EasyExcel.readSheet("用户信息").build();
        excelReader.read(readSheet);
        excelReader.finish();

    }

    /**
     * 读取格式化
     * 1.日期格式化 @DateTimeFormat
     * 2.数字格式化
     */
    @Test
    public void test04(){
        String fileName = "user7.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName, UserStyleData.class, new AnalysisEventListener<UserStyleData>() {
            /**
             * 解析一行调用一次
             * @param user
             * @param analysisContext
             */
            @Override
            public void invoke(UserStyleData user, AnalysisContext analysisContext) {
                System.out.println(user);
            }

            /**
             * 全部解析完调用
             * @param analysisContext
             */
            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("解析完成");
            }
        }).build();

        ReadSheet readSheet = EasyExcel.readSheet("用户信息").build();
        excelReader.read(readSheet);
        excelReader.finish();

    }

    /**
     * 读取全部
     */
    @Test
    public void test05(){
        String fileName = "user1.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName, UserData.class, new AnalysisEventListener<UserData>() {
            /**
             * 解析一行调用一次
             * @param user
             * @param analysisContext
             */
            @Override
            public void invoke(UserData user, AnalysisContext analysisContext) {
                System.out.println(user);
            }

            /**
             * 全部解析完调用
             * @param analysisContext
             */
            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("解析完成");
            }
        }).build();

        ReadSheet readSheet = EasyExcel.readSheet().build();
        excelReader.readAll();
        excelReader.finish();

    }

    /**
     * 读取指定多个表
     */
    @Test
    public void test06(){
        String fileName = "user1.xlsx";
        //构建
        ExcelReader excelReader = EasyExcel.read(fileName).build();

        AnalysisEventListener<User> analysisEventListener = new AnalysisEventListener<User>() {
            /**
             * 解析一行调用一次
             * @param user
             * @param analysisContext
             */
            @Override
            public void invoke(User user, AnalysisContext analysisContext) {
                System.out.println(user);
            }

            /**
             * 全部解析完调用
             * @param analysisContext
             */
            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("解析完成");
            }
        };
        ReadSheet sheet0 = EasyExcel.readSheet(0).head(User.class).registerReadListener(analysisEventListener).build();
        ReadSheet sheet2 = EasyExcel.readSheet(2).head(User.class).registerReadListener(analysisEventListener).build();
        ReadSheet readSheet = EasyExcel.readSheet().build();
        excelReader.read(sheet0,sheet2);
        excelReader.finish();

    }
}
