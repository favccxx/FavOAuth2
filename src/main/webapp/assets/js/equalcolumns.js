function smartColumns() { //Create a function that calculates the smart columns

        //Reset column size to a 100% once view port has been adjusted
	$("ul.column").css({ 'width' : "100%"});

	var colWrap = $("ul.column").width(); //Get the width of row
	var colNum = Math.floor(colWrap / 200); //Find how many columns of 200px can fit per row / then round it down to a whole number
	var colFixed = Math.floor(colWrap / colNum); //Get the width of the row and divide it by the number of columns it can fit / then round it down to a whole number. This value will be the exact width of the re-adjusted column

	$("ul.column").css({ 'width' : colWrap}); //Set exact width of row in pixels instead of using % - Prevents cross-browser bugs that appear in certain view port resolutions.
	$("ul.column li").css({ 'width' : colFixed}); //Set exact width of the re-adjusted column	

}	

smartColumns();//Execute the function when page loads

$(window).resize(function () { //Each time the viewport is adjusted/resized, execute the function
	smartColumns();
});
