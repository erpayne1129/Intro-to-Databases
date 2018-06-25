create table employee (
    ssn int,
    fname varchar(25),
    lname varchar(25),
    managerssn int,
    jobtitle varchar(25),
    age int,
    primary key(ssn),
    foreign key (managerssn) references employee(ssn)
)

create table insurance (
    insuranceid int,
    owner varchar(25),
    description varchar(25),
    price float,
    duration int,
    primary key(insuranceid)
)
