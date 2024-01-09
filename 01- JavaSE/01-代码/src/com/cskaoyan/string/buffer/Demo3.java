package com.cskaoyan.string.buffer;


/*

    获取功能
        public int capacity() 返回当前容量,数组的长度,理论值
        public int length() 返回长度(字符的个数),实际值
        添加功能
        public StringBuffer append(String s) 将指定的字符串(其他类型有重载方法)追加到此字符序列的尾部
        在指定位置把任意类型的数据插入到字符串缓冲区里面
        public StringBuffer insert(int offset,String str)
        删除功能
        public StringBuffer deleteCharAt(int index)：删除指定位置的字符
        public StringBuffer delete(int start,int end)：删除从指定位置开始指定位置结束的内容
        替换功能
        使用给定String中的字符替换词序列的子字符串中的字符
        public StringBuffer replace(int start,int end,String str)
        反转功能
        public StringBuffer reverse()：将此字符序列用其反转形式取代，返回对象本身
 */
public class Demo3 {

    public static void main(String[] args) {

        // 无参构造方法，没有包含一个字符
        StringBuffer stringBuffer = new StringBuffer();

        // public int capacity() 返回当前容量,数组的长度,理论值
        int capacity = stringBuffer.capacity();
        System.out.println(capacity);

        // public int length() 返回长度(字符的个数),实际值
        int length = stringBuffer.length();
        System.out.println(length);

        // public StringBuffer append(String s)
        stringBuffer.append("abc");
        System.out.println(stringBuffer.length());

        //        在指定位置把任意类型的数据插入到字符串缓冲区里面
        //        public StringBuffer insert(int offset,String str)
        stringBuffer.insert(1, "aaaa");

        // 返回StringBuffer对象所代表的的那个字符串
        String string = stringBuffer.toString();
        System.out.println(string);

        // 删除方法
        // public StringBuffer deleteCharAt(int index)：删除指定位置的字符
        stringBuffer.deleteCharAt(6);
        String string1 = stringBuffer.toString();
        System.out.println(string1);

        //public StringBuffer delete(int start,int end)
        stringBuffer.delete(0, 5);
        String string2 = stringBuffer.toString();
        System.out.println(string2);

        //        替换功能
        //        使用给定String中的字符替换词序列的子字符串中的字符
        //        public StringBuffer replace(int start,int end,String str)

        stringBuffer.append("abdd");
        String string4 = stringBuffer.toString();
        System.out.println(string4);

        StringBuffer qq = stringBuffer.replace(0, 2, "qq");
        String string3 = qq.toString();
        System.out.println(string3);

        String string5 = stringBuffer.reverse().toString();
        System.out.println(string5);


    }
}
