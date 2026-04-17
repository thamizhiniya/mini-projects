create table books( bookid int primary key,
title varchar(100) not null,
category varchar(50) not null);

create table students( studentid int primary key,
name varchar(100) not null,
department varchar(50) not null);

create table issuedbooks(sno int primary key,
studentid int not null,
bookid int not null,
issuedate date not null,
returndate date,
foreign key(studentid) references students(studentid),
foreign key(bookid) references books(bookid));

select distinct s.studentid, s.name, s.department
from students s join issuedbooks i on s.studentid = i.studentid 
where i.returndate is null and datediff(current_date, i.issuedate) > 14;

select b.category ,count(i.bookid) as no  
from books b join issuedbooks i on b.bookid=i.bookid 
group by b.category order by no desc limit 1; 

delete  from students
where studentid not in (
select distinct studentid from issuedbooks
where issuedate >= date_sub(current_date,interval 3 year));

