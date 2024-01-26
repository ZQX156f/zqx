package supplement.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectDemo1
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/26 11:28
 * @Version V1.0
 **/
public class ReflectDemo5 {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //Student类用来去描述学生的信息，无论张三、李四，均可以使用Student来封装表示

        //Class对象是用来表示不同的class信息的，无论Student.class还是Teacher.class，均可以使用Class对象来表示

        //获取Student对应的Class对象
        Class<?> studentClass = Class.forName("supplement.reflect.Student");

        Object o = null;
        //利用Class对象来获取构造函数，实例化一个对象出来
        Constructor<?>[] constructors = studentClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            //通过参数个数为0的，我们选择无参构造函数来实例化对象
            int parameterCount = constructor.getParameterCount();
            if(parameterCount == 0){
                o = constructor.newInstance();
            }
        }

        //通过反射去调用某个方法 setUsername方法
        Method[] methods = studentClass.getMethods();
        for (Method method : methods) {
            if(method.getName().equals("setUsername")){
                //调用对应的方法 调用setUsername方法，调用的是哪个对象里面的这个方法呢？
                //需要传递两个参数：参数一：指的是调用哪个对象里面的setUsername方法
                //参数二：在调用这个setUsername方法时，传递进去的参数是多少
                //方法的返回值便是方法的调用结果
                method.invoke(o, "lisi");
            }
        }
        System.out.println(o);

    }
}
