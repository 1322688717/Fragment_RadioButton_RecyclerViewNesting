package place

import Data_Model.RequestDataAndPlus
import Data_Model.selectInst
import Data_Model.selectInstStatus
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import NetWork.Repository
import java.util.ArrayList


/*
名称  	   查询谱仪基本信息and
              实时状态信息
 */
class selectInstViewModelAndPlus:ViewModel() {
    private val selectInstLiveData= MutableLiveData<RequestDataAndPlus>()


    //(网络请求) 后传入的数组对象
    val SelectInstList= ArrayList<selectInst.DataInstS>()
    val SelectInstStatusList=ArrayList<selectInstStatus.DataStatus>()


    val SelectInstLiveData = Transformations.switchMap(selectInstLiveData) { userId ->
        ///调用switchMap方法来观察searchLivedDta对象
        ///仓库层放回的LiveData对象无法直接观察
        ///转换函数"

        //合并请求
        Repository.SelectInstAndPlus(userId.userId,userId.instId)
//        Repository.SelectInstStatus(userId.instId,userId.instId)
//        Repository.SelectInst(userId.userId)//回传的值
        //emit(result)//这个emit()方法其实类似于调用LiveData的 setValue()"存入数值"方法来通知数据变化
    }
    fun refreshSearchSelectInst(userId: String,instId:String) {
        selectInstLiveData.value = RequestDataAndPlus(userId,instId)
    }
}