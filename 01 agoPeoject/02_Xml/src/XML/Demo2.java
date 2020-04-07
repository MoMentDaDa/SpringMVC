package XML;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @program: JavaWeb
 * @description: xml查询
 * @author: Mr.Wang
 * @create: 2020-03-18 20:01
 **/
@SuppressWarnings("all")
public class Demo2 {
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
        Elements elements = document.select("name");
        System.out.println(elements);
        System.out.println("----------------");
        //4.查询id值为 2 的元素
        Elements elements1 = document.select("#2");
        System.out.println(elements1);
        System.out.println("----------------");
        //5.获取student标签并且number属性值为s001的age子标签
        Elements elements2 = document.select("student[number=\"s001\"]");
        System.out.println(elements2);
        System.out.println("----------------");

        //5.2获取student标签并且number属性值为s001的age子标签
        Elements elements3 = document.select("student[number=\"s001\"] > age");
        System.out.println(elements3);
    }

    // XPath查询
    @Test
    public void test2() throws IOException, XpathSyntaxErrorException {
        //3.根据document对象，创建JXDocument对象
        JXDocument jxDocument = new JXDocument(document);
        //4.结合xpath语法查询
        //4.1查询所有student标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
        System.out.println("--------------------");
        //4.2查询所有student标签下的name标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }
        System.out.println("--------------------");

        //4.3查询student标签下带有id属性的name标签
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }
        System.out.println("--------------------");
        //4.4查询student标签下带有id属性的name标签 并且id属性值为itcast

        List<JXNode> jxNodes4 = jxDocument.selN("//student/name[@id='2']");
        for (JXNode jxNode : jxNodes4) {
            System.out.println(jxNode);
        }
    }
}
