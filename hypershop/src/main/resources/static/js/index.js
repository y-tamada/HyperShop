/**
 * 
 */

$(document).ready(function(){
	
	
	
	$("#productSearch").on("click", function(){
		$.ajax({
			type: 'post',
			url: $("#contextPath").val() + 'productSearch',
			data: { 'keyword' : $("input[name=keyword]").val() },
			async: false,
			success: function(data){
				$("#productListArea").append(data);
			}
		});
		
		$(".productInfo").each(function(){
			var index = $(this).attr("data-value");
			switch(index % 4){
			case 0:
				$(this).addClass("panelBlue");
				break;
			case 1:
				$(this).addClass("panelGreen");
				break;
			case 2:
				$(this).addClass("panelYellow");
				break;
			case 3:
				$(this).addClass("panelRed");
				break;
			default:
				$(this).addClass("panelBlue");
			break;
			}
			
			//ratringStar
			$(function() {
			      $('select[name=ratingStar]').barrating({
			        theme: 'fontawesome-stars',
			        readonly: true,
			        showSelectedRating: true
			      });
			   });
		});
	});
});

function enterSearch(code){
	//エンターキー押下なら
	if(13 === code){
		$("#productSearch").trigger("click");
	}
}