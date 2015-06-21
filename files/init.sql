CREATE KEYSPACE meteo WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

create table meteo.data (
    sid text,
    date text,
    time text,
    obs_type text,
    obs_value text,
    PRIMARY KEY( sid, date, time, obs_type )
);
create index on meteo.data (obs_type);

--insert into meteo.data (station, mydate, mytime, obstype, obsvalue) values('sid0', '08021989', '0700', 'PLUV', '12');