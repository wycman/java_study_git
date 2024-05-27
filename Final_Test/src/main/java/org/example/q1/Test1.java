package org.example.q1;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * **需求**
 *
 * * 某小型商城系统的订单信息在**素材下的orders.xml文件中**，现在要求把xml中的订单信息，封装成一个一个的订单对象，将订单对象保存到ArrayList集合中。
 *
 * **具体功能点要求**
 *
 * 1)   定义订单类Order，创 建ArrayList集合，用于存储订单Order对象 （解析XML 4分，封装成对象2分）
 *
 * 2）请使用Stream流找出今天之前的订单，并遍历输出。（3分）
 *
 * 3)   请使用Stream流找出集合中价格最贵的订流单，把这个订单的详细信息打印出来。（3分）
 *
 * 4)   请使用Stream流遍历集合中的每个订单，要求按照价格降序输出每个订单的详情。（3分）
 */
public class Test1 {
    public static void main(String[] args) throws DocumentException {
        List<Order> orders = new ArrayList<>();
        //首先需要解析order.xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(Test1.class.getClassLoader().getResourceAsStream("orders.xml"));
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        //定义字符串转换为localDateTime类对象的日期转换formatter
        DateTimeFormatter MyTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (Element element : elements) {
            String current_id = element.attributeValue("id");
            String current_name = element.elementText("name");
            String time_string = element.elementText("time");
            LocalDateTime current_time = LocalDateTime.parse(time_string, MyTimeFormatter);
            double current_price = Double.parseDouble(element.elementText("double"));
            orders.add(new Order(current_id, current_name, current_time, current_price));
        }
        System.out.println("***************");
        //2.用stream流找出今天之前的订单，并遍历输出
        System.out.println("今天之前的订单如下:");
        Stream<Order> date_before_today_stream = orders.stream().filter(order -> {
            return order.getL_time().isBefore(LocalDateTime.now());
        });
        date_before_today_stream.forEach((Order order) -> System.out.println(order));
        //3.用stream流找出集合中价格最贵的订流单，把这个订单的详细信息打印出来
        System.out.println("**************");
        Stream<Order> stream_2 = orders.stream();

        Optional<Order> max_order_op = stream_2.max((o1, o2) -> {
            return (int) (o1.getPrice() - o2.getPrice());
        });
        Order max_price_order = max_order_op.get();
        System.out.println("集合中最贵的订单为:" + max_price_order);

        //4.用Stream流遍历集合中的每个订单，要求按照价格降序输出每个订单的详情
        System.out.println("***************");
        System.out.println("按照价格降序输出每个订单的详情:");
        orders.stream().sorted(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return (int) (o2.getPrice() - o1.getPrice());
            }
        }).forEach((order) -> System.out.println(order));
    }
}
