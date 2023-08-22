use test;
create table if not exists interface_info (
    id bigint auto_increment comment 'id' primary key,
    name varchar(256) not null comment '接口名称',
    description varchar(256) null comment '接口描述',
    url varchar(512) not null comment '接口地址',
    requestHeader text null comment '请求头',
    responseHeader text null comment '响应头',
    status int default 0 not null comment '状态 0 - 关闭 1 - 开启',
    method varchar(256) not null comment '请求类型',
    userId bigint not null comment '创建人信息',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    isDelete tinyint default 0 not null comment '是否删除(0-未删，1-已删)'
) comment '接口信息';

INSERT INTO interface_info (name, description, url, requestHeader, responseHeader, status, method, userId, isDelete)
VALUES
    ('Interface 11', 'Description 11', 'https://example.com/api/11', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'GET', 1, 0),
    ('Interface 12', 'Description 12', 'https://example.com/api/12', '{"Content-Type": "application/xml"}', '{"Content-Type": "application/xml"}', 0, 'POST', 2, 0),
    ('Interface 13', 'Description 13', 'https://example.com/api/13', '{"Authorization": "Bearer xyz"}', '{"Authorization": "Bearer xyz"}', 1, 'GET', 1, 0),
    ('Interface 14', 'Description 14', 'https://example.com/api/14', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'POST', 3, 0),
    ('Interface 15', 'Description 15', 'https://example.com/api/15', '{"Authorization": "Bearer abc"}', '{"Authorization": "Bearer abc"}', 0, 'GET', 2, 0),
    ('Interface 16', 'Description 16', 'https://example.com/api/16', '{"Content-Type": "application/xml"}', '{"Content-Type": "application/xml"}', 1, 'POST', 3, 0),
    ('Interface 17', 'Description 17', 'https://example.com/api/17', '{"Authorization": "Bearer def"}', '{"Authorization": "Bearer def"}', 1, 'GET', 1, 0),
    ('Interface 18', 'Description 18', 'https://example.com/api/18', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 0, 'POST', 2, 0),
    ('Interface 19', 'Description 19', 'https://example.com/api/19', '{"Authorization": "Bearer xyz"}', '{"Authorization": "Bearer xyz"}', 1, 'GET', 1, 0),
    ('Interface 20', 'Description 20', 'https://example.com/api/20', '{"Content-Type": "application/xml"}', '{"Content-Type": "application/xml"}', 1, 'POST', 3, 0);