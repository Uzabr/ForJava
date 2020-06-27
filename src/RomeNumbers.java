import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomeNumbers {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), XIX(9), X(10);

    private int numbers;
    RomeNumbers(int numbers){
        this.numbers = numbers;
    }
    public int getNumbers(){
        return numbers;
    }
    

}
