package test;

import com.cskaoyan.pacman.model.Coordinate;
import com.cskaoyan.pacman.model.Ghost;
import com.cskaoyan.pacman.util.ClassUtils;

import java.util.List;

/**
 * @ClassName ClassTest
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/21 11:48
 * @Version V1.0
 **/
public class ClassTest {

    public static void main(String[] args) throws ClassNotFoundException {
//        List<Class> allClasses = ClassUtils.getAllClasses();
//        System.out.println(allClasses);

        Ghost ghost = new Ghost(new Coordinate(1, 1));
    }
}
