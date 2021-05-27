package Data_Model
/*
名称  	   查询实验详细信息
地址		域名/Monitor/webApi/expinfo /selectExpinfo.do
参数		{' expinfoInstId ':long,’ expId’:long}
 */
data class selectExpinfo (val code :String,val message:String,val data:List<DataExpInfo>)
data class DataExpInfo(val expinfoId:Int,val expinfoInstId:Int, val expinfoSolvent:Int,val expinfoPulseseq:Int,val expinfoSample:Int
,val expinfoStartTime:Long,val expinfoResidule:Int, val expinfoTotalTime:String,val expinfoTotalScan:String,val expinfoAlreadyScan:String,
                val expinfoNmrfilePath:String, val expinfoInfilePath:String, val expinfoUploadTime:Long)