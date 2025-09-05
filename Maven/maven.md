# Maven

什么是Maven
• Maven是一款用于管理和构建Java项目的工具，是apache旗下的一个开源项目。

<img src="assets/image-20250901080941101.png" alt="image-20250901080941101" style="zoom:50%;" />

![image-20250901081016426](assets/image-20250901081016426.png)

依赖管理

<img src="assets/image-20250901081125691.png" alt="image-20250901081125691" style="zoom:50%;" />

项目构建

![image-20250901090326383](assets/image-20250901090326383.png)

统一项目结构

<img src="assets/image-20250901090659310.png" alt="image-20250901090659310" style="zoom:50%;" />

<img src="assets/image-20250901090824571.png" alt="image-20250901090824571" style="zoom:50%;" />

## Maven核心

### Maven概述

• Apache Maven 是一个项目管理和构建工具，它基于项目对象模型（POM-project object model）的概念，通过一小段描述信息来管理项目的构建。
• 作用：
＞方便的依赖管理
＞标准的项目构建流程
＞统一的项目结构
• 官网：http://maven.apache.org/

![image-20250901092250162](assets/image-20250901092250162.png)

![image-20250901093013220](assets/image-20250901093013220.png)

1．Maven中的仓库用来存储什么的？
• Maven的仓库是用来存储和管理jar包的

2. Maven中有哪几类仓库？查找依赖（jar）的顺序是什么样的？
   • 本地仓库（1）
   • 远程仓库（2）
   • 中央仓库（3）

maven的安装（我之前装过了，这里就记录视频，不实践）

<img src="assets/image-20250901093315978.png" alt="image-20250901093315978" style="zoom:50%;" />



### IDEA集成Maven

**创建Maven项目**

**Maven坐标**

什么是坐标？
> Maven 中的坐标是资源（jar）的唯一标识，通过该坐标可以唯一定位资源位置。
> 使用坐标来定义项目或引入项目中需要的依赖。
>
> ![image-20250901101653976](assets/image-20250901101653976.png)

1. Maven的坐标由哪几个部分组成？各部分的含义是什么？
• groupId： 组织名称（通常为域名反写）
• artifactId： 模块名称
• version：版本号
2. Maven项目的版本分类？
• SNAPSHOT：功能不稳定、尚处于开发中的版本，即快照版本
• RELEASE：功能趋于稳定、当前更新停止，可以用于发行的版本

导入Maven项目

![image-20250901105025083](assets/image-20250901105025083.png)

**• 依赖管理**

• 依赖：指当前项目运行所需要的jar包，一个项目中可以引入多个依赖。
•配置：
1.pom.xml 中编写 <dependencies>标签
2.在<dependencies>标签中 使用 <dependency>引入坐标
3.定义坐标的 groupId,artifactId, version
4．点击刷新按钮，引入最新加入的坐标

<img src="assets/image-20250901105626838.png" alt="image-20250901105626838" style="zoom:50%;" />

![image-20250901105813249](assets/image-20250901105813249.png)

**排除依赖**
• 排除依赖：指主动断开依赖的资源，被排除的资源无需指定版本。

![image-20250901110213881](assets/image-20250901110213881.png)

<img src="assets/image-20250901133344337.png" alt="image-20250901133344337" style="zoom:50%;" />

**生命周期**

Maven的生命周期就是为了对所有的maven项目构建过程进行抽象和统一。

Maven中有3套相互独立的生命周期：
• clean：清理工作。
• default：核心工作，如：编译、测试、打包、安装、部署等。
• site：生成报告、发布站点等。

<img src="assets/image-20250901133627320.png" alt="image-20250901133627320" style="zoom:50%;" />

![image-20250901133656583](assets/image-20250901133656583.png)



• clean：移除上一次构建生成的文件
• compile：编译项目源代码
• test：使用合适的单元测试框架运行测试（junit）
• package：将编译后的文件打包，如：jar、war等
• install：安装项目到本地仓库

![image-20250901134020571](assets/image-20250901134020571.png)

maven生命周期：
• clean： 清理
• compile：编译
• test：测试
• package： 打包
•install：安装

###  单元测试

测试：是一种用来促进鉴定软件的正确性、完整性、安全性和质量的过程。

![image-20250901135147821](assets/image-20250901135147821.png)

测试方法：白盒测试、黑盒测试 及 灰盒测试。

![image-20250901135326358](assets/image-20250901135326358.png)

![image-20250901135615572](assets/image-20250901135615572.png)

单元测试
• 单元测试：就是针对最小的功能单元（方法），编写测试代码对其正确性进行测试。

• JUnit：最流行的Java测试框架之一，提供了一些功能，方便程序进行单元测试（第三方公司提供）。

![image-20250901135946334](assets/image-20250901135946334.png)

<img src="assets/image-20250901140029275.png" alt="image-20250901140029275" style="zoom:50%;" />



![image-20250901140453985](assets/image-20250901140453985.png)

1.JUnit单元测试是做什么的？
• 测试类中方法的正确性

2.JUnit单元测试的优点是什么？
• 测试代码与应用程序代码分开，便于维护
• 可以自动生成测试报告（通过：绿色，失败：红色）
•一个测试方法执行失败，不会影响其它测试方法

3.JUnit单元测试的命名规范？
•类：XxxxTest（规范）
• 方法：public void xxxx（）｛...｝（规定）



单元测试运行不报错（绿色），就代表代码没问题，测试通过？
并不是

**断言**

JUnit提供了一些辅助方法，用来帮我们确定被测试的方法是否按照预期的效果正常工作，这种方式称为断言。

![image-20250901144728585](assets/image-20250901144728585.png)

![image-20250901144923854](assets/image-20250901144923854.png)

1．在JUnit单元测试中，为什么要使用断言？
• 单元测试方法运行不报错，不代表业务方法没问题。
• 通过断言可以检测方法运行结果是否和预期一致，从而判断业务方法的正确性
• Assertions.assertXxxx（...）

![image-20250901150146910](assets/image-20250901150146910.png)

静态方法就是static的那个

![image-20250901160122024](assets/image-20250901160122024.png)

单元测试-企业开发规范
• 原则：编写测试方法时，要尽可能的覆盖业务方法中所有可能的情况（尤其是边界值）。

![image-20250902082931016](assets/image-20250902082931016.png)

![image-20250902085213326](assets/image-20250902085213326.png)



<img src="assets/image-20250902090324510.png" alt="image-20250902090324510" style="zoom:50%;" />

### 依赖范围

依赖的jar包，默认情况下，可以在任何地方使用。可以通过 <scope>...</scope>设置其作用范围。
作用范围：

> 主程序范围有效。（main文件夹范围内）
> 测试程序范围有效。（test文件夹范围内）
> 是否参与打包运行。（package指令范围内）

![image-20250902090619623](assets/image-20250902090619623.png)



<img src="assets/image-20250902091049900.png" alt="image-20250902091049900" style="zoom:50%;" />



### Maven常见问题

![image-20250902091439091](assets/image-20250902091439091.png)

![image-20250902091545739](assets/image-20250902091545739.png)

![image-20250902091631190](assets/image-20250902091631190.png)