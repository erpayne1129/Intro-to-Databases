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
