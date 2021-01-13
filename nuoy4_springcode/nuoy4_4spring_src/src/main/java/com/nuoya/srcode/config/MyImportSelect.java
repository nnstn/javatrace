package com.nuoya.srcode.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelect implements ImportSelector {
    //返回字符串数组就是需要导入注册的全类名
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String []beans = new String[]{"com.nuoya.srcode.bean.UserPo"}; //需要注册的类
        return beans;
    }
}