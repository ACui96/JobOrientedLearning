package JavaBasic.Java基础.jicheng;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acui
 * @date 2021年06月18日 15:47
 */
public class SuperClass {
    protected List<Integer> func() throws Throwable {
        return new ArrayList<>();
    }

    public class SubClass extends SuperClass {
        @Override
        public ArrayList<Integer> func() throws Exception {
            return new ArrayList<>();
        }
    }

}
