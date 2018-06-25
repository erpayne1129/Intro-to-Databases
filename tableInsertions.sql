INSERT INTO employee
values(12345678, 'Victor', 'Liam', NULL, 'Manager', 35);

INSERT INTO employee
values(87654321, 'Valerie', 'Edwards', NULL, 'Manager', 31);

INSERT INTO employee
values(98345791, 'Nicole', 'Marson', 87654321, 'Accountant', 24);

INSERT INTO employee
values(52347587, 'Chris', 'Coleman', 12345678, 'Attendant', 28);

INSERT INTO employee
values(24343589, 'Hanes', 'Wilson', 87654321, 'Receptionist', 26);

INSERT INTO employee
values(54839215, 'Blake', 'Nuke', NULL, 'Manager', 42);

INSERT INTO employee
values(84573902, 'Claire', 'Keller', 54839215, 'Support', 25);

INSERT INTO employee
values(38754377, 'Wayne', 'Keller', 54839215, 'Support', 21);

INSERT INTO employee
values(44693864, 'Josh', 'Eckart', 12345678, 'Attendant', 29);

INSERT INTO employee
values(62452379, 'Richard', 'Moore', 87654321, 'Accountant', 36);



insert into insurance values(848204421, 'state farm', 'full coverage', 12.50, 2); 
insert into insurance values(438291248, 'all state', 'liability', 14.50, 3); 
insert into insurance values(112313413, 'geico', 'full coverage', 20, 1); 
insert into insurance values(738194243, 'state farm', 'full coverage', 19.50, 4); 
insert into insurance values(573910313, 'geico', 'liability', 12.50, 3); 
insert into insurance values(974914891, 'all state', 'full coverage', 12, 6); 
insert into insurance values(231421232, 'general', 'liability', 11, 2); 
insert into insurance values(424815312, 'liberty mutual', 'liability', 10.50, 1); 
insert into insurance values(548392042, 'state farm', 'full coverage', 13.50, 6); 
insert into insurance values(984827532, 'liberty mutual', 'full coverage', 11.50, 9); 

insert into lessee( ssn, fname, lanme, paymenttype, cardnumber, licensenumber, email, phone, insurance) values (13235869,'Jim','Jimson','debit','1111 2222 3333 4444','123456789','jj@email.com','123-456-789',848204421);
insert into lessee( ssn, fname, lanme, paymenttype, cardnumber, licensenumber, email, phone, insurance) values (25789451,'Peter','Peters','debit','2222 2222 3333 4444','123456788','pp@email.com','123-456-788',438291248);
insert into lessee( ssn, fname, lanme, paymenttype, cardnumber, licensenumber, email, phone, insurance) values (33697454,'Tom','Wong','debit','3333 2222 3333 4444','123456787','qq@email.com','123-456-787',112313413);
insert into lessee( ssn, fname, lanme, paymenttype, cardnumber, licensenumber, email, phone, insurance) values (48534976,'Tim','Choi','credit','4444 2222 3333 4444','123456786','ss@email.com','123-456-786',738194243);
insert into lessee( ssn, fname, lanme, paymenttype, cardnumber, licensenumber, email, phone, insurance) values (52469464,'Eric','Zhang','debit','1122 2222 3333 4444','123456785','aa@email.com','123-456-785',573910313);
insert into lessee( ssn, fname, lanme, paymenttype, cardnumber, licensenumber, email, phone, insurance) values (66587956,'Adu','Pham','debit','1133 2222 3333 4444','123456784','ll@email.com','123-456-784',974914891);
insert into lessee( ssn, fname, lanme, paymenttype, cardnumber, licensenumber, email, phone, insurance) values (77895988,'John','White','credit','1144 2222 3333 4444','123456783','lop@email.com','123-456-783',231421232);
insert into lessee( ssn, fname, lanme, paymenttype, cardnumber, licensenumber, email, phone, insurance) values (88975648,'Sam','Flynn','debit','1155 2222 3333 4444','123456782','oing@email.com','123-456-782',424815312);
insert into lessee( ssn, fname, lanme, paymenttype, cardnumber, licensenumber, email, phone, insurance) values (93687549,'Lily','Huang','credit','1166 2222 3333 4444','123456781','zkzk@email.com','123-456-781',548392042);
insert into lessee( ssn, fname, lanme, paymenttype, cardnumber, licensenumber, email, phone, insurance) values (10147526,'Zed','Allen','debit','1177 2222 3333 4444','123456780','opop@email.com','123-456-780',984827532);

INSERT INTO  Vehicle (model, description, place, insurance, passengers, vin) VALUES ('2014 Civic', 'White', 'Richardson, TX', 848204421, 2, '12345');
INSERT INTO  Vehicle (model, description, place, insurance, passengers, vin) VALUES ('2016 Accent', 'White', 'Irving, TX', 438291248, 4, '58693');
INSERT INTO  Vehicle (model, description, place, insurance, passengers, vin) VALUES ('2007 Impala', 'Silver', 'Plano, TX', 112313413, 2, '69674');
INSERT INTO  Vehicle (model, description, place, insurance, passengers, vin) VALUES ('2012 Escape', 'Black', 'Richardson, TX', 738194243, 2, '34962');
INSERT INTO  Vehicle (model, description, place, insurance, passengers, vin) VALUES ('2017 Accord', 'White', 'Richardson, TX', 573910313, 3, '19386');
INSERT INTO  Vehicle (model, description, place, insurance, passengers, vin) VALUES ('2011 Maxima', 'Black', 'Coppell, TX', 974914891, 1, '95483');
INSERT INTO  Vehicle (model, description, place, insurance, passengers, vin) VALUES ('2011 Altima', 'Grey', 'Irving, TX', 231421232, 2, '69504');
INSERT INTO  Vehicle (model, description, place, insurance, passengers, vin) VALUES ('2013 MX-5', 'Red', 'Addison, TX', 424815312, 1, '68241');
INSERT INTO  Vehicle (model, description, place, insurance, passengers, vin) VALUES ('2018 Sierra', 'White', 'Plano, TX', 548392042, 2, '75832');
INSERT INTO  Vehicle (model, description, place, insurance, passengers, vin) VALUES ('2012 Silverado', 'Silver', 'Grand prarie, TX', 984827532, 1, '25796');

insert into office values('dallas','texas', 75205, 28921283, 12345678);
insert into office values('allen', 'texas', 75214, 89023842, 87654321);
insert into office values('arlington', 'texas', 75242, 79252324, 54839215);
insert into office values('christy','texas', 75245, 64829417, 12345678);
insert into office values('allen', 'texas', 75234, 11234244, 87654321);
insert into office values('richardson', 'texas', 75242, 89884212, 54839215);
insert into office values('dallas','texas', 75943, 43371832, 12345678);
insert into office values('mckinney', 'texas', 75203, 94832232, 87654321);
insert into office values('irving', 'texas', 75245, 74232312, 54839215);
insert into office values('dallas', 'texas', 75259, 74838291, 87654321);


