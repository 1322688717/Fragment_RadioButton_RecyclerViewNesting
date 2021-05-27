package Data_Model
/*
名称  	   查询谱仪基本信息
地址		域名/Monitor/webApi/inst/selectInst.do
参数		{' userId ':long}
 */
 data class selectInst (val code:String,val message:String ,val data:List<DataInstS>) {
 data class DataInstS(val instId: Int, val instInstallTime: Long, val instInstallLocation: String, val producerName: String, val instBuyTime: Long,
                      val instChargePerson: String, val typeName: String, val instProducerId: Int, val instName: String, val instNum: Int, val instTypeId: Int)
}