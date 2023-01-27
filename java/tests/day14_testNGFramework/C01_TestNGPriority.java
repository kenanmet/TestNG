package tests.day14_testNGFramework;

import org.testng.annotations.Test;

public class C01_TestNGPriority {
    // 1- Priority kucukden buyuge dogru calisir.
    // 2- Priority verilmeyen test method’unun priority degeri 0 olarak kabul edilir.
    // 3- Esit priority degerine sahip olan test method’lari isim sirasina gore calisir.

    @Test(priority = 2)
    public void test01(){
        System.out.println("1.test calisti");
    }

    @Test(priority = 1)
    public void test02(){
        System.out.println("2.test calisti");
    }

    @Test(priority = 3)
    public void test03(){
        System.out.println("3.test calisti");
    }
}
