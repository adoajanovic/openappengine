jQuery(document).ready(function (){
	//Trim Whitespaces from Text Area.
	jQuery("textarea").val(function(i,v){
    	return v.replace(/\s+/g,' ').replace(/>(\s)</g,'>\n<');
	}); 
		
	jQuery("textarea").addClass('ui-widget');
		
	jQuery(".datepicker").datepicker(
		{
			changeMonth: true,
			changeYear: true,
			showOn: "button",
			/*buttonImage: "../../css/images/calendar.gif",*/
			buttonImageOnly: true
		}
	);
		
	$(function() {
		jQuery(".checkbox" ).button();
	});
			
	$(function() {
		jQuery(".radio" ).button();
	});
  }
);


$(function(){
	jQuery("tbody tr").hover(
	function(){ jQuery("td", this).addClass('ui-state-hover');},
	function(){ jQuery("td", this).removeClass('ui-state-hover');}
	)
	.toggle(
	function(){ jQuery("td", this).addClass('ui-state-highlight');},
	function(){ jQuery("td", this).removeClass('ui-state-highlight');}
	);
}); 


/* On Focus CSS Handler */
jQuery("input").focus(function(){
  $(this).addClass('ui-state-active');
});

/* On Focus CSS Handler */
jQuery("input").blur(function(){
  $(this).removeClass('ui-state-active');
});

jQuery("textarea").focus(function(){
  	$(this).addClass('ui-state-active');
});

/* On Focus CSS Handler */
jQuery("textarea").blur(function(){
  $(this).removeClass('ui-state-active');
});

jQuery("input").focusin(function() {
	$(this).addClass("ui-state-highlight");
});

jQuery("input").focusout(function() {
	$(this).removeClass("ui-state-highlight");
});

//jQuery("tr:odd").addClass("odd");
	
	
/* attach a submit handler to the form */
jQuery("form").submit(function() {
   
    /* stop form from submitting normally*/ 
   	event.preventDefault(); 
    
        
    /* get some values from elements on the page: */
    var $form = $( this ),
    
    /* Get the url for form submit. */
    urlAction = $form.attr( 'action' );

    /* Send the data using post and put the results in a div */
    $.ajax( {
      type: "POST",
      url: urlAction,
      success: function() {
        /*$('#contact_form').html("<div id='message'></div>");*/
        
      }
    });
   
   return true;
});