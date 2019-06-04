
import com.cavin.crud.bean.Department;
import com.cavin.crud.bean.Employee;
import com.cavin.crud.dao.DepartmentMapper;
import com.cavin.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

// @ContextConfiguration注解设定Spring单元测试模块，locations指定Spring配置文件的位置

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private SqlSession batchSqlSession;

    @Test
    public void mapperTest() {
        System.out.println(departmentMapper);

//        插入部门
//        departmentMapper.insertSelective(new Department(null, "开发部"));
//        departmentMapper.insertSelective(new Department(null, "测试部"));

//        插入员工
//        employeeMapper.insertSelective(new Employee(null, "Mary", "F", "Mary@gmail.com", 2));

        // 查询员工
        System.out.println( employeeMapper.selectByPrimaryKeyWithDept(3).getDepartment().getDeptName() );

//        EmployeeMapper mapper = batchSqlSession.getMapper(EmployeeMapper.class);
//        for( int i=0; i<1000; i++ ){
//            String uuid = UUID.randomUUID().toString().substring(0, 5) + i;
//            mapper.insertSelective(new Employee(null, uuid, "M", uuid+"@gmail.com", 1));
//        }
//        System.out.println("批量完成");

    }

}
