# web基础

![image-20250902093056139](assets/image-20250902093056139.png)

![image-20250902093236889](assets/image-20250902093236889.png)

## SpringBoot Web入门

### Spring

官网：spring.io
Spring发展到今天已经形成了一种开发生态圈，Spring提供了若干个子项目，每个项目用于完成特定的功能。

![image-20250902100143232](assets/image-20250902100143232.png)

![image-20250902100224940](assets/image-20250902100224940.png)

![image-20250902100302733](assets/image-20250902100302733.png)

Spring Boot可以帮助我们非常快速的构建应用程序、简化开发、提高效率。

入门程序
•需求：基于SpringBoot开发一个Web应用，浏览器发起请求/hel1o之后，给浏览器返回一个字符串"Hello Xxx"。

**入门程序剖析**
• 为什么一个main方法就将web应用启动了？

![image-20250902130134075](assets/image-20250902130134075.png)

![image-20250902130554189](assets/image-20250902130554189.png)

![image-20250902130618426](assets/image-20250902130618426.png)



## HTTP协议

概念：Hyper Text Transfer Protocol，超文本传输协议，规定了浏览器和服务器之间数据传输的规则。

![image-20250902130920099](assets/image-20250902130920099.png)

特点：
1.基于TCP协议：面向连接，安全

2.基于请求-响应模型的：一次请求对应一次响应

3.HTTP协议是无状态的协议：对于事务处理没有记忆能力。每次请求-响应都是独立的。
缺点：多次请求间不能共享数据。
优点：速度快

### HTTP-请求协议

![image-20250902143449319](assets/image-20250902143449319.png)

![image-20250902143631686](assets/image-20250902143631686.png)

![image-20250902143711033](assets/image-20250902143711033.png)

![image-20250902143747947](assets/image-20250902143747947.png)

Web服务器（Tomcat）对HTTP协议的请求数据进行解析，并进行了封装（HttpServletRequest），在调用Controller方法的时候传递给了该方法。这样，就使得程序员不必直接对协议进行操作，让Web开发更加便捷。

![image-20250902144417567](assets/image-20250902144417567.png)

1．HTTP请求数据需要程序员自己解析吗？
• 不需要，web服务器负责对HTTP请求数据进行解析，并封装为了请求对象
2．如何获取请求数据？
• HttpServletRequest对象里面封装了所有的请求信息



### HTTP-响应协议

响应数据格式

![image-20250902155701584](assets/image-20250902155701584.png)

![image-20250902155756690](assets/image-20250902155756690.png)

![image-20250902160050182](assets/image-20250902160050182.png)



<img src="assets/image-20250902160517954.png" alt="image-20250902160517954" style="zoom:50%;" />

1. HTTP响应数据分为几个部分？
• 响应行、响应头、响应体
1.  响应状态码的分类？
• 1XX：响应中，临时状态码
• 2XX：成功
• 3XX：重定向
• 4XX：客户端错误
• 5XX：服务端错误



HTTP协议-响应数据设置
• Web服务器对HTTP协议的响应数据进行了封装（HttpServletResponse），并在调用Controller方法的时候传递给了该方法。这样，就使得程序员不必直接对协议进行操作，让Web开发更加便捷。

![image-20250902161013167](assets/image-20250902161013167.png)

![image-20250902192525080](assets/image-20250902192525080.png)

![image-20250902192947964](assets/image-20250902192947964.png)

但是值得注意的是，响应状态码 和 响应头如果没有特殊要求的话，通常不手动设定。服务器会根据请求处理的逻辑，自动设置响应状态码和响应头。



开发**web**程序，**完成用户列表的渲染展示**

1．准备工作：
• 创建一个SpringBoot工程，并勾选web依赖、lombok。
• 引入资料中准备好的用户数据文件（user.txt），及前端静态页面。
• 定义一个实体类，用来封装用户信息

2．开发服务端程序，接收请求，读取文本数据并响应。

![image-20250902201023213](assets/image-20250902201023213.png)



## SpringBoot Web案例



















## 分层解耦

![image-20250903151059195](assets/image-20250903151059195.png)

![image-20250903154625579](assets/image-20250903154625579.png)

![image-20250903155112784](assets/image-20250903155112784.png)

![image-20250903155548600](assets/image-20250903155548600.png)

1．实现分层解耦的思路是什么？
• 将项目中的类交给IOC容器管理（IOC，控制反转）
• 应用程序运行时需要什么对象，直接依赖容器为其提供（DI，依赖注入）

![image-20250903160000972](assets/image-20250903160000972.png)

1.将Dao 及 Service层的实现类，交给IOC容器管理。
2.为Controller 及 Service注入运行时所依赖的对象。

![image-20250903160144357](assets/image-20250903160144357.png)

@Component注解：表明进入IOC容器

@Autowired注解：实现自动导入



1.如何将一个类交给IOC容器管理？
 @Component（注意：是加在实现类上，而非接口上）

2.如何从IOC容器中找到该类型的bean，然后完成依赖注入？
@Autowired

![image-20250903161415913](assets/image-20250903161415913.png)

为了更好的分别三层架构，于是开发者在component的基础上，又封装了三个衍生类专门用来对，controller，service，dao进行使用，component就可以用在那些工具类等其他类上了

![image-20250903162335142](assets/image-20250903162335142.png)



前面声明bean的四大注解，要想生效，还需要被组件扫描注解@ComponentScan扫描。
**该注解虽然没有显式配置，但是实际上已经包含在了启动类声明注解 @SpringBootApplication 中，默认扫描的范围是启动类所在包及其子包。**

![image-20250903164708240](assets/image-20250903164708240.png)



1．声明bean的注解有哪几个？
@Controller
@Service
@Repository
@Component
2.注意事项
在Springboot集成web开发中，声明控制器bean只能用@Controller。
声明bean的注解要想生效，需要被扫描到，启动类默认扫描当前包及其子包。

![image-20250903165544438](assets/image-20250903165544438.png)

![image-20250903191844514](assets/image-20250903191844514.png)



@Autowired注解，默认是按照类型进行注入的。

如果存在多个相同类型的bean，将会报出如下错误：

![image-20250903192237611](assets/image-20250903192237611.png)

![image-20250903192429751](assets/image-20250903192429751.png)

1.依赖注入的注解
• @Autowired：默认按照类型自动装配
• 如果同类型的bean存在多个：
@Primary
@Autowired + @Qualifier
@Resource
2.@Resource与@Autowired区别？
• @Autowired是Spring框架提供的注解，而eResource是JavaEE规范提供的
• @Autowired默认是按照类型注入，而@Resource默认是按照名称注入



# 数据库

什么是数据库？
• 数据库：DataBase（DB），是存储和管理数据的仓库。

数据库管理系统：DataBase Management System（DBMS），操纵和管理数据库的大型软件。
SQL：structured Query Language，操作关系型数据库的编程语言，定义了一套操作关系型数据库统一标准。

![image-20250903193544869](assets/image-20250903193544869.png)

## MySQL概述

（之前安装好了这里直接跳过）

关系型数据库：建立在关系模型基础上，由多张相互连接的二维表组成的数据库。

特点：
• 使用表存储数据，格式统一，便于维护。
• 使用SQL语言操作，标准统一，使用方便，可用于复杂查询。

![image-20250903194451311](assets/image-20250903194451311.png)

![image-20250903194648989](assets/image-20250903194648989.png)

![image-20250903201422217](assets/image-20250903201422217.png)

SQL语句
DDL

![image-20250903211902535](assets/image-20250903211902535.png)

![image-20250903212427969](assets/image-20250903212427969.png)

<img src="assets/image-20250903212819932.png" alt="image-20250903212819932" style="zoom:50%;" />

![image-20250903212951428](assets/image-20250903212951428.png)

DML





DQL

















## SQL语句

#### DDL

![image-20250904084026373](assets/image-20250904084026373.png)

```sql
-— 创建表
create table user(
id int comment'ID,唯一标识',
username varchar(50) comment'用户名',
name varchar(10) comment'姓名',
age int comment'年龄',
gender char(1) comment'性别',
) comment'用户信息表'；

```

DDL-表结构-创建
• 约束：约束是作用于表中字段上的规则，用于限制存储在表中的数据。
• 目的：保证数据库中数据的正确性、有效性和完整性。

![image-20250904085731820](assets/image-20250904085731820.png)

![image-20250904085740464](assets/image-20250904085740464.png)

修改之后：

![image-20250904090113132](assets/image-20250904090113132.png)

![image-20250904090644892](assets/image-20250904090644892.png)

•数据类型
MySQL中的数据类型有很多，主要分为三类：数值类型、字符串类型、日期时间类型。

![image-20250904091052555](assets/image-20250904091052555.png)

![image-20250904092341431](assets/image-20250904092341431.png)

![image-20250904092500236](assets/image-20250904092500236.png)

1.数值类型在定义的时候，后面加了unsigned关键字是什么意思？
• unsigned表示无符号类型，表示只能取0及正数
• 不加默认是signed，表示可以取负数

2.char与varchar的区别是什么？什么时候用char，什么时候用varchar？
• char是定长字符串，varchar是变长字符串
• 如果一个字段的长度是固定的，建议使用char；如：身份证号、手机号
• 如果一个字段的长度不是固定的，建议使用varchar；如：用户名、姓名

**根据页面原型，设计员工表**

1.阅读并分析页面原型及需求

2.分析表中包含哪些字段，以及字段的类型、约束

3.创建表结构

![image-20250904092714802](assets/image-20250904092714802.png)

表结构的查询、修改、删除相关语法如下：

![image-20250904093035669](assets/image-20250904093035669.png)

注意：在删除表时，表中的全部数据也会被删除。

#### DML

DML英文全称是Data Manipulation Language（数据操作语言），用来对数据库中表的数据记录进行增、删、改操作。

添加数据（INSERT）
修改数据（UPDATE）
删除数据（DELETE）

![image-20250904104947871](assets/image-20250904104947871.png)

![image-20250904104957731](assets/image-20250904104957731.png)

![image-20250904105215435](assets/image-20250904105215435.png)

![image-20250904105454673](assets/image-20250904105454673.png)

<img src="assets/image-20250904105538155.png" alt="image-20250904105538155" style="zoom:50%;" />

![image-20250904105547669](assets/image-20250904105547669.png)



#### DQL

DQL英文全称是Data Query Language（数据查询语言），用来查询数据库表中的记录。
关键字：SELECT

完整的DQL语句语法：

```sql
select
			字段列表
from
			表名列表
where
			条件列表
group by
			分组字段列表
having
			分组后条件列表
order by
			排序字段列表
limit
			分页参数
```

<img src="assets/image-20250904111451046.png" alt="image-20250904111451046" style="zoom:50%;" />

![image-20250904114020986](assets/image-20250904114020986.png)

<img src="assets/image-20250904114108807.png" alt="image-20250904114108807" style="zoom:50%;" />

![image-20250904152314678](assets/image-20250904152314678.png)

Eg: 查询 姓‘李'的员工信息
select * from emp where name like '李%'；

查询 姓名中包含‘二'的员工信息
select * from emp where name like '%二%'；

**分组查询**

<img src="assets/image-20250904155349981.png" alt="image-20250904155349981" style="zoom:50%;" />

![image-20250904155758623](assets/image-20250904155758623.png)



分组查询：

select 字段列表 from 表名［where 条件列表］group by 分组字段名［having 分组后过滤条件］；

where与having的区别：
1．执行时机不同：where是分组之前进行过滤，不满足where条件，不参与分组；而having是分组之后对结果进行过滤。
2． 判断条件不同：where不能对聚合函数进行判断，而having可以。

![image-20250904160117908](assets/image-20250904160117908.png)

![image-20250904160333882](assets/image-20250904160333882.png)

![image-20250904160354389](assets/image-20250904160354389.png)

1. DQL语句中where与having的区别？
• 执行时机不同（where -> group by -> having）
• 判断条件不同（having后可以用聚合函数，where不可以）



select 字段列表 from 表名［where 条件列表］［group by 分组字段名 having 分组后过滤条件］order by 排序字段 排序方式；

排序方式：升序（asc），降序（desc）；默认为升序asc，是可以不写的。

![image-20250904163357120](assets/image-20250904163357120.png)

1.下面排序查询的语法分别代表什么意思？
order by age；
order by age desc, score asc；
order by age,score,update_time desc；

**分页查询**

select 字段 from 表名［where 条件］［group by 分组字段 having 过滤条件］［order by 排序字段］limit 起始索引，查询记录数；

1.DQL语句中的分页查询
• 语法：limit 起始索引，每页展示记录数
• 注意：项目开发中，前端传递过来的是页码，需要转换为起始索引
• 公式：（页码-1）* 每页展记录数



## 多表设计



## 多表查询



## 事务



# JDBC

![image-20250904171434005](assets/image-20250904171434005.png)

JDBC：（Java DataBase Connectivity），就是使用Java语言操作关系型数据库的一套API。
![image-20250904171712337](assets/image-20250904171712337.png)

•本质：
• sun公司官方定义的一套操作所有关系型数据库的规范，即接口。
• 各个数据库厂商去实现这套接口，提供数据库驱动jar包。
• 我们可以使用这套接口（JDBC）编程，真正执行的代码是驱动jar包中的实现类。

**入门程序**

需求：基于JDBC程序，执行update语句（update user set age = 25 where id = 1）

步骤：
• 准备工作：创建一个maven项目，引入依赖；并准备数据库表user。
• 代码实现：编写JDBC程序，操作数据库。

![image-20250904171916571](assets/image-20250904171916571.png)

![image-20250905090030701](assets/image-20250905090030701.png)

JDBC-查询数据

![image-20250905090227525](assets/image-20250905090227525.png)



需求：基于JDBC执行如下select语句，将查询结果封装到User对象中。
SQL: select * from user where username = 'daqiao' and password = '123456'
ResultSet（结果集对象）：ResultSet rs = statement .executeQuery（）
• next（）：将光标从当前位置向前移动一行，并判断当前行是否为有效行，返回值为boolean。
• true：有效行，当前行有数据
• false：无效行，当前行没有数据
• getXxx（..）：获取数据，可以根据列的编号获取，也可以根据列名获取（推荐）。

**预编译sql**

![image-20250905102103592](assets/image-20250905102103592.png)

预编译：

优势一：可以防止SQL注入，更安全
SQL注入：通过控制输入来修改事先定义好的SQL语句，以达到执行代码对服务器进行攻击的方法。

<img src="assets/image-20250905103213695.png" alt="image-20250905103213695" style="zoom:50%;" />

![image-20250905103223600](assets/image-20250905103223600.png)



