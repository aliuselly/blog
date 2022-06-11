package org.aliuselly.blog_demo.util;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 该插件用于解决多次执行generate，生成的xml只能追加无法覆盖问题。一般情况下不需要多次执行generate操作。
 *
 * 不过，现在不需要了，因为，可以直接在 xml 中定义字段即可解决，所以，pass
 */
public class OverIsMergeablePlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> list) {
        return false;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        try
        {
            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
