package supplement.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectDemo1
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/26 11:28
 * @Version V1.0
 **/
public class ReflectDemo2 {

    public static void main(String[] args) throws ClassNotFoundException {
        //Student类用来去描述学生的信息，无论张三、李四，均可以使用Student来封装表示

        //Class对象是用来表示不同的class信息的，无论Student.class还是Teacher.class，均可以使用Class对象来表示

        //获取Student对应的Class对象
        Class<?> studentClass = Class.forName("supplement.reflect.Student");

        //利用这个方法可以获取所有的构造函数
        Constructor<?>[] constructors = studentClass.getConstructors();

        //利用这个方法可以获取所有的属性、也就是成员变量
        //其中如果是私有的属性或者私有的方法，那么直接利用getXXX获取不到
        //则可以使用一种更加暴力的方式来获取
        Field[] fields = studentClass.getFields();
        //可以获取私有的成员变量
        Field[] fields2 = studentClass.getDeclaredFields();

        //利用该方法可以获取所有的方法信息
        Method[] methods = studentClass.getMethods();
        //可以获取私有的方法
        Method[] declaredMethods = studentClass.getDeclaredMethods();

        System.out.println("===============================");

        Class<?> teacherClass = Class.forName("supplement.reflect.Teacher");

        Field[] fields1 = teacherClass.getFields();
        Method[] methods1 = teacherClass.getMethods();
        Constructor<?>[] constructors1 = teacherClass.getConstructors();

        System.out.println("==================================");
    }
}
