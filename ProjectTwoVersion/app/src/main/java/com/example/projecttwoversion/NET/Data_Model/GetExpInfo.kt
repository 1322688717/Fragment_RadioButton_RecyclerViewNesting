package Data_Model


/*
名称  	   查询实验详细信息
地址		域名/Monitor/webApi/expinfo /selectExpinfo.do
参数		{' expinfoInstId ':long,’ expId’:long}
 */
//取出来用的//直接用的在Activity中
data class GetExpInfo (val data:List<DataExpInfo>)