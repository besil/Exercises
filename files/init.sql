CREATE KEYSPACE meteo WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

use meteo;

create table data (
    id text PRIMARY KEY,

);