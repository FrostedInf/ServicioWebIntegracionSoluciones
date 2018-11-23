    servicio = "/countries/getAllCountries";
    var ruta_completa = host + ruta_ws + servicio;
    $('document').ready(function(){
          
          const tabla = $("#tabla_id").DataTable({
              "ajax":{
                  "dataType": 'json',
                  "contentType": "application/json; charset=utf-8",
                  "crossDomain": true,
                  "'Access-Control-Allow-Origin": '*',
                  "method": "GET",
                  "url": ruta_completa,
              },
              "columns":[
                  {"data" : "country_id" },
                  {"data" : "country_name" },
                  {"data" : "region_name"}
              ]

          });
          
          $('#tabla_id tbody').on('click', 'tr', function () {
            var data = tabla.row( this ).data();
            $("#country_id").val(data.country_id);
            $("#country_name").val(data.country_name);
            $("#region_name").val(data.region_name);            
          } );
          
          setInterval( function () {
          tabla.ajax.reload();
          }, 30000 );
          
        } );
    
        $("#target").submit(function (event) {
            event.preventDefault();                        
        });
        $("#Guardar").on('click', function(){
            $.ajax({
                dataType: 'json',
                method:'POST',
                contentType: 'application/json',
                url: host + ruta_ws + 'countries/createCounty',
                data:{  
                        region_id : $("#country_id").val(), 
                        country_name : $("#country_name").val(),
                        region_name : $("#region_name").val()
                    },
                
            })
                .done(function(msg){
                    alert(msg);
                })
                .fail(function (msg){
                    alert(msg);
                })
        });
        
    
    
    


