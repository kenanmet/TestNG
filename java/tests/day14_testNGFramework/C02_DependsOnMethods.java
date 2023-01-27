package tests.day14_testNGFramework;

import org.testng.annotations.Test;

public class C02_DependsOnMethods {

    @Test
    public void test01(){
        System.out.println("1.test calisti");
    }

    @Test(dependsOnMethods = "test01")
    public void test02(){
        System.out.println("2.test calisti");
    }

    @Test(dependsOnMethods = "test02")
    public void test03(){
        System.out.println("3.test calisti");
    }
}
