package Data_Model


/*
名称  	   查询实验队列信息
地址		域名/Monitor /webApi/exp /selectExp.do
参数		{' userId':long,’ page’:int,’limit’:int}
 */
//取出来用的//直接用的在Activity中
////存放的用的到的数据//
data class GetExp (val data:selectExp.Page )