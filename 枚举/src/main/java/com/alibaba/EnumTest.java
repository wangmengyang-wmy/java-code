package com.alibaba;

/**
 * 枚举方法测试、创建枚举对象的多种方式
 */
public class EnumTest {
    public static void main(String[] args) {
        test1();

        Direction2 d = Direction2.FRONT;
        System.out.println(d.getName());
    }

    public static void test1() {
        Direction direction = Direction.BEHIND;

        switch (direction){
            case FRONT:
                System.out.println("前面");break;
            case BEHIND:
                System.out.println("后面");break;
            case LEFT:
                System.out.println("左面");break;
            case RIGHT:
                System.out.println("右面");break;
            default:
                System.out.println("错误的方向");break;
        }

        Direction direction1=Direction.LEFT;
        int i = direction.compareTo(direction1);
        System.out.println(i);

        int j = direction1.compareTo(direction);
        System.out.println(j);

        boolean equals = direction.equals(direction1);
        System.out.println("equals:"+ equals);

        int i1 = direction.hashCode();
        System.out.println("hashCode:"+i1);

        String name = direction.name();
        System.out.println("name:"+name);

        String s = direction.toString();
        System.out.println("toString:"+s);

        Direction direction2 = Enum.valueOf(Direction.class, "FRONT");
        System.out.println("valueOf:"+direction2);

        System.out.println(Direction.FRONT.ordinal());
        System.out.println(Direction.BEHIND.ordinal());
        System.out.println(Direction.LEFT.ordinal());
        System.out.println(Direction.RIGHT.ordinal());

        System.out.println(direction1);

        Direction[] values = Direction.values();
        System.out.println("for values");
        for (Direction item:values) {
            System.out.println(item.name());
        }
        Direction direction3 = Direction.valueOf("FRONT");
        System.out.println("valueOf:"+direction3);
    }
}
