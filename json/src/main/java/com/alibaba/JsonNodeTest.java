package com.alibaba;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonNodeTest {

    /**
     * JsonNodeFactory.instance: 创建单例的 JsonNodeFactory 工厂
     *
     * ObjectNode objectNode() : 构造空的 JSON 对象,这个JSON对象里面存储的值结构是key-value形式，其中key是String类型，
     * value是节点类型：例如文本节点TextNode、数值节点NumberNode但这些节点都会强制转换为JsonNode节点，也就是说ObjectNode是一个存储多个对象的节点类型，每一个value都是以强转JsonNode的形式存储
     * ObjectNode put(String fieldName, String v): 将字段的值设置为指定的字符串值，如果字段已经存在，则更新值
     * ObjectNode put(String fieldName, int v)：其它数据类型也是同理
     *
     * ArrayNode putArray(String fieldName)：构造 ArrayNode 并将其作为此 ObjectNode 的字段添加。
     * ObjectNode putNull(String fieldName): 为指定字段添加 null 值
     * ArrayNode add(String v) :将指定的字符串值添加到此数组的末尾，其它数据类型也是同理。
     */
    @Test
    public void objectNode1() {
        JsonNodeFactory jsonNodeFactory = JsonNodeFactory.instance;
        ObjectNode objectNode = jsonNodeFactory.objectNode();
        objectNode.put("name", "张三");
        objectNode.put("age", 25);
        objectNode.putNull("marry");

        ArrayNode arrayNode = objectNode.putArray("urls");
        arrayNode.add("http://tomcat.org/tomcat.png#1");
        arrayNode.add("http://tomcat.org/tomcat.png#2");
        arrayNode.add("http://tomcat.org/tomcat.png#3");

        //{"name":"张三","age":25,"marry":null,"urls":["http://tomcat.org/tomcat.png#1","http://tomcat.org/tomcat.png#2","http://tomcat.org/tomcat.png#3"]}
        System.out.println(objectNode.toString());
    }
    @Test
    public void objectNode2() {
        JsonNodeFactory jsonNodeFactory = JsonNodeFactory.instance;
        ObjectNode objectNode_root = jsonNodeFactory.objectNode();
        ArrayNode arrayNode = jsonNodeFactory.arrayNode();

//        ArrayNode arrayNode = objectNode_root.putArray("notices");
        ObjectNode objectNodeChild = jsonNodeFactory.objectNode();
        objectNodeChild.put("title", "放假通知");
        objectNodeChild.put("content", "寒假放假于本月3号开始.");
        arrayNode.add(objectNodeChild);

        objectNode_root.put("notices", arrayNode);

        //{"notices":[{"title":"放假通知","content":"寒假放假于本月3浩开始."}]}
        System.out.println(objectNode_root);
    }

    /**
     * JsonNode replace(String fieldName, JsonNode value):将特定属性的值替换为传递的值，字段存在时更新，不存在时新增
     * JsonNode set(String fieldName, JsonNode value)：设置指定属性的值为 json 节点对象，字段存在时更新，不存在时新增，类似 replace 方法
     * JsonNode setAll(Map<String,? extends JsonNode> properties)：同时设置多个 json 节点
     */
    @Test
    public void objectNode3() {
        try {
            String json = "{\"notices\":{\"title\":\"放假通知\",\"content\":\"寒假放假于本月3浩开始.\"}}";
            JsonNode jsonNode = new ObjectMapper().readTree(json);
            ObjectNode objectNode = (ObjectNode) jsonNode;

            ObjectNode node = JsonNodeFactory.instance.objectNode();
            node.put("code", 200);
            objectNode.set("status", node);
            //{"notices":[{"title":"放假通知","content":"寒假放假于本月3浩开始."}],"status":{"code":200}}
            System.out.println(objectNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * JsonNode setAll(ObjectNode other)：添加给定对象（other）的所有属性，重写这些属性的任何现有值
     */
    @Test
    public void objectNode4() {
        try {
            String json = "{\"notices\":{\"title\":\"放假通知\",\"content\":\"寒假放假于本月3浩开始.\"}}";
            JsonNode jsonNode = new ObjectMapper().readTree(json);
            ObjectNode objectNode = (ObjectNode) jsonNode;

            String json1 = "{\"status\":{\"code\":\"200\",\"msg\":\"成功\"}}";
            JsonNode jsonNode1 = new ObjectMapper().readTree(json1);
            ObjectNode objectNode1 = (ObjectNode) jsonNode1;
            ObjectNode node = JsonNodeFactory.instance.objectNode();
            node.put("code", 201);
            node.put("msg", "成");
            objectNode.set("status", node);
//            objectNode.setAll(objectNode1);
            //{"notices":[{"title":"放假通知","content":"寒假放假于本月3浩开始."}],"code":200}
            System.out.println(objectNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * JsonNode get(String fieldName):
     * 1、用于访问对象节点的指定字段的值，如果此节点不是对象、或没有指定字段名的值，或没有这样名称的字段，则返回 null。
     * boolean isArray(): 判断此节点是否为 {@link ArrayNode} 数组节点
     * int size()：获取数组节点的大小
     * int asInt()：
     * 1、尝试将此节点的值转换为 int 类型，布尔值 false 转换为 0,true 转换为 1。
     * 2、如果不能转换为 int（比如值是对象或数组等结构化类型），则返回默认值 0 ，不会引发异常。
     * String asText()：如果节点是值节点（isValueNode返回true），则返回容器值的有效字符串表示形式，否则返回空字符串。
     * 其它数据类型也是同理
     */

    public void objectNode5() {
        try {
            String json = "{\"notices\":[{\"title\":\"停水\",\"day\":\"12\"},{\"title\":\"停电\",\"day\":\"32\"},{\"title\":\"停网\",\"day\":\"22\"}]}";
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode jsonNode = (ObjectNode) objectMapper.readTree(json);

            JsonNode notices = jsonNode.get("notices");
            if (notices != null && notices.isArray()) {
                for (int i = 0; i < notices.size(); i++) {
                    JsonNode childNode = notices.get(i);
                    String title = childNode.get("title").asText();
                    Integer day = childNode.get("day").asInt();
                    System.out.println((i + 1) + "：" + title + "\t" + day);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ArrayNode withArray(String propertyName): 将 json 节点转为 json 数组对象
     * ObjectNode with(String propertyName)：将 json 节点转为 ObjectNode 对象
     */

    public void objectNode6() {
        try {
            String json = "{\"notices\":[{\"title\":\"放假通知\",\"content\":\"寒假放假于本月3浩开始.\"}]}";
            JsonNode jsonNode = new ObjectMapper().readTree(json);

            ObjectNode objectNode = (ObjectNode) jsonNode;
            ArrayNode arrayNode = objectNode.withArray("notices");
            for (int i = 0; i < arrayNode.size(); i++) {
                //{"title":"放假通知","content":"寒假放假于本月3浩开始."}
                JsonNode node = arrayNode.get(i);
                System.out.println(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * JsonNode remove(String fieldName)：删除指定的 key，返回被删除的节点
     * JsonNode without(String fieldName):
     * ObjectNode remove(Collection<String> fieldNames)：同时删除多个字段
     * ObjectNode without(Collection<String> fieldNames)：同时删除多个字段
     * ObjectNode removeAll(): 删除所有字段属性
     */

    public void objectNode7() {
        try {
            String json = "{\"notices\":[{\"title\":\"放假通知\",\"content\":\"寒假放假于本月3浩开始.\"}]}";
            JsonNode jsonNode = new ObjectMapper().readTree(json);
            ObjectNode objectNode = (ObjectNode) jsonNode;

            JsonNode remove = objectNode.remove("notices");
            System.out.println(remove);//[{"title":"放假通知","content":"寒假放假于本月3浩开始."}]
            System.out.println(objectNode);//{}

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ObjectNode deepCopy()：json 节点对象深度复制，相当于克隆
     * Iterator<String> fieldNames(): 获取 json 对象中的所有 key
     */

    public void objectNode8() {
        try {
            String json = "{\"title\":\"放假通知\",\"content\":\"寒假放假于本月3浩开始.\"}";
            JsonNode jsonNode = new ObjectMapper().readTree(json);
            ObjectNode objectNode = (ObjectNode) jsonNode;
            ObjectNode deepCopy = objectNode.deepCopy();
            deepCopy.put("summary", "同意");
            System.out.println(objectNode);//{"title":"放假通知","content":"寒假放假于本月3浩开始."}
            System.out.println(deepCopy);//{"title":"放假通知","content":"寒假放假于本月3浩开始.","summary":"同意"}

            Iterator<String> fieldNames = deepCopy.fieldNames();
            while (fieldNames.hasNext()) {
                String next = fieldNames.next();
                System.out.println(next + "=" + deepCopy.get(next));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void objectNode9() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("code", 200);
        dataMap.put("msg", "成功");

        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        objectNode.putPOJO("data", dataMap);

        System.out.println(objectNode);
        JsonNode jsonNode = objectNode.get("data");
    }

    /**
     * double asDouble(): 尝试将此节点的值转换为 double，布尔值转换为0.0（false）和1.0（true），字符串使用默认的Java 语言浮点数解析规则进行解析。
     * 如果表示不能转换为 double（包括对象和数组等结构化类型），则返回默认值 0.0,不会引发异常。
     * BigDecimal decimalValue() :返回此节点的浮点值 BigDecimal, 当且仅当此节点为数字时（isNumber 返回true）,对于其他类型，返回 BigDecimal.ZERO
     */

    public void test10() {
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        objectNode.put("id", 1000);
        objectNode.put("salay", 15000.456);

        double salay = objectNode.get("salay").asDouble();
        BigDecimal bigDecimal = objectNode.get("salay").decimalValue();
        System.out.println(salay + "," + bigDecimal);//15000.456,15000.456
    }

    /**
     * boolean has(int index)：检查此节点是否为数组节点，并是否含有指定的索引。
     * boolean has(String fieldName)：检查此节点是否为 JSON 对象节点并包含指定属性的值。
     */

    public void test11() {
        ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
        arrayNode.add(12).add("中国").addNull().add(345.5667);
        System.out.println(arrayNode);//[12,"中国",null,345.5667]

        System.out.println(arrayNode.has(1));//true
        System.out.println(arrayNode.has(2));//true
        System.out.println(arrayNode.has(4));//false
    }

    /**
     * Iterator<JsonNode> elements()：如果该节点是JSON数组或对象节点，则访问此节点的所有值节点
     * 对于对象节点，不包括字段名（键），只包括值，对于其他类型的节点，返回空迭代器。
     */

    public void test12() {
        try {
            String json = "{\"title\":\"放假通知\",\"content\":\"寒假放假于本月3浩开始.\",\"id\":23400}";
            JsonNode jsonNode = new ObjectMapper().readTree(json);
            Iterator<JsonNode> elements = jsonNode.elements();
            while (elements.hasNext()) {
                JsonNode next = elements.next();
                //"放假通知" "寒假放假于本月3浩开始." 23400
                System.out.print(next + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ArrayNode addAll(ArrayNode other): 用于添加给定数组的所有子节点
     */

    public void test13() {
        try {
            String json = "[{\"title\":\"放假通知\",\"content\":\"寒假放假于本月3浩开始.\"}]";
            JsonNode jsonNode = new ObjectMapper().readTree(json);

            ArrayNode rootArrayNode = JsonNodeFactory.instance.arrayNode();
            rootArrayNode.add(1000);
            if (jsonNode.isArray()) {
                ArrayNode arrayNode = (ArrayNode) jsonNode;
                rootArrayNode.addAll(arrayNode);
            }
            //[1000,{"title":"放假通知","content":"寒假放假于本月3浩开始."}]
            System.out.println(rootArrayNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ArrayNode addNull() :该方法将在此数组节点的末尾添加空值。
     */

    public void test14() {
        try {
            String json = "[{\"title\":\"放假通知\",\"content\":\"寒假放假于本月3浩开始.\"}]";
            JsonNode jsonNode = new ObjectMapper().readTree(json);
            if (jsonNode.isArray()) {
                ArrayNode arrayNode = (ArrayNode) jsonNode;
                arrayNode.addNull();
                //[{"title":"放假通知","content":"寒假放假于本月3浩开始."},null]
                System.out.println(arrayNode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ArrayNode addArray(): 构造新的 ArrayNode 节点，并将其添加到此数组节点的末尾
     */

    public void test15() {
        try {
            String json = "[{\"title\":\"放假通知\",\"content\":\"寒假放假于本月3浩开始.\"}]";
            JsonNode jsonNode = new ObjectMapper().readTree(json);
            if (jsonNode.isArray()) {
                ArrayNode arrayNode = (ArrayNode) jsonNode;
                ArrayNode addArray = arrayNode.addArray();
                addArray.add(31.4F);
                addArray.add("优秀");
                //[{"title":"放假通知","content":"寒假放假于本月3浩开始."},[31.4,"优秀"]]
                System.out.println(arrayNode);
                //[31.4,"优秀"]
                System.out.println(addArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ObjectNode putObject(String fieldName)：构造新的 ObjectNode 字节的，并将其作为此 ObjectNode 的字段添加。
     */

    public void test16() {
        try {
            String json = "{\"title\":\"放假通知\",\"content\":\"寒假放假于本月3浩开始.\"}";
            JsonNode jsonNode = new ObjectMapper().readTree(json);
            if (jsonNode.isObject()) {
                ObjectNode objectNode = (ObjectNode) jsonNode;
                ObjectNode persons = objectNode.putObject("person");
                persons.put("name", "张三");
                persons.put("age", 34);
                //{"title":"放假通知","content":"寒假放假于本月3浩开始.","person":{"name":"张三","age":34}}
                System.out.println(objectNode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
