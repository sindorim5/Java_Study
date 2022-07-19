package com.ssafy.oop3_7.exception.custom;

class MyExceptionTest {
    public static void main(String[] args) {
        int result = 0;
        MyExceptionTest my = new MyExceptionTest();
        for (int i = 0; i < 4; i++) {
            try {
                result = my.calc(2, i);
                System.out.println(i + ") res =" + result);
            } catch (ValueException e) {
                System.out.println(e);
            }
        }
        System.out.println("End of main body");
    }

    public int calc(int x, int y) throws ValueException {
        if ( (x - y) == 0) {
//             ValueException me = new ValueException();
//             throw me;
            throw new ValueException();
        }
        
        int result = (x + y) / (x - y);
        
        return result;
    }
}