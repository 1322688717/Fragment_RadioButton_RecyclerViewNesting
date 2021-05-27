package Data_Model

/*
请求体存放的请求值//

//需要在详细页面给赋值
 */


/*
 查询实验队列信息
 */
data class RequestData(val userId: String,

                       val page: String,
                       val limit: String,//
)

/*
名称  	   查询实验详细信息
地址		域名/Monitor/webApi/expinfo /selectExpinfo.do
参数		{' expinfoInstId ':long,’ expId’:long}
返回示例  {"code":200,"message":"查询成功
 */
data class RequestDataExpinfo(val expinfoInstId:String ,val expId:String)



/*
名称  	   查询谱仪基本信息  (合并写)同下
地址		域名/Monitor/webApi/inst/selectInst.do
参数		{' userId ':long}
//
名称  	   查询谱仪实时状态信息  (合并)同上//加
地址		域名/Monitor/webApi/instrument/selectInstStatus.do
参数		{' userId':long,’instId’:long}
 */
data class RequestDataAndPlus(val userId:String,val instId:String)