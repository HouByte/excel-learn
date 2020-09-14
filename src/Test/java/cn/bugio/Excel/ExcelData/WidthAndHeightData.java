package cn.bugio.Excel.ExcelData;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description:
 * @author: Vincent Vic
 * @email: vincent-vic@qq.com
 * @time: 2020/9/11 22:21
 */
@ContentRowHeight(30) //设置内容高度
@HeadRowHeight(40) //没置标题高度
@ColumnWidth( 25)// 设置列宽
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WidthAndHeightData {
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    //@ColumnWidth(50) //设 置列宽(可以修饰类,也可以修饰具体属性)
    @ExcelProperty("数字标题")
    private Double doubleData;

}
