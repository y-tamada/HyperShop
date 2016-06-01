/**
 * 
 */

$(document).ready(function(){
	$('.loader-inner').loaders();
	$('.loader-inner').hide();
	//ratringStar
	$(function() {
		$('select[name=ratingStar]').barrating({
			theme: 'fontawesome-stars',
			readonly: true,
			showSelectedRating: true
		});
	});
	
	$("#productSearch").on("click", function(){
		
		$('.loader-inner').show();
		
		$.ajax({
			type: 'post',
			url: $("#contextPath").val() + 'productSearch',
			data: { 'keyword' : $("input[name=keyword]").val() },
			async: false,
			success: function(data){
				$("#productListArea ul").remove();
				$("#productListArea").append(data);
			}
		});
		
		$(".productInfo").each(function(){
//			var index = $(this).attr("data-value");
//			switch(index % 4){
//			case 0:
//				$(this).addClass("panelBlue");
//				break;
//			case 1:
//				$(this).addClass("panelGreen");
//				break;
//			case 2:
//				$(this).addClass("panelYellow");
//				break;
//			case 3:
//				$(this).addClass("panelRed");
//				break;
//			default:
//				$(this).addClass("panelBlue");
//			break;
//			}
			$(this).fadeIn("slow");
			
			//ratringStar
			$(function() {
					$('select[name=ratingStar]').barrating({
						theme: 'fontawesome-stars',
						readonly: true,
						showSelectedRating: true
					});
			 });
		});
		$('.loader-inner').hide();
	});
});

function enterSearch(code){
	//エンターキー押下なら
	if(13 === code){
		$("#productSearch").trigger("click");
	}
}