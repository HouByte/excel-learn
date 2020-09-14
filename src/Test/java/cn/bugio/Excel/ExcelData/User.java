package cn.bugio.Excel.ExcelData;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description:
 * @author: Vincent Vic
 * @email: vincent-vic@qq.com
 * @time: 2020/9/11 15:04
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    //index 编号
    //@ExcelProperty( value = "用户编号",index = 1)
    @ExcelProperty( "用户编号")
    private Integer userId;
    @ExcelProperty( "姓名")
    private String userName ;
    @ExcelProperty( "性别")
    private String genderI;
    @ExcelProperty("工资")
    private Double salary;
    @ExcelProperty("入职时问")
    private Date hireDate ;
}
