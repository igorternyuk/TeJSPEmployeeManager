/**
 * Author:  igor
 * Created: 24.10.2017
 */

use db_employees;

create table users(
    id integer not null primary key auto_increment,
    name VARCHAR(40),
    email VARCHAR(40),
    password VARCHAR(50)
);

insert into users values(1, 'igor', 'xmonad@ukr.net', '1319')

select * from users;
