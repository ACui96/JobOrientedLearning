package Interview;

import java.util.*;

/**
 * @author Acui
 * @date 2022年05月11日 20:07
 */
public class Baidu20220511 {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>(40);
        for (int i = 0; i < 40; i++) {
            if (i < 30) {
                cars.add(new Car(true));
            } else {
                cars.add(new Car(false));
            }
        }
        Collections.shuffle(cars);
        // 总的 车辆队列
        Queue<Car> queue_all = new ArrayDeque<>();
        for (Car car : cars) {
            queue_all.add(car);
        }


        Lane etc0 = new Lane(0);
        Lane etc1 = new Lane(0);
        Lane etc2 = new Lane(0);
        Lane mix3 = new Lane(1);
        Lane manual4 = new Lane(2);



    }

}

class Lane {

    int kind; // 种类 0: etc 1: mix 2: manual
    int[] processTime; // 处理时间  [min, max]

    public Lane(int kind) {
        this.kind = kind;
        if (kind == 0) {
            this.processTime = new int[]{10, 15};
        } else if (kind == 2) {
            this.processTime = new int[]{15, 25};
        } else if (kind == 1) {
            //TODO 混合时间应是多少
            this.processTime = new int[]{10, 15, 15, 25};
        }
    }
}
class Car {
    private boolean isEtc;
    private int[] processTime;

    public Car(boolean isEtc) {
        this.isEtc = isEtc;
        if (isEtc) {
            this.processTime = new int[]{10, 15};
        } else {
            this.processTime = new int[]{15, 25};
        }
    }
}
