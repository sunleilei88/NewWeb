$(function(){
	clickEvent();
});

function clickEvent(){
	$('#page1').on('click','#test1',CORE.bind(this.test1, this));
}

function test1(){
	var url="test1.do";
	var params={
		url:"11",
	};
	var data = CORE.post(url,params);

}
