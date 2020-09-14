package cn.bugio.Excel.ExcelData;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: Vincent Vic
 * @email: vincent-vic@qq.com
 * @time: 2020/9/11 21:20
 */

@AllArgsConstructor
@Data
public class ComplexHeadUser {
    @ExcelProperty({"用户主题1", "用户编号"})
    private Integer userId ;
    @ExcelProperty({"用户主题1","用户名脉"})
    private String userName;
    @ExcelProperty({"用户主题2" ,"入职时间"})
    private Date hireDate;

}