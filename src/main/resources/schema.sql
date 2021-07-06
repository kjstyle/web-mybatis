CREATE TABLE IF NOT EXISTS member
(
    member_no bigint not null auto_increment,
    member_id varchar(20) not null,
    member_password varchar(50) not null,
    member_name varchar(50) not null,
    primary key (member_no)
);

INSERT INTO member
(member_id, member_password, member_name)
VALUES
('kilju', '1234', '이길주');


INSERT INTO member
(member_id, member_password, member_name)
VALUES
('lovekim', '4567', '김사랑');