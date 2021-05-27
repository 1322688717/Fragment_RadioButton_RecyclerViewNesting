package NetWork

import Data_Model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PlaceService {
//    @POST("/Monitor/webApi/bind/selectBind.do")
//    fun searchPlaces(@Body userId:userId):Call<PlaceResponse>


//查询用户绑定的谱仪{' userId':long}
 @POST("/Monitor/webApi/bind/selectBind.do")
fun SBind(@Body userId: String):retrofit2.Call<selectBind>

//	   查询实验队列信息  // userId':long,’ page’:int,’limit’:int
@POST("/Monitor/webApi/exp/selectExp.do")
fun SExp(@Body userId:String,@Body page:String,@Body limit:String):retrofit2.Call<selectExp>

//查询实验详细信息  {' expinfoInstId ':long,’ expId’:long}
@POST("/Monitor/webApi/expinfo/selectExpinfo.do")
fun SInfo(@Body expinfoInstId:String,@Body expId:String):retrofit2.Call<selectExpinfo>

//查询谱仪基本信息	{' userId ':long}
@POST("/Monitor/webApi/inst/selectInst.do")
fun INST(@Body userId:String):Call<selectInst>


//查询谱仪实时状态信息	{' userId':long,’instId’:long}
@POST("/Monitor/webApi/instrument/selectInstStatus.do")
fun Status(@Body userId:String,@Body instId:String):retrofit2.Call<selectInstStatus>

}