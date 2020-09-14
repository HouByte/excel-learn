package cn.bugio.Excel.ExcelData;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.FillPatternType;

import java.util.Date;

/**
 * @description: 样式模板
 * @author: Vincent Vic
 * @email: vincent-vic@qq.com
 * @time: 2020/9/12 10:04
 */
@ContentRowHeight(30) //设置内容高度
@HeadRowHeight(40) //没置标题高度
@ColumnWidth( 25)// 设置列宽
//头背景设置成红色Indexedcolors.RED.getIndex ( )
@HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND,fillForegroundColor = 10)
//头字体设置成20
@HeadFontStyle(fontHeightInPoints = 20)
//内容的背景设置成绿色工ndexedColors.GREEN.getIndex()
@ContentStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND,fillForegroundColor = 17)
//内容字体设置成10
@ContentFontStyle(fontHeightInPoints = 10)

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DemoStyleData {

    //字符串的头背景设置成粉红 IndexedColors.PINK.getIndex()
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND,fillForegroundColor = 14 )
    //字符串字体设置成20
    @HeadFontStyle(fontHeightInPoints = 20)
    //字符串内容背景设置天蓝色
    @ContentStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND,fillForegroundColor = 40)
    //字符串内容字体设置成15
    @ContentFontStyle(fontHeightInPoints = 15)
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    //@ColumnWidth(50) //设 置列宽(可以修饰类,也可以修饰具体属性)
    @ExcelProperty("数字标题")
    private Double doubleData;
}
