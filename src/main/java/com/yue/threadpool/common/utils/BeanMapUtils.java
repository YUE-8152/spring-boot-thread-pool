package com.yue.threadpool.common.utils;

import com.yue.threadpool.common.core.ServiceException;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.cglib.beans.BeanMap;

import java.util.*;

/**
 * @ProjectName: cln-api
 * @Package: com.cln.common.util
 * @ClassName: BeanMapUtils
 * @Author: YUE
 * @Description:
 * @Date: 2021/7/16 10:27
 * @Version: 1.0
 */
public class BeanMapUtils {
    /**
     * 将对象属性转化为map集合
     *
     * @param bean:
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @Author: YUE
     * @Date: 2021/7/16 10:36
     **/
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap<>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * 将map集合中的数据转化为指定对象的同名属性中
     *
     * @param map:
     * @param clazz:
     * @return: T
     * @Author: YUE
     * @Date: 2021/7/16 10:36
     **/
    public static <T> T mapToBean(Map<String, Object> map, Class<T> clazz) {
        try {
            T bean = clazz.newInstance();
            BeanMap beanMap = BeanMap.create(bean);
            beanMap.putAll(map);
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("Map to JavaBean Error");
        }
    }

    /**
     * 将一组数据平均分成n组
     *
     * @param list: 要分组的数据list
     * @param n:    平均分成n组
     * @return: java.util.List<java.util.List < T>>
     * @Author: YUE
     * @Date: 2021/8/19 10:24
     **/
    public static <T> List<List<T>> averageSplitList(List<T> list, int n) {
        List<List<T>> result = new ArrayList<List<T>>();
        // 先计算出余数
        int remainder = list.size() % n;
        // 计算商值
        int number = list.size() / n;
        // 偏移量
        int offset = 0;
        for (int i = 0; i < n; i++) {
            List<T> value = null;
            if (remainder > 0) {
                value = list.subList(i * number + offset, (i + 1) * number + offset + 1);
                remainder--;
                offset++;
            } else {
                value = list.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;
    }

    /**
     * 将一组数据固定分组，每组n个元素
     *
     * @param list: 要分组的数据list
     * @param n:    每组n个元素
     * @return: java.util.List<java.util.List < T>>
     * @Author: YUE
     * @Date: 2021/8/19 10:25
     **/
    public static <T> List<List<T>> fixedElementSplitList(List<T> list, int n) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        List<List<T>> result = new ArrayList<List<T>>();
        int sourceSize = list.size();
        int size = (list.size() / n) + 1;
        for (int i = 0; i < size; i++) {
            List<T> subset = new ArrayList<T>();
            for (int j = i * n; j < (i + 1) * n; j++) {
                if (j < sourceSize) {
                    subset.add(list.get(j));
                }
            }
            result.add(subset);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        List<List<String>> lists = fixedElementSplitList(list, 3);
        lists.forEach(e -> {
            System.out.println(e);
        });
    }
}
