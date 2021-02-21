package com.ahang.blog.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ahang
 * @date 2021/2/18 13:22
 */
@Entity
@Table(name = "t_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Type {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty(message = "分类名称不能为空")
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();
}
