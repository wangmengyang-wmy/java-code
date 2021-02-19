package com.alibaba;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogTest {


    private static Logger logger= LoggerFactory.getLogger(LogTest.class);

//    https://logging.apache.org/log4j/2.x/manual/appenders.html
    public static void main(String[] args) {
        /*for (int i = 0; i < 100; i++) {
            logger.info(i + "一、什么是RollingFileAppender\n" +
                    "RollingFileAppender是Log4j2中的一种能够实现日志文件滚动更新(rollover)的Appender。\n" +
                    "\n" +
                    "rollover的意思是当满足一定条件(如文件达到了指定的大小、达到了指定的时间)后，就重命名原日志文件进行归档，并生成新的日志文件用于log写入。\n" +
                    "如果还设置了一定时间内允许归档的日志文件的最大数量，将对过旧的日志文件进行删除操作。\n" +
                    "\n" +
                    "RollingFile实现日志文件滚动更新，依赖于TriggeringPolicy和RolloverStrategy。\n" +
                    "\n" +
                    "其中，TriggeringPolicy为触发策略，其决定了何时触发日志文件的rollover，即When。\n" +
                    "\n" +
                    "RolloverStrategy为滚动更新策略，其决定了当触发了日志文件的rollover时，如何进行文件的rollover，即How。\n" +
                    "\n" +
                    "Log4j2提供了默认的rollover策略DefaultRolloverStrategy。\n" +
                    "\n" +
                    "下面通过一个log4j2.xml文件配置简单了解RollingFile的配置。\n" +
                    "\n" +
                    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<Configuration status=\"warn\">\n" +
                    "  <Appenders>\n" +
                    "    <RollingFile name=\"RollingFile\" fileName=\"logs/app.log\" filePattern=\"logs/app-%d{yyyy-MM-dd HH}.log\">\n" +
                    "      <PatternLayout>\n" +
                    "        <Pattern>%d %p %c{1.} [%t] %m%n</Pattern>\n" +
                    "      </PatternLayout>\n" +
                    "      <Policies>\n" +
                    "        <TimeBasedTriggeringPolicy interval=\"1\"/>\n" +
                    "        <SizeBasedTriggeringPolicy size=\"250MB\"/>\n" +
                    "      </Policies>\n" +
                    "    </RollingFile>\n" +
                    "  </Appenders>\n" +
                    "  <Loggers>\n" +
                    "    <Root level=\"error\">\n" +
                    "      <AppenderRef ref=\"RollingFile\"/>\n" +
                    "    </Root>\n" +
                    "  </Loggers>\n" +
                    "</Configuration>\n" +
                    "\n" +
                    "上述配置文件中配置了一个RollingFile，日志写入logs/app.log文件中，每经过1小时或者当文件大小到达250M时，按照app-2017-08-01 12.log的格式\n" +
                    "对app.log进行重命名并归档，并生成新的文件(app.log)用于写入log。\n" +
                    "\n" +
                    "其中，fileName指定日志文件的位置和文件名称（如果文件或文件所在的目录不存在，会创建文件。）\n" +
                    "\n" +
                    "filePattern指定触发rollover时，文件的重命名规则。filePattern中可以指定类似于SimpleDateFormat中的date/time pattern，如yyyy-MM-dd HH，\n" +
                    "或者%i指定一个整数计数器。\n" +
                    "\n" +
                    "TimeBasedTriggeringPolicy指定了基于时间的触发策略。\n" +
                    "\n" +
                    "SizeBasedTriggeringPolicy指定了基于文件大小的触发策略。\n" +
                    "\n" +
                    "二、TriggeringPolicy\n" +
                    "\n" +
                    "RollingFile的触发rollover的策略有CronTriggeringPolicy(Cron表达式触发)、OnStartupTriggeringPolicy(JVM启动时触发)、\n" +
                    "SizeBasedTriggeringPolicy(基于文件大小)、TimeBasedTriggeringPolicy(基于时间)、CompositeTriggeringPolicy(多个触发策略的混合，如同时基于文件大小和时间)。\n" +
                    "\n" +
                    "其中，SizeBasedTriggeringPolicy(基于日志文件大小)、TimeBasedTriggeringPolicy(基于时间)或同时基于文件大小和时间的混合触发策略最常用。\n" +
                    "\n" +
                    "SizeBasedTriggeringPolicy\n" +
                    "\n" +
                    "SizeBasedTriggeringPolicy规定了当日志文件达到了指定的size时，触发rollover操作。size参数可以用KB、MB、GB等做后缀来指定具体的字节数，如20MB。\n" +
                    "<SizeBasedTriggeringPolicy size=\"20MB\"/>\n" +
                    "\n" +
                    "TimeBasedTriggeringPolicy\n" +
                    "TimeBasedTriggeringPolicy规定了当日志文件名中的date/time pattern不再符合filePattern中的date/time pattern时，触发rollover操作。\n" +
                    "\n" +
                    "比如，<TimeBasedTriggeringPolicy interval=\"1\"/> filePattern指定文件重命名规则为app-%d{yyyy-MM-dd HH}.log，文件名为app-2017-08-25 11.log，\n" +
                    "当时间达到2017年8月25日中午12点（2017-08-25 12），将触发rollover操作。\n" +
                    "\n" +
                    "参数名       类型        描述\n" +
                    "interval    integer     此参数需要与filePattern结合使用，规定了触发rollover的频率，默认值为1。\n" +
                    "                        假设interval为4，若filePattern的date/time pattern的最小时间粒度为小时(如yyyy-MM-dd HH)，则每4小时触发一次rollover；\n" +
                    "                        若filePattern的date/time pattern的最小时间粒度为分钟(如yyyy-MM-dd HH-mm)，则每4分钟触发一次rollover。\n" +
                    "modulate\tboolean     指明是否对interval进行调节，默认为false。\n" +
                    "                        若modulate为true，会以0为开始对interval进行偏移计算。\n" +
                    "                        例如，最小时间粒度为小时，当前为3:00，interval为4，则以后触发rollover的时间依次为4:00，8:00，12:00，16:00,...。\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        // 测试仅有TimeBasedTriggeringPolicy实现日志滚动
        for (int i = 0; i < 10; i++) {
            try {
                logger.info("Time Is {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
                logger.info("111");
                System.out.println("111");
                Thread.sleep(60000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
