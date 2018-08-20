package dreamlv.lvzheng.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import dreamlv.lvzheng.bean.Emp;
import dreamlv.lvzheng.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 以动手实践为荣,以只看不练为耻.
 * 以打印日志为荣,以出错不报为耻.
 * 以局部变量为荣,以全局变量为耻.
 * 以单元测试为荣,以手工测试为耻.
 * 以代码重用为荣,以复制粘贴为耻.
 * 以多态应用为荣,以分支判断为耻.
 * 以定义常量为荣,以魔法数字为耻.
 * 以总结思考为荣,以不求甚解为耻.
 *
 * @author LvZheng
 * 创建时间：lvzheng  2018/8/2
 */
@RestController
public class EmpController {

    @Autowired
    private EmpRepository empRepository;

    @GetMapping("/get")
    public  List<Emp> getemp() {

        // Emp one = empRepository.findOne(1);
      //  Emp one = empRepository.findByNameAndAndEid("令狐冲", 1);
        List<Emp> all = empRepository.findAll();
        return all;
    }


    @GetMapping("/find")
    // @HystrixCommand(fallbackMethod = "getemp")//回掉方法参数必须跟本方法相同  还有启动累加注解
    // 可以做缓存 注解@CacheResult、@CacheRemove和@CacheKey
    public Emp findByNameAndAndSect(@RequestParam("name") String name, @RequestParam("sect") String sect) {
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        final Emp byNameAndAndSect = empRepository.findByNameAndAndSect(name, sect);


        return byNameAndAndSect;
    }
    @PostMapping("/add")
    public  Emp addemp(Emp emp) {
        Emp save = empRepository.save(emp);
        return save;
    }

    @GetMapping("/rest1")
    // @LoadBalanced   ribbon
    public Object rest() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> map = new HashMap<String, String>();
        //   map.put("id",1);
        //map.put("name",2);
        //  "http://localhost:7777/get?name={name}"
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:7777/get", String.class, map);
        String body = forEntity.getBody();
        return body;
    }


}
