package com.ahang.blog.util;

import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.dialect.MySQL8Dialect;

/**
 * @author 阿行
 */
public class MySQL5InnoDBDialectUtf8mb4 extends MySQL8Dialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}