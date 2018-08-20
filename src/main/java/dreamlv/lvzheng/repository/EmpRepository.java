package dreamlv.lvzheng.repository;

import dreamlv.lvzheng.bean.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* @author LvZheng
* 创建时间：2018年2月2日 下午3:26:45
*/
public interface EmpRepository extends JpaRepository<Emp, Integer>{
    Emp findByNameAndAndEid(String name,Integer eid);

    Emp findByNameAndAndSect(String name,String sect);
}
