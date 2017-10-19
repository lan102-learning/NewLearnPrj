create database mmp;
use mmp;
create table tb_menu(#�˵�
menu_id int primary key COMMENT '�˵�id',
menu_name varchar(20) COMMENT '�˵�����',
order_id numeric(4) COMMENT '�˵�˳��',
parent_id int COMMENT '���ڵ�id',
path varchar(200) COMMENT '�˵���Ӧurl',
create_time date COMMENT '����ʱ��',
status numeric(1)  COMMENT '״̬ 1������0ʧЧ'
);

create table tb_user(#�û�
user_id int primary key  COMMENT '�û�id',
password varchar(20) COMMENT '����',
status numeric(1)  COMMENT '״̬ 1������0ʧЧ'
);

create table tb_privilege(#Ȩ��
user_id int COMMENT '�û�id',
menu_id int COMMENT '�˵�id',
create_time date COMMENT '����ʱ��',
status numeric(1)  COMMENT '״̬ 1������0ʧЧ'
);
alter table tb_privilege add primary key (user_id,menu_id);

create table tb_conf(#�����ļ�
conf_name_en varchar(30) COMMENT '�����ļ�Ӣ����',
conf_name_chs varchar(30) COMMENT '�����ļ�������',
conf_path varchar(50) COMMENT '�����ļ�·��'
);
################################################################
/*create table tb_notice_conf(#������������
catch_time date,
send_imm boolean,
send_time date
);

create table tb_receive_mail(#������������
email varchar(30),
name varchar(30),
belong_conf varchar(30),
is_del boolean
);

create table tb_send_mail(#������������
email varchar(30),
name varchar(30),
password varchar(30),
smtp_host varchar(30),
smtp_port varchar(8),
mail_charset varchar(15),
belong_conf varchar(30),
is_del boolean
);

create table tb_work_time(#ʱ������
work_time time,
belong_conf varchar(30)
);
*/


insert into tb_menu values(0,'���ڵ�',null,null,sysdate(),1);
insert into tb_menu values(1,'��ҳ',0,'<%=request.getContextPath()%>/jsps/welcome.jsp',sysdate(),1);
insert into tb_menu values(2,'����ʦ����ڹ�������',0,'<%=request.getContextPath()%>/jsps/notice/fjnuHqjtNotice.jsp',sysdate(),1);
insert into tb_menu values(3,'��������',2,'#',sysdate(),1);
insert into tb_menu values(4,'��������',2,'#',sysdate(),1);