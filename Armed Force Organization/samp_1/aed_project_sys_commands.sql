CREATE TABLE `govw_perm_id`
(
  `req_id` int(11),
  `Status` Varchar(10)
);

CREATE TABLE `perm_id`
(
  `req_id` int(11),
  `Status` Varchar(10)
);

CREATE TABLE `soldier_details`
(
  `Name` Varchar(30) primary key,
  `ID` Varchar(45),
   DOB date,
   DOJ date,
   Phone int(11),
   Gender Varchar(45),
   Address Varchar(100),
   trainer_name Varchar(45),
   Benefits varchar(100),
   username varchar(45),
   password varchar(45)
   );
  
CREATE TABLE `trainer_details`
(
  `Name` Varchar(30),
  `ID` Varchar(45),
   DOB date,
   DOJ date,
   Phone int(11),
   Gender Varchar(45),
   Address Varchar(100),
   Soldier_no int(11),
   Benefits varchar(100),
   username varchar(45),
   password varchar(45)
   );
   
   CREATE TABLE `veteran_details`
(
  `Name` Varchar(50) primary key,
  `ID` Varchar(45),
   dob date,
   doj date,
   dol date,
   Gender Varchar(45),
   Address Varchar(100),
   years int(11),
   designation varchar(45),
   Benefits varchar(50),
   pension int(11),
   username varchar(45),
   password varchar(45)
   );
   
   CREATE TABLE `waw_perm_id`
(
  `req_id` int(11),
  `Status` Varchar(10)
);

CREATE TABLE `doc_app`
(
  `req_id` int(11),
  `Status` Varchar(10),
  `Position` Varchar(30)
);

CREATE TABLE `Request_Maintenance`
(
  `req_id` int(11),
  `Status` Varchar(10),
  `user` Varchar(110),
  `quantity` Varchar(10),
  `Name` Varchar(40),
  `role` Varchar(40),
  `Organization_name` Varchar(40),
   `Country` Varchar(40),
   `Continent` Varchar(30)
);
select * from soldier_details;
select * from veteran_details;
select * from trainer_details;