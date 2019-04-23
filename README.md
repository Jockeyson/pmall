# 商城分布式Demo
采购商城分布式基本架构
## 模块划分
pmall-admin：后台应用<br>
pmall-front：前台应用<br>
pmall-common：公共模块<br>
pmall-parent：公共依赖<br>
pmall-member：会员模块--->子模块：pmall-member-api，pmall-member-service<br>
pmall-order：订单模块--->子模块：pmall-order-api，pmall-order-service<br>
pmall-goods：商品模块--->子模块：pmall-goods-api，pmall-goods-service<br>
pmall-sys：系统模块--->子模块：pmall-sys-api，pmall-sys-service<br>
pmall-search：商品模块--->子模块：pmall-search-api，pmall-search-service<br>
api模块为服务接口，service模块为服务实现<br>
## 技术栈
springboot，mybatis，zookeeper，dubbo，redis，rabbitmq，fescar，nginx
## 功能
未实现商城业务功能，只是做个框架基本实践，后续可基于此开发商城功能，有待完善！<br>
参考：https://gitee.com/shuaiqing/xmall
