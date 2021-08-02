package kr.seok.item62;

import java.util.Map;
import java.util.WeakHashMap;

import static java.lang.Integer.parseInt;

public class InputInterface {

    /**
     * 정수형 타입 데이터를 입력 받는 경우
     *
     * @param input the input
     * @return
     */
    public int inputInteger(String input) {
        int tmpData = 0;
        try {
            tmpData = parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return tmpData;
    }

    /**
     * Input short short.
     *
     * @param shortData the short data
     * @return the short
     */
    public short inputShort(String shortData) {
        short tmpData = 0;
        try {
            tmpData = Short.parseShort(shortData);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return tmpData;
    }

    /**
     * Input double double.
     *
     * @param doubleData the double data
     * @return the double
     */
    public double inputDouble(String doubleData) {
        double tmpData = 0;
        try {
            tmpData = Double.parseDouble(doubleData);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return tmpData;
    }


    /**
     * Input enum type.
     *
     * @param inputData the input data
     * @return the type
     */
    public Type inputEnum(int inputData) {
        return Type.findByField(inputData);
    }

    enum Type {
        A(1682489),
        B(1688213),
        ETC(0);

        static final Map<Integer, Type> data = new WeakHashMap<>();

        static {
            data.put(1682489, Type.A);
            data.put(1688213, Type.B);
        }

        private int field;

        Type(int field) {
            this.field = field;
        }

        public static Type findByField(int fieldNm) {
            return data.getOrDefault(fieldNm, ETC);
        }
    }
}
