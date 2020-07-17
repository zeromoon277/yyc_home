package learn.yyc.test.demo.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/16 0016 下午 15:24
 */
public class CglibProxyFactory implements MethodInterceptor {
    //得到目标对象
    private Object target;

    //使用构造方法传递目标对象
    public CglibProxyFactory(Object target) {
        super();
        this.target = target;
    }

    //创建代理对象
    public Object createProxy(){
        //1.创建Enhancer
        Enhancer enhancer = new Enhancer();
        //2.传递目标对象的class
        enhancer.setSuperclass(target.getClass());
        //3.设置回调操作
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("这是增强方法前......");
        Object invoke = methodProxy.invoke(target, objects);
        System.out.println("这是增强方法后......");
        return invoke;
    }

    public static void main(String[] args) {
        // 1.创建对象
        FoodServiceImpl foodService = new FoodServiceImpl();
        // 2.创建代理对象
        CglibProxyFactory proxy = new CglibProxyFactory(foodService);
        // 3.调用代理对象的增强方法,得到增强后的对象
        FoodService createProxy = (FoodService) proxy.createProxy();
        createProxy.makeChicken();
    }
}
