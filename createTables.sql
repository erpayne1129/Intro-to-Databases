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

create table lessee (
    ssn int,
    fname varchar(25),
    lanme varchar(25),
    paymenttype varchar(25),
    cardnumber varchar(25),
    licensenumber int,
    email varchar(25),
    phone varchar(25),
    insurance int,
    primary key(ssn),
    foreign key (insurance) references insurance(insuranceid)
)

create table Vehicle(
 type varchar(25),
 place varchar(25),
 insurance varchar(25),
 size varchar(25),
 vin varchar(25),
 primary key(vin),
 foreign key (vin) references insurance (id));
 
 create table office (
 city varchar(15),
 state varchar(15),
 postalCode int,
 branchNumber int,
 Mgr_SSN int,
 Primary key (branchNumber),
 Foreign key (Mgr_SSN) references Employee(Emp_SSN));
