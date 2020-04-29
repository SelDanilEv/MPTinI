use master
go
create [Java10-11]
go 
use [Java10-11]
go

create table Users
(
ID int identity(1,1) not null,
 user_login nvarchar(50),
 user_password int,
 user_role nvarchar(50)
);

drop table Users

insert into Users values ('Admin', 1,'Admin')
delete Users where Users.user_login = 'Admin'