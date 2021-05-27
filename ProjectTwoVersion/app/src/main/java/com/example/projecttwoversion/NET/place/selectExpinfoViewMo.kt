package place

import Data_Model.DataExpInfo
import Data_Model.RequestDataExpinfo
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import NetWork.Repository

/*
名称  	   查询实验详细信息
地址		域名/Monitor/webApi/expinfo /selectExpinfo.do
参数		{' expinfoInstId ':long,’ expId’:long}
 */
class selectExpinfoViewMo:ViewModel() {
    private val ExpinfoLiveData=MutableLiveData<RequestDataExpinfo>()

    val seleExpinfoList=ArrayList<DataExpInfo>()

    val selectExpinfoLiveData=Transformations.switchMap(ExpinfoLiveData){expinfoInstId->
        Repository.SelectExpinfo(expinfoInstId.expinfoInstId,expinfoInstId.expId)

    }
    fun refreshExpInfo(expinfoInstId:String,expId:String){
        ExpinfoLiveData.value=RequestDataExpinfo(expinfoInstId ,expId )
    }


}