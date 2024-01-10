package com.cskaoyan.exception;


/*

       当我们有多种不同的异常需要处理，其每一个catch处理一种不同的异常

        try{
           // 可能出现异常的代码
        }catch(异常类型 对象名){
           // 对异常的处理操作
        }catch(异常类型 对象名){
           // 对异常的处理操作
        }catch(异常类型 对象名){
           // 对异常的处理操作
        }.....

        匹配规则：
          1.根据实际的异常对象的类型，和异常分支(异常处理器)声明的异常类型，从上到下一次做类型匹配
          2. 一旦通过类型匹配，发现实际异常对象的类型和Catch分支(异常处理器)声明的异常类型，类型匹配，
             就把异常对象交给这个异常分支（异常处理器）
          3. 多分支的异常处理的执行，有点类似于多分支if-else的执行，一次匹配，只会执行多个catch分支中的一个

       注意事项：
        如果说，在多catch分支的情况下，如果不同的catch分支，处理的异常类型，有父子关系
        那么就一定要注意，处理子类的异常分支写在前面，父类的异常分支写在后面
 */
public class Demo3 {

    public static void main(String[] args) {

        try {
            int j = 0;
            // 除0异常
            //int i = 10 / j;

            int[] ints = new int[3];
            // 数组越界异常
            //System.out.println(ints[3]);

            ints = null;
            // null指针异常
            System.out.println(ints[0]);

        }  catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            // 这个异常分支有点类似于多分支if-else 中的else分支
        }



    }
}
