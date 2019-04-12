# mall-zlq
源代码： https://github.com/macrozheng/mall

mall项目是一套电商系统，包括前台商城系统及后台管理系统，基于SpringBoot+MyBatis实现。
前台商城系统包含首页门户、商品推荐、商品搜索、商品展示、购物车、订单流程、会员中心、客户服务、帮助中心等模块。
后台管理系统包含商品管理、订单管理、会员管理、促销管理、运营管理、内容管理、统计报表、财务管理、权限管理、设置等模块

本地安装部署步骤
    
（1）克隆源代码到本地
（2） 在mysql中新建mall数据库，导入document/sql下的mall.sql文件；
    然后运行mall.sql 创建表， 不懂怎么用sql 文件创建数据表，请google一下
（3）使用IDEA或Eclipse打开，并完成编译;
（4） mall-mbg如果没有生成mapper 文件， 可以在idea 右键运行mall-mbg 下的Generator
  
  复制表结构和数据：
  CREATE TABLE db2.table LIKE db1.table;
  INSERT INTO db2.table SELECT * FROM db1.table;



运行测试看看效果：
    启动mall-admin项目：直接运行com.zlq.mall.MallAdminApplication的main方法即可， 
    web浏览器运行接口文档地址：http://localhost:9090/swagger-ui.html;

