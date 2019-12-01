package MyThink;


/*@Controller
@Scope("prototype")  @Scope("Singleton")
public class MyController {
    static int i = 10;
    int j = 10;
    @RequestMapping("/point")
    @ResponseBody
    public String show(){
        return "static i"+--i+"==================="+"j"+--j;
    }
}*/


/*
prototype : 多例，spring在多例模式下，每次请求访问会从新创建(new)对象，此时static变量不会初始化，且所有的对象，都公用一个类变量，但是成员变量会被初始化,打印如下
static i10===================j9
static i9===================j9
static i8===================j9
static i7===================j9
static i6===================j9
static i5===================j9

Singleton :  单例模式下，每次请求都是唯一对象，所以此时的成员变量不会初始化，每次的修改也会保存，静态变量自然也会同时修改保存，因为所有的对象都公用一个静态变量，打印如下：
static i10===================j10
static i9===================j9
static i8===================j8
static i7===================j7
static i6===================j6
static i5===================j5*/






