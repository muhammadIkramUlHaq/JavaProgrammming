/**
 * Created with IntelliJ IDEA.
 * User: Ikram
 */
public class JavaConvention {

    private int member1;
    private static int member2;
    Integer integer ;
    int array[] =  {1,2,3,4,5,};


    void method1(){
        integer =  new Integer(90);
         member1 = 1;
         member2 = 3;
        integer = 96;
    }

    static void staticMethod2(){
           member2 = 5;
    }


    public static void main(String args[]){
            JavaConvention javaConvention = new JavaConvention();
            javaConvention.method1();
            javaConvention.staticMethod2();
            System.out.print("Value = " + javaConvention.member1);
            System.out.print("Value2 = " + JavaConvention.member2);
           System.out.print("Value3 = " + javaConvention.integer);
        System.out.print("Value4 = " + javaConvention.array.length);

    }
}
