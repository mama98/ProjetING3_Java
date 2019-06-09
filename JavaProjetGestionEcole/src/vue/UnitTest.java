/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.util.logging.Logger;

/**
 *
 * @author Marine 
 */
public class UnitTest{

/**
 * How to use :
 *
 * Let's say you have a function that returns twice the value of the param
 *
 * Create a new testing function and instanciate UnitTest inside :

 public void test_my_func(){
    UnitTest my_test("test_my_func()");

    my_test.assert_int(my_func(12), 24);
    my_test.assert_int(my_func(0), 0);
    my_test.assert_double(my_func(5.6), 11.2);
    my_test.assert_int(my_func(-1), -2);

    my_test.success();
}

 * If one assertion fails, the program exits and shows what went wrong.
 */
    private String alert_msg;

    /**
     *
     */
    public UnitTest(){
        alert_msg = null;
    }

    /**
     *
     * @param alert_msg
     */
    public UnitTest(String alert_msg){
        this.alert_msg = alert_msg;
    }

    /**
     *
     */
    public void success(){
        System.out.println("Test passed : " + this.alert_msg);
    }

    /**
     *
     */
    public void error(){
        System.out.println("TEST FAILED : " + this.alert_msg);
        System.exit(1);
    }

    /**
     *
     * @param left
     * @param right
     */
    public void assert_int(int left, int right){
        if (left != right)
            error();
    }

    /**
     *
     * @param left
     * @param right
     */
    public void assert_char(char left, char right){
        if (left != right)
            error();
    }

    /**
     *
     * @param left
     * @param right
     */
    public void assert_boolean(boolean left, boolean right){
        if (left != right)
            error();
    }

    /**
     *
     * @param left
     * @param right
     */
    public void assert_double(double left, double right){
        if (left != right)
            error();
    }

    /**
     *
     * @param left
     * @param right
     */
    public void assert_String(String left, String right){
        if (!left.equals(right))
            error();
    }
}
