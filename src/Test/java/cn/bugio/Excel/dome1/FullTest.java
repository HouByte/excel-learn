package cn.bugio.Excel.dome1;

import cn.bugio.Excel.ExcelData.User;
import cn.bugio.Excel.ExcelData.templateData;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Vincent Vic
 * @email: vincent-vic@qq.com
 * @time: 2020/9/12 13:05
 */

public class FullTest {

    /**
     * 填充单个
     */
    @Test
    public void test01(){
        //根据模板填充
        String templateName = "template.xlsx";

        //填充完成的excel
        String fullName = "templateSuccee.xlsx";

        //数据
        templateData data = new templateData("user",1000.00);

        //构建
        EasyExcel.write(fullName).withTemplate(templateName).sheet().doFill(data);

    }

    /**
     * 填充多个
     */
    @Test
    public void test02(){
        //根据模板填充
        String templateName = "template2.xlsx";

        //填充完成的excel
        String fullName = "templateSuccee2.xlsx";
        //数据
        List<templateData> datas = new ArrayList<>();
        for (int i = 0; i < 20 ; i++) {
            templateData data = new templateData("user" + i,1000.00 * (i%3));
            datas.add(data);
        }

        //构建
        EasyExcel.write(fullName).withTemplate(templateName).sheet().doFill(datas);

    }
}
