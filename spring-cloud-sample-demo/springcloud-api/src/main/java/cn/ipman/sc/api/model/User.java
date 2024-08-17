package cn.ipman.sc.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/17 18:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long id;
    private String name;
    private int age;
}
