package com.cskaoyan.pacman.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectDemo1
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/26 11:28
 * @Version V1.0
 **/
public class ReflectDemo3 {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //Student类用来去描述学生的信息，无论张三、李四，均可以使用Student来封装表示

        //Class对象是用来表示不同的class信息的，无论Student.class还是Teacher.class，均可以使用Class对象来表示

        //获取Student对应的Class对象
        Class<?> studentClass = Class.forName("com.cskaoyan.pacman.reflect.Student");

        Constructor<?>[] constructors = studentClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            //直接调用构造函数，创建、实例化一个对象，和之前大家手动 new Student()完全等价的效果
            //构造函数中参数的个数
            int parameterCount = constructor.getParameterCount();
            //选择构造函数参数个数为0的进行实例化一个对象
            if(parameterCount == 0){
                Object o = constructor.newInstance();
                System.out.println(o);
            }
            System.out.println(parameterCount);
        }
    }
}
