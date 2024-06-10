create table admin
(
    admin_id int auto_increment comment '管理员编号，主键，自增长'
        primary key,
    username varchar(50)  not null comment '用户名',
    password varchar(100) not null comment '密码'
);

create table employer
(
    employer_id         int auto_increment comment '用人单位编号，主键，自增长'
        primary key,
    company_name        varchar(100)                        not null comment '企业名称',
    password            varchar(100)                        not null comment '登录密码',
    contact_person      varchar(50)                         not null comment '联系人',
    address             varchar(200)                        null comment '地址',
    registration_time   timestamp default CURRENT_TIMESTAMP null comment '注册时间，默认当前时间',
    nature              varchar(50)                         null comment '性质',
    email               varchar(100)                        null comment '电子邮箱',
    scale               varchar(50)                         null comment '规模',
    contact_number      varchar(20)                         null comment '联系电话',
    verification_status varchar(50)                         null comment '审核状态',
    verification_time   timestamp                           null comment '审核时间'
);

create table employment
(
    employment_id      int auto_increment comment '用工ID，主键，自增长'
        primary key,
    employer_id        int                                        null comment '用人单位ID，外键关联employer表',
    start_date         date                                       null comment '用工开始时间',
    salary_information varchar(200)                               null comment '薪酬信息',
    job_title          varchar(100)                               null comment '岗位标题',
    status             enum ('招聘中', '已关闭') default '招聘中' null comment '状态',
    description        varchar(500)                               not null,
    type               varchar(50)                                null
);

create index idx_employer_id
    on employment (employer_id);

create table message_board
(
    message_id      int auto_increment comment '留言编号，主键，自增长'
        primary key,
    student_id      int                                 null comment '发送者ID',
    employer_id     int                                 null comment '接收者ID',
    message_content text                                not null comment '留言内容',
    send_time       timestamp default CURRENT_TIMESTAMP null comment '发送时间，默认当前时间'
);

create table student
(
    student_id       int auto_increment comment '学号，主键，自增长'
        primary key,
    gender           varchar(10)  not null comment '性别',
    name             varchar(50)  not null comment '姓名',
    ethnicity        varchar(50)  null comment '民族',
    native_place     varchar(100) null comment '籍贯',
    date_of_birth    date         null comment '出生日期',
    political_status varchar(50)  null comment '政治面貌',
    password         varchar(255) not null comment '密码'
);

create table job_application
(
    application_id   int auto_increment comment '申请ID，主键，自增长'
        primary key,
    employment_id    int                                                  not null comment '用工ID，外键关联employment表',
    student_id       int                                                  not null comment '学生ID，外键关联student表',
    application_date date                                                 not null comment '申请日期',
    status           enum ('待处理', '已录用', '未录用') default '待处理' null comment '申请状态',
    notes            varchar(500)                                         null comment '申请备注',
    employer_id      int                                                  null comment '雇主ID 关联employment表',
    constraint fk_employer_id
        foreign key (employer_id) references employment (employer_id),
    constraint fk_employment_id
        foreign key (employment_id) references employment (employment_id),
    constraint fk_student_id
        foreign key (student_id) references student (student_id)
)
    comment '招聘申请表';

