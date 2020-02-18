create schema restaurant;

use restaurant;

select * from restaurants;
select * from restaurant_tables;
select * from reservations;

drop table accounts;
drop table reservations;
drop table restaurant_tables;
drop table restaurants;

# test
select * from restaurant_tables t left join reservations r 
	on t.id = r.table_id 
	where t.restaurant_id = 1 and (r.date = Date("2020-02-18") or r.date is null) and (r.approved = false or r.approved is null)
    group by t.id;
    
select * from restaurant_tables t left join reservations r 
	on t.id = r.table_id 
	where r.approved = false or r.approved is null
    group by t.id;
    
# -----------------------------------------------------------
# This is correct
# Find empty tables by restaurant id
select * from restaurant_tables 
where restaurant_id = 1 and id not in(
	select t.id from restaurant_tables t join reservations r
    on t.id = r.table_id
	where r.date = Date("2020-02-18") and r.approved = true
    group by id
);
# -----------------------------------------------------------

select t.id from restaurant_tables t join reservations r
    on t.id = r.table_id
	where r.date = Date("2020-02-18") and r.approved = true;

# -----------------------------------------------------------
select * from restaurant_tables t left join reservations r 
	on t.id = r.table_id 
	where t.restaurant_id = 1 and (r.date = Date("2020-02-18") or r.date is null) and (r.approved = false or r.approved is null)
   ;
select * from restaurant_tables t left join reservations r 
	on t.id = r.table_id 
	where t.restaurant_id = 1 and r.date = Date("2020-02-18") or r.date is null and r.approved = false or r.approved is null
    ;
    
select * from reservations;
select * from reservations where approved = false;
    
insert into reservations value
(null,Date("2020-02-18"),true,5,1);

select * from restaurants r  join restaurant_tables t on r.id = t.id;
