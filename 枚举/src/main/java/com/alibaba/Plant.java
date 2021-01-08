package com.alibaba;

public interface Plant {
    enum Vegetable implements INumberEnum {
        POTATO(1, "土豆"),
        TOMATO(2, "西红柿");

        Vegetable(int number, String description) {
            this.code = number;
            this.description = description;
        }

        private int code;
        private String description;

        @Override
        public int getCode() {
            return code;
        }

        @Override
        public String getDescription() {
            return description;
        }
    }

    enum Fruit implements INumberEnum {
        APPLE(3, "苹果"),
        ORANGE(4, "桔子"),
        BANANA(5, "香蕉");

        Fruit(int number, String description) {
            this.code = number;
            this.description = description;
        }

        private int code;
        private String description;

        @Override
        public int getCode() {
            return code;
        }

        @Override
        public String getDescription() {
            return description;
        }
    }
}
