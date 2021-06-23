package JavaBasic.Java基础.Object通用方法;

/**
 * @author Acui
 * @date 2021年06月18日 10:42
 */
public class CloneExample implements Cloneable{
    private int a;
    private int b;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        CloneExample e1 = new CloneExample();
//        CloneExample e2 = e1.clone();

        try {
            CloneExample e2 = (CloneExample) e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
