 /* ================== JQUERY ===================*/
	  /* ============ MONTA SELECT/INPUT =============*/  

	  (function( $ ) {
	    $.widget( "ui.combobox", {
	      _create: function() {
	        this.wrapper = $( "<span>" )
	          .addClass( "ui-combobox" )
	          .insertAfter( this.element );
	        this._createAutocomplete();
	      },
	 
	      _createAutocomplete: function() {
	        var selected = this.element.children( ":selected" ),
	          value = selected.val() ? selected.text() : "";
	          
	        this.input = $( "<input>" )
	          .appendTo( this.wrapper )
	          .val( value )
	          .attr( "name", this.options.idCombo )
	          .attr("placeholder", this.options.placeholder)	          
	          .attr( "style", this.options.style )
	          .addClass(this.options.classe  )
	          .attr("id", this.options.idInput)
	          .css("display", this.options.display)
	          .autocomplete({
	            delay: 0,
	            minLength: 2,
	            ajaxGetAll: {get: "all"},
	            source: $.proxy( this, "_source" )
	          });
	        this._on( this.input, {
	          autocompleteselect: function( event, ui ) {
	            ui.item.option.selected = true;
	            this._trigger( "select", event, {
	              item: ui.item.option
	            });
	          },

	          autocompletechange: "_removeIfInvalid"
	        });
	      },
	 
	      _source: function( request, response ) {
	        var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
	        response( this.element.children( "option" ).map(function() {
	          //var text = acento($( this ).text());
	          //var text2 = $( this ).text();
	          //var text = $( this ).text();
	        	var text = $( this ).text();

	          if(this.value && ( !request.term || matcher.test(acento(text)) || matcher.test(text)))
	          //if ( this.value && ( !request.term || (matcher.test(text) || matcher.test(text2))))
	            return {
	              label:  $( this ).text(),
	              value: $( this ).text(),
	              option: this	              
	            };
	        }) );
	      },
	      
	      
	 
	      _removeIfInvalid: function(event, ui) {
	        // Selected an item, nothing to do
	        if ( ui.item ) {
	          return;
	        }
	 
	        // Search for a match (case-insensitive)
	        var value = this.input.val(),
	          valueLowerCase = value.toLowerCase(),
	          valid = false;
	        
	        this.element.children( "option" ).each(function() {
	          if ( $( this ).text().toLowerCase() === valueLowerCase ) {
	            this.selected = valid = true;

	            return false;
	          }
	        });
	        
	        // Found a match, nothing to do
	        if ( valid ) {
	          return;
	        }
		    
	        // Remove invalid value
	        this.input.val( "" );

	        /*var autoridade = document.getElementById("_autoridade");
	        autoridade.innerHTML = "Inexistente.";
	        setTimeout ("limpar();", 2500);*/

	        this.input.data( "ui-autocomplete" ).term = "";
	      },
	      refresh:function(){ 
	             selected = this.element.children( ":selected" );
	             this.input.val(selected.text());
	         },
	 
	      _destroy: function() {
	        this.wrapper.remove();
	        this.element.show();
	      }
	    });
	  })( jQuery );
	  
	  
	  
	  /* ================== FIM ======================*/
	  
	   /* ================ JAVASCRIPT =================*/
	  /* ========== FUN��O DE ACENTUA��O =============*/
	  
	  
	  function acento(str) {
			var str = str.toLowerCase(), 
			specialChars = [ 
			{val : 'a', let : 'áàãâä'}, 
			{val : 'e', let : 'éèêë'}, 
			{val : 'i', let : 'íìîï'}, 
			{val : 'o', let : 'óòõôö'}, 
			{val : 'u', let : 'úùûü'}, 
			{val : 'c', let : 'ç'}, 
			], 
			regex;

			for ( var i in specialChars) {
				regex = new RegExp('[' + specialChars[i].let + ']', 'g');
				str = str.replace(regex, specialChars[i].val);
				regex = null;
			}

			return str;
		};
		
	 