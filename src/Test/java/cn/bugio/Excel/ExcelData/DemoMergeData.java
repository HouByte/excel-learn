package cn.bugio.Excel.ExcelData;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


@NoArgsConstructor
@AllArgsConstructor
@Data
/**
 * @OnceAbsoluteMerge:指定从哪一行开始，哪一行结束，哪一列开始，哪—列结束，进行合并单元格
 * firstRouIndex:起始行索引 从0开始
 * lastRow工ndex:结束行索引
 *  firstcolumnIndex:起始列索引 从0开始
 * lastColumnIndex:结束列索引
 * 例如:第2-3行,2-3列进行合并
 */
@OnceAbsoluteMerge(firstRowIndex = 1,lastRowIndex = 2,firstColumnIndex = 1,lastColumnIndex = 2)
public class DemoMergeData {

    //每隔两行合并一次(竖吞合并单元格)
    @ContentLoopMerge(eachRow = 2)
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    //@ColumnWidth(50) //设 置列宽(可以修饰类,也可以修饰具体属性)
    @ExcelProperty("数字标题")
    private Double doubleData;
}
