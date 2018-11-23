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
            saveRegion(id,name);
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
                method:"POST",
                url: "",
                data:{  
                        region_id : $("#region_id").val(), 
                        region_name : $("#region_id").val() 
                    }
            });
        });
        
    
    
    


