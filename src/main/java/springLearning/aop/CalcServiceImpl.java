package springLearning.aop;

import org.springframework.stereotype.Service;

/**
 * @author Acui
 * @date 2022年05月22日 19:00
 */
@Service
public class CalcServiceImpl implements CalcService{
    @Override
    public int div(int x, int y) {
        int result = x / y;

        System.out.println("             =========> CalcServiceImpl 被调用了，计算结果为："  + result);

        return result;
    }
}
