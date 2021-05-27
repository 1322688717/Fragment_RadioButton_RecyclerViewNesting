package NetWork

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//object/申明单例类//
object ServiceCreator {
    private const val BAST_URL ="https://192.168."//主地址带定
    private val retrofit=Retrofit.Builder()
        .baseUrl(BAST_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //外部可见的create()方法，并接收一个Class类型的参数。当在外部调
    //用这个方法时，实际上就是调用了Retrofit对象的create()方法，从而创建出相应Service接
    //口的动态代理对象

    //使得单例类对外部可见的方法//
    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)
    //外部使用方法//
    //val appService = ServiceCreator.create(AppService::class.java)
    inline fun <reified T> create(): T = create(T::class.java)
    //获取接口动态代理对象//
    // val placeService = ServiceCreator.create<PlaceService>()
}