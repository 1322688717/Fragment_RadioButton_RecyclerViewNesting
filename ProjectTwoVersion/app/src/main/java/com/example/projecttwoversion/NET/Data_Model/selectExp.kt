package Data_Model

/*
data class PlaceResponse (val code:String,val message :String,val data:List<Place>)
data class Place(@SerializedName("instrument_name")val instrument_name:String,
                 //加注解是防止_＿＿_这种符号两边不互通//
                  val bindInstId:String,val bindUserId:String,val bindId:String)
 */
/*
名称  	   查询实验队列信息
地址		域名/Monitor /webApi/exp /selectExp.do
参数		{' userId':long,’ page’:int,’limit’:int}
 */
data class selectExp (val code:String,val message:String,val data:Page) {
    data class Page(val pageNum: Int, val pageSize: Int, val size: Int, val startRow: Int, val endRow: Int,
                    val total: Int, val pages: Int, val list: List<ExpInstId>, val prePage: String, val nextPage: String,
                    val isFirstPage: String, val isLastPage: String, val hasPreviousPage: String, val hasNextPage: String, val navigatePages: String,
                    val navigatepageNums: List<NumberS>, val navigateFirstPage: String, val navigateLastPage: String, val lastPage: String, val firstPage: String)

    data class ExpInstId(val expInstId: Int, val expPath: Int, val instName: String, val expId: Int)

    ///不知传回的是什么数组?数字构成?
    //Number属于List navigatepageNums: List<NumberS>这一层级//
    data class NumberS(val one: Int)
}