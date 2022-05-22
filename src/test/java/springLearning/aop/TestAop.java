package springLearning.aop;

import org.junit.Test; // spring4 用的junit
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Acui
 * @date 2022年05月22日 19:29
 */
@SpringBootTest // 相当于一个 Controller
@RunWith(SpringRunner.class)
public class TestAop {
    @Resource // 或用 Autowired
    private CalcService calcService;

    @Test
    public void testAop4() {
        System.out.println("正常情况");
        System.out.println("spring版本"+ SpringVersion.getVersion() + "\t" + "SpringBoot版本"+ SpringBootVersion.getVersion());
        System.out.println();
        calcService.div(10, 2);
    }

    @Test
    public void testAop4WithException() {
        System.out.println("testAop4WithException");
        System.out.println("spring版本"+ SpringVersion.getVersion() + "\t" + "SpringBoot版本"+ SpringBootVersion.getVersion());
        System.out.println();
        calcService.div(10, 0);
    }
}
