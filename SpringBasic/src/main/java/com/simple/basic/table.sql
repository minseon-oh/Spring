create table score(
    num number(10, 0),
    name varchar2(50),
    kor varchar2(50),
    eng varchar2(50),
    math varchar2(50)
);

alter table score add CONSTRAINT score_ok PRIMARY KEY (num);
create SEQUENCE score_seq INCREMENT BY 1 START with 1;
