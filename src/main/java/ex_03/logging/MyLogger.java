package ex_03.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
@Component
@Aspect
public class MyLogger {
    private static long time;
    private static Set<String> set;
    private static Map<String, Integer> map;

    public MyLogger() {
    }

    public MyLogger(long time, Set<String> set, Map<String, Integer> map) {
        MyLogger.time = time;
        MyLogger.set = set;
        MyLogger.map = map;
    }

    public static long getTime() {
        return time;
    }

    public static Set<String> getSet() {
        return set;
    }


    public static Map<String, Integer> getMap() {
        return map;
    }


    @Pointcut("@annotation(ex_03.annotations.ShowTime)")
    private void showTime() {
    }

    @Pointcut("@annotation(ex_03.annotations.ShowTime)")
    private void showResult() {
    }

    @Around("showTime()")
    public Object watchTime(ProceedingJoinPoint joinpoint) {
        long start = System.currentTimeMillis();
        Object output = null;
        try {
            output = joinpoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        time = System.currentTimeMillis() - start;
        return output;
    }

    @AfterReturning(pointcut = "showResult()", returning = "obj")
    public void print(Object obj) {
        if (obj instanceof Set) {
            set = (Set) obj;
        } else if (obj instanceof Map) {
            map = (Map) obj;
        }
    }

}
