create database [Space]
use [Space]

create table Planet
(
	ID int identity,
	Name nvarchar(30) primary key,
	Radius float not null check (Radius>0),
	Temperature float not null check (Temperature>0),
	IsLife nvarchar(2) not null check(IsLife = 'Y' or IsLife = 'N'),
	IsAtmosphere nvarchar(2) not null check(IsAtmosphere = 'Y' or IsAtmosphere = 'N'),
	Satellites nvarchar(max) not null,
	Photo image 
)

delete Planet;
drop table Planet;


delete Planet;
drop table Satellite;

create table Satellite
(
	ID int identity not null,
	Radius float not null check (Radius>0),
	Name nvarchar(30) not null,
	Distance_to_Planet float not null,
	PlanetName nvarchar(30) constraint Satellite_Planet_FK foreign key 
                         references Planet(Name)
						 )

create table MoreInformation
(
	ID int identity not null,
	Discriprion nvarchar(300),
	Photo1 image,
	Photo2 image,
	Photo3 image,
	PlanetName nvarchar(30) constraint MoreInformation_Planet_FK foreign key 
							references Planet(Name)
						 )

drop table MoreInformation

insert into Satellite values
(1737.10,'Moon',384400, 'Earth'),
(1821.3,'IO',421700, 'Jupiter'),
(1560.8,'Europa',671100, 'Jupiter'),
(11.1,'Phobos',9377.2,'Mars')

insert into Planet(Name,Radius,Temperature,IsLife,IsAtmosphere,Satellites) values
('Earth', 6371, 287.2, 'Y', 'Y', 'Moon'),
('Venus', 6051.8, 737, 'N', 'Y', ''),
('Mars', 3376.2, 210, 'N', 'Y', 'Phobos, Deimos'),
('Jupiter', 69911, 230, 'N', 'Y', 'Io, Europa, Ganymede, Callisto')


insert into MoreInformation (Discriprion,PlanetName) values ('This is our Planet','Earth')
