use perfios;
create table register(
	accno int auto_increment, 
    username varchar(50) unique, 
    password varchar(50), 
    phno varchar(10), 
    address varchar(50), 
    email varchar(50), 
    amt double, 
    acctype varchar(50),
    primary key(accno));
    
create table transaction(
	accno int,
    username varchar(50), 
    status varchar(50), 
    amt double, 
    bal double);
    
create table contact(
	id int,
    name varchar(50), 
    email varchar(50), 
    mobile varchar(50), 
    message varchar(50));
    
create table airtelrecharge(
	id int, 
    data varchar(50), 
    validity varchar(50), 
    description varchar(50), 
    price int);
    
create table jiorecharge(
	id int, 
    data varchar(50), 
    validity varchar(50), 
    description varchar(50), 
    price int);
    
    insert into airtelrecharge values(1,"2Gb","28 days","Unlimited calls",99);
    insert into airtelrecharge values(2,"1Gb","28 days","Unlimited calls",79);
    insert into airtelrecharge values(3,"1.5Gb","56 days","Unlimited calls",299);
    insert into airtelrecharge values(4,"2Gb","56 days","Unlimited calls",499);
    
    insert into jiorecharge values(1,"2Gb","28 days","Unlimited calls",199);
    insert into jiorecharge values(2,"1Gb","28 days","Unlimited calls",109);
    insert into jiorecharge values(3,"1.5Gb","56 days","Unlimited calls",399);
    insert into jiorecharge values(4,"2Gb","56 days","Unlimited calls",599);
