package com.cskaoyan.datastructure.generic.edition5;


import com.cskaoyan.datastructure.generic.base.Test;

/*
      泛型方法
      泛型方法: 把泛型定义在方法上
格式:
		public <泛型类型> 返回类型 方法名(泛型类型 .) {
		}
 */
public class Demo2 {

    public static void main(String[] args) {
        A a = new A();
        Integer t = a.getT(1);
        String abc = a.getT("ABC");
    }
}

class A{
    public <T> T getT(T t){
        return t;
    }
}
