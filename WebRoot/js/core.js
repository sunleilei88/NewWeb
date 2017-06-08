var CORE = {
		
	//点击事件绑定函数
	bind : function (fn, scope) {
		if (!Object.prototype.toString.apply(fn) === '[object Function]') {
			return fn;
		}
		return function() {
			return fn.apply(scope, arguments);
		};
	},
	
	//post请求
	post : function (url, params) {
		debugger;
		$.post(url,params,function(data){
			return data;
		},"json");
	},
	
	
};
