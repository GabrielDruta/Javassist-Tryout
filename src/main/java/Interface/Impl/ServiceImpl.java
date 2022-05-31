package Interface.Impl;

import Interface.Service;

public class ServiceImpl implements Service {


    @Override
    public String sumOfTwoNumbers(int a, int b) {

        return Integer.toString(a+b+x);
        //System.out.println(a+b);
    }

    private int x=1;
}
