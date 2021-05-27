package place

import Data_Model.selectBind
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import NetWork.Repository
import java.util.ArrayList

/*
名称  	   查询用户绑定的谱仪
 */
//在fragment中引入//实例化
//例如:
//val viewModel by lazy { ViewModelProvider(this).get(PlaceViewModel::class.java) }

/*
名称  	   查询用户绑定的谱仪
参数		{' userId':long}
 */

//这时传回的(POst)的值是什么//这个userID具体是什么?Token?

/*
使用方法 1.
        在fragment里加载
        val viewModel by lazy { ViewModelProvider(this).get(selectBindViewModel::class.java) }

      2.
      //清楚旧数据//
       viewModel.BindList.clear()
       //写入新数据             //从places对象(看下面)载入数据到Collection<selectBind>  //后面的selectBind类对应着数据模型
                viewModel.BindList.addAll(places as Collection<selectBind>)

     3.使用回调在fragment中回传值(变化)
      viewModel.SselectBindLiveData.observe(viewLifecycleOwner, Observer{ result ->//回调
                                        ///这里是fragment中所以不适用"this"  //当  result中的数据发生变化时 便会触发函数回调//
            val places = result.getOrNull()

     4.刷新请求
     在外部调用方法 searchBind 传入的值就是 HTTP 请求的参数//方便起见都为String类型
                                                    //->的用法之一 前面是参数  后面是返回
      searchPlaceEdit.addTextChangedListener { editable ->
                   /////监听输入框中内容的变化//
            val content = editable.toString()//获得搜索的内容//
            //对应网络请求时的参数//
            if (content.isNotEmpty())
                //不为空
                viewModel.searchBind(content)//传入请求参数//


 */
class selectBindViewModel :ViewModel(){
    private val BindLiveData=MutableLiveData<String>()


    val BindList=ArrayList<selectBind>()

                                                                   //->
                                                                   //分隔 lambda 表达式的参数与主体
                                                                   //分隔在函数类型中的参数类型与返回类型声明
                                                                   //分隔 when 表达式分支的条件与代码体
                                                                    ///->分隔符//1/3  在此处是用来分割 参数类型/返回类型与/
    val SselectBindLiveData = Transformations.switchMap(BindLiveData) { userId ->
        ///调用switchMap方法来观察searchLivedDta对象
        ///仓库层放回的LiveData对象无法直接观察
        ///转换函数"
        Repository.selectBind(userId)//回传的值
        //emit(result)//这个emit()方法其实类似于调用LiveData的 setValue()"存入数值"方法来通知数据变化
    }
    fun refreshBind(userId: String) {
        BindLiveData.value = userId
    }
}