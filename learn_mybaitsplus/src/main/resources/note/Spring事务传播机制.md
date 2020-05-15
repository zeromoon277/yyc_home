1，Propagation.REQUIRED
如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。详细解释在代码下方。

看下代码
员工service

    @Service
    public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentService departmentService;

    /**
     * 添加员工的同时添加部门
     * REQUIRED 传播
     * @param name 员工姓名
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addEmpByRequired(String name) {
        Employee employee = new Employee();
        employee.setDeptId(1);
        employee.setName(name);
        employee.setAddress("邯郸");
        employeeMapper.insertSelective(employee);
        departmentService.addDept("jishubu");
        int i = 1/0;
        }
    }

部门service

    @Service
    public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public void addDeptByRequired(String name) {
        Department department = new Department();
        department.setName(name);
        departmentMapper.insertSelective(department);
    //        int i = 1/0;
        }
    }
注：该篇文章所测试的皆是运行addEmpByRequired方法。
1，上述代码中，无论int i =1/0 这个异常出现在哪里，添加员工和添加部门都会回滚。
因为 REQUIRED 会让添加员工和添加部门变为一个事务。,
2，值得一提的是，如果异常在addDept中，但是在addEmpByRequired把 addDept方法 try，catch了，则会抛出异常：Transaction rolled back because it has been marked as rollback-only 。
3，如果在addDeptByRequired上添加@Transactional(propagation = Propagation.REQUIRED)，在addEmpByRequired不添加事务，则addDeptByRequired是一个事务，addEmpByRequired并不是一个事务。因为addDeptByRequired开启了一个事务，但是addEmpByRequired并不存在一个事务中。

2，Propagation.SUPPORTS
支持当前事务，如果当前没有事务，就以非事务方式执行。

员工service

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addEmpBySupports(String name) {
        Employee employee = new Employee();
        employee.setDeptId(2);
        employee.setName(name);
        employee.setAddress("邯郸");
        employeeMapper.insertSelective(employee);
        departmentService.addDeptBySupports("jishubu");
    //        int i = 1/0;
        }
部门Service

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void addDeptBySupports(String name) {
        Department department = new Department();
        department.setName(name);
        departmentMapper.insertSelective(department);
        int i = 1/0;
    }
关于这个属性，在以上代码中，主要是添加到addDeptBySupports上的，也就是被调用方法上。因为添加到addEmpBySupports就不以事务的方式运行了。
然后，如果addEmpBySupports为事务，则addDeptBySupports也为事务。如果addEmpBySupports不是事务，则addDeptBySupports也不是事务。

3，Propagation.MANDATORY
使用当前的事务，如果当前没有事务，就抛出异常。

员工Service

    @Override
    //    @Transactional(propagation = Propagation.REQUIRED)
    public void addEmpByMandatory(String name) {
        System.out.println("aaaaaa");
        Employee employee = new Employee();
        employee.setDeptId(3);
        employee.setName(name);
        employee.setAddress("邯郸");
        employeeMapper.insertSelective(employee);
        departmentService.addDeptByMandatory("jishubu");
        int i = 1/0;
    }
部门Service

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addDeptByMandatory(String name) {
        Department department = new Department();
        department.setName(name);
        departmentMapper.insertSelective(department);
        int i = 1/0;
    }
这个属性也是添加到addDeptByMandatory（被调用者） 上的。如果添加到addEmpByMandatory（调用者）上，则直接抛出异常。
该属性添加到addDeptByMandatory上， 如果addEmpByMandatory有事务，则addDeptByMandatory加入到addEmpByMandatory的事务中，如果addEmpByMandatory没有事务，则直接抛出异常。

4，Propagation.REQUIRES_NEW
员工Service

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addEmpByRequiresNew(String name) {
        Employee employee = new Employee();
        employee.setDeptId(4);
        employee.setName(name);
        employee.setAddress("邯郸");
        employeeMapper.insertSelective(employee);
        departmentService.addDeptByRequiresNew("jishubu");
        int i = 1/0;
    }
部门Service

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addDeptByRequiresNew(String name) {
        Department department = new Department();
        department.setName(name);
        departmentMapper.insertSelective(department);
    //        int i = 1/0;
        }
这个属性应该是除了REQUIRED用的最多的。这个属性也是针对被调用者的（addDeptByRequiresNew）。
不管调用者（addEmpByRequiresNew）是否存在事务，被调用者（addDeptByRequiresNew）都会新开一个事务，相当于被调用者都存在于自己的事务中和调用者没有关系。
如上述代码，addEmpByRequiresNew会回滚，但addDeptByRequiresNew不会回滚。因为他们是两个事务。

5，Propagation.NOT_SUPPORTED
以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。

员工Service

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addEmpByNotSupported(String name) {
        Employee employee = new Employee();
        employee.setDeptId(5);
        employee.setName(name);
        employee.setAddress("邯郸");
        employeeMapper.insertSelective(employee);
        departmentService.addDeptByNotSupported("jishubu");
        int i = 1/0;
    }
部门Service

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addDeptByNotSupported(String name) {
        Department department = new Department();
        department.setName(name);
        departmentMapper.insertSelective(department);
        int i = 1/0;
    }
这个属性如果放在调用者（addEmpByNotSupported）上，则是以非事务方式运行。
如果放在被调用者（addDeptByNotSupported）上，该方法（addDeptByNotSupported）以非事务运行，调用者如果有事务，则运行单独的事务（挂起）。
上述代码，会出现添加员工回滚，添加部门不回滚。

6，Propagation.NEVER
以非事务方式执行，如果当前存在事务，则抛出异常。

员工Service

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addEmpByNever(String name) {
        Employee employee = new Employee();
        employee.setDeptId(6);
        employee.setName(name);
        employee.setAddress("邯郸");
        employeeMapper.insertSelective(employee);
        departmentService.addDeptByNever("jishubu");
        int i = 1/0;
    }
部门Service

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public void addDeptByNever(String name) {
        Department department = new Department();
        department.setName(name);
        departmentMapper.insertSelective(department);
        int i = 1/0;
    }
这个属性如果在调用者上，则直接以非事务运行。如果作用在被调用者上，则看调用者是否有事务，如果调用者有事务，则抛出异常，如果没有事务，则以非事务运行。
上述代码中，则会抛出异常。（并不是除0异常，而是：Existing transaction found for transaction marked with propagation 'never'）

7，Propagation.NESTED
如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
（这个和REQUIRED区别在于一个是加入到一个事务，一个是在嵌套事务运行）

员工Service

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addEmpByNested(String name) {
        Employee employee = new Employee();
        employee.setDeptId(7);
        employee.setName(name);
        employee.setAddress("邯郸");
        employeeMapper.insertSelective(employee);
        try {

            departmentService.addDeptByNested("jishubu");
        }catch (Exception e){

        }
    //        int i = 1/0;
        }
部门Service

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void addDeptByNested(String name) {
        Department department = new Department();
        department.setName(name);
        departmentMapper.insertSelective(department);
        int i = 1/0;
    }
可以这么理解，大多数情况下，效果和REQUIRED一样。但是有一种情况，就是上述代码中，被调用者事务传播属性为NESTED，当出现异常时， 调用者把departmentService try，catch了。这个区别与REQUIRED的并不会报错，而且addEmpByNested方法不会回滚，只有addDeptByNested回滚了。
大概原理：当被调用者使用PROPAGATION_NESTED时，底层的数据源必须基于JDBC 3.0，并且实现者需要支持保存点事务机制。按上述代码来说（去掉try，catch），当执行到addDeptByNested这个方法时，Spring会为它创建一个内部的嵌套事务，如果addDeptByNested执行失败，则事务回滚到addDeptByNested之前的点，此时如果不抛异常，则不会回滚。这个嵌套事务，是addEmpByNested的一部分，只有外层事务提交了，内层的嵌套事务才会一起提交，这也是与REQUIRED（加入事务），REQUIRES_NEW（开启新事务）的区别。
还值得一提的是，NESTED是嵌套的意思，其实并不是只有NESTED用于嵌套，只要理解上述7个传播机制的意思，都可以嵌套用。
