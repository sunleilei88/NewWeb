$(function(){
	clickEvent();
});

function clickEvent(){
	$('#page1').on('click','#test1',CORE.bind(this.test1, this));
}

function test1(){
	var url="test1.do";
	var params={
		"name":"孙磊磊",
		"age":"18",
	};
	var data = CORE.post(url,params);

}
