package ex_03.objects;

import org.springframework.stereotype.Component;

@Component
public class SomeService {

    public int getIntValue() {
        return 8;
    }

    public double getDoubleValue() {
        return 7.4;
    }

}