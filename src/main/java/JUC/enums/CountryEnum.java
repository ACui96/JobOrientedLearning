package JUC.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Acui
 * @date 2021年09月21日 16:10
 */
@AllArgsConstructor
public enum CountryEnum {
    ONE(1, "齐"),TWO(2, "楚"),THREE(3, "燕"),FOUR(4, "赵"),FIVE(5, "魏"),SIX(6, "韩");


    @Getter
    private Integer retCode;
    @Getter
    private String retMessage;


    public static CountryEnum forEach_CountryEnum(int index) {

        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum countryEnum : myArray) {
            if (index == countryEnum.getRetCode()) {
                return countryEnum;
            }
        }
        return null;
    }


}
