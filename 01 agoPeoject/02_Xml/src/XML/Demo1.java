package XML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;


/**
 * @program: JavaWeb
 * @description: Jsoup基本使用
 * @author: Mr.Wang
 * @create: 2020-03-18 16:45
 **/
@SuppressWarnings("all")
public class Demo1 {
    private static Document document;

    static {
        try {
            // 解析xml或html字符串
            // 通过网络路径获取指定的html或xml的文档对象
            // URL url = new URL("https://baike.baidu.com/item/jsoup/9012509?fr=aladdin");//代表网络中的一个资源路径
            String path = Demo1.class.getClassLoader().getResource("student.xml").getPath();
            //2.2解析xml文档，加载文档进内存，获取dom树--->Document
            document = Jsoup.parse(new File(path), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() throws IOException {
        //3.获取元素对象 Element
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        //3.1获取第一个name的Element对象
        Element element = elements.get(0);
        //3.2获取数据
        String name = element.text();
        System.out.println(name);
    }

    // Document/Element对象功能演示
    @Test
    public void test2() {
        //3.1获取所有student对象
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);
        System.out.println("-----------");
        //3.2 获取属性名为id的元素对象们
        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);
        System.out.println("-----------");
        //3.2获取 number属性值为heima_0001的元素对象
        Elements elements2 = document.getElementsByAttributeValue("number", "s002");
        System.out.println(elements2);
        System.out.println("-----------");
        //3.3获取id属性值的元素对象
        Element itcast = document.getElementById("2");
        System.out.println(itcast);
    }

    //Element对象功能
    @Test
    public void test3() {
        //通过Document对象获取name标签，获取所有的name标签，可以获取到两个
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        System.out.println("----------------");
        //通过Element对象获取子标签对象
        Element element_student = document.getElementsByTag("student").get(0);
        Elements ele_name = element_student.getElementsByTag("name");
        System.out.println(ele_name.size());

        //获取student对象的属性值
        String number = element_student.attr("NUMBER");
        System.out.println(number);
        System.out.println("------------");
        //获取文本内容
        String text = ele_name.text();
        String html = ele_name.html();
        System.out.println(text);
        System.out.println(html);
    }


}
