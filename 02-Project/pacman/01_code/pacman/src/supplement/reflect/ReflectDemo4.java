package supplement.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName ReflectDemo1
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/26 11:28
 * @Version V1.0
 **/
public class ReflectDemo4 {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //Student类用来去描述学生的信息，无论张三、李四，均可以使用Student来封装表示

        //Class对象是用来表示不同的class信息的，无论Student.class还是Teacher.class，均可以使用Class对象来表示

        //获取Student对应的Class对象
        Class<?> studentClass = Class.forName("supplement.reflect.Student");

        Constructor<?>[] constructors = studentClass.getConstructors();
        Object object = null;
        for (Constructor<?> constructor : constructors) {
            //直接调用构造函数，创建、实例化一个对象，和之前大家手动 new Student()完全等价的效果
            //构造函数中参数的个数
            int parameterCount = constructor.getParameterCount();
            //选择构造函数参数个数为0的进行实例化一个对象
            if(parameterCount == 0){
                object = constructor.newInstance();
            }
        }
        //创建了一个student对象，里面次数属性是空的 null
        Field[] fields = studentClass.getDeclaredFields();
        for (Field f : fields) {
            if(f.getName().equals("username")){
                //通过反射给username赋值
                //需要提供两个参数；参数一：给哪个对象的该属性赋值  参数二：给当前属性赋什么值
                //私有的需要暴力破解
                f.setAccessible(true);
                f.set(object, "zhangsan");
            }
        }

        System.out.println(object);
    }
}
