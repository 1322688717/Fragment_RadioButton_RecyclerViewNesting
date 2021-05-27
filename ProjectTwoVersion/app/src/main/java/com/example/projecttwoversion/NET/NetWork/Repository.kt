package NetWork

import Data_Model.*
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext

/*
仓库层代码//
优化的地方:对异常处理在同一包装..try  catch///
 */


object Repository {


    // 查询谱仪实时状态信息
    //{' userId':long,’instId’:long}
    fun SelectInstStatus(userId: String,instId: String)= fire(Dispatchers.IO){//子线程中
        val A=SundayNetWork.Status(userId, instId)
        if (A.code=="200"){
            val B=A.data
            Result.success(B)
        }else{
            Result.failure(RuntimeException("response status is ${A.message}"))
        }
    }

    /*
名称  	   查询谱仪基本信息
地址		域名/Monitor/webApi/inst/selectInst.do
参数		{' userId ':long}
 */
    fun SelectInst(userId: String)= fire(Dispatchers.IO){
        val A=SundayNetWork.INST(userId)
        if (A.code=="200"){
            val B=A.data
            Result.success(B)
        }else{
            Result.failure(RuntimeException("response status is ${A.message}"))
        }
    }



    /*
名称  	   查询实验详细信息
地址		域名/Monitor/webApi/expinfo /selectExpinfo.do
参数		{' expinfoInstId ':long,’ expId’:long}
 */
    fun SelectExpinfo(expinfoInstId:String,expId:String)= fire(Dispatchers.IO){
        val A=SundayNetWork.SInfo(expinfoInstId,expId)
        if (A.code=="200"){
//            val B=A.data
//            Result.success(B)
            val expInfo= GetExpInfo(A.data)
            Result.success(expInfo)

        }else{
            Result.failure(RuntimeException("response status is ${A.message}"))
        }
    }



/*
名称  	   查询实验队列信息
地址		域名/Monitor /webApi/exp /selectExp.do
参数		{' userId':long,’ page’:int,’limit’:int}
 */
    /*
    外部调用Exp方法可获取值
     */
    fun SelectExp(userId:String,page:String,limit:String)= fire(Dispatchers.IO){
    val A=SundayNetWork.SExp(userId,page,limit)
    if (A.code=="200"){
        val exp=GetExp(A.data )
        Result.success(exp)


    }else{
        Result.failure(RuntimeException("response status is ${A.message}"))
    }
}




    /*
名称  	   查询用户绑定的谱仪
地址		域名/Monitor /webApi/bind /selectBind.do
参数		{' userId':long}
 */

    fun selectBind(userId: String)= fire(Dispatchers.IO){
        val A=SundayNetWork.SBind(userId)
        if (A.code=="200"){
            /*
            方式一放回原来的数据模型中
             */
//            val B=A.data
//           Result.success(B)
    /*
    方式2 将获得的需要用到的数据单独拿出来//
     */
            val bin=GetBind(A.data)
            Result.success(bin)
            
        }else{
            Result.failure(RuntimeException("response status is ${A.message}"))
        }
    }



//    fun SelectInstViewModelAndPlus(userId:String,  instId:String)= fire(Dispatchers.IO){
//        coroutineScope {
//            val selectInst=async { SundayNetWork.INST(userId) }
//            va
//        }
//
//    }

        fun SelectInstAndPlus(userId: String, instId: String) = fire(Dispatchers.IO) {
        coroutineScope {
            val inst = async { SundayNetWork.INST(userId)
            }
            val status = async {SundayNetWork.Status(userId,instId)
            }
            val instResponse = inst.await()
            val statusResponse = status.await()//等待两个都完成//
            if (instResponse.code == "200" && statusResponse.code == "200") {
                val andPlus = GetSelectInstAndPlus(instResponse.data,//谱仪基本信息
                    statusResponse.data)//实时信息//
                Result.success(andPlus)
            } else {
                Result.failure(
                    RuntimeException(
                        "realtime response status is ${instResponse.message}" +
                                "daily response status is ${statusResponse.message}"
                    )
                )
            }
        }
    }





    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData<Result<T>>(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure<T>(e)
            }
            emit(result)
        }
}




