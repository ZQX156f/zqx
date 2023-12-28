package baisc.identifier;

/*

    - 包名所有字母一律小写，例如com.cskaoyan.example01（多级包名用“.”隔开）
    - 类和接口每个单词的首字母大写，例如Student，Runnable，MyFirstProgram （大驼峰命名）
    - 常量名所有字母都大写，单词之间用下划线连接，例如STUDENT_MAX_AGE
    - 变量名和方法名的第一个单词首字母小写，从第二个单词开始每个首字母大写(小驼峰命名)，例如，userName，getStudentName


    **约定俗称的规范：**
        2. 标识符字符串尽量只使用英文字母和阿拉伯数字。
        3. 不要使用“$”美元符号，其在命名中有特殊含义，建议程序员不要主动使用它。
        4. 不要使用“_”下划线与"$"开头结尾, 其在命名中也有特殊含义，除开特殊场景不要使用它。
        5. 其他参考**[Java开发编程规约](http://47.97.82.68:8080/course/Java开发编程规约.html?ws=none)**

 */
public class Demo2 {

    public static void main(String[] args) {

        // 包命名:
        // 习惯: 以域名反转的方式定义包名

        // 类命名:

        // 常量：
        int MAX_AGE = 1;

        // 变量和方法名
        int userName = 0;

        // 不要这么做
        String 名字;

        // 可以使用$,不建议
        int $aaa;
    }
}
