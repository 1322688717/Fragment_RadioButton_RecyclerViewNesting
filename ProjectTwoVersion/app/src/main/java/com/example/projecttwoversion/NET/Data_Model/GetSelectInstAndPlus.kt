package Data_Model


/*
名称  	   查询谱仪基本信息
地址		域名/Monitor/webApi/inst/selectInst.do
参数		{' userId ':long}
 */


//＆谱仪基本信息////谱仪实时状态信息

//取出来用的//直接用的在Activity中 接口

data class GetSelectInstAndPlus (val data:List<selectInst.DataInstS>, val data2: List<selectInstStatus.DataStatus>)