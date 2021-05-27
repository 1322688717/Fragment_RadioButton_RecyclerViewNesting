package Data_Model

import com.google.gson.annotations.SerializedName


/*
名称  	   查询用户绑定的谱仪  单独
地址		域名/Monitor /webApi/bind /selectBind.do
参数		{' userId':long}
 */
data class selectBind (
        val code: String,
        val message: String,
        val data: List<Bind>,

        )
    data class Bind (@SerializedName("instrument_name")val instrument_name:String,
            //加注解是防止_＿＿_这种符号两边不互通//
                     val bindInstId:String, val bindUserId:String, val bindId:String)
//data class xxx(可直接加)