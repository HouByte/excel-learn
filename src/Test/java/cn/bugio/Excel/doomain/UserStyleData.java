package cn.bugio.Excel.doomain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description: 用户数据实体类，用于测试导入导出功能
 * @author: Vincent Vic
 * @email: vincent-vic@qq.com
 * @time: 2020/9/12 11:02
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserStyleData {
    @ExcelProperty( "用户编号")
    private Integer userId;
    @ExcelProperty( "姓名")
    private String userName ;
    @ExcelProperty( "性别")
    private String genderI;
    //数字格式化需要字符串类型
    @NumberFormat("#.#")
    @ExcelProperty("工资")
    private String salary;
    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty("入职时问")
    private Date hireDate ;
}
