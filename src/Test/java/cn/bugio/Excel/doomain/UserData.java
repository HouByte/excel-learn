package cn.bugio.Excel.doomain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description:
 * @author: Vincent Vic
 * @email: vincent-vic@qq.com
 * @time: 2020/9/12 11:02
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserData {
    @ExcelProperty( index = 0)
    private Integer userId;
    @ExcelProperty( index = 1)
    private String userName ;
    @ExcelProperty( index = 2)
    private String genderI;
    @ExcelProperty( index = 3)
    private Double salary;
    @ExcelProperty( index = 4)
    private Date hireDate ;
}
