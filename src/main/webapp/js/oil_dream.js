$(function() {
	console.log('oil_dreams');
	// external js: masonry.pkgd.js
	var $grid = $('.grid').masonry({
		itemSelector: '.grid-item',
		columnWidth: 160,
		fitWidth:true,
		transitionDuration: '0.2s',
		stagger: 30,
		//originLeft: false,
		//originTop: false,
		horizontalOrder: true
	});
	
	$grid.on( 'click', '.grid-item', function() {
  		// change size of item via class
  		$( this ).toggleClass('grid-item--gigante');
  		// trigger layout
  		$grid.masonry();
	});

});