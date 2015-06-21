# Exercises

Exercises using Spark and Cassandra, based on the National Climate Data Center datasets.
The aim of the exercise is to implement some Time Series Analysis on top of the data.

You can find sample datasets at ftp://ftp.ncdc.noaa.gov/pub/data/ghcn/daily/by_year/ .

Before starting the analysis, you should execute the files/init.sql script in the Cassandra cql shell.
After that, you can start with the Ingestion object (you have to specify the files you want to use).
At the end, you can launch the Analysis object, which caculates some KPI on the imported data (this is still under development).
