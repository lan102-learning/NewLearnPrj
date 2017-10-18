create database mmp;
use mmp;
create table tb_menu(#菜单
menu_id int primary key COMMENT '菜单id',
menu_name varchar(20) COMMENT '菜单名称',
order_id numeric(4) COMMENT '菜单顺序',
parent_id int COMMENT '父节点id',
path varchar(200) COMMENT '菜单对应url',
create_time date COMMENT '创建时间',
status numeric(1)  COMMENT '状态 1正常，0失效'
);

create table tb_user(#用户
user_id int primary key  COMMENT '用户id',
password varchar(20) COMMENT '密码',
status numeric(1)  COMMENT '状态 1正常，0失效'
);

create table tb_privilege(#权限
user_id int COMMENT '用户id',
menu_id int COMMENT '菜单id',
create_time date COMMENT '创建时间',
status numeric(1)  COMMENT '状态 1正常，0失效'
);
alter table tb_privilege add primary key (user_id,menu_id);

create table tb_conf(#配置文件
conf_name_en varchar(30) COMMENT '配置文件英文名',
conf_name_chs varchar(30) COMMENT '配置文件中文名',
conf_path varchar(50) COMMENT '配置文件路径'
);
################################################################
/*create table tb_notice_conf(#公告推送配置
catch_time date,
send_imm boolean,
send_time date
);

create table tb_receive_mail(#接受邮箱配置
email varchar(30),
name varchar(30),
belong_conf varchar(30),
is_del boolean
);

create table tb_send_mail(#发送邮箱配置
email varchar(30),
name varchar(30),
password varchar(30),
smtp_host varchar(30),
smtp_port varchar(8),
mail_charset varchar(15),
belong_conf varchar(30),
is_del boolean
);

create table tb_work_time(#时间配置
work_time time,
belong_conf varchar(30)
);
*/


insert into tb_menu values(0,'根节点',null,null,sysdate(),1);
insert into tb_menu values(1,'主页',0,'<%=request.getContextPath()%>/jsps/welcome.jsp',sysdate(),1);
insert into tb_menu values(2,'福建师大后勤公告推送',0,'<%=request.getContextPath()%>/jsps/notice/fjnuHqjtNotice.jsp',sysdate(),1);
insert into tb_menu values(3,'爬虫设置',2,'#',sysdate(),1);
insert into tb_menu values(4,'推送设置',2,'#',sysdate(),1);