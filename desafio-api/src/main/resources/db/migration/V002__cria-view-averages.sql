create view vw_mensuration_average as
(SELECT
     date_format(mensuration_date,'%d-%m-%Y') as mensuration_date, 
     coalesce(avg(mensuration_min_value),0) as min_value_avg, 
     coalesce(avg(mensuration_max_value), 0) as max_value_avg 
FROM 
  mensuration 
GROUP BY mensuration_date);