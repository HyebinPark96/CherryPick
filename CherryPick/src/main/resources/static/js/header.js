$('.searchBtn').css("opacity", ".5");	



$(".searchBar").on("keyup", function(e) {
  if (e.target.value.replace(/\s/g, '').length == 0 ) {
        $('.searchBtn').prop('disabled', true);
        $('.searchBtn').css("opacity", ".5");
      } else {
        $('.searchBtn').prop('disabled', false);
        $('.searchBtn').css("opacity", "1");
      }
});