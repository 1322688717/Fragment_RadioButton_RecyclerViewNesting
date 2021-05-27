package Data_Model

import android.provider.ContactsContract

/*
名称  	   查询谱仪实时状态信息
地址		域名/Monitor/webApi/instrument/selectInstStatus.do
参数		{' userId':long,’instId’:long}
 */
data class selectInstStatus (val code:String,val message:String,val data:List<DataStatus>){
data class DataStatus(val statusId:Int,val statusInstrumentId:Int,val statusRealTemp:Float,val statusSpinUserName:Int,
                 val  statusLockLevel:Float,val statusSpin:Float,val statusNLevel :Float,val statusHELevel:Float,
                 val statusUploadTime:ContactsContract.RawContacts.Data)}