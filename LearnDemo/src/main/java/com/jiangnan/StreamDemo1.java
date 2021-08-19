package com.jiangnan;
import sun.util.locale.provider.LocaleDataMetaInfo;

import java.util.stream.Stream;

/**
 * Stream流的学习使用
 * 1.Stream接口的静态方法of可以获取数组对应的流
 * 2.所有的Collection集合都可以通过stream默认方法获取对应的流
 */
public class StreamDemo1 {
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃","爷爷","蛇精","蝎子精");
        // 简单的输出
        stream1.forEach((s -> System.out.println(s)));
        System.out.println("**************************");

        // 每次创建的stream只能使用一次,要想再使用的话，必须重新创建
        // 过滤指定字符
        Stream<String> stream2 = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃","爷爷","蛇精","蝎子精");
        stream2.filter(s -> s.contains("娃")).forEach(s -> System.out.println(s));
        System.out.println("**************************");

        // 统计数量
        Stream<String> stream3 = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃","爷爷","蛇精","蝎子精");
        System.out.println(stream3.count());

        // Stream limit(long maxSize):获取Stream流对象中的前n个元素,返回一个新的Stream流对象
        // 参数是一个long型，如果集合当前长度大于参数则进行截取；否则不进行操作。
        Stream<String> stream4 = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃","爷爷","蛇精","蝎子精");
        Stream<String> limit = stream4.limit(5);
        limit.forEach(s -> System.out.println(s));
        System.out.println("**************************");

        // Stream skip(long n): 跳过Stream流对象中的前n个元素,返回一个新的Stream流对象
        // 如果流的当前长度大于n，则跳过前n个；否则将会得到一个长度为0的空流。
        Stream<String> stream5 = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃","爷爷","蛇精","蝎子精");
        Stream<String> skip = stream5.skip(3);
        skip.forEach(s -> System.out.println(s));
        System.out.println("**************************");

        //如果有两个流，希望合并成为一个流，那么可以使用 Stream 接口的静态方法 concat ：
        //static Stream concat(Stream<? extends T> a, Stream<? extends T> b): 把参数列表中的两个
        //Stream流对象a和b,合并成一个新的Stream流对象
        //备注：这是一个静态方法，与 java.lang.String 当中的 concat 方法是不同的。
        Stream<String> stream6 = Stream.of("四娃", "五娃", "六娃","爷爷","蛇精","蝎子精");
        Stream<String> stream7 = Stream.of("大娃");
        Stream<String> concat = Stream.concat(stream6, stream7);
        concat.forEach(s -> System.out.println(s));
        System.out.println("**************************");

        // map 操作
        Stream<String> stream8 = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃","爷爷","蛇精","蝎子精");
        stream8.map(s -> s.length()).forEach(c -> System.out.println(c));
    }



}
