create sequence hibernate_sequence minvalue 100;

    
    
   
    create table Academic_Records (
        id int8 not null,
        Grescore varchar(255),
        Toeflscore varchar(255),
        gpa float8,
        transcript bytea,
        application_id int8,
        primary key (id)
    );

    create table Degree_program (
        id int8 not null,
        program varchar(255),
        department_Id int8,
        primary key (id)
    );

    create table Degrees (
        id int8 not null,
        degree varchar(255),
        end_year timestamp,
        major varchar(255),
        start_year timestamp,
        univname varchar(255),
        application_id int8,
        primary key (id)
    );

    create table additional (
        Id int8 not null,
        Required boolean,
        name varchar(255),
        type varchar(255),
        application_id int8,
        department_Id int8,
        primary key (Id)
    );

    create table application_status (
        id int8 not null,
        comment varchar(255),
        modification_date varchar(255),
        status varchar(255),
        application_id int8,
        users_id int8,
        primary key (id)
    );

    create table applications (
        id int8 not null,
        CIN int4,
        citizenship varchar(255),
        dateofapp timestamp,
        dob timestamp,
        email varchar(255),
        firstname varchar(255),
        gender varchar(255),
        lastname varchar(255),
        phone varchar(255),
        term varchar(255),
        academicrecords_id int8,
        department_Id int8,
        program_id int8,
        users_id int8,
        primary key (id)
    );

    create table department (
        Id int8 not null,
        Dept_name varchar(255),
        primary key (Id)
    );

    create table user_role (
        user_id int8 not null,
        role varchar(255)
    );

    create table users (
        id int8 not null,
        email varchar(255) not null,
        firstname varchar(255),
        lastname varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table values (
        Id int8 not null,
        filevalue bytea,
        value varchar(255),
        additional_Id int8,
        application_id int8,
        primary key (Id)
    );

    alter table users 
        add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table Academic_Records 
        add constraint FK_3eid2qliai8bcj354twejq5xp 
        foreign key (application_id) 
        references applications;

    alter table Degree_program 
        add constraint FK_c115hx0s5922yoblqtvkqyvr3 
        foreign key (department_Id) 
        references department;

    alter table Degrees 
        add constraint FK_ckdk02485yeqht9bbsybi6oht 
        foreign key (application_id) 
        references applications;

    alter table additional 
        add constraint FK_ggd5nle9vrk738skbwyg2c4us 
        foreign key (application_id) 
        references applications;

    alter table additional 
        add constraint FK_ecyfcjr85xv1t47lqxxxfre95 
        foreign key (department_Id) 
        references department;

    alter table application_status 
        add constraint FK_7bqp4sr3g3xi3h78m01pctbi1 
        foreign key (application_id) 
        references applications;

    alter table application_status 
        add constraint FK_6q2dps69qafwobdp32q1wc478 
        foreign key (users_id) 
        references users;

    alter table applications 
        add constraint FK_i45ycgg3xp189d5ei7fn0be1a 
        foreign key (academicrecords_id) 
        references Academic_Records;

    alter table applications 
        add constraint FK_i826v2c5vcwob1o0ihlt2nemm 
        foreign key (department_Id) 
        references department;

    alter table applications 
        add constraint FK_fvv8mt4q3l0jlgem0374rwfb5 
        foreign key (program_id) 
        references Degree_program;

    alter table applications 
        add constraint FK_jrun151d6ktjkayjmy7ylvq8v 
        foreign key (users_id) 
        references users;

    alter table user_role 
        add constraint FK_apcc8lxk2xnug8377fatvbn04 
        foreign key (user_id) 
        references users;

    alter table values 
        add constraint FK_l8m3bdfrvsxuymfgwfcvjgwne 
        foreign key (additional_Id) 
        references additional;

    alter table values 
        add constraint FK_b08dfjtx64ly8cvhqcktvt14j 
        foreign key (application_id) 
        references applications;

   



    INSERT INTO users (id,firstname,lastname,email,password) values (1,'DrRaj','Pamula','admin@localhost.localdomain','abcd');
    INSERT INTO users (id,firstname,lastname,email,password) values (2,'Shrey','Vithalani','shrey@localhost.localdomain','abcd');
	INSERT INTO users (id,firstname,lastname,email,password) values (3,'keyur','mandani','keyur@localhost.localdomain','abcd');
	INSERT INTO users (id,firstname,lastname,email,password) values (4,'Sagar','pandya','sagar@localhost.localdomain','abcd');
	INSERT INTO users (id,firstname,lastname,email,password) values (5,'rahul','lal','rahul@localhost.localdomain','abcd');
	
	INSERT INTO user_role values(1, 'Admin');
	INSERT INTO user_role values(3, 'Staff');
	
	INSERT INTO department values(1,'Computer Science');
	INSERT INTO department values(2,'Accounting');
	
	INSERT INTO Degree_program values(50,'MS in CS',1);
	INSERT INTO Degree_program values(51,'MS in Accounting',2);
	
	
	INSERT INTO applications values (1,304391404,'Indian',now(),'05/24/92','shrey@localhost.localdomain','Shrey','Male','Vithalani','3238994337','Spring 2016',null,2,51,2);
	
	INSERT INTO application_status values (1,null,null,'Submitted',1,2);
	
	

    
    
