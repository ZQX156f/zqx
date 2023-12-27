[TOC]

# Java基础部分

## Scanner基础使用练习

> 键盘输入某个学生的三门学科（数学，语文，英语）成绩，然后分别求出三科成绩的平均分，最低分，最高分，三科的总分。

<span style=color:red;background:yellow>**注：**</span>

1. 代码直接写在main()方法中即可，<font color=red>**注意命名规范！**</font>
2. 注意录入数据的数据类型。

```java
import java.util.Scanner;

/**
 * 键盘输入某个学生的三门学科（数学，语文，英语）成绩
 *      然后分别求出三科成绩的平均分，最低分，最高分，三科的总分。
 *
 * @since 15:23
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class ScannerBasicDemo1 {
    public static void main(String[] args) {
        /*
            关于局部变量的使用,局部变量就只在作用域内生效
            为了代码具有更好的可读性和扩展性
            建议局部变量应该在用的时候再定义,而不要一股脑全部定义完再用
            最合理的情况下,定义局部变量和使用不超过三行
         */

        System.out.println("请依次输入学生的数学,语文,英语成绩:");
        // 使用键盘录入 Scanner 三步走
        Scanner sc = new Scanner(System.in);

        // .var快捷键 自动补全方法调用左边的内容
        // 标识符变量名的命名: 小驼峰式,见名知意
        double mathScore = sc.nextDouble();
        double chineseScore = sc.nextDouble();
        double englishScore = sc.nextDouble();

        // 求和,求总分
        double sum = (mathScore + chineseScore + englishScore);
        // 求平均成绩
        double average = sum / 3;
        // 求最高分和最低分
        // 使用三目运算符求两个数的最大值
        double tempMaxScore = (mathScore > chineseScore) ? mathScore : chineseScore;
        double maxScore = (tempMaxScore > englishScore) ? tempMaxScore : englishScore;

        // 求最小值
        double tempMinScore = (mathScore < chineseScore) ? mathScore : chineseScore;
        double minScore = (tempMinScore < englishScore) ? tempMinScore : englishScore;

        System.out.println("总分是:" + sum);
        System.out.println("平均分是:" + average);
        System.out.println("最高分:" + maxScore);
        System.out.println("最低分:" + minScore);
    }
}
```



## Scanner基础使用练习

> 使用Scanner依次接收以下三种数据类型的值：
>
> 1. int类型
> 2. String类型
> 3. double类型
>
> 接收三个值后，再计算：
>
> 1. 求和：int + double
> 2. 拼接字符串：int + double + String
>
> 分别接收计算结果后，输出该计算结果。

<span style=color:red;background:yellow>**注：**</span>

1. **使用Scanner时，注意不要混用next系列和nextLine方法。**（原因可以查看详细文档说明）
2. 代码直接全部写在main方法中即可。

```java
import java.util.Scanner;

/**
 * 使用Scanner依次接收以下三种数据类型的值：
 *
 * 1. int类型
 * 2. String类型
 * 3. double类型
 *
 * 接收三个值后，再计算：
 *
 * 1. 求和：int + double
 * 2. 拼接字符串：int + double + String
 *
 * 分别接收计算结果后，输出该计算结果。
 *
 * @since 15:06
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class ScannerBasicDemo2 {
    public static void main(String[] args) {
        // 为了避免出现混用问题，统一使用nextLine方法接收键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个int数值：");
        String intNumStr = sc.nextLine();
        int intNum = Integer.parseInt(intNumStr);
        System.out.print("请输入一个String字符串：");
        String str = sc.nextLine();
        System.out.print("请输入一个double数值：");
        String doubleNumStr = sc.nextLine();
        double doubleNum = Double.parseDouble(doubleNumStr);

        System.out.println("两个数值相加的结果是：" + (intNum + doubleNum));
        System.out.println("字符串拼接的结果是：" + (intNum + doubleNum + str));
    }

}
```



## Scanner综合练习

模拟账号登录功能

1.用户名(String):admin

2.密码(String): 123456

3.使用scanner进行输入, 有3次机会可以重新输入, 用户名密码匹配成功提示登陆成功并结束, 否则提示登陆失败还剩几次机会 , 一旦3次都失败提示锁定账户结束程序.

```java
import java.util.Scanner;

/**
 * @description:
 * @author: 景天
 * @date: 2023/3/3 10:27
 **/

public class AccountLogin {
    public static void main(String[] args) {
        // 用户名
        String userName = "admin";
        // 密码
        String password = "123456";

        // 3次输入机会
        for (int i = 0; i < 3; i++) {
            // 0 1 2
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入用户名:");
            String user = scanner.nextLine();
            System.out.println("请输入密码:");
            String pwd = scanner.nextLine();
            if (userName.equals(user) && password.equals(pwd)) {
                System.out.println("Login successful!");
                break;
            }else{
                if (i == 2) {
                    // 3次机会后锁定账户
                    System.out.println("账户被锁定");
                    break;
                }
                // 输错了重新输入
                System.out.println("信息错误,重新登录!还剩"+(2-i)+"次机会");

            }
        }


    }
}

```



## switch练习

> 利用switch语句输出每个月份对应的季节：
>
> 1. 12、1、2：冬季
> 2. 3、4、5：春季
> 3. 6、7、9：夏季
> 4. 9、10、11：秋季

**注：合理使用case穿越，注意命名规范**

```java
import java.util.Scanner;

/**
 * 利用switch语句输出每个月份对应得季节
 *
 * - 12，1，2 — 冬季
 * - 3，4，5 — 春季
 * - 6，7，8 —夏季
 * - 9，10，11 —秋季
 *
 */
public class SwitchExercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入月份: ");
        // 这里仅接收一个int参数,且是月份
        int month = sc.nextInt();
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            default:
                System.out.println("输入的月份有误!");
                break;
        }
    }
}
```





## if多分支练习

> 键盘录入某个人的工资收入，求他应该缴纳的个人所得税以及最后得到的工资。
>
> **也就是说需要求两个值：**
>
> 1. **缴纳的个税**
> 2. **到手工资**
>
> 个人所得税的计算方法是：
>
> 应纳税额 = 应纳税所得额 * 税率 - 速算扣除数 <span style=color:red;background:yellow>**（速算扣除额已经扣除了重复计算的部分）**</span>
>
> 其中，应纳税所得额 = 工资薪金所得-2000（即工资超过2000的部分才需要缴税）
>
> 针对不同的收入人群，需要缴纳个税的税率是不同的，详参下列表格：
>
> | 级数 |            应纳税所得额             | 税率（单位:%） | 速算扣除数 |
> | :--: | :---------------------------------: | :------------: | :--------: |
> |  1   |          **不超过500元的**          |       5        |     0      |
> |  2   |    **超过500元但是不超过2000的**    |       10       |     25     |
> |  3   |  **超过2000元但是不超过5000元的**   |       15       |    125     |
> |  4   |  **超过5000元但是不超过20000元的**  |       20       |    375     |
> |  5   | **超过20000元但是不超过40000元的**  |       25       |    1375    |
> |  6   | **超过40000元但是不超过60000元的**  |       30       |    3375    |
> |  7   | **超过60000元但是不超过80000元的**  |       35       |    6375    |
> |  8   | **超过80000元但是不超过100000元的** |       40       |   10375    |
> |  9   |         **超过100000元的**          |       45       |   15375    |

注：

1. 代码直接写在main()方法中即可，<font color=red>**注意命名规范！**</font>
2. <font color=red>**再次重复一遍，速算扣除数，已经扣除了重复计算的部分。你不需要考虑重复计算的部分。**</font>

<img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202206060053041.png?align=center" alt="image-20220606005339928" style="zoom:50%;" />



```java
import java.util.Scanner;

/**
 * 计算税收,题目这里不复制过来了
 *
 * @since 15:27
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class IfMultiBranchDemo {
    public static void main(String[] args) {
        System.out.print("请输入工资：");
        Scanner sc = new Scanner(System.in);
        // 输入工资
        double salary = sc.nextDouble();
        // 应纳税所得额
        double taxable = salary - 2000;
        if (taxable <= 0) {
            System.out.println("不用缴税，到手工资为：" + salary);
        } else {
            // 税率
            double taxRate;
            // 速算扣除数
            double deduction;
            if (taxable <= 500) {
                taxRate = 0.05;
                deduction = 0;
            } else if (taxable <= 2000) {
                taxRate = 0.1;
                deduction = 25;
            } else if (taxable <= 5000) {
                taxRate = 0.15;
                deduction = 125;
            } else if (taxable <= 20000) {
                taxRate = 0.2;
                deduction = 375;
            } else if (taxable <= 40000) {
                taxRate = 0.25;
                deduction = 1375;
            } else if (taxable <= 60000) {
                taxRate = 0.3;
                deduction = 3375;
            } else if (taxable <= 80000) {
                taxRate = 0.35;
                deduction = 6375;
            } else if (taxable <= 100000) {
                taxRate = 0.4;
                deduction = 10375;
            } else {
                taxRate = 0.45;
                deduction = 15375;
            }
            // 应纳税额
            double tax = taxable * taxRate - deduction;
            // 实际到手工资
            double salaryLeft;
            salaryLeft = salary - tax;

            System.out.println("缴纳的个人所得税为：" + tax);
            System.out.println("实际到手工资为：" + salaryLeft);
        }
    }
}
```





## 循环相关练习题

> 无论是for循环、while循环还是do...while循环，它们的本质都是一致的，使用时也没有特别的差异。下列给出几道简单的练习题，大致做一做。实际开发中，要根据实际需求，灵活使用循环。
>
> 1. 计算 2 + 4 + 6 + … + 100 的值。
> 2. 计算2000年1月1日到2008年1月1日相距多少天。（注意闰年）
> 3. 循环输入一个不为0的数进行累加，直到输入的数字为0，结束循环并最后输出累加的结果。

注：

1. 代码直接写在main()方法中即可，<font color=red>**注意命名规范！**</font>
2. 使用什么循环都行，实现功能就行。

```java

/**
 * 计算 2 + 4 + 6 + … + 100 的值。
 * @since 15:35
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class CycleSumDemo {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 2; i <= 100; i += 2) {
            sum += i;
        }
        System.out.println(sum);
        // 相应的，你还可以求1 + 3 + 5 + ... + 99的值
        int sum2 = 0;
        for (int i = 1; i <= 100; i += 2) {
            sum2 += i;
        }
        System.out.println(sum2);

    }
}
```



```java
/**
 * 计算2000年1月1日到2008年1月1日相距多少天。（注意闰年）
 * @since 15:43
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class CalcDaysNum {
    public static void main(String[] args) {
        // 总天数
        int sum = 0;
        for (int i = 2000; i < 2008; i++) {
            // 某年的天数
            int daysNum;
            // 判断是闰年
            if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
                daysNum = 366;
            } else {
                daysNum = 365;
            }
            sum += daysNum;
        }
        System.out.println(sum);
    }
}
```

```java
import java.util.Scanner;

/**
 * 循环输入一个不为0的数进行累加，直到输入的数字为0，结束循环并最后输出累加的结果。
 * @since 15:45
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class ScannerCycleSumDemo {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        // 循环输入
        while (true) {
            System.out.print("请输入一个int数值（按0结束输入）：");
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }
            sum += num;
        }
        System.out.println("输入的数累加结果是:" + sum);
    }
}
```





# 方法

## 基础语法练习

> 方法是Java代码中最常用的语法结构，这里对方法的语法做一下练习。
>
> 在使用方法或者想要写一个方法时，首先要考虑的是方法需要的参数是什么数据类型，需要几个（形式参数），再考虑方法需要返回什么结果（返回值类型）。在调用方法时，需要搞清楚具体传入什么数值（实际参数）。
>
> <span style=color:red;background:yellow>**完成如下练习题，要求提取出必要的方法，然后在main方法中调用测试：**</span>
>
> <font color=red>**注：不是让你用Junit测试！用main方法测试即可！**</font>
>
> 1. 使用for循环遍历**n以内**的奇数，并计算所有的奇数的和并输出。
>
> 2. 打印倒三角形，并且行数（line）是可控制的。比如我想打印6行的倒三角形，则如下图：
>
>    ``` 
>    ******
>    *****
>    ****	
>    ***	
>    **	
>    *
>    ```
>
> 3. 根据键盘录入打印nn乘法表，n是可变的。
>
> 4. 键盘录入一个int数字，判断它是奇数还是偶数。
>
> 5. 根据键盘录入打印n行m列井号，n和m是可变的。
>
> 6. （扩展题）输出前n个数当中的所有素数，并统计个数。



使用for循环遍历n以内的奇数，并计算所有的奇数的和并输出

```java
import java.util.Scanner;
/**
 * @description: for循环的小练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 使用for循环遍历n以内的奇数，并计算所有的奇数的和并输出，要求使用方法
 *
 * 怎么判断一个数是奇数呢? 一个数取余%2,结果只要不是0,那么它就是一个奇数
 *
 * 在一个方法中，如果有返回值，那么return就起到结束方法和返回一个结果的作用
 * 如果方法没有返回值，那么return就只能表示结束方法
 *
 */
public class OddSumDemo {
    public static void main(String[] args) {
        System.out.print("请输入一个正整数,表示求它以内的奇数和: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n + "以内的奇数和为: " + sumOddNum(n));
    }

    public static int sumOddNum(int n) {
        //求和之前，可以声明一个结果值，初始值为0
        int result = 0;
        for (int i = 1; i <= n; i++) {
            //取余2不是0，说明是奇数
            if (i % 2 != 0) {
                //求和
                result += i;
            }
        }
        return result;
    }
}
```



打印倒三角形，并且行数（line）是可控制的

```java

/**
 * @description: 嵌套for循环练习题
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 外层for控制行数，内层for控制列数（打印矩形的时候）
 * 打印倒三角形图案，原理上是一样的，不同点就在于列数,列数是逐行递减的
 *      这一点只需要在写内层for循环时，稍作修改即可
 */
public class PrintTriangleDemo {
    public static void main(String[] args) {
        printInvertedTriangle(10);
    }
    public static void printInvertedTriangle(int line){
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < line - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

```



根据键盘录入打印nn乘法表，n是可变的。

```java
import java.util.Scanner;

/**
 * @description: 根据键盘录入打印nn乘法表
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 根据键盘录入打印nn乘法表，n是可变的
 * 打印乘法表实际上和打印m行n列的井号没有本质区别
 * 1 * 1 = 1
 * 1 * 2 = 2	2 * 2 = 4
 * 1 * 3 = 3	2 * 3 = 6	3 * 3 = 9
 * 1 * 4 = 4	2 * 4 = 8	3 * 4 = 12	4 * 4 = 16
 *
 */
public class MultiplicationTablesDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个int参数作为乘法表的阶数:");
        int x = sc.nextInt();

        // 调用方法
        printTable(x);
    }

    public static void printTable(int n) {
        // 打印n行n列的乘法列
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + " = " + (i * j) + '\t');
            }
            System.out.println();
        }
    }
}
```



键盘录入一个int数字，判断它是奇数还是偶数。

```java
import java.util.Scanner;

/**
 * 判断奇偶性
 *
 * @since 21:31
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class JudgeNumDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个int整数：");
        int num = sc.nextInt();
        System.out.println("输入的数是一个奇数吗？  " + isOddNum(num));
        System.out.println("输入的数是一个偶数吗？  " + isEvenNum(num));
    }

    /**
     * 判断传入的int数是否是奇数
     * @since 21:32
     * @param num 该方法传入一个int整数
     * @return boolean 返回true表示是一个奇数，否则不是
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    public static boolean isOddNum(int num) {
        /*
            if的使用
            if、if...else，多分支的if...else
            如果分支很多，那么就会多很多大括号，大括号越多代码层次就越多，可读性就很差
            所以我们在用if时，尽量不要写else（该用还是要用）

            日常开发中，用一个return去结束if单分支
            然后在后面继续写代码，不要用else

         */
        if (num % 2 != 0) {
            // 是奇数
            return true;
        }
        // 代码能够运行到这里，说明它肯定不是奇数，一定是偶数
        return false;
    }


    /**
     * 判断传入的int数是否是偶数
     * @since 21:32
     * @param num 该方法传入一个int整数
     * @return boolean 返回true表示是一个偶数，否则不是
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    public static boolean isEvenNum(int num) {
        // 一个数不是奇数就是偶数
        return !isOddNum(num);
    }
}

```





根据键盘录入打印n行m列井号，n和m是可变的。

```java
import java.util.Scanner;

/**
 * @description: 根据键盘录入打印x行y列的井号
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 根据键盘录入打印n行m列井号，n和m是可变的
 * 对于n行m列井号而言,必须使用双层for循环,外层for控制行数,内层for控制列数
 */
public class PrintWellDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入两个int参数作为打印的行数和列数，x是行数，y是列数: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        // 调用方法
        printWell(x, y);
    }

    public static void printWell(int x, int y) {
        /*
            嵌套for循环打印井号
            外层for控制行数
            内层for控制列数
         */
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}

```



(扩展题）输出前n个数当中的所有素数，并统计个数。

```java
import java.util.Scanner;

/**
 * 判断素数
 * 求前n个数当中的所有素数。
 *
 * @since 21:37
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class PrimeNumDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数n: ");
        int n = sc.nextInt();
        int count = 0;
        // 从2开始计算
        for (int i = 2; i < n; i++) {
            if (isPrimeNum(i)) {
                System.out.println(i + "是一个素数");
                count++;
            }
        }
        System.out.println(n + "以内，一共有" + count + "个素数。");
    }

    /**
     * 判断一个数是否是素数，true表示是素数，否则表示不是
     * @since 21:41
     * @param num 传入的大于0的正整数
     * @return boolean
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    private static boolean isPrimeNum(int num) {
        // 用一个数分别去除2到这个数的开平方，如果能被整除，则表明此数不是素数，反之是素数。
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if ((num % i) == 0) {
                // 能够整除，说明不是素数
                return false;
            }
        }
        // 代码执行到这里，说明它是一个素数
        return true;
    }
}

```





# Java数组

## 数组基本使用练习

> 1. 定义一个double数组用来存放学生成绩，然后键盘录入10位同学的成绩并存入数组，求这10位同学成绩的平均值。
> 2. 定义一个String数组，输出该数组的长度，并用多种方式遍历打印数组元素（常见的方式遍历即可）

注：

1. **请合理使用方法，不要胡子眉毛一把抓把代码全部写在main方法里。**
2. 数组遍历的方式，比如for、增强for或者使用工具类等等。

```java
import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: double数组的案例
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 *  定义一个double数组用来存放学生成绩，然后键盘录入10位同学的成绩并存入数组，求这10位同学成绩的平均值。
 *
 * 代码应该放在它应该在的位置,一个方法就应该完成它对应的功能,别的事情它不应该管,也不需要管
 */
public class ArrayBasicDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1,声明和动态初始化一个double数组
        // 2,遍历赋值

        // 数组的长度是已知的，直接动态初始化
        double[] arr = new double[10];

        System.out.println("请连续输入10个学生的成绩：");
        for (int i = 0; i < 10; i++) {
            // 连续接收10次 double数据
            double score = sc.nextDouble();
            // 存入数组
            arr[i] = score;
        }

        // 打印遍历这个数组，查看键盘录入的结果
        System.out.println(Arrays.toString(arr));

        arr = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // 调用方法，求平均分
        double average = getAverage(arr);
        System.out.println("10个人的平均分是：" + average);
    }

    public static double getAverage(double[] arr) {
        double sumScore = 0;
        for (int i = 0; i < arr.length; i++) {
            sumScore += arr[i];
        }
        return sumScore / arr.length;
    }
}

```





```java
import java.util.Arrays;

/**
 * @description: String数组练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 定义一个String数组，输出该数组的长度，并用多种方式遍历打印数组元素（常见的方式遍历即可）
 */
public class ArrayBasicDemo2 {
    public static void main(String[] args) {
        String[] arr = {"hello", "2", "world!"};
        System.out.println("数组的长度：" + arr.length);
        // 最朴实无华 最简单的方式
        System.out.println("数组的第一个元素是" + arr[0]);
        System.out.println("数组的第二个元素是" + arr[1]);
        System.out.println("数组的第三个元素是" + arr[2]);

        // 数组工具类
        System.out.println(Arrays.toString(arr));
        // for循环遍历 快捷键数组名.fori
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // 增强for循环遍历 快捷键iter
        for (String s : arr) {
            System.out.println(s);
        }

    }
}

```



## 数组基本使用练习

> 现在你去参加歌唱比赛。有10个评委打分，规则是去掉最高分和最低分，求平均分是最终成绩。请编码计算出你的最终成绩~

注：

1. **请合理使用方法，不要胡子眉毛一把抓把代码全部写在main方法里。**

2. **最高分和最低分可能有多个，但只需要去掉其中一个即可（也就是说平均成绩要除以8）**

3. 建议给出下面的三个方法：

   1. 求数组中元素最大值的方法
   2. 求数组中元素最小值的方法
   3. 求数组中元素平均分的方法

   当然如果你有自己的想法，也可以用自己的方式去实现功能。



```java
/**
 * 参加快乐男声比赛,有10个评委打分,(去掉一个最高一个最低)求最后的平均成绩
 * 提示：用数组装这些分数，并找到最大值和最小值去掉他们，然后算平均值。
 * 要求：必须提供三个方法：求最大值，最小值，平均分
 *
 * 求数组的最大值/最小值：假设法，假设数组当中第一个元素是最值，然后遍历数组逐个比较，最终得到最值
 * 数组当中元素的平均值： 先求和，然后除以数组的长度（这道题应该除以8）
 * 数组的求和： 先设定一个和的变量（初始值0），然后遍历数组，累加
 *
 */
public class DoubleArrayDemo {
    public static void main(String[] args) {
        // 选择double去装分数是为了方便计算平均分
        double[] arr = {5, 8, 6, 7, 8, 9, 10, 10, 8, 8};
        System.out.println("平均分是：" + getAverageScore(arr));
    }

    public static double getMaxScore(double[] arr) {
        // 设置首元素是最大值
        double max = arr[0];
        // 遍历数组,逐一比较,求最大值
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                // 找到一个更大的元素,设置它为最大值
                max = arr[i];
            }
        }
        return max;
    }

    public static double getMinScore(double[] arr) {
        // 设置首元素是最小值
        double min = arr[0];
        // 遍历数组,逐一比较,求最小值
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                // 找到一个更小的元素,设置它为最小值
                min = arr[i];
            }
        }
        return min;
    }

    public static double getAverageScore(double[] arr) {
        // 先把数组所有元素加起来,然后减掉数组中的最大值和最小值,除以8
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        // static方法之间是可以互相调用的，前提是在一个类中
        double score = sum - getMaxScore(arr) - getMinScore(arr);
        return score / 8;
    }
}
```





## 数组排序（扩展）

> 随意给出一个长度为10的int数组，然后升序排列它。

注：

1. 如果想自己写排序实现，可以使用最简单的冒泡排序或者选择排序。（不会就百度一下）
2. 排序对于数组而言是非常常见的操作，Java源码工具类中，早有对应的实现。请百度查询一下，不需要了解它具体怎么实现的，会用即可。（百度并学习是非常重要的能力，我们不可能在课堂上学会所有的知识）

```java
import java.util.Arrays;
import java.util.Collections;

/**
 * 如果想要自己手写排序,最容易想到的就是选择排序和冒泡排序
 *      但这两种排序方式"偏笨",实际开发中更多建议使用
 *      Array.sort(arr)
 *      完成数组的排序
 * @since 19:24
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class ArraySortDemo {
    public static void main(String[] args) {
        Integer[] arr = {1, 21, 3, 4, 22, 12, 5, 2, 3, 4, 4};
        // selectionSort(arr);
        // bubbleSort(arr);
        // System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }

    // 对一个int数组做选择排序
    /*
        对数组元素升序排序,直接在原先数组中操作就可以了,无需给出返回值
        选择排序指的是每次选择一个最小的放在首位,直到将整个数组排序完毕
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 从第二个元素开始遍历
            for (int j = i + 1; j < arr.length; j++) {
                // 如果后面的元素更小,那就给它替换到前面
                if (arr[j] < arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    // 对一个int数组做冒泡排序
    // 冒泡排序指的是每次选择一个最大的放在末尾,直到将整个数组排序完毕
    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            // 从倒数第二个元素开始遍历
            for (int j = i - 1; j >= 0; j--) {
                // 如果前面的元素更大,那就给它替换到后面
                if (arr[i] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}

```



## 数组基础练习——除以首元素

> 定义一个double类型的数组，让数组中每个元素（包括首位元素）都除以首位元素，得到的结果过作为该位置上的新元素。请在原先数组数组上操作，并打印新数组。
> 例如数组[ 2.0 , 4.0 , 6.0 , 4.0 ] 经过方法运算得到新数组 [ 1.0 ,2.0 , 3.0 ,2.0 ]

注：注意元素取值的变化。

```java
import java.util.Arrays;

/**
 * 定义一个double类型的数组，让数组中每个元素（包括首位元素）都去除以首位元素，得到的结果作为该位置上的新元素
 * 该题尤其注意不能直接正序的遍历数组 然后除以第一个元素
 * 因为第一次除以后 首位元素已经改变了
 *
 * 考虑三种做法:
 *      1,把首位元素提取出来
 *      2,倒序遍历数组
 *      3,先从第二个元素开始除，第一个元素跳过，最后再除第一个
 *
 */
public class DeleteFirstElementDemo {
    public static void main(String[] args) {
        double[] arr = {2, 10, 16, 8, 7, 5, 15};
        modifyArrayByDividedFirstElement3(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 提取出首位元素,然后除以它
    public static void modifyArrayByDividedFirstElement(double[] arr) {
        double first = arr[0];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / first;
        }
    }

    // 倒序遍历数组,除以首元素
    public static void modifyArrayByDividedFirstElement2(double[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = arr[i] / arr[0];
        }
    }

    // 先从第二个开始除,最后把第一个元素变为1.0
    public static void modifyArrayByDividedFirstElement3(double[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] / arr[0];
        }
        arr[0] = 1.0;
    }
}
```



## 数组综合练习——删除元素

> <font color=red>**对于某个String类型数组，将其中的某个元素全部去掉，得到一个新数组，并统计去掉了几个元素。**</font>
>
> 举例，对于String数组["abc", "123", "123", "123", "666", "777"] 将其中的元素"123"全部去掉，就得到了新数组["abc","666", "777"]，一共去掉了3个元素。

注：

1. 这里说的去掉，不是指用0/null等默认值替代原先的元素，而是指真正的删除掉。
2. **思考：同一个数组能不能实现这个功能？如果不能，应该怎么完成呢？**

```java
import java.util.Arrays;

/**
 * 对于某个String类型数组，将其中的某个元素全部去掉，得到一个新数组，并统计去掉了几个元素。
 *
 * 举例，对于String数组["abc", "123", "123", "123", "666", "777"] 将其中的元素"123"全部去掉，就得到了新数组["abc","666", "777"]，一共去掉了3个元素。
 *
 * @since 21:12
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class RealDeleteElementDemo {
    public static void main(String[] args) {
        String[] oldArr = {"123", "456", "789", "123", "123", "666", "777"};
        // 获取删除元素后新数组的长度
        String target = "123";
        int delNum = getDeleteElementNum(oldArr, target);
        // 创建新数组
        String[] newArr = new String[oldArr.length - delNum];
        deleteElement(oldArr, newArr, target);

        // 遍历查看新数组
        System.out.println(Arrays.toString(newArr));
    }

    //传入两个数组，删除old数组中的target元素，得到一个新数组
    public static void deleteElement(String[] oldArr, String[] newArr, String target) {
        // 新数组的下标
        int newIndex = 0;
        //遍历old数组
        for (int i = 0; i < oldArr.length; i++) {
            // null元素跳过,避免空指针异常
            if (oldArr[i] == null) {
                continue;
            }
            // 找到不是目标元素的元素复制进新数组
            if (!oldArr[i].equals(target)) {
                newArr[newIndex] = oldArr[i];
                //赋值后数组下标+1
                newIndex++;
            }
        }
    }

    //获取一个数组中目标数据的个数
    public static int getDeleteElementNum(String[] oldArr, String target) {
        // 计数器
        int count = 0;
        for (int i = 0; i < oldArr.length; i++) {
            // null元素跳过,避免空指针异常
            if (oldArr[i] == null) {
                continue;
            }
            if (oldArr[i].equals(target)) {
                count++;
            }
        }
        return count;
    }
}

```





## 数组综合练习——合并数组（扩展）

> 首先准备两个数组（简单起见，用两个int数组即可）
>
> 然后写方法，将这两个数组合并。

注：

1. 数组合并也是很常见的操作，实际开发中有很多现成的手段去完成它。由于有些手段是超纲的，所以这里不再细表。
2. 如果后续工作中碰到了，可以再百度学习一下。目前就先考虑自己手写实现就可以了。

```java
import java.util.Arrays;

/**
 * 合并数组,思路是：
 *      首先获取两个数组的长度得出新数组的长度
 *      然后创建出这个新数组
 *      最后把两个数组中的元素都拷贝到新数组中
 *
 * @since 16:21
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class MergeArrDemo {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 6, 7, 8};
        int[] arr2 = {4, 5, 6};
        int[] newArr = mergeTwoIntArr(arr1, arr2);
        System.out.println(Arrays.toString(newArr));
    }

    /**
     * 合并两个int数组,得到一个新数组
     * @since 16:33
     * @param arr1 需要合并的数组1
     * @param arr2 需要合并的数组2
     * @return int[]
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    public static int[] mergeTwoIntArr(int[] arr1, int[] arr2) {
        int mergeLength = arr1.length + arr2.length;
        int[] result = new int[mergeLength];

        // 设置一个初始下标用于给结果数组赋值
        int index = 0;

        // 开始赋值arr1
        for (int i = 0; i < arr1.length; i++) {
            result[index] = arr1[i];
            index++;
        }

        // 开始赋值arr2
        for (int i = 0; i < arr2.length; i++) {
            result[index] = arr2[i];
            index++;
        }
        return result;
    }

}

```



 ```java
import java.util.Arrays;

/**
 * 合并数组,思路是：
 *      首先获取两个数组的长度得出新数组的长度
 *      然后创建出这个新数组
 *      最后把两个数组中的元素都拷贝到新数组中
 *
 * 上面的Demo已经能够实现功能了,但还有一些小细节可以优化
 * Demo2就来看一下优化
 *
 * @since 16:21
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class MergeArrDemo2 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 6, 7, 8};
        int[] arr2 = {4, 5, 6};
        int[] newArr = mergeTwoIntArr(arr1, arr2);
        System.out.println(Arrays.toString(newArr));
    }

    /**
     * 合并两个int数组,得到一个新数组
     * @since 16:33
     * @param arr1 需要合并的数组1
     * @param arr2 需要合并的数组2
     * @return int[]
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    public static int[] mergeTwoIntArr(int[] arr1, int[] arr2) {
        int mergeLength = arr1.length + arr2.length;
        int[] result = new int[mergeLength];

        // 开始赋值arr1
        copyIntArr(arr1, result, 0);

        // 开始赋值arr2
        copyIntArr(arr2, result, arr1.length);

        return result;
    }

    /*
        上面这个方法在给新数组赋值时,很明显用了两个for循环,这个代码是可以提取出方法的
        那么在Demo2我们就提取出方法,来优化代码

        在实际开发中,这种场景是非常多,我们写方法,追求:
            突出代码逻辑中的主干
            而那些分支逻辑,最好提取出来作为额外的方法,这样能够使主干逻辑更加清晰
     */

    /**
     * 拷贝数组,将源数组的元素全部拷贝到目标数组中,可以选择从目标数组的什么位置开始复制
     * @since 16:57
     * @param srcArr 源数组,被拷贝的数组
     * @param dstArr 目标数组,将源数组元素拷贝到的数组
     * @param dstBegin 拷贝进目标数组的开始下标(包含)
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    public static void copyIntArr(int[] srcArr, int[] dstArr, int dstBegin) {
        // 拷贝结束的下标(不包含)
        int dstEnd = dstBegin + srcArr.length;
        // 遍历目标数组的对应区间,进行元素拷贝
        int srcIndex = 0;
        for (int i = dstBegin; i < dstEnd; i++) {
            dstArr[i] = srcArr[srcIndex];
            srcIndex++;
        }
    }


}
 ```



## 可变参数练习

> 可变参数的本质是数组，完成下列需求：
>
> 求不限定个数参数的最大值（要求使用可变参数，使用int类型即可）

```java
/**
 * 可变参数的本质是数组，完成下列需求：
 *
 * 求不限定个数参数的最大值（要求使用可变参数）
 * 
 * @since 11:25
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class VariableParameterDemo {
    public static void main(String[] args) {
        System.out.println(getMaxValue(77, 2, 3, 4, 5, 6, 7));
    }

    // 将可变参数当成数组使用即可
    public static int getMaxValue(int... pars){
        int max = pars[0];
        for (int ele : pars) {
            if (ele > max){
                max = ele;
            }
        }
        return max;
    }
}
```



# 递归

## 练习使用递归

> 递归在实际开发中用途并不广泛，但我们仍有必要学习它的基本使用。
>
> 这道题目如果想不明白，那就百度一下吧。

```
使用递归，把十进制正整数（N>=0）转换成二进制数
```



```java
/**
 * 十进制转换成二进制的方法：
 * 用2整除十进制整数，可以得到一个商和余数；
 * 再用2去除商，又会得到一个商和余数，如此进行，直到商为小于1（等于0）时为止
 * 最后倒读余数，得到一个二进制的数
 */
public class DecimalToBinaryDemo {
    public static void main(String[] args) {
        decimalToBinary(2141);
    }

    /*
         分析：
         既然是使用递归求解，那就需要往递归的思想——分解问题上面去靠。
         在打印二进制数的过程中，实际上是一个除以2取余，然后倒读余数的过程。
         也就是一次方法调用只打印一次余数
         下次就继续打印除以2商的余数，这就是递归体。

         递归体找到后，再找递归的出口，在这个除以2取余然后倒读的过程中
         其实只要商小于2，其实就没必要继续进行了
         因为如果商是1，直接打印余数1就可以了，无需计算了

         最后最重要的就是如何实现倒读余数呢？
         这里需要借助栈的一个先进后出的特性 -> 递归体，一定要在打印余数的上面
         这样就能倒读余数了。

     */
    public static void decimalToBinary(int n) {
        //如果商是0了，表示递归需要结束了
        if (n >= 2) {
            //只要商不是0，就继续递归
            decimalToBinary(n / 2);
        }
        System.out.print(n % 2);
    }
}
```







# OOP1——基础部分

## 对象与类基础语法练习题

> 设计物品（Item）类
>
> 它具有以下属性：
>
> 1. 名字
> 2. 价格
> 3. 类别
>
> 它具有以下行为：
>
> 1. 售卖。该方法需要传入一个参数表示购买使用的金钱，如果金钱足够则打印**"xx物品被卖出"**的信息，并将找零作为返回值。
>
>    否则打印**"金钱不足，购买失败"**，并将"-1"作为返回值表示购买失败。
>
> 类定义完毕后，试着创建三个对象并使用**"对象名点"**完成属性赋值：
>
> 1. "手机类的Samsung Galaxy S21 8000元"
> 2. "家具类的海尔冰箱 3000元"
> 3. "日用品类的海飞丝洗发水 30元"
>
> 然后自行调用一下售卖方法，测试一下。

注：

1. 建议用一个public class作为测试类，用于创建对象，调用方法，访问属性等。
2. 具体类（比如本题中的Item）的定义，建议在public class下面定义非public class，这样比较方便快捷。
3. <font color=red>**不要将类定义在其它类的内部（内部类），在定义class时，一定要看清楚大括号！**</font>
4. <font color=red>**以上三条，（如无特别要求）适用于后续面向对象学习中的所有习题。**</font>

```java

/**
 * 对象与类基础语法练习题
 * 设计类Item
 *
 * @since 11:34
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class ClazzBasicDemo {
    public static void main(String[] args) {
        Item it1 = new Item();
        it1.name = "Samsung Galaxy S21";
        it1.category = "手机";
        it1.price = 8000;
        Item it2 = new Item();
        it2.name = "海尔冰箱";
        it2.category = "家具";
        it2.price = 3000;
        Item it3 = new Item();
        it3.name = "海飞丝洗发水";
        it3.category = "日用品";
        it3.price = 30;

        System.out.println(it1.sell(7000));
        System.out.println(it2.sell(5000));
        System.out.println(it3.sell(50));
    }
}

// 注意不要定义内部类
class Item {
    String name;
    double price;
    String category;

    public double sell(double money) {
        if (money > price) {
            System.out.println("种类为" + category + "的物品:" + name + "被出售了！");
            return money - price;
        }
        System.out.println("金钱不足，购买失败！");
        return -1;
    }
}
```





## 构造方法和this关键字练习题

> 定义一个Teacher类：
>
> 包含4个成员变量 String name, int age, String gender, int teacherId
>
> 然后定义5个构造方法：
>
> 1. 无参构造
> 2. name单参构造方法
> 3. name和teacherId双参构造方法
> 4. name，age和gender的三参构造器
> 5. name，age，gender和teacherId的四参构造器（要求用this调用已存在的三参构造器）
>
> 最后再定义一个成员方法：
>
> print()：用于打印这个Teacher类对象的基本信息。
>
> 回答下列问题：
>
> 1. 在上面5个构造方法的基础上，再定义一个构造方法单独给gender赋值，能够做到吗？为什么？
> 2. 定义完上述结构后，再定义一个成员方法setGender，用于给gender赋值。要求方法的形参就是String gender，这个方法如何写呢？
>
> 定义完这个类后，创建两个Teacher对象分别为t1和t2
>
> 1. 要求t1对象的四个成员变量name, age, gender, teacherId的值分别为"张三"、18、"男"、 1
>
> 2. 要求t2对象的四个成员变量name, age, gender, teacherId的值分别为"李四"、25、"女"、 2
>
>    <font color=red>**注意在使用构造器时，对应位置的实参和形参要一一对应。**</font>
>
> 最后分别用两个对象调用print方法，两次调用方法输出的结果相同吗？为什么？



```java
/**
 * @description: 构造方法和this关键字练习题
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 定义类Teacher的练习题
 * 回答下列问题：
 * 1.在上面5个构造方法的基础上
 *      再定义一个构造方法单独给gender赋值，能够做到吗？为什么？
 *      这是做不到的，一个类中的多个构造器能够同时存在，符合Java方法的重载语法
 *      而形参的名字不同是不能构造方法重载的。
 * 2.定义完上述结构后，再定义一个成员方法setGender，用于给gender赋值。
 *      要求方法的形参就是String gender，这个方法如何写呢？
 *      使用this区分同名的局部变量和成员变量即可，详细见具体代码。
 *
 * 定义完这个类后，创建两个Teacher对象分别为t1和t2
 * 1. 要求t1对象的四个成员变量name, age, gender, teacherId的值分别为"张三"、18、"男"、 1
 * 2. 要求t2对象的四个成员变量name, age, gender, teacherId的值分别为"李四"、25、"女"、 2
 * 最后分别用两个对象调用print方法，两次调用方法输出的结果相同吗？为什么？
 * 肯定是不同的，不同对象调用成员方法，访问的都是自身的成员变量。
 *
 */
public class TeacherClazzDemo {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("张三", 18,"男",1);
        Teacher t2 = new Teacher("李四", 25,"女",2);
        t1.print();
        t2.print();
    }
}

/*
    定义类时，需要定义成员变量，成员方法，构造方法等结构
    虽然这些结构的具体定义顺序，对代码的执行没有影响
    但普遍来说推荐大家按照下列顺序定义，这样代码的可读性更好：
         1.首先定义成员变量
         2.再定义构造器（如果有多个组成方法重载，就放在一起，并按照参数从少到多排列）
         3.最后定义成员方法（同样，如果有方法重载就放在一起，并按照参数从少到多排列）
 */
class Teacher {
    // 成员变量
    String name;
    int age;
    String gender;
    int teacherId;

    // 默认无参构造
    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(String name, int teacherId) {
        this.name = name;
        this.teacherId = teacherId;
    }


    public Teacher(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Teacher(String name, int age, String gender, int teacherId) {
        this(name, age, gender);
        this.teacherId = teacherId;
    }

    public void print() {
        System.out.println("这个老师的姓名为:" + this.name + "，年龄是" + this.age + "，职工号为" + this.teacherId + "，性别是" + this.gender);
    }

    // 成员方法给gender赋值
    public void setGender(String gender){
        this.gender = gender;
    }
}
```





## 对象数组练习

> 定义一个Student类：
>
> 成员变量：String name，int stuId，String gender，int age，double score（表示学生Java考试成绩）
>
> 构造器：无参构造器，全参构造器等，自由发挥。
>
> 成员方法：print()，打印对象所有属性的取值。
>
> 类定义完毕后，创建五个Student对象存入Student对象数组中，完成以下两个操作：
>
> 1. 遍历输出每个学生的属性信息（遍历对象调用print()方法）
> 2. 求成绩平均值。

注：

1. **数组既可以存储基本数据类型（的值），也可以存储引用数据类型（的引用）。它们的使用没有本质区别。**
2. 可以考虑提取方法实现功能，不要把所有代码一股脑写在main方法中。

```java
package com.cskaoyan.javase.homework.primary._3oop1.basic;

/**
 * 定义一个Student类：
 * 成员变量：String name，int stuId，String gender，int age，double score（表示学生成绩）
 * 构造器：无参构造器，全参构造器等，自由发挥。
 * 成员方法：print()，打印对象所有属性的取值。
 * 类定义完毕后，创建五个Student对象存入Student对象数组中，完成以下两个操作：
 * 1. 遍历输出每个学生的属性信息（遍历对象调用print()方法）
 * 2. 求成绩平均值。
 *
 * @since 11:56
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class StudentArrDemo {
    public static void main(String[] args) {
        // 初始化一个长度为5的学生对象数组
        Student[] studs = new Student[5];
        // 创建5个学生对象，然后给数组赋值
        Student s1 = new Student(1, "张三", "女", 18, 90);
        Student s2 = new Student(2, "李四", "男", 27, 55);
        Student s3 = new Student(3, "王二", "男", 48, 48);
        Student s4 = new Student(4, "麻子", "女", 30, 60);
        Student s5 = new Student(5, "小七", "女", 18, 86);
        studs[0] = s1;
        studs[1] = s2;
        studs[2] = s3;
        studs[3] = s4;
        studs[4] = s5;
        // 打印所有学生信息
        printStuByArr(studs);

        // 求平均分
        System.out.println("5位同学的Java考试平均分是:" + getAverageScoreByArr(studs));
    }

    // 遍历并输出学生信息
    public static void printStuByArr(Student[] arr) {
        for (Student s : arr) {
            s.print();
        }
    }

    // 遍历并求数组中所有学生的平均分
    public static double getAverageScoreByArr(Student[] arr) {
        // 遍历求总分
        double sum = 0;
        for (Student s : arr) {
            sum += s.score;
        }
        return (sum / arr.length);
    }
}

class Student {
    int id;
    String name;
    String gender;
    int age;
    double score;

    public Student() {
    }

    public Student(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Student(int id, String name, String gender, int age, double score) {
        this(id, name, gender, age);
        this.score = score;
    }

    public void print() {
        System.out.println("该学生姓名为:" + this.name + "，学号为" + id + "，性别为" + gender + "，年龄为" + age + "，Java成绩为" + score);
    }
}

```





# OOP1——高级部分

## static基础语法练习

> 当类中的成员变量被static修饰时，那么它就是一个静态成员变量。当类中的成员方法被static修饰时，那么它就是一个静态成员方法。
>
> 普通成员（变量和方法）必须创建对象才能够访问，它们是属于对象的的。静态成员（变量和方法） 属于类，通过"类名点"就可以访问，它们是属于类的。
>
> 静态成员变量还有一个非常重要特性：**由于类加载只有一次，所以静态成员变量在类全局都是唯一的！**
>
> 现在你需要完成以下基础语法练习：
>
> 
>
> **编写一个类模拟银行账户（Account）的功能，包含的属性有"账户名（ID）"、"密码"、"账户余额"、"储蓄年利率"等。**
> 其中：
>
> 1. **账号名：**要求每个账户的账户名都是唯一的，且按照固定格式自动生成：
>    - 第一位账户的账户名是"10001"
>    - 其后账户的账户名依次加1。比如第二位账户的账户名就是"10002"，第三位就是"10003".....
> 2. **密码：**新建账户时，可以选择自定义密码，也可以选择使用默认密码："000000"（6个0）
> 3. **账户余额：**可以选择在新建账户时预设一个值，也可以保持默认值0
> 4. **储蓄年利率：**由银行设置，和账户本身没有关系。你可以将它设置为**"0.3%"**（活期年利率一般都非常低，聊胜于无）
>
> 定义完属性后，再给出两个成员方法：
>
> 1. 打印账户<font color=red>**自身**</font>所有属性。
>
> 2. 根据传入的年限和储蓄年利率，计算本息合计后的余额。
>
>    **注：计算利息时简单点，不考虑利滚利。即利息 = 利率 * 时间 * 本金**

提示：

1. 账户ID是独属于某个账户的，它肯定是一个成员变量。但是它的赋值却是在一个初始值的基础上，创建一个对象就+1，这需要一个不受创建对象影响的变量。
2. 储蓄年利率肯定不是属于账户对象的。

```java
/**
 * 编写一个类模拟银行账户（Account）的功能，包含的属性有"账户名（ID）"、"密码"、"账户余额"、"储蓄年利率"等。
 * 其中：
 *
 * 1.账号名：要求每个账户的账户名都是唯一的，且按照固定格式自动生成：
 *    ·第一位账户的账户名是"10001"
 *    ·其后账户的账户名依次加1。比如第二位账户的账户名就是"10002"，第三位就是"10003".....
 * 2.密码：新建账户时，可以选择自定义密码，也可以选择使用默认密码："000000"（6个0）
 * 3.账户余额：可以选择在新建账户时预设一个值，也可以保持默认值0
 * 4.储蓄年利率：由银行设置，和账户本身没有关系。
 *
 * 定义完属性后，再给出两个成员方法：
 * 1. 打印账户自身所有属性。
 * 2. 根据传入的年限和储蓄年利率，计算本息合计金额。
 *
 * @since 17:27
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class StaticBasicDemo {
    public static void main(String[] args) {
        // 测试自动生成账户ID
        Account a1 = new Account("123456", 1000);
        a1.printAccount();
        Account a2 = new Account("366788", 2000);
        a2.printAccount();
        Account a3 = new Account("345998", 3000);
        a3.printAccount();

        // 计算本息余额
        System.out.println(a1.getBalanceAfterYear(3));

    }
}

class Account {
    /*
        账户ID
        账户密码
        账户余额
        很显然是每个账户都有的属性，它们应该是成员变量
     */
    int id;
    // 密码比较独特,具有初始值
    String pwd = "000000";
    // 余额
    double balance;

    /*
        储蓄年利率显然不是某个账户的属性,它应该用static修饰
        这里将它设置成0.3%
      */
    static double annualSavingsRate = 0.003;

    /*
        账户ID的初始值是固定的
        然后每创建一个对象就+1
        于是需要一个不受创建对象影响的变量存放值，即静态成员变量。
     */
    static int initAccountId = 10001;

    /*
        无参构造器表示创建账户
        仅给出自动生成的ID
        密码默认6个0
        余额为0
     */
    public Account() {
        // 利用自增++的特性
        id = initAccountId++;
    }

    /*
        有参构造器表示创建账户
        给出自动生成的ID
        密码也自己给出
        余额也自己给出
     */
    public Account(String pwd, double balance) {
        id = initAccountId++;
        this.pwd = pwd;
        this.balance = balance;
    }

    // 打印账户信息
    public void printAccount() {
        System.out.println("账户名为" + id + "的账户,密码是" + pwd + ",余额是:" + balance);
    }

    // 计算本息合计后的余额
    public double getBalanceAfterYear(int year) {
        // 计算利息
        double interest = balance * annualSavingsRate * year;
        // 返回余额
        return interest + balance;
    }
}
```





## static练习二

设计一个员工类(Staff)，要求该类：
属性: 姓名,性别,工号,工资
构造器:
姓名的单参构造器、姓名和性别的双参构造器、姓名、性别和工资的三参构造器
其中员工的工号要求(每一位员工都必须有工号):
第一个员工对象的工号是10001
第二个员工对象的工号是10002
第三个员工对象的工号是10003
....
现在每位员工都要缴纳一个固定额的公积金（比如2000），要求在员工类中设计一个方法求员工的到手工资。（除了扣除这个固定额度的公积金，不考虑诸如扣税等其余问题）
最后再定义一个方法用于打印员工对象的各种属性取值，其中在打印工资时，要打印实际到手工资。
将该类定义完毕后，尝试创建对象，测试一下代码。

```java
/**
 * 设计一个员工类(Staff)，要求该类：
 *      属性: 姓名,性别,工号,工资
 *      构造器:
 *      姓名的单参构造器、姓名和性别的双参构造器、姓名、性别和工资的三参构造器
 * 其中员工的工号要求(每一位员工都必须有工号):
 *      第一个员工对象的工号是10001
 *      第二个员工对象的工号是10002
 *      第三个员工对象的工号是10003
 *      ....
 * 现在每位员工都要缴纳一个固定额的公积金（比如2000），要求在员工类中设计一个方法求员工的到手工资。（除了扣除这个固定额度的公积金，不考虑诸如扣税等其余问题）
 *
 * 最后再定义一个方法用于打印员工对象的各种属性取值，其中在打印工资时，要打印实际到手工资。
 *
 * 将该类定义完毕后，尝试创建对象，测试一下代码。
 *
 * @since 10:35
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class BlockDemo {
    public static void main(String[] args) {
        Staff s1 = new Staff("张三");
        s1.printStaff();

        Staff s2 = new Staff("李四", "女");
        s2.printStaff();

        Staff s3 = new Staff("王二", "男", 10000);
        s3.printStaff();
    }
}

class Staff {
    String name;
    String gender;
    int id;
    double salary;

    static double accumulationFundQuota = 2000;
    static int initId = 10001;

    // 由于id是每个构造器都需要赋值的，所以放在构造代码块中完成
    {
        id = initId++;
    }

    // 构造器
    public Staff(String name) {
        this.name = name;
    }

    public Staff(String name, String gender) {
        this(name);
        this.gender = gender;
    }

    public Staff(String name, String gender, double salary) {
        this(name, gender);
        this.salary = salary;
    }

    public double calcSalary() {
        return salary - accumulationFundQuota;
    }

    public void printStaff() {
        System.out.println("Staff{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                ", salary=" + calcSalary() +
                '}');
    }
}
```



## 自己编写数组工具类

> 工具类：指的是类中方法全部是静态方法的类，工具类在使用时无需创建对象（静态方法无需对象调用）
>
> 以下方法的实现，都是我们上课写过的代码，如果觉得自己很熟练了，直接抄代码即可
>
> 如果觉得不熟悉或者想再练习一遍，再写一遍也可以~

```
写一个数组的工具类ArrayTool, 要求提供如下方法：
	遍历，求最大值，最小值，逆置数组元素
	查询（在数组中查找指定元素，若不存在，待查找元素返回-1，若存在返回元素在数组中首次出现的位置)
```



```java
public class ArrayUtils {

    // 既然工具类无需创建对象,那就不要创建对象了,私有化构造器
    private ArrayUtils() {
    }

    /**
     * 该方法会在控制台循环打印int数组的元素，可以接受null和空数组输入。
     * @since 9:44
     * @param arr 需要被遍历输出的int类型数组
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    public static void traverse(int[] arr) {
        // 应该单独判断null,单独处理
        if (arr == null) {
            // null数组
            System.out.println("您输入的数组是null数组,请重新输入!");
            return;
        }
        // 程序运行到这里,数组肯定不是null,避免了空指针异常
        if (arr.length == 0) {
            // 长度为0,直接给出提示结束方法即可
            System.out.println("[]");
            System.out.println("您输入的数组长度为0!请重新输入!");
            // 用return结束方法,可以少写一个else
            return;
        }
        // 代码执行到这里,数组长度一定不为0
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("\b\b]");
    }


    /**
     * 获取int数组中的最大值
     *      利用包装类型，使得该方法可以接受长度为0或者null数组的输入
     * @since 9:50
     * @param arr 被求最大值的int数组
     * @return java.lang.Integer
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    public static int getMaxValue(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("错误参数，数组是null或者长度为0！");
            return null;
        }
        int max = arr[0];
        // 遍历数组,逐一比较
        for (int element : arr) {
            // 如果元素更大,就成为新的最大值
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    /**
     * 获取int数组中的最小值
     *      利用包装类型，使得该方法可以接受长度为0或者null数组的输入
     * @since 9:50
     * @param arr 被求最小值的int数组
     * @return java.lang.Integer
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    public static int getMinValue(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("错误参数，数组是null或者长度为0！");
            return null;
        }
        int min = arr[0];
        // 遍历数组,逐一比较
        for (int element : arr) {
            // 如果元素更小,就成为新的最小值
            if (element < min) {
                min = element;
            }
        }
        return min;
    }

    /**
     * 在原有数组的基础上，将它的元素逆置
     * @since 10:01
     * @param arr 被逆置的数组
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    public static void reserve(int[] arr) {
        /*
            这个遍历交换的过程,进行数组的一半就可以了
            如果遍历完整个数组,那就交换了两次,又换回来了
         */
        for (int i = 0; i < arr.length / 2; i++) {
            // 核心arr[i] <---> arr[arr.length-i-1]
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }


    /**
     * 在目标数组中查找目标元素,如果找到了,就立刻返回它的下标
     *      即第一次查找到该元素的下标
     *      当然也完全可能找不到,返回-1表示目标元素不存在
     * @since 11:46
     * @param arr 被查找元素的数组
     * @param target 目标元素
     * @return int 找到目标元素的下标
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    public static int getFirstTargetElementIndex(String[] arr, String target) {
        // 预先定义一个返回结果的下标
        int resultIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            // 避免空指针异常,最简单的方法就是if判断
            if (arr[i] == null) {
                // 直接跳过循环,避免空指针异常
                continue;
            }
            if (arr[i].equals(target)) {
                // 找到目标元素,i就是目标下标
                resultIndex = i;
                return resultIndex;
            }
        }
        
        return resultIndex;
    }

}

```







## 导包相关练习

> 导包是很基本的操作，某些细节也需要注意，请完成以下练习：

```Java
// 在com.cskaoyan.a包下，定义一个名为MyClazz的类如下
     public class  MyClazz {
        public void hello() {
        System.out.println("a包");
       }
     }
     
// 同时，在com.cskaoyan.b包下，一个类名也为MyClazz
     public class  MyClazz {
       public void hello() {
       System.out.println("b包");
       }
     }

// 同时在com.cskaoyan.b包下定义一个Test类如下：
     public class Test {
       public static void main(String[] args) {
       MyClazz myClazz = new MyClazz();
       myClazz.hello();
       }
     }
```

> 首先根据上述注释，将三个类定义出来
>
> 毫无疑问，直接执行Test中的main方法会输出的是b包，思考以下问题<font color=red>**（独立的三个问题）**</font>：
>
> 1. 不改变Test类中main方法的基础上，让main方法运行之后输出“a包”，应该怎么做？
> 2. 不做任何导包操作的基础上，修改main方法，让main方法运行之后同时输出“a包”和“b包”，应该怎么做？
> 3. 在Test类中添加导包语句import com.cskaoyan.a.*，不修改任何代码，执行main方法，输出的是什么？为什么？

答：

1，只需要使用import语句导入a包中的MyClazz类即可

2，同包下的MyClazz直接使用，不同包下的用全限定类名

3，输出b包，因为智能导包如果同包下有同名类就不会再去导包了



## 工具类禁止创建对象

> 普遍来说，工具类不应该创建对象，应该私有化构造方法

```
需求一：在昨天自己的作业，数组工具类的基础上，私有化它的构造方法
需求二：
定义一个Scanner工具类ScannerUtils，提供以下方法：
	1，键盘录入字符串
	2，键盘录入int整数
	3，键盘录入一个Person对象（Person类中有age和name属性）
	不要忘记私有化构造器
```

注：录入对象，无非就是先录入成员变量取值，然后构造器创建对象。

```java
package com.cskaoyan.javase.homework.primary._3oop1.scannerutils;

/**
 * @description: 键盘录入工具类
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

import java.util.Scanner;

/**
 * Scanner在做键盘录入时,建议不要混用next系列和nextLine方法
 * 否者会出现问题
 *
 * 工具类当中的Scanner实际上没有必要创建多个对象,全局使用一个对象就行了
 * 所以给出一个静态成员变量sc
 *
 */
public class ScannerTools {
    private static final Scanner sc = new Scanner(System.in);

    // 工具类无需在外部创建对象，应该私有化它
    private ScannerTools() {
    }

    public static String getStringByScanner() {
        System.out.println("请输入字符串：");
        return sc.nextLine();
    }

    public static int getIntByScanner() {
        System.out.println("请输入一个int整数：");
        return Integer.parseInt(sc.nextLine());
    }

    // 工具类接收对象，先接收各个成员变量的取值，最后使用构造方法创建对象即可
    public static Person getPersonInstanceByScanner() {
        System.out.println("现在开始键盘录入一个Person对象！");
        System.out.println("请输入Person对象的name：");
        String name = sc.nextLine();
        System.out.println("请输入Person对象的age：");
        int age = Integer.parseInt(sc.nextLine());
        Person p = new Person(name, age);
        System.out.println("Person对象创建完毕！");
        return p;
    }

    // 录入数组，录入对象和上述方法是一样的，所以直接调用即可
    public static Person[] getPersonArrByScanner(int length) {
        Person[] targetArr = new Person[length];
        System.out.println("现在开始为Person数组输入Person对象！");
        System.out.println("你总共需要输入" + length + "个Person对象！");
        for (int i = 0; i < targetArr.length; i++) {
            System.out.println("现在是输入第" + (i + 1) + "个Person对象！");
            targetArr[i] = getPersonInstanceByScanner();
        }
        System.out.println("Person数组输入完毕！");
        return targetArr;
    }

    public static void closeScanner() {
        sc.close();
    }
}

```







## 禁止创建对象

> 综合访问权限修饰符，static等知识点，做一个综合的练习。

```
定义一个Student类，并要求在其他类中，最多只能创建10个Student类的对象。
	分析：
		1，如果允许外部直接创建对象，显然无法控制创建对象的个数
		2，需要计数器指示外部创建对象的个数
```



```java
package com.cskaoyan.javase.homework.primary._3oop1.objectdemo;

/**
 * @description: 禁止创建学生对象
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/


/**
 * 定义一个Student类，并要求在其他类中，最多只能创建10个Student类的对象。
 *
 * 这个题目要求能够在外部控制创建对象的次数 ->
 *    要想在外部控制创建对象的次数，如果构造器是可以任意访问的，那肯定控制不了 -> 私有化构造方法
 *    私有化构造方法，外部就真的无法创建对象了，但是为了创建出10个对象，就必须提供一种方式来创建对象
 *      -> 需要提供一个方法用来创建Student对象
 *      这个方法在哪里？
 *      为了能够兼顾私有的构造方法，所以这个方法必须在Student类当中
 *      这个方法怎么写？声明怎么写？
 *      public static Student getStudentInstance(参数想写就写){
 *
 *      }
 *      于是又想到需要控制能够创建10次对象，毫无疑问需要一个计数器，每创建一次对象+1，直到创建了10次对象
 *      然后在方法中用if判断 让它不能创建对象
 *      这个计数器的变量应该写在哪里？ 这个变量必须是全体对象共享的，必须用static修饰
 *
 */
public class Student {
    // 计数，这个计数器必须是类共享的，而不是每创建一个对象就新生成一个
    private static int count = 1;
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    // 私有化构造方法
    private Student() {
    }

    /*
        因为构造方法已经私有化了，根据现有的知识，外部是没办法创建对象了
        需要在内部直接给个方法创建对象
     */
    public static Student getInstance() {
        Student student = null;
        // 如果次数小于等于10次，允许继续创建对象
        if (count <= 10) {
            student = new Student();
            System.out.println("创建stu对象" + Student.count + "次");
            count++;
            return student;
        }
        // 否则创建失败，不允许创建对象
        System.out.println("创建失败");
        // 程序走到这里必然创建失败，返回null
        return student;
    }
}
```





# OOP2——封装

## Getter/Setter方法

> 当属性私有化，又有外界访问需求时，提供Getter/Setter方法

```
创建两个类，分别用来表示长方形和正方形。
同时定义所需的成员变量（边长），代表长方形或者正方形的边长（私有化成员变量，并提供相应的Getter/Setter方法，获取以及改变长方形和正方形的边长。）
然后在两个类中分别定义两个成员方法，用于求对应图形的面积和周长。
最后，写代码测试一下创建对象，方法调用等。
```

注：Getter/Setter方法可以选择手写一个，其余的用快捷键自动生成。





# OOP2——继承

## 继承基础语法练习

> 明确记住，继承中的两个类应该有is-a关系

```
提供以下两个动物需要描述，请用你的知识来编写代码
猫：姓名，年龄，颜色，可以叫，可以抓老鼠
狗：姓名，年龄，性别，可以叫，可以看门
分析这个案例，设计出合适的继承体系。

最后思考：人类研究出来了机器人，它们也有姓名，年龄，颜色等属性，可以套用本题中的继承体系吗？
```

```java

/**
 * @description: 继承练习题
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 这个案例中，为了复用成员，需要新建一个父类Animal
 *
 * 手写猫狗案例，并进行测试，要求使用继承
 *  猫：姓名，年龄，颜色，可以叫，可以抓老鼠
 * 狗：姓名，年龄，性别，可以叫，可以看门
 *
 * 机器人类显然和动物没有is-a关系,不应该为了复用成员,强行使用继承！
 *
 */
public class ExtendsDemo {
    public static void main(String[] args) {
        Cat c = new Cat();
        Dog d = new Dog();

        /*
            Dog对象和Cat对象都可以访问父类Animal当中的成员
            也可以访问自身当中定义的独有成员
            这就是继承。
         */
        c.catchMouse();
        System.out.println(c.getName());

        d.watchDoor();
        System.out.println(d.getName());
    }
}

class Animal {
    private String name;
    private int age;

    public void shout() {
        System.out.println("我会叫！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Cat extends Animal {
    private String color;

    public void catchMouse() {
        System.out.println("我会抓老鼠！");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class Dog extends Animal {
    private String gender;

    public void watchDoor() {
        System.out.println("我会看门！");
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}



```



## 练习继承中的构造器使用

> 使用**alt  +  insert**快捷键可以快速生成各种类中结构。子类继承父类后，在子类中按**alt + insert**快捷键快速创建构造方法时，第一步会让你选择父类构造器（也就是super(参数)）
>
> 随后才是选择子类自身的成员变量，生成子类构造器。
>
> 当然如果选择使用父类无参构造器，这时`super()`是隐藏的，即子类对象隐式初始化。
>
> 当选择使用子类有参构造器时，这时`super(参数)`必须写在子类构造器第一行，这是子类对象的显式初始化。

```
给出三个层级的继承关系
顶层父类Grandfather，Father继承Grandfather，Son继承Father
成员变量：
Grandfather：gA,a
Father：fA,a
Son：sA,a

成员方法：
Grandfather：testGrand,test
Father：testFather,test
Son：testSon,test

使用快捷键在Son中生成不同的构造方法，调用不同的父类构造器（需要先生成父类相应的构造器）
随后使用多种方式创建Son对象（思考有几种），测试对象名访问成员的机制，理解属性隐藏和方法覆盖
```



```java

/**
 * @description: 构造器练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 先定义好相应的类、成员变量、成员方法等
 * 然后在子类中，使用alt + insert快捷键自动生成构造方法
 * 自己进行练习即可~
 * 最后创建对象，使用对象名点访问成员，查看结果即可
 */
public class SubClazzConstructorDemo {
    public static void main(String[] args) {
        Son s = new Son();
        System.out.println(s.a); //3
        Father f = new Son();
        System.out.println(f.a); //2
        Grandfather gf = new Son();
        System.out.println(gf.a); //1

        s.test(); //testSon
        f.test();  //testSon
        gf.test(); //testSon

        //f.testSon();
        //gf.testFather();
    }
}

class Grandfather {
    int gA = 1;
    int a = 1;
    public void testGrand() {
        System.out.println("Grand独有");
    }
    public void test() {
        System.out.println("testGrand");
    }
    public Grandfather(int gA, int a) {
        this.gA = gA;
        this.a = a;
    }
    public Grandfather() {
    }
}

class Father extends Grandfather {
    int fA = 2;
    int a = 2;
    public void testFather() {
        System.out.println("Father独有");
    }
    public void test() {
        System.out.println("testFather");
    }
    public Father(int fA, int a) {
        this.fA = fA;
        this.a = a;
    }
    public Father() {
    }
    public Father(int gA, int a, int fA, int a1) {
        super(gA, a);
        this.fA = fA;
        this.a = a1;
    }
}

class Son extends Father {

    int sA = 3;
    int a = 3;

    public void testSon() {
        System.out.println("Son独有");
    }

    public void test() {
        System.out.println("testSon");
    }

    public Son() {
    }

    public Son(int gA, int a, int fA, int a1, int sA, int a2) {
        super(gA, a, fA, a1);
        this.sA = sA;
        this.a = a2;
    }

    public Son(int sA, int a) {
        this.sA = sA;
        this.a = a;
    }

    public Son(int gA, int a, int fA, int a1) {
        super(gA, a, fA, a1);
    }
}

```





## final语法练习

> final修饰成员/静态成员变量，表示一个常量，必须明确地赋值。

```
自定义一个类，类中定义三个成员变量a，b，c，用final修饰这三个成员变量
再定义两个静态成员变量staticA和staticB，也用final修饰这两个静态成员变量
然后：
	1，请用三种不同的方式，分别为成员变量a，b，c赋值
	2，请用两种不同的方式，分别为静态成员变量staticA和staticB赋值
```



```java

/**
 * 自定义一个类，类中定义三个成员变量a，b，c，用final修饰这三个成员变量
 * 再定义两个静态成员变量staticA和staticB，也用final修饰这两个静态成员变量
 * 然后：
 * 	1，请用三种不同的方式，分别为a，b，c赋值
 * 	2，请用两种不同的方式，分别为staticA和staticB赋值
 *
 * 	复习一下成员变量的赋值：
 * 	    （掐头去尾）
 * 	    头：默认初始化，有默认值
 * 	    尾：构造器
 * 	    中间：显式赋值和构造代码块，顺序是代码的书写顺序
 *
 * 	    最后在加上父子类，先父后子
 *
 */
public class FinalDemo {
}

class A {
    final int a = 10;
    final int b;

    {
        b = 20;
    }

    final int c;

    public A(int c) {
        this.c = c;
    }

    static final int staticA = 100;
    static final int staticB;

    static {
        staticB = 200;
    }
}

```



## 多态语法基础练习

> 牢记多态发生的条件

```
请根据题目，作出合理设计，定义如下类：
父类Person
	属性：String name，int age
	行为：eat();
	
子类SouthPerson
	属性：String name，int age，double salary
	行为：eat()，swim()

子类NorthPerson
	属性：String name，int age，double height
	行为：eat()，drink()

写代码实现，eat()方法的多态效果
	1，人都要吃饭
	2，南方人喜欢吃米饭
	3，北方人喜欢吃面食

最后，在测试类中，编写测试代码，要求进行如下测试：
	1，编写测试方法，	
		要求该方法允许传入SouthPerson对象和NorthPerson对象，并在方法体中调用它们的eat()方法
		方法调用的结果一致吗？
	2，用父类引用指向子类对象的方式创建SouthPerson对象，能否直接访问salary属性和swim()方法？
		如果不能，应该怎么写代码让它能够正常调用？
	3，用父类引用指向子类对象的方式创建NorthPerson对象，能否（直接或写代码）访问salary属性和swim()方法？
		如果不能，将该对象引用强转为SouthPerson引用，能否成功？为什么？
```



```java 
/**
 *  回答以下问题：
 * 	1，编写测试方法，
 * 		要求该方法允许传入SouthPerson对象和NorthPerson对象，并在方法体中调用它们的eat()方法，方法调用的结果一致吗？
 * 	        显然方法调用的结果是不一致的，方法调用结果要根据对象的具体类型而定。
 * 	        而SouthPerson和NorthPerson这两个类，都重写了继承的eat()方法。
 *
 * 	2，用父类引用指向子类对象的方式创建SouthPerson对象，能否直接访问salary属性和swim()方法？
 * 		如果不能，应该怎么写代码让它能够正常调用？
 * 	        显然是不能直接访问的，引用限制了访问范围。
 * 	        如果想要正常访问，需要进行强制类型转换。
 *
 * 	3，用父类引用指向子类对象的方式创建NorthPerson对象，能否（直接或写代码）访问salary属性和swim()方法？
 * 		如果不能，将该对象引用强转为SouthPerson引用，能否成功？为什么？
 * 	    不能，不在同一条继承链中的两个类没有任何关系。也不可能发生强转。
 *
 */
public class PolymorphicDemo {
    public static void main(String[] args) {
        NorthPerson np = new NorthPerson();
        SouthPerson sp = new SouthPerson();
        test(np);
        test(sp);
        Person p = new NorthPerson();
    }
    public static void test(Person p){
        p.eat();
    }
}

abstract class Person {
    String name;
    int age;
    public abstract void eat();
}

class SouthPerson extends Person {
    double salary;
    @Override
    public void eat() {
        System.out.println("南方人吃米饭");
    }
    public void swim(){
        System.out.println("南方人会游泳");
    }
}

class NorthPerson extends Person {
    double height;
    @Override
    public void eat() {
        System.out.println("北方人吃馒头");
    }
    public void drink(){
        System.out.println("北方人特别能喝酒");
    }
}

```



# OOP3——抽象类和接口

> 主要针对OOP3阶段：
>
> 包含：
>
> 1. 抽象类
> 2. 接口

## 抽象类基础语法练习

> 完成抽象类的基础语法练习，按照说明操作即可。

```
定义抽象类A，抽象类B继承A，普通类C继承B。
A类中，定义成员变量a赋值为10，抽象showA方法
B类中，定义成员变量b赋值为20，抽象showB方法
C类中，定义成员变量c赋值为30，重写showA方法打印a，重写showB方法打印b，定义showC方法，打印c

然后在测试类中，创建C类的对象，调用showA方法，showB方法，showC方法。
然后查看方法调用结果，思考为什么会出现这种现象。
```



```java 
/**
 * 定义抽象类A，抽象类B继承A，普通类C继承B
 * A类中，定义成员变量a赋值为10，抽象showA方法。
 * B类中，定义成员变量b赋值为20，抽象showB方法。
 * C类中，定义成员变量c赋值为30，重写showA方法打印a，重写showB方法打印b，定义showC方法，打印c。
 * 测试类中，创建C对象，调用showA方法，showB方法，showC方法。
 *
 */
public class AbstractClazzDemo {
    public static void main(String[] args) {
        C c = new C();
        c.showA();
        c.showB();
        c.showC();
    }
}

abstract class A {
    int a = 10;

    public abstract void showA();
}

abstract class B extends A {
    int b = 20;

    public abstract void showB();
}

class C extends B {
    int c = 30;

    @Override
    public void showA() {
        System.out.println(a);
    }

    @Override
    public void showB() {
        System.out.println(b);
    }

    public void showC() {
        System.out.println(c);
    }
}

```







## 接口与抽象类基础语法练习

> 从实际角度出发，接口和抽象类的差异是十分明显的。可以参考完成以下案例：

```
学生和老师都有共同的属性: name、gender、age
共同的行为：eat() sleep() 
	注：虽然行为一致，但实现会不同。
现在为了提升自身素质，大家都需要额外进行技能的学习：学生需要增强实践动手能力，老师需要增强语言能力。
请定义抽象类和接口，描述以上体系。

然后用以下方式进行测试：
	1，用不同的父类指向不同的子类对象，理解方法调用时“编译时看左边”
	2，用这些引用调用方法，理解方法调用时“运行时看右边”
```



```java 
/**
 * 学生和老师都有共同的属性: name、gender、age
 * 共同的行为：eat() sleep()
 * 老师和学生都需要（额外地）学习知识（这里定义一个接口）
 * 请定义抽象类和接口，描述以上体系
 *
 * 然后进行测试：
 * 测试以下方式:
 * 	1，用不同的父类指向不同的子类对象，理解“编译看左边”
 * 	2，用这些引用调用方法，理解“运行时看右边”
 *
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        IStudy is;
        is = new Student();
        is = new Teacher();

        Student s = new Student();
        s.test();
    }
}

abstract class AbstractPerson{
    String name;
    String gender;
    int age;
    public abstract void eat();
    public abstract void sleep();
}

class Student extends AbstractPerson implements IStudy {
    @Override
    public void eat() {
        System.out.println("学生吃了学习,学习完了就吃");
    }

    @Override
    public void sleep() {
        System.out.println("你怎么睡得着的?");
    }

    @Override
    public void learningEnglish() {
        System.out.println("学习英语考研");
    }

    @Override
    public void test() {
        System.out.println("你好中国!");
    }
}

class Teacher extends AbstractPerson implements IStudy {
    @Override
    public void eat() {
        System.out.println("上完课就去吃饭!");
    }

    @Override
    public void sleep() {
        System.out.println("每天睡几个小时!");
    }

    @Override
    public void learningEnglish() {
        System.out.println("学习英语授课");
    }
}

interface IStudy{
    void learningEnglish();
    default void test(){
        System.out.println("hello");
    }
}

```





# Object类

## getClass()方法练习

> 定义两个类，然后分别创建对象，调用getClass方法
>
> 用“==”号比较它们的运行时Class对象是否相等，并说明原因
>
> 理解运行时类对象、类加载、类的对象的区别





## equals方法练习

```
定义一个Animal类
成员变量：
	int age,String name,double price
手写它的equals方法，比较getClass和instanceof的区别
```



```java 
package homework.essay._8object;

/**
 * @description: equals方法练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class EqualsDemo {
}

class Animal{
    private int age;
    private String name;
    private double price;

    //重写equals方法的Select all non-null fields选项，选中后默认该引用类型成员变量不会是null，比如下面的name属性，就去掉了判null的操作
    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (age != animal.age) return false;
        if (Double.compare(animal.price, price) != 0) return false;
        return name.equals(animal.name);
    }*/

    //如果不勾选该选项，默认该引用类型成员变量可能是null，会判null
    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (age != animal.age) return false;
        if (Double.compare(animal.price, price) != 0) return false;
        return name != null ? name.equals(animal.name) : animal.name == null;
        //Objects.equals()
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (age != animal.age) return false;
        if (Double.compare(animal.price, price) != 0) return false;
        return name != null ? name.equals(animal.name) : animal.name == null;
        //Objects.equals(, )
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

```





# String

## String API

### 统计这段绕口令有多少个以p开头的单词

"peter piper picked a peck of pickled peppers"

tips:

- split
- startsWith



```java 
/**
 * @description:
 * @author: 景天
 * @date: 2022/2/10 17:34
 **/

/*
"peter piper picked a peck of pickled peppers"
统计这段绕口令有多少个以p开头的单词
 */
public class Work1 {
    public static void main(String[] args) {
        String s = "peter piper picked a peck of pickled peppers";
        // 以" "分隔成字符串数组
        String[] strs = s.split(" ");
        int count = 0;
        // 遍历字符串数组,以p开头 计数器+1
        for (String str :
                strs) {
            if (str.startsWith("p")) {
                count += 1;
            }
        }
        System.out.println("p开头的单词有:" + count);
    }
}

```







### 大小写

把字符串"lengendary"中字符 改成间隔大写小写模式，即 "LeNgEnDaRy"



```java 
/**
 * @description:
 * @author: 景天
 * @date: 2022/2/11 9:47
 **/

/*
把字符串"lengendary"中字符 改成间隔大写小写模式，即 "LeNgEnDaRy"
 */
public class Work2 {
    public static void main(String[] args) {
        String s = "lengendary";
        String newStr = "";
        // 遍历 分奇数 偶数去处理 从0开始算, 偶数位置的字符变大写
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                newStr+=Character.toUpperCase(s.charAt(i));
            }
            else {
                newStr += s.charAt(i);
            }
        }
        System.out.println(newStr);
    }
}

```



### 大串中小串出现的次数

在字串”woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun”
中java出现了5次, 统计次数

tips：

- indexOf
- 仅考虑本题举出的字符串，无需复杂考虑



```java 

/*
统计大串中小串出现的次数

举例：
在字符串”woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun”
中java出现了5次
提示：可以考虑使用indexOf方法，仅考虑本题举出的字符串，无需复杂考虑
 */
public class Work3 {
    public static void main(String[] args) {
        String s ="woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
        int count = getCountSubString(s, "java");
        System.out.println("java出现了" + count + "次");
    }

    private static int getCountSubString(String bigStr, String smallStr) {
        int fromIndex = 0; //查询大串的起始下标
        int count = 0; //小串出现的次数
        //具体查询的方式有很多种
        //这里推荐int indexOf(String str,int fromIndex) 这个方法
        //该方法可以从大字符串中查询小字符串 并返回下标 如果没找到返回-1
        //然后需要注意的是该方法查找的结果是子串的第一个字符的下标
        //所以下一次查找要给fromIndex+1
        while ((fromIndex = bigStr.indexOf(smallStr, fromIndex)) != -1) {

            count++;
            fromIndex++;
        }
        return count;
    }
}

```





## 综合练习

### 穷举匹配密码

1. 生成一个长度是3的随机数字字符串，把这个字符串作为当做密码
2. 使用穷举法生成长度是3个字符串，匹配上述生成的密码,将列举到的可能的密码打印,直到匹配成功结束.

tips:

- Random
- equals
- String 数组



```java 
import java.util.Random;

/**
 * @description:
 * @author: 景天
 * @date: 2022/2/9 10:13
 **/

/*
穷举匹配密码

1. 生成一个长度是3的随机数字字符串，把这个字符串作为当做密码

2. 使用穷举法生成长度是3个字符串，匹配上述生成的密码,将列举到的可能的密码打印,直到匹配成功结束.


 */
public class Work7 {
    public static void main(String[] args) {
        String password = getRandomPassword(3);
        System.out.printf("密码是: %s%n", password);
        // 穷举匹配密码
        matchPassword(password);

    }

    private static void matchPassword(String password) {
        // 所有的可能性000-999
        for (int i = 0; i < 1000; i++) {
            String possiblePassword = String.format("%03d", i);
            System.out.println(possiblePassword);
            if (password.equals(possiblePassword)) {
                System.out.println("匹配到了密码,密码是:" + possiblePassword);
                break;
            }
        }

    }

    private static String getRandomPassword(int len) {
        String pool = "";
        for (int i = '0'; i <= '9' ; i++) {
            pool += ((char) i);
        }
        System.out.println(pool);
        // 生成长度为3的随机密码
        char[] chars = new char[len];
        // 填充字符数组
        Random random = new Random();
        for (int i = 0; i < chars.length; i++) {
            int index = random.nextInt(pool.length());
            chars[i] = pool.charAt(index);
        }
        String password = new String(chars);
        return password;
    }
}


```





### 排序(<font color=red>选做</font>)

```
创建一个长度是8的字符串数组
使用8个长度是5的随机字符串初始化这个长度为8的字符串数组
对这个数组进行排序，按照每个字符串的首字母排序(无视大小写)

注1： 不能使用Arrays.sort() 要自己写
注2： 无视大小写，即 Axxxx 和 axxxxx 没有先后顺序
举例:
排序前
[UxoEl, If3js, 9SSwC, czHuA, lZLBF, IhynX, VgjrY, dJAIW]
排序后
[9SSwC, czHuA, dJAIW, If3js, IhynX, lZLBF, UxoEl, VgjrY]
```

tips:

- 冒泡排序
- Random
- 数组
- String API 



```java 
import java.util.Arrays;
import java.util.Random;

/*
创建一个长度是8的字符串数组
使用8个长度是5的随机字符串初始化这个长度为8的字符串数组
对这个数组进行排序，按照每个字符串的首字母排序(无视大小写)

注1： 不能使用Arrays.sort() 要自己写
注2： 无视大小写，即 Axxxx 和 axxxxx 没有先后顺序
举例:
排序前
[UxoEl, If3js, 9SSwC, czHuA, lZLBF, IhynX, VgjrY, dJAIW]
排序后
[9SSwC, czHuA, dJAIW, If3js, IhynX, lZLBF, UxoEl, VgjrY]
 */
public class Work8 {
    public static void main(String[] args) {
        //创建一个长度是8的字符串数组
        String[] strs = new String[8];

        // 使用8个长度是5的随机字符串初始化这个数组
        for (int i = 0; i < 8; i++) {
            strs[i] = getRandomStr(5);
        }
        System.out.println("排序前");
        System.out.println(Arrays.toString(strs));


        // 对这个数组进行排序，按照每个字符串的首字母排序(无视大小写)
        // 使用冒泡排序
        for (int i = 0; i < strs.length-1; i++) {
            // 里层循环控制比较次数
            for (int j = 0; j < strs.length - 1 - i; j++) {
                // 第一个字符串的第一个字符
                char firstCharacter = strs[j].charAt(0);
                // 第二个字符串的第一个字符
                char secondCharacter = strs[j+1].charAt(0);
                // 转换成小写
                char first = Character.toLowerCase(firstCharacter);
                char second = Character.toLowerCase(secondCharacter);
                if (first > second) {
                    // 做交换
                    String temp = strs[j];
                    strs[j] = strs[j + 1];
                    strs[j + 1] = temp;
                }
            }
        }
        // 排序后
        System.out.println("排序后");
        System.out.println(Arrays.toString(strs));

    }

    /*
     * 随机生成长度为5的字符串
     * 创建日期：2022/2/8 16:22
     * @param length
     * @return void
     * @author 景天
     */
    private static String getRandomStr(int length) {
        String strPool = "";
        for (int i = '0'; i <= '9'; i++) {
            strPool += ((char) i);
        }
        for (int i = 'a'; i <= 'z'; i++) {
            strPool += ((char) i);
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            strPool += ((char) i);
        }
        System.out.println(strPool);
        // 创建长度为length  5 的字符数组
        char[] chars = new char[length];
        Random random = new Random();
        for (int i = 0; i < chars.length; i++) {
            // random中 nextInt(int bound)方法 随机数范围为[0,bound)
            int index = random.nextInt(strPool.length());
            // 从字符串中获取1个随机的字符 并填充到字符数组中
            chars[i] = strPool.charAt(index);
        }

        System.out.println(Arrays.toString(chars));

        // 将填充过数据的字符数组转化为字符串
        String randomStr = new String(chars);

        // 返回生成的随机字符串
        System.out.println(randomStr);
        return randomStr;
    }
}
```





### 统计重复字符串(<font color=red>选做</font>)

```
创建一个长度是100的字符串数组
使用长度是2的随机字符填充该字符串数组
统计这个字符串数组里重复的字符串有多少种(忽略大小写)

例如
20个字符串一行 共5行
01 0S 1M 1q 01 2R 2S 3d 3k 3x 43 4A 4R 5T 7C 7U 7e 7k 80 88
8p AD AG AY BF BO Db E2 Eg El GF Gm HC HO IB If J0 JY Jv KW
L0 LT MA NL NL NU PY Qx Rr Ry SB So TH Tu UR VD WR Xe Xw Xx
Y3 YL Yd Yk a3 aL bW bq cI cv cv dg eL fL gA gL gh h4 hm j7
jp kN m1 mS o6 pQ qV rP rf s7 sA um vE 01 vb w6 wB xP yK yQ

El发生了重复 重复了2次
NL发生了重复 重复了2次
Yk发生了重复 重复了2次
cv发生了重复 重复了2次
```

tips:

- String 数组
- Random
- String API

```java
import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: 景天
 * @date: 2022/2/11 10:49
 **/

/*
创建一个长度是100的字符串数组
使用长度是2的随机字符填充该字符串数组
统计这个字符串数组里重复的字符串有多少种(忽略大小写)

例如
20个字符串一行 共5行
01 0S 1M 1q 01 2R 2S 3d 3k 3x 43 4A 4R 5T 7C 7U 7e 7k 80 88
8p AD AG AY BF BO Db E2 Eg El GF Gm HC HO IB If J0 JY Jv KW
L0 LT MA NL NL NU PY Qx Rr Ry SB So TH Tu UR VD WR Xe Xw Xx
Y3 YL Yd Yk a3 aL bW bq cI cv cv dg eL fL gA gL gh h4 hm j7
jp kN m1 mS o6 pQ qV rP rf s7 sA um vE 01 vb w6 wB xP yK yQ

El发生了重复 重复了2次
NL发生了重复 重复了2次
Yk发生了重复 重复了2次
cv发生了重复 重复了2次
 */
public class Work9 {
    public static void main(String[] args) {
        // 创建长度为100的字符串数组
        String[] strs = new String[100];
        // 随机生成100个 长度为2的字符串
        for (int i = 0; i < strs.length; i++) {
            strs[i] = getRandomStr(2);
        }
        // 为了方便看 先排序
        Arrays.sort(strs);
        String s = Arrays.toString(strs);
        System.out.println(s);
        System.out.println("--------------");
        for (int i = 0; i < strs.length; i++) {
            // 20个一行输出一下
            System.out.print(strs[i] + " ");
            if (i % 20 == 19) {
                System.out.println();
            }
        }
        System.out.println();

        // 依次比较 类似选择排序
        for (int i = 0; i < strs.length - 1; i++) {
            // 计数
            int count = 1;
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[i].equals("")) {
                    break;
                }
                if (strs[i].equalsIgnoreCase(strs[j])) {
                    // 有相同的+1
                    count++;
                    // 再把它剔除掉 去重
                    strs[j] = "";
                }
            }
            if (count > 1) {
                System.out.println(strs[i]+ "发生了重复" + " 重复了" + count + "次");
            }
        }
    }

    private static String getRandomStr(int length) {
        String pool = "";
        for (int i = '0'; i < '9'; i++) {
            pool += ((char) i);
        }
        for (int i = 'a'; i < 'z'; i++) {
            pool += ((char) i);
        }
        for (int i = 'A'; i < 'Z'; i++) {
            pool += ((char) i);
        }
        char[] chars = new char[2];
        Random random = new Random();
        for (int i = 0; i < chars.length; i++) {
            int index = random.nextInt(pool.length());
            chars[i] = pool.charAt(index);
        }
        return new String(chars);

    }
}

```





## 可变长字符串

```
判断一个字符串是否是对称字符串,例如"abc"不是对称字符串，"aba"、"abba"、"aaa"、"mnanm"是对称字符串

判断一个字符串是否是对称的字符串，我只需要把

第一个和最后一个比较

第二个和倒数第二个比较

...

```

tips:

- 可以借助StringBuffer
- reverse



```java
import java.util.Scanner;

/**
 * @description:
 * @author: 景天
 * @date: 2022/2/11 9:59
 **/

/*
判断一个字符串是否是对称字符串,例如"abc"不是对称字符串，"aba"、"abba"、"aaa"、"mnanm"是对称字符串

判断一个字符串是否是对称的字符串，我只需要把

第一个和最后一个比较

第二个和倒数第二个比较

...

可以借助StringBuffer
 */
public class Work4 {
    public static void main(String[] args) {
        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s = sc.nextLine();

        // 一个一个的比较
        boolean b = isSame(s);
        System.out.println("b:" + b);

        //用StringBuffer的反转功能
        boolean b2 = isSame2(s);
        System.out.println("b2:"+b2);
    }

    public static boolean isSame2(String s) {
        return new StringBuffer(s).reverse().toString().equals(s);
    }



    public static boolean isSame(String s) {
        boolean flag = true;

        // 把字符串转成字符数组
        char[] chs = s.toCharArray();

        for (int start = 0, end = chs.length - 1; start <= end; start++, end--) {
            if (chs[start] != chs[end]) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}

```





# 异常

## 自定义异常与异常处理

写一个类，在该类的三个方法中抛出三种不同的异常。

然后在mian方法中调用这个类的不同方法，尝试用try catch捕获你写的异常。

```java
public class Work2 {
  public static void main(String[] args) {

    ExceptionGenerator exceptionGenerator = new ExceptionGenerator();

    //处理第一种自定义编译时异常

    try {

      exceptionGenerator.genFirstException();

    } catch (MyFirstException e) {

      e.printStackTrace();

    }

    //处理第二种自定义运行时异常

    try {

      exceptionGenerator.genSecondException();

    } catch (Exception e) {

      e.printStackTrace();

    }

    //处理第三种自定义编译时异常

    try {

      exceptionGenerator.genThirdException();

    } catch (MyThirdException e) {

      e.printStackTrace();

    }

  }

}

class ExceptionGenerator {

  //抛出第一种编译时异常

  public void genFirstException() throws MyFirstException {

    throw new MyFirstException("第一种编译时类型的异常");

  }

  //抛出第二种运行时异常

  public void genSecondException() {

    throw new MySecondException("第二种运行时类型的异常");

  }

  //抛出第二种编译时异常

  public void genThirdException() throws MyThirdException {

    throw new MyThirdException("第三种编译时类型的异常");

  }

}


/*

    第一种自定义编译时异常

 */

class MyFirstException extends Exception {

  public MyFirstException(String msg) {
    super(msg);
  }
}

/*

    第二种自定义运行时异常

 */

class MySecondException extends RuntimeException {

  public MySecondException(String msg) {
    super(msg);
  }
}

/*

    第三种自定义编译时异常

 */

class MyThirdException extends Exception {

  public MyThirdException(String msg) {
    super(msg);
  }

}
```



# File

## File API

需求:

递归删除目录与文件

```
给大家发一个目录,里面是多级目录与文件,使用递归的方式,将该目录里面的文件,目录全删除了.(目录为空才可以删)
注意: 不要放在C盘
```

tips:

- 递归
- delete
- isDirectory
- listFiles
- getAbsolutePath



```java
import java.io.File;


/*
   需求:递归删除目录与文件
   注意: 不要放在C盘
 */
public class Work1 {
    public static void main(String[] args) {
        File dir = new File("D:\\app");
        deleteFile(dir);
    }

    /*
     *
     * 创建日期：2021/11/29 16:32
     * @param dir
     * @return void
     * @author 景天
     */
    private static void deleteFile(File dir) {
        // 列出所有的目录 文件
        File[] files = dir.listFiles();
        // 遍历
        for (File file :
                files) {
            // 如果是目录 递归
            if (file.isDirectory()) {
                deleteFile(file);
            }else{
                // 是文件直接删除
                System.out.println(file.getAbsolutePath() +" = " + file.delete());
            }
        }
        // 删除目录 只有空的情况下才能删除目录
        System.out.println(dir.getAbsolutePath() + " = " + dir.delete());
    }


}
```



## 文件过滤

自己建立文件夹 ,放一些文件, 文件夹

```
仅针对这三个条件提供规则方法，具体实现自己去做
条件一：仅留下文件夹名包括a的文件夹
条件二：仅留下.txt结尾的文本文件
条件三：仅留下以a开头的文件
```

tips:

- listFiles
- FileFiter

```java
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 * 仅针对这三个条件提供规则方法，具体实现自己去做
 * 条件一：仅留下文件夹名包括a的文件夹
 * 条件二：仅留下.txt结尾的文本文件
 * 条件三：仅留下以a开头的文件
 *
 */
public class Work2_2 {
    public static void main(String[] args) {
        //具体自己实现，可以选择匿名内部类，lambda表达式都行
        File f = new File("D:\\app2");
        File[] files1 = f.listFiles(new MyFileFilter1());
        File[] files2 = f.listFiles(new MyFileFilter2());
        File[] files3 = f.listFiles(new MyFileFilter3());

        System.out.println(Arrays.toString(files1));
        System.out.println(Arrays.toString(files2));
        System.out.println(Arrays.toString(files3));
    }
}

class MyFileFilter1 implements FileFilter{

    @Override
    public boolean accept(File file) {
        return file.isDirectory() && file.getName().contains("a");
    }
}

class MyFileFilter2 implements FileFilter{

    @Override
    public boolean accept(File file) {
        return file.isFile() && file.getName().endsWith(".txt");
    }
}

class MyFileFilter3 implements FileFilter{

    @Override
    public boolean accept(File file) {
        return file.isFile() && file.getName().startsWith("a");
    }
}
```



# IO

## 字节流

### 键盘输入并保存1

分别键盘输入文件名 和 文件内容，并按照文件名保存相应的内容

tips:

- FileOutputStream
- Scanner
- 异常处理

### 键盘输入并保存2

键盘输入文件名，文件内容，按照输入的文件名，文件内容保存。
要求输入内容的时候可以多次追加写入，以一个约定字符串表示结束输出内容，
比如当输入end时表示终止内容输入。

tips:

- FileOutputStream
- Scanner
- 异常处理
- equals

## 字符流

### 统计各种字符

```
从磁盘上读取一个文本文件（如某个java源代码），
分别统计出文件中英文字母、空格、数字字符的个数。(注意文本文件中的数字指的是数字字符！！！)
```

tips:

- FileReader
- ASCII 或Character
- 异常处理

### 文本按行逆序

```
利用字符流去读取一个文本文件，每次读取一行，并将这行数据逆序，写入新的文本文件当中
```

tips:

- BufferedReader
- BufferedWriter/ FileWriter
- String API/StringBuffer
- 异常处理

## 综合

### 单词分类(动词,名词)

```
有这样的一个words数组，数组中每个字符串的格式为“词性:单词”

String[] words = {"verb:eat","verb:drink","verb:sleep","verb:play","noun:rice","noun:meat","noun:hand","noun:hair"};

根据单词性质动词verb全部存入verb.txt文件中

根据单词性质名词noun全部存入noun.txt文件中
```

tips:

- FileOutputStream
- String API
- 异常处理

### 统计奇数偶数

```
读取一个文件，这个文件中有随机的一些数字字符，统计这些数字有几个偶数，几个奇数，并且追加写入到该文件末尾。
例如：
a.txt文件：
   3241256364789629090126581212515
   奇数：xx个
   偶数：xx个
```

tips:

- FileInputStream
- FileOutputStream
- 取余数
- 异常处理





### 英文排序

```
在一个磁盘的文件里保存26个英文小写字母（乱序），将他们读入内存中，进行排序，
把排好顺序的数再重新追加写到磁盘的该文件中。
```

tips:

- IO
- 排序
- 异常处理

### 递归查找并复制

```
递归查找指定目录中(包括子目录中)，所有的.java文件，并且，
把所有这些找到的java文件，复制(是复制不是移动)到一个指定的目录下
```

tips:

- 递归
- File API
- 文件复制
- 异常处理



```java
package com.cskaoyan.javase.homework.senior._04io;


import java.io.*;
import java.util.Arrays;

/**
 * @description:
 * @author: songtao@cskaoyan.onaliyun.com
 **/

/*
递归查找指定目录中(包括子目录中)，所有的.java文件，并且，
把所有这些找到的java文件，复制(是复制不是移动)到一个指定的目录下
 */
public class Work7 {
    public static void main(String[] args) throws IOException {
        // 指定源目录
        File srcDir = new File("D:\\app2");
        // 指定目的目录
        File desDir = new File("D:\\copyResult");
        // 查找java文件
        findFile(srcDir,desDir);
    }

    private static void findFile(File srcDir, File desDir) throws IOException {
        // 从源目录中找java文件
        File[] files = srcDir.listFiles();
        System.out.println(Arrays.toString(files));
        if (files.length > 0) {
            for (File file : files) {
                // 判断是否是文件
                if (file.isFile()) {
                    // 判断是否是java文件
                    // lambda表达式
                    boolean javaFile = isJavaFile((file1) -> file1.getPath().endsWith(".java"), file);
                    if (javaFile) {
                        // 是  进行复制操作
                        copyFile(file,desDir);
                    }
                    // 不是 忽略
                }else{
                    // 是目录
                    // 递归 继续查找
                    findFile(file,desDir);
                }

            }
        }
    }

    private static boolean isJavaFile(FileFilter filter,File file){
        return filter.accept(file);
    }

    private static void copyFile(File srcFile,File desDir) throws IOException {
        // 创建输入流对象
        FileInputStream in = new FileInputStream(srcFile);
        // 创建输出流对象
        FileOutputStream out = new FileOutputStream(desDir + "\\" + srcFile.getName());

        // 边读边写
        byte[] bytes = new byte[1024];
        int readCount;
        while ((readCount = in.read(bytes)) != -1) {
            out.write(bytes, 0, readCount);
        }
        // close
        in.close();
        out.close();
    }

}


```



### 文件内容加密

```
设计一个方法

public static void encodeFile(File encodingFile, File encodedFile);

在这个方法中把encodingFile的内容进行加密，然后保存到encodedFile文件中。

加密算法：
数字：
如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4
如果是9的数字，变成0
字母字符：
如果是非z字符，向右移动一个，比如d变成e, G变成H
如果是z，z->a, Z-A。
字符需要保留大小写
非字母字符
比如',&^ 保留不变，中文也保留不变
```



```java
package com.cskaoyan.javase.homework.senior._04io;

/**
 * @description:
 * @author: 景天
 * @date: 2022/2/11 11:12
 **/

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
设计一个方法

public static void encodeFile(File encodingFile, File encodedFile);

在这个方法中把encodingFile的内容进行加密，然后保存到encodedFile文件中。

加密算法：
数字：
如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4
如果是9的数字，变成0
字母字符：
如果是非z字符，向右移动一个，比如d变成e, G变成H
如果是z，z->a, Z-A。
字符需要保留大小写
非字母字符
比如',&^ 保留不变，中文也保留不变

 */
public class Work9 {
    /**
     *
     * @param encodingFile
     *            被加密的文件
     * @param encodedFile
     *            加密后保存的位置
     */
    public static void encodeFile(File encodingFile, File encodedFile) {

        try (FileReader fr = new FileReader(encodingFile); FileWriter fw = new FileWriter(encodedFile)) {
            // 读取源文件
            char[] fileContent = new char[(int) encodingFile.length()];
            fr.read(fileContent);
            System.out.println("加密前的内容：");
            String s = new String(fileContent);
            System.out.println(s);

            // 进行加密
            encode(fileContent);
            // 把加密后的内容保存到目标文件
            System.out.println("加密后的内容：");
            System.out.println(new String(fileContent));

            fw.write(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void encode(char[] fileContent) {
        for (int i = 0; i < fileContent.length; i++) {
            char c = fileContent[i];
            if (isLetterOrDigit(c)) {
                switch (c) {
                    case '9':
                        c = '0';
                        break;
                    case 'z':
                        c = 'a';
                        break;
                    case 'Z':
                        c = 'A';
                        break;
                    default:
                        c++;
                        break;
                }
            }
            fileContent[i] = c;
        }
    }

    public static boolean isLetterOrDigit(char c) {
        // 不使用Character类的isLetterOrDigit方法是因为，中文也会被判断为字母
        String letterOrDigital = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        return -1 == letterOrDigital.indexOf(c) ? false : true;
    }

    public static void main(String[] args) {
        File encodingFile = new File("Test1.txt");
        File encodedFile = new File("Test2.txt");
        encodeFile(encodingFile, encodedFile);
    }
}

```



### 文件内容解密

解密上面加密的文件

# 多线程

## 多线程实现方式一

```
使用多线程实现方式一 ,多个文件一起复制功能(3个线程复制3个文件)，并在控制台显示复制的进度，进度以百分比表示
使用多线程实现方式一 ,多个文件一起复制功能，
并在控制台显示复制的进度，进度以百分比表示

例如：把文件A复制到E盘某文件夹下，在控制台上显示“XXX文件已复制xx%”，
“XXX文件已复制xxx%”……“XXX文件已复制xxx%”，“XXX复制完成！
```

tips:

- Thread
- 文件复制
- 保留2位小数可以用String中的format方法 %.2f



```java
package com.cskaoyan.javase.homework.senior._05thread;

/**
 * @description:
 * @author: 景天
 * @date: 2022/2/11 11:25
 **/

import java.io.*;

/*
.使用多线程实现方式一 ,多个文件一起复制功能(3个线程复制3个文件)，并在控制台显示复制的进度，进度以百分比表示
使用多线程实现方式一 ,多个文件一起复制功能，
并在控制台显示复制的进度，进度以百分比表示

例如：把文件A复制到E盘某文件夹下，在控制台上显示“XXX文件已复制xx%”，
“XXX文件已复制xxx%”……“XXX文件已复制xxx%”，“XXX复制完成！
 */
public class Work1 {
    public static void main(String[] args) {
        new CopyFile("D:\\temp\\aa.jpg", "aa.jpg").start();
        new CopyFile("D:\\temp\\bb.jpg", "bb.jpg").start();
        new CopyFile("D:\\temp\\cc.jpg", "cc.jpg").start();
    }
}

class CopyFile extends Thread{
    File oldFile;
    File newFile;

    public CopyFile(String oldFile, String newFile) {
        this.oldFile = new File(oldFile);
        this.newFile = new File(newFile);
    }

    @Override
    public void run() {
        // 复制文件操作
        try(FileInputStream in = new FileInputStream(oldFile);
            FileOutputStream out = new FileOutputStream(newFile)) {

            // 边读边写
            int readCount;
            byte[] bytes = new byte[1024];
            // 用来做累加的
            double temp = 0;
            long length = oldFile.length();
            while ((readCount = in.read(bytes)) != -1) {
                // write
                out.write(bytes);
                temp += readCount;
                double persent = temp / length * 100;
                System.out.println(oldFile + "复制了:"+String.format("%.2f",persent)+"%");
            }
            System.out.println(oldFile + "复制完成!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```



## 线程控制API

### Join

```
现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
利用线程控制API
```

tips:

- join



```java
/**
 * @description:
 * @author: 景天
 * @date: 2023/7/7 16:45
 **/

public class Work2_2 {
    public static void main(String[] args) {
        Thread t1 = new MyThread1();
        Thread t2 = new MyThread2();
        Thread t3 = new MyThread3();
        // 保证t1先执行 t2  t3
        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("T1");
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        System.out.println("T2");
    }
}

class MyThread3 extends Thread{
    @Override
    public void run() {
        System.out.println("T3");
    }
}
```



## 多线程实现方式二

```
使用多线程实现方式二 ,多个文件一起复制功能，
并在控制台显示复制的进度，进度以百分比表示

例如：把文件A复制到E盘某文件夹下，在控制台上显示“XXX文件已复制xx%”，
“XXX文件已复制xxx%”……“XXX文件已复制xxx%”，“XXX复制完成！
```

tips:

- Runnable
- 文件复制
- 异常处理
- 保留2位小数可以用String中的format方法 %.2f

```java

/**
 * @description:
 * @author: 景天
 * @date: 2022/2/11 11:31
 **/

import java.io.*;

/**
 * @description:
 * @author: songtao@cskaoyan.onaliyun.com
 **/

/*
使用多线程实现方式二 ,多个文件一起复制功能，
并在控制台显示复制的进度，进度以百分比表示

例如：把文件A复制到E盘某文件夹下，在控制台上显示“XXX文件已复制xx%”，
“XXX文件已复制xxx%”……“XXX文件已复制xxx%”，“XXX复制完成！
 */
public class Work4 {
    public static void main(String[] args) {

        new Thread(new CopyFileRunnable("D:\\temp\\aa.jpg", "aa.jpg")).start();
        new Thread(new CopyFileRunnable("D:\\temp\\bb.jpg", "bb.jpg")).start();
        new Thread(new CopyFileRunnable("D:\\temp\\cc.jpg", "cc.jpg")).start();
    }
}

class CopyFileRunnable implements Runnable{
    File oldFile;
    File newFile;

    public CopyFileRunnable(String oldFile, String newFile) {
        this.oldFile = new File(oldFile);
        this.newFile = new File(newFile);
    }
    @Override
    public void run() {
        // 复制文件操作
        try(FileInputStream in = new FileInputStream(oldFile);
            FileOutputStream out = new FileOutputStream(newFile)) {

            // 边读边写
            int readCount;

            byte[] bytes = new byte[1024];
            // 用来做累加的
            double temp = 0;
            long length = oldFile.length();
            while ((readCount = in.read(bytes)) != -1) {
                // write
                out.write(bytes);
                temp += readCount;
                double persent = temp / length * 100;
                System.out.println(oldFile + "复制了:"+String.format("%.2f",persent)+"%");
            }
            System.out.println(oldFile + "复制完成!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```





## 线程安全

### 模拟迅雷下载

```
用多线程代码来模拟，迅雷用3个线程下载100M资源的的过程。

 每个线程每次，一次下载1兆(M)资源，直到下载完毕，即剩余的待下载资源大小为0

 (用一个整数表示资源大小，每次个线程每次下载多少兆(M), 剩余待下载资源就减少多少兆(M)，

  模拟我们售票的代码实现，考虑多线程的数据安全问题)
```

tips:

- synhronized

```java
/**
 * @description: 迅雷
 * @author: songtao@cskaoyan.onaliyun.com
 **/
/*1. 用多线程代码来模拟，迅雷用3个线程下载100M资源的的过程。

 每个线程每次，一次下载1兆(M)资源，直到下载完毕，即剩余的待下载资源大小为0

 (用一个整数表示资源大小，每次个线程每次下载多少兆(M), 剩余待下载资源就减少多少兆(M)，

  模拟我们售票的代码实现，考虑多线程的数据安全问题)*/
public class Work5 {
    public static void main(String[] args) {

        // 创建Ruunable对象表示下载任务

        DownloadRunnable downloadTask = new DownloadRunnable();


        //开启3个线程，执行下载任务

        new Thread(downloadTask).start();

        new Thread(downloadTask).start();

        new Thread(downloadTask).start();


    }
}


class DownloadRunnable implements Runnable {


    //待下载的100M资源

    int remaining = 100;


    private Object lockObj = new Object();

    /**
     * 在子线程中执行的下载任务的实现代码
     */

    @Override
    public void run() {
        //模拟下载过程所需要的时间延迟
        while (remaining > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //模拟成功下载资源
            synchronized (lockObj) {

                if (remaining > 0) {

                    //注意因为这里是还剩下的资源，代码执行到这里，我们认为已经下载了1M了，所以输出的是 --remaining

                    System.out.println(Thread.currentThread().getName() + "下载了1M资源，还剩" + --remaining

                            + "M资源待下载");

                    if (remaining == 0) {

                        System.out.println("下载完毕");
                        //return;
                    }

                }

            }

        }

    }



}
```



## 线程通信

### wait notify

```
要求2个线程交替打印1A2B3C4D...
wait notify
附加: 怎么保证某个线程先执行 比如先打印A 再打印1
=====通过flag标记做判断
```

tips:

- wait 
- notify
- synchronized

```java
package com.cskaoyan.javase.homework.senior._05thread;

/**
 * @description: 题目
 * @author: 景天
 * @date: 2022/3/9 11:28
 **/

/*
   练习题:
   要求2个线程交替打印1A2B3C4D...
   wait notify
   附加: 怎么保证某个线程先执行 比如先打印A 再打印1
   =====通过flag标记做判断
 */
public class Work6 {
    // 定义一把锁
    private static Object obj = new Object();
    // 定义1个标记值
    private static boolean flag = false;

    public static void main(String[] args) {
        // 定义2个字符串数组
        String s1 = "1234567";
        String s2 = "ABCDEFG";
        // 转为字符数组
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        // 启动2个线程
        // 打印数字
        new Thread(() -> {
            synchronized (obj) {
                // 通过这个flag去判断
                // 如果是false 阻塞当前线程 先执行另一个线程
                while (!flag) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 遍历chars1
                for (char c :
                        chars1) {
                    // 输出
                    System.out.print(c);
                    // notify
                    obj.notify();
                    // wait
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 目的是叫醒另一个线程 避免另一个一直在wait
                obj.notify();
            }

        }).start();

        // 打印字母的
        new Thread(() -> {

            synchronized (obj) {
                // 修改flag的值
                flag = true;
                // 遍历chars1
                for (char c :
                        chars2) {
                    // 输出
                    System.out.print(c);
                    // notify
                    obj.notify();
                    // wait
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                obj.notify();
            }
        }).start();
    }

}

```



### wiat  notifyAll(<font color=red>选做</font>)

```
启动3个线程打印递增的数字使用wait notifyAll (选做)

 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10,
 然后是线程3打印11,12,13,14,15. 接着再由线程1打印16,17,18,19,20....以此类推,
 直到打印到75
```

```java
package com.cskaoyan.javase.homework.senior._05thread;

/**
 * @description:
 * @author: songtao@cskaoyan.onaliyun.com
 **/

/*
## 启动3个线程打印递增的数字使用wait notifyAll (选做)

 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10,
 然后是线程3打印11,12,13,14,15. 接着再由线程1打印16,17,18,19,20....以此类推,
 直到打印到75
 */
public class Work7 {
    public static void main(String[] args) {
        // 启动3个线程
        new Thread(new PrintRunnable(1),"a").start();
        new Thread(new PrintRunnable(2),"b").start();
        new Thread(new PrintRunnable(3),"c").start();
    }
}

class PrintRunnable implements Runnable{
    static int printNum = 0;
    int threadId;

    public PrintRunnable(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        while (printNum < 75) {
            // 同步代码块
            synchronized (PrintRunnable.class) {
                // 核心就是让这个值等于线程id
                if (printNum / 5 % 3 + 1 == threadId) {
                    // 打印5个数
                    for (int i = 0; i < 5; i++) {
                        System.out.println(Thread.currentThread().getName()+
                                "线程: " + ++printNum);
                    }
                    System.out.println("----------");
                    // notifyAll
                    PrintRunnable.class.notifyAll();
                }else{
                    // wait
                    try {
                        PrintRunnable.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


```

