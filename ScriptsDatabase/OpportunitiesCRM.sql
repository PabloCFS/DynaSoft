
SELECT * FROM dbo.opportunity;

SELECT * FROM dbo.opportunity WHERE new_contadorautonumerico = 4266;

SELECT 
	new_contadorautonumerico,
	name,
	ap_uenname,
	accountidname,
	customeridname,
	actualvalue,
	actualvalue_base,
	estimatedvalue,
	estimatedvalue_base,
	new_estprofit,
	new_estprofit_base,
	actualclosedate,
	estimatedclosedate,
	modifiedon,
	new_estimatedbillingdate,
	owneridname,
	owneridyominame
	FROM dbo.opportunity WHERE new_contadorautonumerico = 4697;