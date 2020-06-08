//import com.yyc.learn.StartMain;
//import com.yyc.learn.business.order.entity.Order;
//import com.yyc.learn.business.order.service.OrderService;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * @author yyc
// * @version 1.0
// * @date 2020/5/26 0026 下午 18:39
// */
//public class OrderServiceImplTest extends StartMain {
//
//    @Autowired
//    private OrderService orderService;
//    @Test
//    public void testSave(){
//        for (int i = 0 ; i< 100 ; i++){
//            Order order = new Order();
//            order.setName("电脑"+i);
//            order.setType("办公");
//            orderService.save(order);
//        }
//    }
//    @Test
//    public void testGetById(){
//        long id = 1184489163202789377L;
//        Order order  = orderService.getById(id);
//        System.out.println(order.toString());
//    }
//}
