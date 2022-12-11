package hhhqi.com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 付费课程实体
 * @create: 2022-11-20 14:59
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PayProject {
    //项目id 自增
    private Integer projectId;

    //项目名称
    private String projectName;

    //项目价格
    private BigDecimal projectPrice;

    //项目日期
    private Timestamp projectDate;

    //项目简述
    private String projectContent;
}
