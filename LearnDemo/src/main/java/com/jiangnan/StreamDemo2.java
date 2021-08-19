package com.jiangnan;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 流结构转化为其他数据结构
 * // 1. Array
 * String[] strArray1 = stream.toArray(String[]::new);
 * // 2. Collection
 * List<String> list1 = stream.collect(Collectors.toList());
 * List<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
 * Set set1 = stream.collect(Collectors.toSet());
 * Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));
 * // 3. String
 * String str = stream.collect(Collectors.joining()).toString();
 * //分组构造Map
 * Map<Integer, String> factoryMap = factoryConfigDOS.stream().collect( Collectors.groupingBy(AgencyDailySalaryFactoryConfigDO::getFenceId, Collectors.mapping(AgencyDailySalaryFactoryConfigDO::getFactoryName, joining(",")) ));
 *
 * //Map转化  函数表达式转成MAP,key1和key2重复就覆盖不然会报错
 * Map nameMap = incumbentExcelInfoList.stream().collect(Collectors.toMap(info -> info.getIdCard(), info -> info.getName(),(key1,key2)->key2));
 *
 */
public class StreamDemo2 {
    public static void main(String[] args) {
        //注意：如果map操作后，没有执行collect方法，那么就没有返回新的流，因此map中的操作也不会生效。
        //使用Stream中的of方法传入两个字符串
        Stream.of("小王:18","小杨:20")
                .map(new Function<String, People>() {
                    /*调用Stream中的map方法，使用匿名接口Function，
                    需要重写Function中的抽象方法apply，apply方法需要传入两个数据，
                    前一个为转化前的String类型，后一个为转化后的对象类型*/
                    @Override
                    public People apply(String s) {//传入要转变的参数
                        String[] str = s.split(":");
                        //调用String中的split方法，以：切割，定义一个字符串接收切割后的字符串数据
                        //对象家接收匿名对象切割后的元素。数组索引0为字符串，数组索引1为数字
                        People people = new People(str[0],Integer.valueOf(str[1]));
                        return people;//返回people类型对象
                    }
                }).forEach(people-> System.out.println("people = " + people));

        /**
         * 这个接口，跟map一样，接收一个Fucntion的函数式接口，不同的是，Function接收的泛型参数，第二个参数是一个Stream流；
         * 方法，返回的也是泛型R，具体的作用是把两个流，变成一个流返回，
         * 下面，我们看一个案例，来详细解答，怎么把两个流的内容，变成一个流的内容
         */

        /**
         * 首先，第二段代码，才输出的具体的字符串；
         * 第一段输出代码里，我们先看map操作，通过上面对map的介绍，我们可以看到，map可以改变返回的Stream的泛型，str.split("")，根据空字符串分隔，返回的类型是一个数组，返回的流也是Stream<String[]>，而不是Stream<String>；
         * 在第二段代码中，数组的流，经过map操作，返回Stream<String[]>后，再经过flatMap，把数组通过Arrays.stream变成一个新的流，再返回到原来的流里；这样，两个流就合并成一个流；
         * 第三段代码，是第二段代码的，另一种写法；
         */
        String[] strs = {"大娃", "二娃", "三娃", "四娃", "五娃", "六娃","爷爷","蛇精","蝎子精"};
        Arrays.stream(strs).map(s -> s.split(",")).forEach(System.out::println);
        Arrays.stream(strs).map(s -> s.split(",")).flatMap(Arrays::stream).forEach(System.out::println);
        Arrays.stream(strs).map(s -> s.split(",")).flatMap(strings -> Arrays.stream(strings)).forEach(System.out::println);

    }
}
