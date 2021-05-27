package NetWork

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

///网络访问入口
object SundayNetWork {



    //实例化 得  接口得动态代理对象//接口封装//
    private val placeService = ServiceCreator.create<PlaceService>()
    //ServiceCreator.create(PlaceService::class.java)


    //当外部调用SBind时  便会实现网络请求

    suspend fun SBind(userId: String)= placeService.SBind(userId).await()

    // userId':long,’ page’:int,’limit’:int
    suspend fun SExp(userId:String,page:String,limit:String)= placeService.SExp(userId,page,limit).await()

    //{' expinfoInstId ':long,’ expId’:long}
    suspend fun SInfo(expinfoInstId:String,expId:String)= placeService.SInfo(expinfoInstId,expId).await()

   // {' userId ':long}
    //suspend fun Inst(userId2: String)= placeService.Inst(userId2).await()
    suspend fun INST(userId: String)= placeService.INST(userId).await()


    //{' userId':long,’instId’:long}
    suspend fun Status(userId: String,instId:String)= placeService.Status(userId,instId).await()

    //调用await函数用于协程
    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)

                    else continuation.resumeWithException(
                        RuntimeException("response body is null"))
                }
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}