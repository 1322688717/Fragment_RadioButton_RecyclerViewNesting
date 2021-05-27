package place

import Data_Model.selectBind
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import NetWork.Repository
import java.util.ArrayList
/*
名称  	   查询实验队列信息
地址		域名/Monitor /webApi/exp /selectExp.do
参数		{' userId':long,’ page’:int,’limit’:int}
 */

abstract class selectExpViewModel : ViewModel() {

    private val BindLiveData = MutableLiveData<Data_Model.RequestData>()


    val selectExpList = ArrayList<selectBind>()


    val selectExpLiveData = Transformations.switchMap(BindLiveData) { request ->
        ///调用switchMap方法来观察searchLivedDta对象
        ///仓库层放回的LiveData对象无法直接观察
        ///转换函数"
        Repository.SelectExp(request.userId, request.page, request.limit)//回传的值
        //emit(result)//这个emit()方法其实类似于调用LiveData的 setValue()"存入数值"方法来通知数据变化
    }

    fun refreshSelectExp(userId: String, page: String, limit: String) {
        BindLiveData.value = Data_Model.RequestData(userId, page, limit)
    }



}